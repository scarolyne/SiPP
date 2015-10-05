<%-- 
    Document   : cadastrarFator
    Created on : 04/11/2014, 18:09:58
    Author     : Asus PC
--%>

<%@ include file="/includes/headerProjeto.jsp" %>

                <div class="tutorial-content">
                    <h5 class="title">Tutorial</h5>
                    <div class="row-fluid add-top">
                        <div class="span12">
                            <p style="word-wrap: break-word;">
                                lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala
                                lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala
                                lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala
                                lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala
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
                <h5 class="title">Fator de Complexidade Técnica</h5>
                <div class="row-fluid add-top">

                    <div class="span12">
                        <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/comunicacao/buscar" method="POST">
                            <ul id="ulForm">

                            </ul>
                        </form>
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
                                        <td class="is-visible">${fator.nome}</td>
                                        <td class="is-hidden">${fator.peso}</td>
                                        <td class="is-hidden">
                                            <select id="select01">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>

                                        </td>   
                                    </tr>

                                </c:forEach>
                            </tbody>
                        </table>
                        <ul>
                            <li>
                                <button class="submit" type="submit">Salvar</button>
                                <a href="${pageContext.request.contextPath}/Bootstrap/comunicacao/cadastrar">
                                    <button class="submit" type="button">Novo</button>
                                </a>
                            </li>
                        </ul>

                    </div>           
                </div>
            </div>
        </div>


    </div>

</div>

<%@include file="/includes/footerProjeto.jsp" %>


