<%--
    Document   : definicaoEscopo
    Created on : 24/10/2014, 22:18:42
    Author     : Camyla
--%>

<%@ include file="/includes/headerProjeto.jsp" %>

<div class="tutorial-content">
    <h5 class="title">Tutorial</h5>
    <div class="row-fluid add-top">
        <div class="span12">
            <p style="word-wrap: break-word;">
                A elaboração de um bom plano de risco depende de uma análise profunda de todas as etapas, atividades e módulos de um projeto, possibilitando o levantamento das condições de um 
                possíveis ameaças, que podem comprometer o sucesso do mesmo.
            </p>
        </div>
    </div>
</div>
</div>
</div>
</div>
<div class="span8">
    <div class="display-dev">
        <div class="display-dev-content">
            <h5 class="title">Plano de Riscos</h5>
            <div class="row-fluid add-top">
                <%@ include file="/includes/mensagens.jsp" %>

                <div class="span12">
                    <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/riscos/salvar" method="post" name="contact_form">
                        <ul id="ulForm">                                
                            <c:if test = "${plano.idPlano != null}">
                                <input type="hidden" name="id" value="${plano.idPlano}"/>
                                <input type="hidden" name="valida" value="editar"/>
                            </c:if>
                            <c:if test = "${plano.idPlano  == null}">
                                <input type="hidden" name="valida" value="inserir"/>
                            </c:if>
                            <li>
                                <label for="condicao">Condição:</label>
                                <textarea rows="3" style="width: 80%;" name="condicao" placeholder="Condição" required>${plano.condicaoRisco}</textarea>
                            </li>
                            <li>
                                <label for="classificacao">Classificação:</label>
                                <textarea rows="3" style="width: 80%;" name="classificacao" placeholder="Classificação" required>${plano.classificacaoRisco}</textarea>
                            </li>

                            <li>
                                <label for="Probabilidade">Probabilidade: </label>
                                <textarea rows="3" style="width: 80%;" name="probabilidade" placeholder="Probabilidade" required>${plano.probabilidadeRisco}</textarea>
                            </li>
                            <li>
                                <label for="impacto">Impacto: </label>
                                <textarea rows="3" style="width: 80%;" name="impacto" placeholder="Impacto" required>${plano.impactoRisco}</textarea>
                            </li>
                            <li>
                                <button class="submit" name ="botao" type="submit">Salvar</button> 
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<%@include file="/includes/footerProjeto.jsp" %>