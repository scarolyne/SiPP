<%--
    Document   : definicaoEscopo
    Created on : 24/10/2014, 22:18:42
    Author     : Camyla
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
                <h5 class="title">Casos de Uso</h5>
                <div class="row-fluid add-top">
                    <div class="span12">
                        <img src="${pageContext.request.contextPath}/casos_usos/3.jpg"/>
                        <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/DefinicaoEscopo/salvar" method="post" name="contact_form">
                            <ul id="ulForm">   
                                <li>
                                    <label for="name"  name="tipo">Selecione: </label>
                                    <select id="tipo">
                                        <option>Selecione</option>
                                        <option value="ator">Ator</option>
                                        <option value="caso">Casos de Uso</option>
                                    </select>
                                </li>

                                <li>
                                    <label for="name">Nome: </label>
                                    <input type="text" value="${user.sobrenome}" name="nome" placeholder="Sobrenome" required />
                                </li>
                                <li>
                                    <label for="name">Complexidade: </label>
                                    <select id="complexidade" name="complexidade">
                                        <option>Selecione</option>
                                        <option>Complexo</option>
                                        <option>Médio</option>
                                        <option>Simples</option>

                                    </select>
                                </li>
                                <li>
                                    <button id="adicionaUC" class="submit" name ="botao" type="button">Gravar</button> 
                                    <button class="submit"  type="reset">Limpar</button>
                                </li>
                            </ul>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="guider" id="guider_1" style="top: 15px; left: 60px; word-wrap: break-word;">
        <div class="guider-border">
            <div class="guider-set" style="top: 12px; left: -15px;"></div>
            <p class="guider-header">TESTE</p>
            <p class="guider-content">blablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablabla</p>
            <p class="guider-buttons">
                <button class="submit" onclick="showGuider(1, 2);">Próximo</button>
            </p>
        </div>
    </div>

    <div class="guider" id="guider_2" style="top: 115px; left: 560px; word-wrap: break-word; display: none;">
        <div class="guider-border">
            <div class="guider-set" style="top: 12px; left: -15px;"></div>
            <p class="guider-header">TESTE</p>
            <p class="guider-content">blablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablabla</p>
            <p class="guider-buttons">
                <button class="submit" onclick="showGuider(2, 1);">Anterior</button>
                <button class="submit" onclick="showGuider(2, 3);">Próximo</button>
            </p>
        </div>
    </div>

    <%@include file="/includes/footerProjeto.jsp" %>