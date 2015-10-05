<%-- 
    Document   : index
    Created on : 23/10/2014, 14:39:32
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
        <div class="span4 well" style="text-align: center;">
            <h1 class="title" style="font-size: 100px;">&nbsp;</h1><br>
            <h1 class="title" style="font-size: 15em;">S<span style="color: #68BA25">i</span>PP</h1><br><br><br><br>
            <span style="font-size: 1.1em;">Sistema para Planejamento de Projetos</span><br><br><br><br><br><br><br>
            <i class="icon-sitemap" style="font-size: 15em;"></i>
        </div>
        <div class="span3 well">
            <h1 class="title">Login</h1>
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
        <div class="span3 well">
            <h1 class="title">Cadastro</h1>
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