
<%@ include file="/includes/headerProjeto.jsp" %>

<div class="tutorial-content">
    <h5 class="title">Tutorial</h5>
    <div class="row-fluid add-top">
        <div class="span12">
            <p style="word-wrap: break-word;">
                O Gerenciamento de Riscos é o meio pelo qual as incertezas em relação ao projeto são sistematicamente gerenciadas, permitindo avaliar e enfrentar os riscos, evitando o evitável, controlando o controlável e minimizando a imprevisibilidades;<br>
                O risco é um evento, é uma incerteza, e tem um impacto sobre o projeto que pode ser positivo ou negativo:<br>
                <strong>Positivo:</strong> se transforma em uma oportunidade;<br>
                <strong>Negativo:</strong> gera risco de fracasso;
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
            <h5 class="title">Pesquisa de Risco</h5>
            <div class="row-fluid add-top">

                <%@ include file="/includes/mensagens.jsp" %>

                <div class="span12">
                    <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/riscos/buscar" method="POST">
                        <ul id="ulForm">
                            <input type="hidden" name="id" value="${projeto.id}"/>

                            <div class="control-group">
                                <label class="control-label" for="condicao">Condição</label>
                                <div class="controls">
                                    <input id="condicao" name="condicao" class="input-xlarge" type="text" value = ${condicao}>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="classificacao">Classificação</label>
                                <div class="controls">
                                    <input id="classificacao" name="classificacao" class="input-xlarge" type="text" value = ${classificacao}>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="probabilidade">Probabilidade</label>
                                <div class="controls">
                                    <input id="classificacao" name="probabilidade" class="input-xlarge" type="text" value = ${probabilidade}>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="impacto">Impacto</label>
                                <div class="controls">
                                    <input id="classificacao" name="impacto" class="input-xlarge" type="text" value = ${impacto}>
                                </div>
                            </div>

                            <ul>
                                <li>
                                    <button class="submit" type="submit">Pesquisar</button>
                                    <a href="${pageContext.request.contextPath}/Bootstrap/riscos/cadastrar">
                                        <button class="submit" type="button">Novo</button>
                                    </a>
                                </li>
                            </ul>
                    </form>
                </div>

                <c:set var="registros" value="${pageContext.request.getAttribute('registros')}" />
                <c:if test="${registros.size() > 0}">

                    <div class="span11">
                        <table class="table table-bordered table-striped responsive-utilities">
                            <thead>
                                <tr>
                                    <th>Condição</th>
                                    <th>Classificação</th>
                                    <th>Probabilidade</th>
                                    <th>Impacto</th>
                                    <th>#</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="plano" items="${registros}">
                                    <tr>
                                        <td class="is-visible"><c:out value="${plano.condicaoRisco}" /></td>
                                        <td class="is-hidden"><c:out value="${plano.classificacaoRisco}" /></td>
                                        <td class="is-hidden"><c:out value="${plano.probabilidadeRisco}" /></td>
                                        <td class="is-hidden"><c:out value="${plano.impactoRisco}" /></td>
                                        <td class="is-hidden">
                                            <a href='${pageContext.request.contextPath}/Bootstrap/riscos/editar/id/${plano.idPlano}'>
                                                <span class="icon-edit"></span>
                                            </a>
                                            <a href='#'>
                                                <span class="icon-remove excluir" url="/tcc/Bootstrap/riscos/excluir/id/${plano.idPlano}"></span>
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
<script src="${pageContext.request.contextPath}/resources/js/risco/risco.js"></script>