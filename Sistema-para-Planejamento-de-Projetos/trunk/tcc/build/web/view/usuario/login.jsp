<%--
    Document   : login
    Created on : 28/10/2014, 22:26:53
    Author     : Carol
--%>

<%@ include file="/includes/header.jsp" %>

<div class="container">
    <div class="row add-top">
        <c:if test="${mensagemErro != null}">
            <div class="span5">
                <div class="alert alert-error">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    ${mensagemErro}
                </div>
            </div>
         </c:if>
        <div class="span12">
            <h1 class="title">Login</h1>
        </div>
    </div>
    <div class="row add-top">
        <div class="span12">
            <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/usuario/logar" method="post" name="contact_form">
                <ul>
                    <li>
                        <label for="name">Email:</label>
                        <input type="text" value="${email}" name="email" placeholder="Nome" required />
                    </li>
                    <li>
                        <label for="name">Senha:</label>
                        <input type="password" name="senha" placeholder="Senha" required />
                    </li>
                    <li>
                        <button class="submit" type="submit">Entrar</button>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>

<%@ include file="/includes/footer.jsp" %>