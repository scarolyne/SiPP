<%-- 
    Document   : cadastrar
    Created on : 23/10/2014, 16:09:34
    Author     : Carol
--%>

<%@ include file="../../includes/header.jsp" %>

<div class="container">
    <div class="row add-top">
        <div class="span12">
            <h1 class="title">Cadastro</h1>
        </div>
    </div>
    <div class="row add-top">
        <div class="span12">
            <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/usuario/salvar" method="post" name="contact_form">
                <ul>
                    <li>
                        <label for="name">Nome:</label>
                        <input type="text" value="${user.nome}" name="nome" placeholder="Nome" required />
                    </li>
                    <li>
                        <label for="name">Sobrenome:</label>
                        <input type="text" name="sobrenome" placeholder="Sobrenome" required />
                    </li>
                    <li>
                        <label for="email">E-mail:</label>
                        <input type="email" value="teste"name="email" placeholder="usuario@dominio.com" required />
                        <span class="form_hint">Formato: "usuario@dominio.com"</span>
                    </li>
                    <li>
                        <label for="name">Senha:</label>
                        <input type="password" name="senha" placeholder="Senha" required />
                    </li>
                    <li>
                        <button class="submit" type="submit">Submit Form</button> 
                        
                        <button class="submit" type="reset">Reset Form</button>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>

<%@ include file="/includes/footer.jsp" %>