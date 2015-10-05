
<%@ include file="/includes/headerProjeto.jsp" %>

                <div class="tutorial-content">
                    <h5 class="title">Tutorial</h5>
                    <div class="row-fluid add-top">
                        <div class="span12">
                            <p style="word-wrap: break-word;">
                                Cadastrar os profissionais que executarão as atividades propostas na EAP.
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
                <h5 class="title">Cadastro de Profissional</h5>
                <div class="row-fluid add-top">

                    <%@ include file="/includes/mensagens.jsp" %>

                    <div class="span12">
                        <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/Profissional/salvar" method="POST">
                            <ul id="ulForm">
                                <input type="hidden" name="profissional" value="${profissional.id}"/>

                                <div class="control-group">
                                    <label class="control-label" for="nome">Nome</label>
                                    <div class="controls">
                                        <input id="nome" name="nome" class="input-xlarge" required type="text" value='${profissional.nome}'>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="cargo">Função:</label>
                                    <div class="controls">
                                        <select id="cargo" name="cargo" required="true">
                                            <option value="">Escolha</option>
                                            <c:forEach items="${cargos}" var="cargo">
                                                <option value="${cargo.id}" ${profissional.cargo.id == cargo.id ? "selected='selected'" : ""}>${cargo.nome}</option>
                                            </c:forEach>

                                        </select>
                                    </div>
                                </div>

                                <ul>
                                    <li>
                                        <button class="submit" type="submit" id="salvar">Salvar</button>
                                        <a href="${pageContext.request.contextPath}/Bootstrap/Profissional">
                                            <button class="submit" type="button">Voltar</button>
                                        </a>
                                    </li>
                                </ul>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/includes/footerProjeto.jsp" %>

<script src="${pageContext.request.contextPath}/resources/js/profissional/profissional.js"></script>