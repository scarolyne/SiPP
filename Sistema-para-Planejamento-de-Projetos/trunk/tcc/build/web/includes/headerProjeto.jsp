<%--
    Document   : headerProjeto
    Created on : 25/10/2014, 17:10:54
    Author     : Carol
--%>

<%@ include file="/includes/configProjeto.jsp" %>

<body>
    <div class="container-projeto">
        <div class="mp-pusher" id="mp-pusher">
            <nav id="mp-menu" class="mp-menu">
                <div class="mp-level">
                    <h2>ETAPAS DO PROJETO</h2>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/Bootstrap/termoAbertura/cadastrar">Termo de Abertura</a></li>
                        <li><a href="${pageContext.request.contextPath}/Bootstrap/DefinicaoEscopo/buscar">Definição de Escopo</a></li>

                        <li><a href="#">Plano de Atividades</a>
                            <div class="mp-level">
                                <h2>Plano de Atividades</h2>
                                <a class="mp-back" href="#">VOLTAR</a>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/Bootstrap/atividade/carregar">EAP</a></li>
                                    <li><a href="${pageContext.request.contextPath}/Bootstrap/Gantt">Diagrama Gantt</a></li>
                                </ul>
                            </div>
                        </li>
                        <li><a href="#">Pontos por Casos de Uso</a>
                            <div class="mp-level">
                                <h2>Pontos por Casos de Uso</h2>
                                <a class="mp-back" href="#">VOLTAR</a>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/Bootstrap/CasoDeUso/upload">Upload</a></li>
                                    <li><a href="${pageContext.request.contextPath}/Bootstrap/CasoDeUso/cadastrar">Casos de Uso</a></li>
                                    <li><a href="${pageContext.request.contextPath}/Bootstrap/fator/buscarFatoresTecnico">Fator de Complexidade Técnica</a></li>
                                    <li><a href="${pageContext.request.contextPath}/Bootstrap/fator/buscarFatoresAmbiental">Fator de Complexidade Ambiental</a></li>
                                    <li><a href="${pageContext.request.contextPath}/Bootstrap/pontoUC/calculoUC">Calculo</a></li>
                                </ul>
                            </div>
                        </li>
                        <li><a href="#">Recursos Humanos</a>
                            <div class="mp-level">
                                <h2>Recursos Humanos</h2>
                                <a class="mp-back" href="#">VOLTAR</a>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/Bootstrap/cargo/index">Função</a>
                                    <li><a href="${pageContext.request.contextPath}/Bootstrap/Profissional">Profissional</a></li>

                                </ul>
                            </div>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/view/planoComunicacao/pesquisar.jsp">Plano de Comunicação</a></li>
                        <li><a href="${pageContext.request.contextPath}/Bootstrap/riscos/index">Plano de Riscos</a></li>
                        <li><a href="${pageContext.request.contextPath}/Bootstrap/PlanoDeCusto">Plano de Custo</a></li>
                        <li><a href="#">Visualizar Projeto</a>
                            <div class="mp-level">
                                <h2>Visualizar Projeto</h2>
                                <a class="mp-back" href="#">VOLTAR</a>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/Bootstrap/pdf/geraPdf" target="_blank">PDF</a></li>
                                    <li><a href="${pageContext.request.contextPath}/Bootstrap/pdf/geraPdfPlanos" target="_blank">PDF Planos</a></li>

                                </ul>
                            </div>
                        </li>

                        <li><a href="${pageContext.request.contextPath}/Bootstrap/usuario">Sair da Área de Desenvolvimento</a></li>

                    </ul>
                </div>
            </nav>
        <div class="row-fluid">
            <div class="span4">
                <div class="display-dev">
                    <div class="tutorial">
                        <h2>
                            <a href="#" id="trigger" class="icon-reorder"></a>
                            <span class="logo">
                                S<span style="color: #53B808">i</span>PP <i class="icon-sitemap"></i>
                            </span>
                        </h2>

