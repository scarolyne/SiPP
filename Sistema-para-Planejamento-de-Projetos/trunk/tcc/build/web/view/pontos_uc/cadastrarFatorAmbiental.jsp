<%-- 
    Document   : cadastrarFatorAmbiental
    Created on : 04/11/2014, 18:09:58
    Author     : Asus PC
--%>

<%@ include file="/includes/headerProjeto.jsp" %>

                <div class="tutorial-content">
                    <h5 class="title">Tutorial</h5>
                    <div class="row-fluid add-top">
                        <div class="span12">
                            <p style="word-wrap: break-word;">
                                Os fatores de complexidade ambiental (FCA) indicam a eficiência do projeto e estão relacionados ao nível de experiência dos profissionais;
                                Cada fator é classificado de 0 a 5, onde 0 significa pouca experiência, 3 significa média e 5 significa muita experiência;
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
                <h5 class="title">Fator de Complexidade Ambiental</h5>
                <div class="row-fluid add-top">

                    <div class="span12">
                        <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/pontoUC/salvar" method="POST">
                            <input type="hidden" name="acao" value="${fn:length(projetoFatoresComplexidade) gt 0 ? 'alterar' : 'incluir'}">                          
                            <ul id="ulForm">
                                </div>
                                <div class="span11">

                                    <table class="table table-bordered table-striped responsive-utilities">
                                        <thead>
                                            <tr>
                                                <th>Fator de Complexidade Técnica</th>
                                                <th>Peso</th>
                                                <th>Classificação</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="fator" items="${fatores}">
                                                <tr>
                                                    <input type="hidden" name="idFator[]"  value="${fator.id}">
                                                    <td class="is-visible">${fator.nome}</td>
                                                    <td class="is-hidden">${fator.peso}</td>
                                                    <td class="is-hidden">
                                                        <select name ="classificacao[]" id="select01">
                                                                <option value="0">0</option>
                                                                <option value="1">1</option>
                                                                <option value="2">2</option>
                                                                <option value="3">3</option>
                                                                <option value="4">4</option>
                                                                <option value="5">5</option>
                                                        </select>
                                                    </td>   
                                                </tr>
                                            </c:forEach>
                                            <c:forEach var="projetoFatorComplexidade" items="${projetoFatoresComplexidade}">
                                                <tr>
                                                    <input type="hidden" name="idFator[]"  value="${projetoFatorComplexidade.fator.id}">
                                                    <td class="is-visible">${projetoFatorComplexidade.fator.nome}</td>
                                                    <td class="is-hidden">${projetoFatorComplexidade.fator.peso}</td>
                                                    <td class="is-hidden">
                                                        <select name ="classificacao[]" id="select01">
                                                                <option ${projetoFatorComplexidade.classificacao == 0 ? "selected" : ""}>0</option>
                                                                <option ${projetoFatorComplexidade.classificacao == 1 ? "selected" : ""}>1</option>
                                                                <option ${projetoFatorComplexidade.classificacao == 2 ? "selected" : ""}>2</option>
                                                                <option ${projetoFatorComplexidade.classificacao == 3 ? "selected" : ""}>3</option>
                                                                <option ${projetoFatorComplexidade.classificacao == 4 ? "selected" : ""}>4</option>
                                                                <option ${projetoFatorComplexidade.classificacao == 5 ? "selected" : ""}>5</option>
                                                        </select>
                                                    </td>   
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <ul>
                                        <li>
                                            <button class="submit" type="submit">Salvar</button>

                                        </li>
                                    </ul>
                            </ul>
                        </form>
                    </div>
                </div>
            </div>


        </div>

    </div>

    <%@include file="/includes/footerProjeto.jsp" %>


