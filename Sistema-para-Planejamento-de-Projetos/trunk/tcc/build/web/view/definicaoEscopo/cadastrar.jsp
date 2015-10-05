<%--
    Document   : definicaoEscopo
    Created on : 24/10/2014, 22:18:42
    Author     : Camyla
--%>

<%@ include file="/includes/headerProjeto.jsp" %>
<script>

    function addEntrega() {

        li = document.createElement("li");
        label = document.createElement("label");
        span = document.createElement("span");
        span.innerHTML = "&nbsp;";

        data = document.createElement("input");
        data.type = "date";
        data.name = "data[]";
        data.placeholder = "Data";
        data.className = "input-medium";

        entrega = document.createElement("input");
        entrega.type = "text";
        entrega.name = "entrega[]";
        entrega.placeholder = "Entrega";

        //li.appendChild(label);
        li.appendChild(data);
        li.appendChild(span);
        li.appendChild(entrega);
        document.getElementById("ulForm").appendChild(li);
    }
</script>

                <div class="tutorial-content">
                    <h5 class="title">Tutorial</h5>
                    <div class="row-fluid add-top">
                        <div class="span12">
                            <p style="word-wrap: break-word;">
                                Documentar de maneira detalhada o projeto e o produto a ser criado, baseando-se em entregas principais, premissas e restrições que foram previamente documentadas na iniciação do projeto;
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="span8">
        <div class="display-dev">
            <div class="display-dev-content" style="height: 98.3%;">
                <h5 class="title">Definição de Escopo</h5>
                <div class="row-fluid add-top">

                    <%@ include file="/includes/mensagens.jsp" %>

                    <div class="span12">
                        <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/DefinicaoEscopo/salvar" method="post" name="contact_form">
                            <ul id="ulForm">
                                <input type="hidden" name="id" value="${escopo.idEscopo}"/>
                                <c:if test = "${escopo.idEscopo  != null}">
                                    <input type="hidden" name="valida" value="editar"/>
                                </c:if>
                                <c:if test = "${escopo.idEscopo == null}">
                                    <input type="hidden" name="valida" value="inserir"/>
                                </c:if>

                                <li>
                                    <label for="name" class="cem">Descrição do Escopo:</label>
                                    <textarea rows="3" style="width: 80%;" name="descricao" placeholder="Descrição" required>${escopo.descricaoEscopo}</textarea>
                                </li>
                                <li>
                                    <label for="email" class="cem">Critérios de Aceitação:</label>
                                    <textarea rows="3" style="width: 80%;" name="criterios" placeholder="Critérios de Aceitação" required>${escopo.criteriosAceitacao}</textarea>
                                </li>

                                <li>
                                    <label for="name" class="cem">Restrições do Projeto:</label>
                                    <textarea rows="3" style="width: 80%;" name="restricoes" placeholder="Restrições do Projeto" required>${escopo.restricoesProjeto}</textarea>
                                </li>
                                <li>
                                    <label for="name" class="cem">Exclusões do Projeto:</label>
                                    <textarea rows="3" style="width: 80%;" name="exclusoes" placeholder="Exclusões do Projeto" required>${escopo.exclusoesProjeto}</textarea>
                                </li>
                                <li>
                                    <label for="name" class="cem">Premissas do Projeto:</label>
                                    <textarea rows="3" style="width: 80%;" name="premissas" placeholder="Premissas do Projeto" required>${escopo.premissasProjeto}</textarea>
                                </li>
                                <li>
                                    <h6>Entregas Projeto</h6>
                                </li>
                                <li>
                                    <label>Data</label>
                                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Descrição</label>
                                    <br>
                                </li>

                                <c:if test="${escopo.entregas == null }">
                                    <li>

                                        <input type="date" class="input-medium" id="input_1" name="data[]" placeholder="Data" required>
                                        <input type="text" class="input-medium" id="input_1" name="entrega[]"  placeholder="Entrega" required>
                                    </li>
                                </c:if>
                                <c:forEach items="${escopo.entregas}" var = "entrega">
                                    <li>
                                        <input type="hidden" name="id_entrega[]" value="${entrega.id}"/>
                                        <input type="date" class="input-medium" id="input_1" name="data[]" value="${entrega.data}" placeholder="Data" required>
                                        <input type="text" class="input-medium" id="input_1" name="entrega[]" value="${entrega.descricao}" placeholder="Entrega" required>
                                    </li>
                                </c:forEach>
                            </ul>
                            <ul>
                                <li>
                                    <button type="button" id="adicionaAprovador" class="submit" onclick="addEntrega()">Adicionar Entregas</button>
                                </li>
                            </ul>
                            <ul>
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