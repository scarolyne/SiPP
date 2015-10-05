<%-- 
    Document   : pesquisar
    Created on : 01/11/2014, 12:23:13
    Author     : Asus PC
--%>


<%@ include file="/includes/headerProjeto.jsp" %>

                <div class="tutorial-content">
                    <h5 class="title">Tutorial</h5>
                    <div class="row-fluid add-top">
                        <div class="span12">
                            <p style="word-wrap: break-word;">
                                O plano de comunicação tem como objetivo assegurar que as informações sejam obtidas, disseminadas  e armazenadas de maneira correta para que todos envolvidos estejam alinhados.
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
                <h5 class="title">Pesquisa de Comunicação</h5>
                <div class="row-fluid add-top">
                   <%@ include file="/includes/mensagens.jsp" %>
                    <div class="span12">
                        <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/comunicacao/buscar" method="POST">
                            <ul id="ulForm">
                                <input type="hidden" name="id" value="${projeto.id}"/>
                                
                                <div class="control-group">
                                    <label class="control-label" for="interessado">Grupo Interessado</label>
                                    <div class="controls">
                                        <input id="condicao" name="interessado" value="${interessado}" class="input-xlarge" type="text">
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="metodo">Metodo</label>
                                    <div class="controls">
                                        <input id="classificacao" name="metodo" value="${metodo}" class="input-xlarge" type="text">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="Quando">Quando</label>
                                    <div class="controls">
                                        <input id="classificacao" name="quando" value="${quando}" class="input-xlarge" type="text">
                                    </div>
                                </div>
                                <ul>
                                    <li>
                                        <button class="submit" type="submit">Pesquisar</button>
                                        <a href="${pageContext.request.contextPath}/Bootstrap/comunicacao/cadastrar">
                                            <button class="submit" type="button">Novo</button>
                                        </a>
                                    </li>
                                </ul>
                        </form>
                    </div>


                    <c:if test="${planos.size() > 0}">

                        <div class="span11">
                            <table class="table table-bordered table-striped responsive-utilities">
                                <thead>
                                    <tr>
                                        <th>Grupo Interessado</th>
                                        <th>Foco</th>
                                        <th>Informaçao</th>
                                        <th>Metodo</th>
                                        <th>Quando</th>
                                        <th>#</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="plano" items="${planos}">
                                        <tr>
                                            <td class="is-visible">${plano.interessado}</td>
                                            <td class="is-hidden">${plano.foco}</td>
                                            <td class="is-hidden">${plano.informacao}</td>
                                            <td class="is-hidden">${plano.metodo}</td>
                                            <td class="is-hidden">${plano.quando}</td>
                                            <td class="is-hidden">
                                                <a href='${pageContext.request.contextPath}/Bootstrap/comunicacao/editar/id/${plano.id}'>
                                                    <span class="icon-edit"></span>
                                                </a>
                                                <a href='#'>
                                                    <span class="icon-remove excluir" url="/tcc/Bootstrap/comunicacao/excluir/id/${plano.id}"></span>
                                                </a>    
                                            </td>
                                        </tr>

                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>

                    </c:if>
                </div>
            </div>
        </div>
    </div>

</div>

<%@include file="/includes/footerProjeto.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/comunicacao/comunicacao.js"></script>

