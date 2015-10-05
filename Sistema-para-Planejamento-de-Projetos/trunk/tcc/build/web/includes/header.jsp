<%--
    Document   : index
    Created on : 23/10/2014, 14:39:32
    Author     : Carol
--%>
<%@ include file="config.jsp" %>
<body>
    <header id="header">
        <div class="container">
            <div class="navbar">
                <div class="navbar-inner">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">
                        S<span style="color: #75DB27">i</span>PP <i class="icon-sitemap"></i>
                    </a>
                    <div class="nav-collapse">
                        <ul class="nav pull-right">
                            <c:if test="${usuario == null}">
                                <li ${menu == null ? "class='active'" : ""}><a href="${pageContext.request.contextPath}/view/index.jsp">Início</a></li>
                            </c:if>
                            <c:if test="${usuario != null}">
                                <li ${menu == "Meus Projetos" ? "class='active'" : ""}><a href="${pageContext.request.contextPath}/Bootstrap/usuario">Meus Projetos</a></li>
                            </c:if>
                            <li ${menu == "Minha Conta" ? "class='active'" : ""}><a href="${pageContext.request.contextPath}/Bootstrap/usuario/cadastrar">${nomeUsuario != null ? 'Minha Conta' : 'Cadastro'}</a></li>
                            <li ${menu == "Login" ? "class='active'" : ""}><a href="${pageContext.request.contextPath}${nomeUsuario != null ? '/Bootstrap/usuario/logout' : '/Bootstrap/usuario/login'}">${nomeUsuario != null ? 'Logout' : 'Login'}</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </header>