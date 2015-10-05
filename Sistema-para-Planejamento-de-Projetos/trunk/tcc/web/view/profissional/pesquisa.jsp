
<%@ include file="/includes/headerProjeto.jsp" %>

                <div class="tutorial-content">
                    <h5 class="title">Tutorial</h5>
                    <div class="row-fluid add-top">
                        <div class="span12">
                            <p style="word-wrap: break-word;">
                                O plano que possibilita organizar e gerenciar a equipe executora do projeto.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <c:set var="cargo_id" value="${pageContext.request.getParameter('cargo')}" />

    <div class="span8">

        <div class="display-dev">
            <div class="display-dev-content">
                <h5 class="title">Pesquisa de Profissional</h5>
                <div class="row-fluid add-top">

                    <%@ include file="/includes/mensagens.jsp" %>

                    <div class="span12">
                        <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/Profissional/pesquisar" method="POST">

                            <div class="control-group">
                                <label class="control-label" for="nome">Nome</label>
                                <div class="controls">
                                    <input id="nome" name="nome" class="input-xlarge" type="text" value="${profissional.nome}">
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="cargo">Cargo</label>
                                <div class="controls">
                                    <select id="cargo" name="cargo">
                                        <option value="">Escolha</option>
                                        <c:forEach items="${cargos}" var="cargo">
                                            <option value="${cargo.id}" ${profissional.cargo.id == cargo.id ? "selected='selected'" : ""}>${cargo.nome}</option>
                                        </c:forEach>

                                    </select>
                                </div>
                            </div>

                            <ul>
                                <li>
                                    <button class="submit" type="submit">Pesquisar</button>
                                    <a href="${pageContext.request.contextPath}/Bootstrap/Profissional/cadastrar">
                                        <button class="submit" type="button">Novo</button>
                                    </a>
                                    <button class="submit" type="button" id="limpar">Limpar</button>
                                </li>
                            </ul>
                        </form>
                    </div>

                    <c:if test="${profissionais.size() > 0}">

                        <div class="span11">
                            <table class="table table-bordered table-striped responsive-utilities">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th>Cargo</th>
                                        <th>#</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="profissional" items="${profissionais}">
                                        <tr>
                                            <td class="is-visible">${profissional.nome}</td>
                                            <td class="is-hidden">${profissional.cargo.nome}</td>
                                            <td class="is-hidden">
                                                <a href='${pageContext.request.contextPath}/Bootstrap/Profissional/editar/id/${profissional.id}'>
                                                    <span class="icon-edit"></span>
                                                </a>
                                                <a href='#'>
                                                    <span class="icon-remove excluir" url="/tcc/Bootstrap/Profissional/excluir/id/${profissional.id}"></span>
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

<script src="${pageContext.request.contextPath}/resources/js/profissional/profissional.js"></script>