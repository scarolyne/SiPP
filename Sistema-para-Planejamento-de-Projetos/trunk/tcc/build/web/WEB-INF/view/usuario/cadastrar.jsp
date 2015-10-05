<%--
    Document   : cadastrar
    Created on : 23/10/2014, 16:09:34
    Author     : Carol
--%>

<%@ include file="/includes/header.jsp" %>

<div class="container">
    <div class="row add-top">
        <div class="span12">
            <h1 class="title">Cadastro</h1>
        </div>
    </div>
    <div class="row add-top">

        <%@ include file="/includes/mensagens.jsp" %>

        <div class="span12">

            <form class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/usuario/salvar" method="post" name="contact_form">
                <ul>
                    <input type="hidden" name="id_user" value="${user.id == null ? 0 : user.id }"/>
                    <li>
                        <label for="name">Nome:</label>
                        <input type="text" value="${user.nome}" name="nome" placeholder="Nome" required />
                    </li>
                    <li>
                        <label for="name">Sobrenome:</label>
                        <input type="text" value="${user.sobrenome}" name="sobrenome" placeholder="Sobrenome" required />
                    </li>
                    <li>
                        <label for="email">E-mail:</label>
                        <input type="email" value="${user.email}" name="email" placeholder="usuario@dominio.com" required />
                        <span class="form_hint">Formato: "usuario@dominio.com"</span>
                    </li>
                    <c:choose>                      
                        <c:when test="${user != null}">
                            <li>
                                <label for="name">Senha atual</label>
                                <input type="password" value="" name="senhaAtual" placeholder="Senha Atual"/>
                            </li>
                            <li>
                                <label for="name">Nova Senha:</label>
                                <input type="password" value="" name="senha" placeholder="Nova Senha" />
                            </li>
                        </c:when>
                        <c:otherwise>
                             <li>
                                <label for="name">Senha:</label>
                                <input type="password" value="" name="senha" placeholder="Senha" required />
                            </li>
                        </c:otherwise>    
                    </c:choose>
                    <li>
                        <button class="submit" type="submit">Salvar</button>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>

<%@ include file="/includes/footer.jsp" %>