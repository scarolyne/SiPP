package org.apache.jsp.view.usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class iniciar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:length", org.apache.taglibs.standard.functions.Functions.class, "length", new Class[] {java.lang.Object.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/includes/header.jsp");
    _jspx_dependants.add("/includes/config.jsp");
    _jspx_dependants.add("/includes/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--[if lt IE 7 ]><html class=\"ie ie6\" lang=\"pt-br\"> <![endif]-->\n");
      out.write("<!--[if IE 7 ]><html class=\"ie ie7\" lang=\"pt-br\"> <![endif]-->\n");
      out.write("<!--[if IE 8 ]><html class=\"ie ie8\" lang=\"pt-br\"> <![endif]-->\n");
      out.write("<!--[if (gte IE 9)|!(IE)]><!--><html lang=\"pt-br\"> <!--<![endif]-->\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>TCC</title>\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"scarolyne\">\n");
      out.write("\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/css/bootstrap.css\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/css/bootstrap-responsive.css\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/css/style.css\">\n");
      out.write("\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:700,400,300,200' rel='stylesheet' type='text/css'>\n");
      out.write("    \n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/modernizr.custom.79639.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/modernizr.custom.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/functions.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/custom.js\"></script>\n");
      out.write("\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("        <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("    <link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/img/favicon.ico\">\n");
      out.write("    <link rel=\"apple-touch-icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/img/apple-touch-icon.png\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"57x57\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/img/apple-touch-icon-57x57.png\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/img/apple-touch-icon-72x72.png\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/img/apple-touch-icon-114x114.png\">\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"144x144\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/img/apple-touch-icon-144x144.png\">\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("</head>");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <header id=\"header\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"navbar\">\r\n");
      out.write("                <div class=\"navbar-inner\">\r\n");
      out.write("                    <a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\">\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a class=\"brand\" href=\"#\">\r\n");
      out.write("                        S<span style=\"color: #75DB27\">i</span>PP <i class=\"icon-sitemap\"></i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <div class=\"nav-collapse\">\r\n");
      out.write("                        <ul class=\"nav pull-right\">\r\n");
      out.write("                            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            <li ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu == \"Minha Conta\" ? \"class='active'\" : \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/usuario/cadastrar\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nomeUsuario != null ? 'Minha Conta' : 'Cadastro'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\r\n");
      out.write("                            <li ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu == \"Login\" ? \"class='active'\" : \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nomeUsuario != null ? '/Bootstrap/usuario/logout' : '/Bootstrap/usuario/login'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nomeUsuario != null ? 'Logout' : 'Login'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"row-fluid\">\n");
      out.write("        <div class=\"span12 comment-post\">\n");
      out.write("            <div class=\"portfolio\">\n");
      out.write("                <div class=\"span2 item\">\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/img/avatares/10.jpg\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"span4\">\n");
      out.write("                    <h2>Olá, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nomeUsuario != null ? nomeUsuario : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("!</h2>\n");
      out.write("                    <p>Você está fazendo parte do SiPP e agora pode gerenciar seus projetos com a melhor ferramenta grátis do mercado.</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"span5 offset1\">\n");
      out.write("                    <p><br>Ainda não sabe por onde começar? Logo abaixo você encontra os primeiros passos. AO TRABALHO!</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("    </div>\n");
      out.write("    <br>\n");
      out.write("    <div class=\"row-fluid\">\n");
      out.write("        <div class=\"span4\">\n");
      out.write("            <h6>Meus Projetos <a href=\"#\" rel=\"tooltip\" data-original-title=\"Gerente do Projeto - Projetos criados por você.\"><i class=\"icon-question-sign\"></i></a></h6>\n");
      out.write("            <ol>\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </ol>\n");
      out.write("            <ul class=\"icons\">\n");
      out.write("                <li><a href=\"#\" id=\"addProjeto\"><i class=\"icon-plus-sign\"></i>Adicionar novo</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"span4\">\n");
      out.write("            <h6>Projetos dos quais faço parte <a href=\"#\" rel=\"tooltip\" data-original-title=\"Projetos em que você foi adicionado - Necessitam de sua aprovação.\"><i class=\"icon-question-sign\"></i></a></h6>\n");
      out.write("            ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            <ol>\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </ol>\n");
      out.write("            ");
      if (_jspx_meth_c_if_4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"span4\">\n");
      out.write("            <h6>Notas <a href=\"#\" rel=\"tooltip\" data-original-title=\"Adicionar lembretes de afazeres\"><i class=\"icon-question-sign\"></i></a></h6>\n");
      out.write("            <ul class=\"ads vertical\">\n");
      out.write("                <li class=\"bg-grunge\">\n");
      out.write("                    <div class=\"ads-provider\"><a href=\"#\"><i class=\"icon-info-sign\"></i></a></div>\n");
      out.write("                    <div class=\"ads-content\">\n");
      out.write("                        <h2>Continuar EAP</h2>\n");
      out.write("                        <p>Efetuar ajustes na EAP, para carregar dados do banco.</p>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"bg-grunge\">\n");
      out.write("                    <div class=\"ads-provider\"><a href=\"#\"><i class=\"icon-info-sign\"></i></a></div>\n");
      out.write("                    <div class=\"ads-content\">\n");
      out.write("                        <h2>Esquecer PERT</h2>\n");
      out.write("                        <p>Efetuar ajustes na EAP, para carregar dados do banco.</p>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"bg-grunge\">\n");
      out.write("                    <div class=\"ads-provider\"><a href=\"#\"><i class=\"icon-info-sign\"></i></a></div>\n");
      out.write("                    <div class=\"ads-content\">\n");
      out.write("                        <h2>Ajustes de Cadastro</h2>\n");
      out.write("                        <p>Efetuar ajustes na EAP, para carregar dados do banco.</p>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <br>\n");
      out.write("    <div class=\"row-fluid\" id=\"cadProjeto\" style=\"display: none;\">\n");
      out.write("        <div class=\"span12 well\">\n");
      out.write("            <form class=\"contact_form\" onsubmit=\"return validaForm('emailok');\"  method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/projeto/salvar\">\n");
      out.write("                <h5>Cadastrar Projeto</h5>\n");
      out.write("                <ul id=\"ulForm\">\n");
      out.write("                    <li>\n");
      out.write("                        <label for=\"descricao\">Título:</label>\n");
      out.write("                        <input type=\"text\" name=\"titulo\" placeholder=\"Título\" required />\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <label for=\"descricao\">Equipe:</label>\n");
      out.write("                        <input type=\"text\" name=\"email[]\" id=\"email_0\" placeholder=\"E-mail\" onblur=\"verificarEmail('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/usuario/verificarEmail', this.value, 0, 'emailok');\" />\n");
      out.write("                        <input type=\"hidden\" name=\"usuario[]\" id=\"usuario_0\" />\n");
      out.write("                        <button class=\"submit\" type=\"button\" onclick=\"addUsuario('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/usuario/verificarEmail')\"><i class=\"icon-plus-sign\"></i>Mais</button>\n");
      out.write("                        <button class=\"submit\" type=\"submit\"><i class=\"icon-save\"></i>Salvar</button>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <input type=\"hidden\" name=\"count_equipe\" id=\"count_equipe\" value=\"0\" />\n");
      out.write("                <input type=\"hidden\" name=\"gerente\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${idUsuario != null ? idUsuario : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <input type=\"hidden\" id=\"emailok\" value=\"1\" />\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <br>\n");
      out.write("    <div class=\"row-fluid\" id=\"editCadProjeto\" style=\"display: none;\">\n");
      out.write("        <div class=\"span12 well\">\n");
      out.write("            <form method=\"post\" onsubmit=\"validaForm('emailequipeok');\" class=\"contact_form\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/usuarioProjeto/editar\">\n");
      out.write("                <h5>Equipe</h5>\n");
      out.write("                <ul id=\"ulEquipe\">\n");
      out.write("                    <li>\n");
      out.write("                        <label>Projeto:</label>\n");
      out.write("                        <span id=\"editTitulo\"></span><br>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <label>Equipe:</label>\n");
      out.write("                        <input type=\"text\" name=\"email_edit[]\" id=\"email_edit_0\" placeholder=\"E-mail\" onblur=\"verificarEmail('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/usuario/verificarEmail', this.value, 'edit_0', 'emailequipeok');\" />\n");
      out.write("                        <button class=\"submit\" type=\"button\" onclick=\"addUsuarioEdit('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/usuario/verificarEmail')\"><i class=\"icon-plus-sign\"></i>Mais</button>\n");
      out.write("                        <button class=\"submit\" type=\"submit\"><i class=\"icon-save\"></i>Salvar</button>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <table id=\"listaEquipe\" class=\"table table-bordered responsive-utilities\"></table>\n");
      out.write("                <input type=\"hidden\" name=\"usuario[]\" id=\"usuario_edit_0\" />\n");
      out.write("                <input type=\"hidden\" name=\"count_equipe_edit\" id=\"count_equipe_edit\" value=\"0\" />\n");
      out.write("                <input type=\"hidden\" name=\"gerente\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${idUsuario != null ? idUsuario : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"lastProj\" id=\"lastProj\" value=\"\">\n");
      out.write("                <input type=\"hidden\" id=\"emailequipeok\" value=\"1\" />\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <br>\n");
      out.write("    <div class=\"row-fluid\" id=\"pendProjeto\" style=\"display: none;\">\n");
      out.write("        <div class=\"span12 well contact_form\">\n");
      out.write("            <h5>Aprovações de Projetos Pendentes</h5>\n");
      out.write("            ");
      if (_jspx_meth_c_if_5(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            <form id=\"formPend\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Bootstrap/usuarioProjeto/atualizar\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" value=\"\" name=\"aprovarProj\" id=\"aprovarProj\">\n");
      out.write("                <input type=\"hidden\" value=\"\" name=\"recusarProj\" id=\"recusarProj\">\n");
      out.write("                <input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${idUsuario != null ? idUsuario : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"gerente\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<iframe name=\"if\" id=\"if\" style=\"visibility: hidden;\"></iframe>\n");
      out.write("  \r\n");
      out.write("\t\t<footer>\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<div class=\"row-fluid\">\r\n");
      out.write("\t\t\t\t\t<div class=\"span4\">\r\n");
      out.write("\t\t\t\t\t\t<h6>Ultimas postagens</h6>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"footer-list\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">TCC text example.</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">TCC text example.</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">TCC text example.</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">TCC text example.</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">TCC text example.</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">TCC text example.</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"span4\">\r\n");
      out.write("\t\t\t\t\t\t<h6>Redes sociais</h6>\r\n");
      out.write("\t\t\t\t\t\t<blockquote class=\"feed\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>TCC text example <a href=\"#\">@TCC</a>. TCC text example <a href=\"#\">http://TCC.com/</a><p>\r\n");
      out.write("\t\t\t\t\t\t\t<cite>TCC text example. (31/12/2014)</cite>\r\n");
      out.write("\t\t\t\t\t\t</blockquote>\r\n");
      out.write("\t\t\t\t\t\t<blockquote class=\"feed\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>TCC text example <a href=\"#\">@TCC</a>. TCC text example <a href=\"#\">http://TCC.com/</a><p>\r\n");
      out.write("\t\t\t\t\t\t\t<cite>TCC text example. (31/12/2014)</cite>\r\n");
      out.write("\t\t\t\t\t\t</blockquote>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"span4\">\r\n");
      out.write("\t\t\t\t\t\t<h6>Sobre nós</h6>\r\n");
      out.write("\t\t\t\t\t\t<p>TCC text example. TCC text example. TCC text example. TCC text example.</p>\r\n");
      out.write("\t\t\t\t\t\t<address><i class=\"icon-pushpin\"></i>TCC Motherfucker<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tRua tal, nº 9821, Curitiba/PR</address>\r\n");
      out.write("\t\t\t\t\t\t<address><i class=\"icon-phone\"></i>5555-5555</address>\r\n");
      out.write("\t\t\t\t\t\t<address><i class=\"icon-envelope\"></i>support@TCC.com</address>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"span6 copyright\">\r\n");
      out.write("\t\t\t\t\t<p>Copyright &copy; TCC. Todos os direitos reservados.</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"span6 footnav\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Termos</a></li> \r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Privacidade</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t<div class=\"scrollTop\">\r\n");
      out.write("\t\t\t<a href=\"javascript:void(0);\"><i class=\"icon-chevron-up\"></i></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/bootstrap.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/jquery.cookie.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/jquery.ba-cond.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/custom.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <li ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu == null ? \"class='active'\" : \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/view/index.jsp\">Início</a></li>\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <li ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu == \"Meus Projetos\" ? \"class='active'\" : \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("><a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/Bootstrap/usuario\">Meus Projetos</a></li>\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projetos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("projeto");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <li style=\"padding: 3px 4px 1px 10px;\">\n");
          out.write("                        <div class=\"row-fluid\">\n");
          out.write("                            <div class=\"span9 text-overflow\">\n");
          out.write("                                <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/Bootstrap/projeto/indexProjeto/id/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projeto.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" title=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projeto.titulo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projeto.titulo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("                            </div>\n");
          out.write("                            <div class=\"span1\">\n");
          out.write("                                <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/Bootstrap/projeto/indexProjeto/id/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projeto.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" rel=\"tooltip\" data-original-title=\"Desenvolvimento\">\n");
          out.write("                                    <i class=\"icon-cogs\"></i> <span class=\"visible-phone\">Desenvolvimento</span>\n");
          out.write("                                </a>\n");
          out.write("                            </div>\n");
          out.write("                            <div class=\"span1\">\n");
          out.write("                                <a href=\"#\" class=\"editProjeto\" onclick=\"editEquipe(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projeto.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(", '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projeto.titulo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("', '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/Bootstrap/usuario/editarEquipe')\" rel=\"tooltip\" data-original-title=\"Equipe\">\n");
          out.write("                                    <i class=\"icon-group\"></i> <span class=\"visible-phone\">Equipe</span>\n");
          out.write("                                </a>\n");
          out.write("                            </div>\n");
          out.write("                            <div class=\"span1\">\n");
          out.write("                                <a href=\"#\" onclick=\"excluirProjeto('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/Bootstrap/projeto/excluir/id/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projeto.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("', '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projeto.titulo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("');\" rel=\"tooltip\" data-original-title=\"Excluir\">\n");
          out.write("                                    <i class=\"icon-remove\"></i> <span class=\"visible-phone\">Excluir Projeto</span>\n");
          out.write("                                </a>\n");
          out.write("                            </div>\n");
          out.write("                        </div>\n");
          out.write("                    </li>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn: length(projetoEquipe) gt 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_0)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                ");
        if (_jspx_meth_c_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_2, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn: length(pendProj) gt 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_0)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <span>Você não faz parte de nenhum projeto.</span>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projetoEquipe}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("pe");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <li style=\"padding: 3px 4px 1px 10px;\">\n");
          out.write("                        <div class=\"row-fluid\">\n");
          out.write("                            <div class=\"span10 text-overflow\">\n");
          out.write("                                <a href=\"#\" title=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pe.titulo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pe.titulo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("                            </div>\n");
          out.write("                            <div class=\"span1\">\n");
          out.write("                                <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/Bootstrap/projeto/indexProjeto/id/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pe.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" rel=\"tooltip\" data-original-title=\"Desenvolvimento\">\n");
          out.write("                                    <i class=\"icon-cogs\"></i> <span class=\"visible-phone\">Desenvolvimento</span>\n");
          out.write("                                </a>\n");
          out.write("                            </div>\n");
          out.write("                            <div class=\"span1\">\n");
          out.write("                                <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/Bootstrap/usuarioProjeto/excluir/id/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${idUsuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/idProjeto/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pe.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" rel=\"tooltip\" data-original-title=\"Sair\">\n");
          out.write("                                    <i class=\"icon-signout\"></i> <span class=\"visible-phone\">Sair da Equipe</span>\n");
          out.write("                                </a>\n");
          out.write("                            </div>\n");
          out.write("                        </div>\n");
          out.write("                    </li>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent(null);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn: length(pendProjetos) gt 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_0)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <ul class=\"icons\">\n");
        out.write("                    <li><a href=\"#\" id=\"aprovProjeto\"><i class=\"icon-warning-sign\"></i>Aprovações Pendentes</a></li>\n");
        out.write("                </ul>\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }

  private boolean _jspx_meth_c_if_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent(null);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fn: length(pendProjetos) gt 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_0)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <table class=\"table table-bordered responsive-utilities\">\n");
        out.write("                    <tr>\n");
        out.write("                        <th>Projeto</th>\n");
        out.write("                        <th>Gerente</th>\n");
        out.write("                        <th style=\"text-align: center;\">Aprovar</th>\n");
        out.write("                        <th style=\"text-align: center;\">Recusar</th>\n");
        out.write("                    </tr>\n");
        out.write("                    ");
        if (_jspx_meth_c_forEach_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_5, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                </table>\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_5);
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pendProjetos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVar("pp");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <tr>\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pp.titulo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pp.gerente.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pp.gerente.sobrenome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                            <td style=\"text-align: center; font-size: 22px;\"><a href=\"#\" onclick=\"document.getElementById('aprovarProj').value = ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pp.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("; document.getElementById('formPend').submit();\"><i class=\"icons icon-ok-sign\"></i></a></td>\n");
          out.write("                            <td style=\"text-align: center; font-size: 22px;\"><a href=\"#\" onclick=\"document.getElementById('recusarProj').value = ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pp.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("; document.getElementById('formPend').submit();\"><i class=\"icons icon-remove-sign\"></i></a></td>\n");
          out.write("                        </tr>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
}
