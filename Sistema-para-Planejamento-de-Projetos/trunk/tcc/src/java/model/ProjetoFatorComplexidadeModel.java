/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ProjetoFatorComplexidadeDAO;
import Exception.ErrorException;
import Exception.FilterCreationException;
import bean.FatorComplexidade;
import bean.Projeto;
import bean.ProjetoFatorComplexidade;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import utils.Filtro;

/**
 *
 * @author Asus PC
 */
public class ProjetoFatorComplexidadeModel extends Model {

    ProjetoFatorComplexidadeDAO dao;
    ProjetoFatorComplexidade projetoFator;
    HttpSession session;
    Projeto projeto;
    FatorComplexidade fator;

    public void salvar(HttpServletRequest request) throws ErrorException {
        session = request.getSession();

        projeto = new Projeto();
        dao = new ProjetoFatorComplexidadeDAO();

        projeto.setId((Integer.parseInt("" + (String) session.getAttribute("idProjeto"))));

        String[] idFatorArray = request.getParameterValues("idFator[]");
        String[] classificacoArray = request.getParameterValues("classificacao[]");
        for (int i = 0; i < idFatorArray.length; i++) {
            fator = new FatorComplexidade();
            projetoFator = new ProjetoFatorComplexidade();

            int idFator = Integer.parseInt(idFatorArray[i]);
            int classificacao = Integer.parseInt(classificacoArray[i]);
            fator.setId(idFator);
            projetoFator.setFator(fator);
            projetoFator.setClassificacao(classificacao);
            projetoFator.setProjeto(projeto);

            if(request.getParameter("acao").equals("alterar")){
                dao.editar(projetoFator);
            }else{
                dao.salvar(projetoFator);
            }

        }
    }

    public List<ProjetoFatorComplexidade> buscar(HttpServletRequest request) throws ErrorException, FilterCreationException {
        dao = new ProjetoFatorComplexidadeDAO();
        session = request.getSession();

        Filtro filtro = new Filtro();

        filtro.setCampo("projeto_id");
        filtro.setValor((String) session.getAttribute("idProjeto"));
        filtro.setOperador("AND");
        filtro.setTipo("LIKE");

        String where = dao.criarFiltro(filtro);

        List<ProjetoFatorComplexidade> fatores = dao.buscar(where);


        return fatores;
    }

    public ProjetoFatorComplexidade buscarPorId(HttpServletRequest request, int idFC) throws ErrorException, FilterCreationException {
        dao = new ProjetoFatorComplexidadeDAO();
        session = request.getSession();
        ArrayList<Filtro> filtros = new ArrayList();
        Filtro filtro;

        filtro = new Filtro();
        filtro.setCampo("fator_complexidade_id");
        filtro.setValor(String.valueOf(idFC));
        filtro.setOperador("AND");
        filtro.setTipo("LIKE");
        filtros.add(filtro);


        session = request.getSession();
        filtro = new Filtro();
        filtro.setCampo("projeto_id");
        filtro.setValor((String) session.getAttribute("idProjeto"));
        filtro.setOperador("AND");
        filtro.setTipo("LIKE");
        filtros.add(filtro);


        String where = dao.criarFiltro(filtros);

        List<ProjetoFatorComplexidade> projetoFatoresComplexidade = dao.buscar(where);

        if (projetoFatoresComplexidade.isEmpty()) {
            return null;
        }

        FatorComplexidadeModel modelFatorComplexidade = new FatorComplexidadeModel();
        projetoFatoresComplexidade.get(0).setFator(modelFatorComplexidade.buscarFatoresporId(projetoFatoresComplexidade.get(0).getFator().getId()));

        return projetoFatoresComplexidade.get(0);
    }


    public float calculoUCAjustados(HttpServletRequest request) throws FilterCreationException, ErrorException {
        FatorComplexidadeModel modelFC = new FatorComplexidadeModel();
        CasoDeUsoModel modelUC = new CasoDeUsoModel();
        List<ProjetoFatorComplexidade> listaProjeto = buscar(request);

        if(listaProjeto.isEmpty()){
            return 0;
        }
        int TPNAA = calculoTPNAA(modelUC.countUCporComplexidade(request, "simples", "Ator"), modelUC.countUCporComplexidade(request, "medio", "Ator"), modelUC.countUCporComplexidade(request, "complexo", "Ator"));
        int TPNAUC = calculoTPNAUC(modelUC.countUCporComplexidade(request, "simples", "Caso de Uso"), modelUC.countUCporComplexidade(request, "medio", "Caso de Uso"), modelUC.countUCporComplexidade(request, "complexo", "Caso de Uso"));
        if(TPNAA == 0 || TPNAUC == 0){
            return 0;
        }
        int PCUNA = TPNAA + TPNAUC;
        float FCT = calculoFCT(obterSomatorio(listaProjeto, modelFC.buscarFatorTecnico()));
        float FCA = calculoFCA(obterSomatorio(listaProjeto, modelFC.buscarFatorAmbiental()));
        float PCUA = PCUNA * FCT * FCA;

        return PCUA;

    }

    public int calculoTPNAA(int simples, int medio, int complexo) {
        dao = new ProjetoFatorComplexidadeDAO();

        int countSimples = simples;
        int countMedio = medio;
        int countComplexo = complexo;

       // int countSimples = dao.contarUCporComplexidade("simples", 1, "Ator");
        // int countMedio = dao.contarUCporComplexidade("médio", 1, "Ator");
        // int countComplexo = dao.contarUCporComplexidade("Complexo", 1, "Ator");
        countSimples = countSimples * 1;
        countMedio = countMedio * 2;
        countComplexo = countComplexo * 3;
        return countSimples + countMedio + countComplexo;

    }

    public int calculoTPNAUC(int simples, int medio, int complexo) {
        dao = new ProjetoFatorComplexidadeDAO();
        int countSimples = simples;
        int countMedio = medio;
        int countComplexo = complexo;

        countSimples = countSimples * 1;
        countMedio = countMedio * 2;
        countComplexo = countComplexo * 3;
        return countSimples + countMedio + countComplexo;
    }

    private float obterSomatorio(List<ProjetoFatorComplexidade> listaProjetos, List<FatorComplexidade> listaFC) {
        float produto;
        float somatorio = 0;

        for (ProjetoFatorComplexidade projetoFC : listaProjetos) {
            for (FatorComplexidade fator : listaFC) {
                if (projetoFC.getFator().getId() == fator.getId()) {
                    produto = projetoFC.getClassificacao() * fator.getPeso();
                    somatorio = somatorio + produto;
                }
            }
        }
        return somatorio;
    }

    public float calculoFCT(float somatorio) {
        float FCT;
        FCT = (float) (0.6 + (0.01 * somatorio));

        return FCT;
    }

    public float calculoFCA(float somatorio) {
        float FCA;
        FCA = (float) (1.4 + (-0.03 * somatorio));
        return FCA;
    }

}
