<%--
    Document   : definicaoEscopo
    Created on : 24/10/2014, 22:18:42
    Author     : Camyla
--%>

<%@ include file="/includes/headerProjeto.jsp" %>
<script>
    function showGuider(x, y) {
        ap = document.getElementById('guider_' + x);
        atual = document.getElementById('guider_' + y);

        ap.style.display = "inline";
        atual.style.display = "none";
    }
</script>

                <div class="tutorial-content">
                    <h5 class="title">Tutorial</h5>
                    <div class="row-fluid add-top">
                        <div class="span12">
                            <p style="word-wrap: break-word;">
                                O Diagrama de Casos de Uso tem o objetivo de auxiliar a comunicação entre o analista e o cliente, descrevendo um cenário que mostra as funcionalidades do sistema do ponto de vista do usuário.
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

                    <%@ include file="/includes/mensagens.jsp" %>

                    <div class="span12">
                        <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/CasoDeUso/salvarImagem" method="post" name="contact_form" enctype="multipart/form-data">
                            <ul>
                                <li>
                                    <label for="name">Casos de Uso: </label>
                                    <input type ="file" name="arquivo"/>

                                    <!--<input type ="submit" class ="btn btn-primary" name ="botao" value="Enviar"/>-->
                                    <button class="submit" type="submit">Salvar</button>

                                </li>
                            </ul>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <%@include file="/includes/footerProjeto.jsp" %>