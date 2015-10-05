<%--
    Document   : TermoAbertura
    Created on : 24/10/2014, 22:18:42
    Author     : VanessaVolochen
--%>

<%@ include file="/includes/headerProjeto.jsp" %>

<div class="tutorial-content">
    <h5 class="title">Tutorial</h5>
    <div class="row-fluid add-top">
        <div class="span12">
            <p style="word-wrap: break-word;">
                O termo de abertura é um documento que formaliza e autoriza a iniciação do projeto. É necessário fornecer informações como a introdução, necessidades básicas, responsabilidades, descrição do produto, entre outros dados. 
                Com isso é possível conhecer as expectativas do cliente.
            </p>
        </div>
    </div>
</div>
</div>
</div>
</div>


<div class="span8">
    <div class="display-dev">
        <div class="display-dev-content" style="height: 99.3%;">
            <h5 class="title">Termo de Abertura</h5>
            <div class="row-fluid add-top">
                <div class="span12">
                    <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/termoAbertura/salvar" method="post" name="contact_form" id="form">
                        <input type="hidden" name="id" value="${termo.id == null ? '' : termo.id}"/>
                        <ul>
                            <li>
                                <label for="name" class="cem">Introdução:</label>
                                <textarea rows="3" style="width: 80%;" name="introducao" placeholder="introducao" required>${termo.introducao}</textarea>
                            </li>
                            <li>
                                <label for="email" class="cem">Responsabilidades do Gerente de Projetos:</label>
                                <textarea rows="3" style="width: 80%;" name="responsabilidade" placeholder="responsabilidade" required>${termo.responsabilidadeGP}</textarea>
                            </li>
                            <li>
                                <label for="name" class="cem">Necessidades Básicas do trabalho a ser realizado: </label>
                                <textarea rows="3" style="width: 80%;" name="necessidade_basica"  placeholder="necessidade_basica" required>${termo.necessidadeBasica}</textarea>
                            </li>
                            <li>
                                <label for="name" class="cem">Descrição do Produto do Projeto: </label>
                                <textarea rows="3" style="width: 80%;" name="descricao_produto"  placeholder="descricao_produto" required>${termo.descricaoProduto}</textarea>
                            </li>
                            <li>
                                <label for="name" class="cem">Estimativas Iniciais de Custo: </label>
                                <textarea rows="3" style="width: 80%;" name="orcamento_inicial"  placeholder="orcamento_inicial" required>${termo.orcamentoInicial}</textarea>
                            </li>
                            <li>
                                <label for="name" class="cem">Necessidade de suporte pela Organização: </label>
                                <textarea rows="3" style="width: 80%;" name="necessidade_suporte" placeholder="necessidade_suporte" required>${termo.necessidadeSuporte}</textarea>
                            </li>
                            <li>
                                <label for="name" class="cem">Controle e gerenciamento das informações do projeto: </label>
                                <textarea rows="3" style="width: 80%;" name="controle_informacao" placeholder="controle_informacao" required>${termo.controleInformacao}</textarea>
                            </li>
                        </ul>
                        <h6>Entregas Projeto</h6>
                        <ul id="ulForm">
                            <li>
                                <label>Data</label>
                                <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Descrição</label>
                                <br>
                            </li>
                            <c:if test="${termo.entregas == null }">
                                <li>
                                    <input type="hidden" name="id_entrega[]" value="${entrega.id == null ? '' : entrega.id }"/>
                                    <input type="date" class="input-medium" id="input_1" name="data[]" placeholder="Data" required>
                                    <input type="text" class="input-medium" id="input_1" name="entrega[]"  placeholder="Entrega" required>
                                </li>
                            </c:if>
                            <c:forEach items="${termo.entregas}" var="entrega">
                                <li>
                                    
                                        <input type="hidden" name="id_entrega[]" value="${entrega.id == null ? '' : entrega.id }"/>
                                        <input type="date" class="input-medium" id="input_1" name="data[]" value="${entrega.data}" placeholder="Data" required>
                                        <input type="text" class="input-medium" id="input_1" name="entrega[]" value="${entrega.descricao}" placeholder="Entrega" required>
                                 
                                  
                                        <a href="#" onclick="excluirEntrega('${pageContext.request.contextPath}/Bootstrap/termoAbertura/excluirEntrega/id/${entrega.id}';" rel="tooltip" data-original-title="Excluir">
                                            <i class="icon-remove"></i> <span class="visible-phone">Excluir Entregas</span>
                                        </a>
                                 
                                </li>
                            </c:forEach>
                        </ul>
                        <ul id="ulForm1">
                            <li>
                                <button type="button" id="adicionaAprovador" class="submit" onclick="addEntrega()">Adicionar Entregas</button>
                            </li>
                            <c:if test="${termo.aprovadores == null }">
                                <li>
                                    <label for="name">Aprovadores do Projeto: </label>
                                    <input type="text" class="input-xlarge" id="input_0" name="aprovador[]" value="${aprov.nome}" placeholder="Aprovador" required>
                                </li>   
                            </c:if>
                            <c:forEach items="${termo.aprovadores}" var = "aprov">
                                <li>
                                    <label for="name">Aprovadores do Projeto: </label>
                                    <input type="text" class="input-xlarge" id="input_0" name="aprovador[]" value="${aprov.nome}" placeholder="Aprovador" required>       
                                
                                    <a href="#" id="excluirAprovador" rel="tooltip" data-original-title="Excluir">
                                        <i class="icon-remove"></i> <span class="visible-phone">Excluir Entregas</span>
                                    </a>
                                </li>
                              
                            </c:forEach>
                        </ul>
                        <ul>
                            <li>
                                <label>&nbsp;</label>
                                <button type="button" id="adicionaAprovador" class="submit" onclick="addAprovador()">Adicionar Aprovador</button>
                            </li>
                        </ul>
                        <ul>
                            <li>
                                <button class="submit" type="submit">Salvar</button>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>

        <%@include file="/includes/footerProjeto.jsp" %>