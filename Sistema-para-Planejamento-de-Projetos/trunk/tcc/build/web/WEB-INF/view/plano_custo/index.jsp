
<%@ include file="/includes/headerProjeto.jsp" %>

<style>
    .table-agg-striped tr.colorida td,
    .table-agg-striped tbody tr.colorida th {
        background-color: #f9f9f9;
    }
</style>

                <div class="tutorial-content">
                    <h5 class="title">Tutorial</h5>
                    <div class="row-fluid add-top">
                        <div class="span12">
                            <p style="word-wrap: break-word;">
                                O Plano de custo visa desenvolver uma estimativa de recursos monetários necessários para a execução do projeto.
                                É possível prever o custo de uma atividade através do levantamento do esforço necessário, profissionais e valor da hora para execução.
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
                <h5 class="title">Plano de Custo</h5>
                <div class="row-fluid add-top">

                    <%@ include file="/includes/mensagens.jsp" %>

                    <div class="span12">
                        <form action="${pageContext.request.contextPath}/Bootstrap/PlanoDeCusto" method="POST">

                            <div class="span11">
                                <table class="table table-bordered table-agg-striped responsive-utilities">
                                    <thead>
                                        <tr>
                                            <th>Atividade</th>
                                            <th>Esforço Estimado (hh)</th>
                                            <th>Profissional</th>
                                            <th>Quantidade Horas</th>
                                            <th>Acao</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="atividade" items="${atividades}">
                                            <tr ${atividade.idPacote == 0 ? "class='colorida'" : ""}>
                                                <td style="vertical-align: middle; text-align: center;" rowspan='${fn:length(atividade.atividadeProfissionais) lt fn:length(profissionais) ? fn:length(atividade.atividadeProfissionais)+1 : fn:length(atividade.atividadeProfissionais) }'>
                                                    ${atividade.nome}
                                                </td>
                                                <fmt:formatNumber var="esforco" maxFractionDigits="0" value="${atividade.esforcoEstimado/1000/60/60}"/>
                                                <td style="vertical-align: middle; text-align: center;" rowspan='${fn:length(atividade.atividadeProfissionais) lt fn:length(profissionais) ? fn:length(atividade.atividadeProfissionais)+1 : fn:length(atividade.atividadeProfissionais) }'>
                                                    ${atividade.esforcoEstimado > 0 ? esforco : "-"}
                                                </td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${fn:length(atividade.atividadeProfissionais) gt 0}">
                                                            ${atividade.atividadeProfissionais[0].profissional.nome}
                                                        </c:when>

                                                        <c:when test="${atividade.idPacote > 0}">
                                                            <select class='input-medium' id='saveProfissional${atividade.id}'>
                                                                <option value="">Escolha</option>
                                                                <c:forEach items="${profissionais}" var="profissional">
                                                                    <option value="${profissional.id}">${profissional.nome}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </c:when>

                                                        <c:otherwise>
                                                            -
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${fn:length(atividade.atividadeProfissionais) gt 0}">
                                                            ${atividade.atividadeProfissionais[0].quantidadeHoras}
                                                        </c:when>

                                                        <c:when test="${atividade.idPacote > 0}">
                                                            <input class='input-small' type='text' value='' id='saveQuantidadeHoras${atividade.id}'/>
                                                        </c:when>

                                                        <c:otherwise>
                                                            -
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td style="text-align: center;">
                                                    <c:choose>
                                                        <c:when test="${fn:length(atividade.atividadeProfissionais) gt 0}">
                                                            <a href='#'>
                                                                <span class="icon-remove excluir" url='${pageContext.request.contextPath}/Bootstrap/PlanoDeCusto/removerAtividadeProfissional/profissional/${atividade.atividadeProfissionais[0].profissional.id}/atividade/${atividade.id}'></span>
                                                            </a>
                                                        </c:when>

                                                        <c:when test="${atividade.idPacote > 0}">
                                                            <a href='#'>
                                                                <span class="icon-save salvar" url='${pageContext.request.contextPath}/Bootstrap/PlanoDeCusto/salvar' atividade='${atividade.id}'></span>
                                                            </a>
                                                        </c:when>

                                                        <c:otherwise>
                                                            -
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                            </tr>
                                            <c:forEach var="atividadeProfissional" begin="1" items="${atividade.atividadeProfissionais}" varStatus="key">
                                                <tr>
                                                    <td>
                                                        ${atividadeProfissional.profissional.nome}
                                                    </td>
                                                    <td>
                                                        ${atividadeProfissional.quantidadeHoras}
                                                    </td>
                                                    <td style="text-align: center;">
                                                        <a href='#'>
                                                            <span class="icon-remove excluir" url='${pageContext.request.contextPath}/Bootstrap/PlanoDeCusto/removerAtividadeProfissional/profissional/${atividadeProfissional.profissional.id}/atividade/${atividade.id}'></span>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            <c:if test="${fn:length(atividade.atividadeProfissionais) gt 0 && (fn:length(atividade.atividadeProfissionais) != fn:length(profissionais))}">

                                                <tr>
                                                    <td>
                                                        <select class='input-medium' id='saveProfissional${atividade.id}'>
                                                            <option value="">Escolha</option>
                                                            <c:forEach items="${profissionais}" var="profissional">
                                                                <c:set var="mostrar" value="true" />

                                                                <c:forEach items="${atividade.atividadeProfissionais}" var="atividadeProfissional">
                                                                    <c:if test="${atividadeProfissional.profissional.id == profissional.id}">
                                                                        <c:set var="mostrar" value="false" />
                                                                    </c:if>
                                                                </c:forEach>

                                                                <c:if test="${mostrar == true}">
                                                                    <option value="${profissional.id}">${profissional.nome}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select>
                                                    </td>
                                                    <td>
                                                        <input class='input-small' type='text' value='' id='saveQuantidadeHoras${atividade.id}'/>
                                                    </td>
                                                    <td style="text-align: center;">
                                                        <a href='#'>
                                                            <span class="icon-save salvar" url='${pageContext.request.contextPath}/Bootstrap/PlanoDeCusto/salvar' atividade='${atividade.id}'></span>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<%@include file="/includes/footerProjeto.jsp" %>

<script src="${pageContext.request.contextPath}/resources/js/plano_de_custo/plano_de_custo.js"></script>