<%-- 
    Document   : iniciar
    Created on : 06/11/2014, 19:21:56
    Author     : Carol
--%>

<%@ include file="/includes/header.jsp" %>

<div class="container">
    <div class="row-fluid">
        <div class="span12 comment-post">
            <div class="portfolio">
                <div class="span2 item">
                    <img src="${pageContext.request.contextPath}/resources/img/avatares/10.jpg">
                </div>
                <div class="span4">
                    <h2>Olá, ${nomeUsuario != null ? nomeUsuario : ''}!</h2>
                    <p>Você está fazendo parte do SiPP e agora pode gerenciar seus projetos com a melhor ferramenta grátis do mercado.</p>
                </div>
                <div class="span5 offset1">
                    <p><br>Ainda não sabe por onde começar? Logo abaixo você encontra os primeiros passos. AO TRABALHO!</p>
                </div>
            </div>
        </div>
                    
                    
    </div>
    <br>
    <div class="row-fluid">
        <div class="span4">
            <h6>Meus Projetos <a href="#" rel="tooltip" data-original-title="Gerente do Projeto - Projetos criados por você."><i class="icon-question-sign"></i></a></h6>
            <ol>
                <c:forEach items="${projetos}" var="projeto">
                    <li style="padding: 3px 4px 1px 10px;">
                        <div class="row-fluid">
                            <div class="span9 text-overflow">
                                <a href="${pageContext.request.contextPath}/Bootstrap/projeto/indexProjeto/id/${projeto.id}" title="${projeto.titulo}">${projeto.titulo}</a>
                            </div>
                            <div class="span1">
                                <a href="${pageContext.request.contextPath}/Bootstrap/projeto/indexProjeto/id/${projeto.id}" rel="tooltip" data-original-title="Desenvolvimento">
                                    <i class="icon-cogs"></i> <span class="visible-phone">Desenvolvimento</span>
                                </a>
                            </div>
                            <div class="span1">
                                <a href="#" class="editProjeto" onclick="editEquipe(${projeto.id}, '${projeto.titulo}', '${pageContext.request.contextPath}/Bootstrap/usuario/editarEquipe')" rel="tooltip" data-original-title="Equipe">
                                    <i class="icon-group"></i> <span class="visible-phone">Equipe</span>
                                </a>
                            </div>
                            <div class="span1">
                                <a href="#" onclick="excluirProjeto('${pageContext.request.contextPath}/Bootstrap/projeto/excluir/id/${projeto.id}', '${projeto.titulo}');" rel="tooltip" data-original-title="Excluir">
                                    <i class="icon-remove"></i> <span class="visible-phone">Excluir Projeto</span>
                                </a>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ol>
            <ul class="icons">
                <li><a href="#" id="addProjeto"><i class="icon-plus-sign"></i>Adicionar novo</a></li>
            </ul>
        </div>
        <div class="span4">
            <h6>Projetos dos quais faço parte <a href="#" rel="tooltip" data-original-title="Projetos em que você foi adicionado - Necessitam de sua aprovação."><i class="icon-question-sign"></i></a></h6>
            <c:if test="${fn: length(projetoEquipe) gt 0}">
                <c:if test="${fn: length(pendProj) gt 0}">
                    <span>Você não faz parte de nenhum projeto.</span>
                </c:if>
            </c:if>
            <ol>
                <c:forEach items="${projetoEquipe}" var="pe">
                    <li style="padding: 3px 4px 1px 10px;">
                        <div class="row-fluid">
                            <div class="span10 text-overflow">
                                <a href="#" title="${pe.titulo}">${pe.titulo}</a>
                            </div>
                            <div class="span1">
                                <a href="${pageContext.request.contextPath}/Bootstrap/projeto/indexProjeto/id/${pe.id}" rel="tooltip" data-original-title="Desenvolvimento">
                                    <i class="icon-cogs"></i> <span class="visible-phone">Desenvolvimento</span>
                                </a>
                            </div>
                            <div class="span1">
                                <a href="${pageContext.request.contextPath}/Bootstrap/usuarioProjeto/excluir/id/${idUsuario}/idProjeto/${pe.id}" rel="tooltip" data-original-title="Sair">
                                    <i class="icon-signout"></i> <span class="visible-phone">Sair da Equipe</span>
                                </a>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ol>
            <c:if test="${fn: length(pendProjetos) gt 0}">
                <ul class="icons">
                    <li><a href="#" id="aprovProjeto"><i class="icon-warning-sign"></i>Aprovações Pendentes</a></li>
                </ul>
            </c:if>
        </div>
        <div class="span4">
            <h6>Notas <a href="#" rel="tooltip" data-original-title="Adicionar lembretes de afazeres"><i class="icon-question-sign"></i></a></h6>
            <ul class="ads vertical">
                <li class="bg-grunge">
                    <div class="ads-provider"><a href="#"><i class="icon-info-sign"></i></a></div>
                    <div class="ads-content">
                        <h2>Continuar EAP</h2>
                        <p>Efetuar ajustes na EAP, para carregar dados do banco.</p>
                    </div>
                </li>
                <li class="bg-grunge">
                    <div class="ads-provider"><a href="#"><i class="icon-info-sign"></i></a></div>
                    <div class="ads-content">
                        <h2>Esquecer PERT</h2>
                        <p>Efetuar ajustes na EAP, para carregar dados do banco.</p>
                    </div>
                </li>
                <li class="bg-grunge">
                    <div class="ads-provider"><a href="#"><i class="icon-info-sign"></i></a></div>
                    <div class="ads-content">
                        <h2>Ajustes de Cadastro</h2>
                        <p>Efetuar ajustes na EAP, para carregar dados do banco.</p>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <br>
    <div class="row-fluid" id="cadProjeto" style="display: none;">
        <div class="span12 well">
            <form class="contact_form" onsubmit="return validaForm('emailok');"  method="post" action="${pageContext.request.contextPath}/Bootstrap/projeto/salvar">
                <h5>Cadastrar Projeto</h5>
                <ul id="ulForm">
                    <li>
                        <label for="descricao">Título:</label>
                        <input type="text" name="titulo" placeholder="Título" required />
                    </li>
                    <li>
                        <label for="descricao">Equipe:</label>
                        <input type="text" name="email[]" id="email_0" placeholder="E-mail" onblur="verificarEmail('${pageContext.request.contextPath}/Bootstrap/usuario/verificarEmail', this.value, 0, 'emailok');" />
                        <input type="hidden" name="usuario[]" id="usuario_0" />
                        <button class="submit" type="button" onclick="addUsuario('${pageContext.request.contextPath}/Bootstrap/usuario/verificarEmail')"><i class="icon-plus-sign"></i>Mais</button>
                        <button class="submit" type="submit"><i class="icon-save"></i>Salvar</button>
                    </li>
                </ul>
                <input type="hidden" name="count_equipe" id="count_equipe" value="0" />
                <input type="hidden" name="gerente" value="${idUsuario != null ? idUsuario : ''}">
                <input type="hidden" id="emailok" value="1" />
            </form>
        </div>
    </div>
    <br>
    <div class="row-fluid" id="editCadProjeto" style="display: none;">
        <div class="span12 well">
            <form method="post" onsubmit="validaForm('emailequipeok');" class="contact_form" action="${pageContext.request.contextPath}/Bootstrap/usuarioProjeto/editar">
                <h5>Equipe</h5>
                <ul id="ulEquipe">
                    <li>
                        <label>Projeto:</label>
                        <span id="editTitulo"></span><br>
                    </li>
                    <li>
                        <label>Equipe:</label>
                        <input type="text" name="email_edit[]" id="email_edit_0" placeholder="E-mail" onblur="verificarEmail('${pageContext.request.contextPath}/Bootstrap/usuario/verificarEmail', this.value, 'edit_0', 'emailequipeok');" />
                        <button class="submit" type="button" onclick="addUsuarioEdit('${pageContext.request.contextPath}/Bootstrap/usuario/verificarEmail')"><i class="icon-plus-sign"></i>Mais</button>
                        <button class="submit" type="submit"><i class="icon-save"></i>Salvar</button>
                    </li>
                </ul>
                <table id="listaEquipe" class="table table-bordered responsive-utilities"></table>
                <input type="hidden" name="usuario[]" id="usuario_edit_0" />
                <input type="hidden" name="count_equipe_edit" id="count_equipe_edit" value="0" />
                <input type="hidden" name="gerente" value="${idUsuario != null ? idUsuario : ''}">
                <input type="hidden" name="lastProj" id="lastProj" value="">
                <input type="hidden" id="emailequipeok" value="1" />
            </form>
        </div>
    </div>
    <br>
    <div class="row-fluid" id="pendProjeto" style="display: none;">
        <div class="span12 well contact_form">
            <h5>Aprovações de Projetos Pendentes</h5>
            <c:if test="${fn: length(pendProjetos) gt 0}">
                <table class="table table-bordered responsive-utilities">
                    <tr>
                        <th>Projeto</th>
                        <th>Gerente</th>
                        <th style="text-align: center;">Aprovar</th>
                        <th style="text-align: center;">Recusar</th>
                    </tr>
                    <c:forEach items="${pendProjetos}" var="pp">
                        <tr>
                            <td>${pp.titulo}</td>
                            <td>${pp.gerente.nome} ${pp.gerente.sobrenome}</td>
                            <td style="text-align: center; font-size: 22px;"><a href="#" onclick="document.getElementById('aprovarProj').value = ${pp.id}; document.getElementById('formPend').submit();"><i class="icons icon-ok-sign"></i></a></td>
                            <td style="text-align: center; font-size: 22px;"><a href="#" onclick="document.getElementById('recusarProj').value = ${pp.id}; document.getElementById('formPend').submit();"><i class="icons icon-remove-sign"></i></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <form id="formPend" action="${pageContext.request.contextPath}/Bootstrap/usuarioProjeto/atualizar" method="post">
                <input type="hidden" value="" name="aprovarProj" id="aprovarProj">
                <input type="hidden" value="" name="recusarProj" id="recusarProj">
                <input type="hidden" value="${idUsuario != null ? idUsuario : ''}" name="gerente">
            </form>
        </div>
    </div>
</div>
<iframe name="if" id="if" style="visibility: hidden;"></iframe>
<%@ include file="/includes/footer.jsp" %>
