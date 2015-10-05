<%-- 
    Document   : diagrama
    Created on : 04/11/2014, 16:07:17
    Author     : Carol
--%>

<%@ include file="/includes/headerProjeto.jsp" %>

                <div class="tutorial-content">
                    <h5 class="title">Tutorial</h5>
                    <div class="row-fluid add-top">
                        <div class="span12">
                            <p style="word-wrap: break-word;">
                                A Estrutura Analítica de Projeto (EAP) é uma estrutura hierárquica orientada à entrega do trabalho a ser executado pela equipe do projeto, para atingir os objetivos do projeto e criar
                                as entregas necessárias;        
                                Subdivide o trabalho do projeto em partes menores e mais facilmente gerenciáveis, até chegar nas atividades que realmente serão executadas;<br>
                                <br>
                                <strong>ELABORAÇÃO: </strong><br>
                                <strong>1.</strong> Colocar no segundo nível as fases que estabelecem o ciclo de vida do projeto;<br>
                                <strong>2.</strong> Identificar os subprodutos necessários para que seja alcançado o sucesso do projeto em cada fase;
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="span8">
        <div class="display-dev">
            <div class="display-dev-content" id="menos-dev">
                <h5 class="title">Estrutura Analítica do Projeto</h5>
                <%@ include file="/includes/mensagens.jsp" %>
                <form action="${pageContext.request.contextPath}/Bootstrap/atividade/salvar" id="formEAPsalvar" method="post">
                    <div class="contact_form">
                        <button type="submit" id="btnSave" class="submit">Salvar</button>
                    </div>
                    <div id="master-div" style="heigth: 100px;">
                        <div class="level">
                            <div class="ret ret_1">
                                <div class="label-eap">PROJETO</div>
                                <div class="appButton">
                                    <button class="btnAdd" onclick="addPacote(); ajustarDiv('PP'); return false;">+</button>
                                </div>
                                <div id="lineBottom" class="lineBottom"></div>
                            </div>
                        </div>
                        <div id="lineHr" class="lineHr"></div>
                        <c:set var="c_pacotes" value="0" />
                        <div class="level" id="pacotes">
                            <c:forEach items="${pacotes}" var="pacote">
                                <div class="ret ret_1" id="PP${pacote.id}">
                                    <div class="lineTop"></div>
                                    <textarea class="input-eap" name="pacote_${pacote.id}">${pacote.nome}</textarea>
                                       <div class="appButton">
                                        <button class="btnAdd" onclick="addAtivi('PP${pacote.id}', ${pacote.id}); return false;">+</button>
                                        <button class="btnDel" type="button" onclick="if (confirmAction('Esta ação irá excluir o pacote ${pacote.nome} e todas as atividades vinculadas a ele. Deseja prosseguir?')) { delAtivId(${pacote.id}); delPacote('PP${pacote.id}', ${pacote.id}); }">x</button>
                                    </div>
                                    <input type="hidden" name="ativiUpdate[]" value="${pacote.id}">
                                </div>
                                <c:set var="c_pacotes" value="${pacote.id}" />
                            </c:forEach>
                        </div>
                        <input type="hidden" id="count_pacotes" name="count_pacotes" value="${c_pacotes != 0 ? c_pacotes + 1 : c_pacotes}">
                        <input type="hidden" id="count_pacotes_del" name="count_pacotes_del" value="0">
                        <c:set var="c_pacotes" value="0" />
                        <c:set var="divpp_ant" value="0" />
                        <c:forEach items="${atividades}" var="atividade">
                            <c:if test="${divpp_ant != atividade.idPacote}">
                                <div id="div-PP${atividade.idPacote}" class="div-pacote" style="background: rgb(204, 204, 204);">
                                &nbsp;
                            </c:if>
                                <div class="ret ret_2" id="PP${atividade.idPacote}_atv_${c_pacotes}">
                                    <textarea class="input-eap" name="atividade_${atividade.id}">${atividade.nome}</textarea>
                                    <div class="appButton">
                                        <button class="btnDel" type="button" onclick="if (confirmAction('Deseja realmente excluir a atividade ${atividade.nome}?')) { delAtivId(${atividade.id}); delAtivi('PP${atividade.idPacote}_atv_${c_pacotes}', ${c_pacotes}); }">x</button>
                                    </div>
                                </div>
                                <input type="hidden" name="ativiUpdate[]" value="${atividade.id}">
                                <c:set var="c_pacotes" value="${c_pacotes + 1}" />
                            <c:set var="divpp_ant" value="${atividade.idPacote}" />
                            <c:if test="${divpp_ant != atividade.idPacote}">
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </form>
            </div>
        </div>
        <div id="img-out">
        </div>
    </div>
</div>
<script>
    ajustarDiv('PP');
</script>

<%@include file="/includes/footerProjeto.jsp" %>