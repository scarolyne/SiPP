<% //session.setAttribute("page", "features"); %>

<%@ include file="/includes/header.jsp" %>

<div class="container">
    <div class="row add-top">
        <div class="span12">
            <h1 class="title">Lista de Recursos</h1>
            
            <ul class="breadcrumb add-top">
                <li class="active"><strong>Indíce</strong> &raquo;&nbsp;&nbsp;</li>
                <li><a href="#list">Listas</a> :</li>
                <li><a href="#tabs">Tabs</a> :</li>
                <li><a href="#global">Configurações Gerais</a> :</li>
                <li><a href="#defaultgrid">Default Grid</a> :</li>
                <li><a href="#fluidgrid">Fluid Grid</a> :</li>
                <li><a href="#responsive">Design Responsivo</a> :</li>
                <li><a href="#buttons">Botões</a> :</li>
                <li><a href="#forms">Formulários</a> :</li>
                <li><a href="#misc">Misc</a></li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="span12">
            <h2 id="list">Lists Styles</h2>
            <p>TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. 
                TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. 
                TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example.</p>
        </div>
    </div>
    
    <div class="row">
        <div class="span4">
            <h6>ul class="type1"</h6>
            <ul class="type1">
                <li>List item longer description.</li>
                <li>List item</li>
                <li>List item
                    <ul>
                    <li>Nested List Item</li>
                    <li>Nested List Item</li>
                    <li>Nested List Item</li>
                    </ul>
                </li>
                <li>List item</li>
                <li>List item</li>
                <li>List item</li>
            </ul>
        </div>
        
        <div class="span4">   
            <h6>ul class="type2"</h6>         
            <ul class="type2">
                <li>List item longer description.</li>
                <li>List item</li>
                <li>List item
                    <ul>
                    <li>Nested List Item</li>
                    <li>Nested List Item</li>
                    <li>Nested List Item</li>
                    </ul>
                </li>
                <li>List item</li>
                <li>List item</li>
                <li>List item</li>
            </ul>
        </div>
        
        <div class="span4">
            <h6>ul class="sidenav"</h6>
            <ul class="sidenav">
            	<li><a href="#">default li</a></li>
  				<li class="active"><a href="#">li class="active"</a></li>
                <li><a href="#">default li</a></li>
  				<li><a href="#">default li</a></li>
			</ul>
        </div>
        
    </div>
    
    <div class="row add-top-large">
        
        <div class="span4">
            <h6>ul class="icons"</h6>
            <ul class="icons">
                <li><i class="icon-ok"></i> i class="icon-ok"</li>
                <li><i class="icon-ok"></i> i class="icon-ok"</li>
                <li><i class="icon-remove"></i> i class="icon-remove"</li>
                <li><i class="icon-remove"></i> i class="icon-remove"</li>
                <li><i class="icon-ok"></i> i class="icon-ok"</li>
			</ul>
        </div>
        
        <div class="span4">
            <h6>ul class="icons"</h6>
            <ul class="icons">
                <li><i class="icon-facebook"></i> i class="icon-facebook"</li>
                <li><i class="icon-twitter"></i> i class="icon-twitter"</li>
                <li><i class="icon-google-plus"></i> i class="icon-google-plus"</li>
                <li><i class="icon-pinterest"></i> i class="icon-pinterest"</li>
                <li><i class="icon-linkedin"></i> i class="icon-linkedin"</li>
			</ul>
        </div>
        
        <div class="span4">
            <h6>Tag < ol ></h6>       
            <ol>
                <li>List item longer description.</li>
                <li>List item</li>
                <li>List item</li>
            </ol>
        </div>
    </div>
    
    <div class="row add-top-large">
        <div class="span12">
            <h2 id="tabs">Tabs</h2>
            <p>TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. 
			   TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. 
			   TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example.</p>
            
            <ul id="myTab" class="tabs row-fluid">
                <li class="span3 active"><a href="#tcc1" data-toggle="tab">li class="span3 active"</a></li>
                <li class="span3"><a href="#tcc2" data-toggle="tab">a href="#"</a></li>
                <li class="span3 dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#dropdown1" data-toggle="tab">a href="#dropdown1"</a></li>
                        <li><a href="#dropdown2" data-toggle="tab">a href="#dropdown2"</a></li>
                    </ul>
                </li>
                <li class="span3"><a href="#tcc3" data-toggle="tab">Last Item</a></li>
            </ul>
            
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="tcc1">
                    <h6>TCC 1</h6>
                    <p>TCC motherfucker text example. <a href="#" rel="tooltip" title="TCC motherfucker example.">TCC motherfucker text example.</a> TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example.</p>
                </div>
                <div class="tab-pane fade" id="tcc2">
                    <h6>TCC 2</h6>
                    <p>TCC motherfucker text example. <a href="#" rel="tooltip" title="TCC motherfucker example.">TCC motherfucker text example.</a> TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example.</p>
                </div>
                <div class="tab-pane fade" id="dropdown1">
                    <h6>DropDown 1</h6>
                    <p>TCC motherfucker text example. <a href="#" rel="tooltip" title="TCC motherfucker example.">TCC motherfucker text example.</a> TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example.</p>
                </div>
                <div class="tab-pane fade" id="dropdown2">
                    <h6>DropDown 2</h6>
                    <p>TCC motherfucker text example. <a href="#" rel="tooltip" title="TCC motherfucker example.">TCC motherfucker text example.</a> TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example.</p>
                </div>
                <div class="tab-pane fade" id="tcc3">
                    <h6>TCC 3</h6>
                    <p>TCC motherfucker text example. <a href="#" rel="tooltip" title="TCC motherfucker example.">TCC motherfucker text example.</a> TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example.</p>
                </div>
            </div>
        </div>
    </div>
    
    <div class="row add-top"><div class="span12">
        
        <section id="global">
            <div class="page-header">
                <h1 id="global">Configurações Gerais</h1>
            </div>
            
            <h3>HTML5 DOCTYPE</h3>
            <p>Pra funfar os HTML5 tudo, não esquecer de colocar:</p>
            <pre>&lt;!DOCTYPE html&gt;
&lt;html lang="pt-br"&gt;
    ...
&lt;/html&gt;</pre>
            
            <h3>Tipografia e links</h3>
            <p>Seguem configurações gerais de display, tipografia e links:</p>
            <ul class="type1">
                <li>Remover <code>margin</code> da tag body</li>
                <li>Usar <code>$base-font-family</code>, <code>$base-font-size</code> e <code>$base-line-height</code> como atributos base para a tipografia</li>
                <li>Setar a cor global de um link via <code>$link-color</code> e aplicar "underlines" somente na situação <code>:hover</code></li>
            </ul>
            <p>Fonte: <strong>bootstrap/_scaffolding.scss</strong>.</p>
		</section>
    
		<section id="gridSystem">
            <div class="page-header">
                <h1 id="defaultgrid">Default grid</h1>
            </div>
            
            <h2>Exemplo</h2>
            <p>O "Default grid" utiliza <strong>12 colunas</strong>. Para alterar o tamanho de um quadro em uma linha, utilize divs com a classe <code>.span*</code>, como no exemplo abaixo:</p>
            <div class="bs-docs-grid">
                <div class="row show-grid">
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                </div>
                <div class="row show-grid">
                    <div class="span2">span2</div>
                    <div class="span3">span3</div>
                    <div class="span3">span3</div>
                    <div class="span4">span4</div>
                </div>
                <div class="row show-grid">
                    <div class="span5">span5</div>
                    <div class="span6">span6</div>
                    <div class="span1">span1</div>
                </div>
                <div class="row show-grid">
                    <div class="span12">span12</div>
                </div>
            </div>
            
            <h3>HTML Básico</h3>
            <pre>&lt;div class="row show-grid"&gt;
    &lt;div class="span8"&gt;...&lt;/div&gt;
    &lt;div class="span4"&gt;...&lt;/div&gt;
&lt;/div&gt;</pre>
            <p>Neste examplo, temos <code>.span4</code> e <code>.span8</code> (12 colunas), ou seja, uma linha completa.</p>
            
            <h2>Deslocamento de colunas com "Offset"</h2>
            <p>Use a classe <code>.offset*</code> para deslocar um quadro à direita. O número em conjunto ao nome da classe corresponde a quantidade de quadros a serem deslocados à direita.</p>
            <div class="bs-docs-grid">
                <div class="row show-grid">
                    <div class="span4">span4</div>
                    <div class="span3 offset2">span3 offset2</div>
                </div><!-- /row -->
                <div class="row show-grid">
                    <div class="span3 offset1">span3 offset1</div>
                    <div class="span3 offset2">span3 offset2</div>
                </div><!-- /row -->
                <div class="row show-grid">
                    <div class="span6 offset3">span6 offset3</div>
                </div><!-- /row -->
            </div>
            <pre>&lt;div class="row"&gt;
    &lt;div class="span4"&gt;...&lt;/div&gt;
    &lt;div class="span3 offset2"&gt;...&lt;/div&gt;
&lt;/div&gt;</pre>

        </section>
        
        <section id="fluidGridSystem">
            <div class="page-header">
                <h1 id="fluidgrid">Fluid grid</h1>
            </div>
            
            <h2>Exemplo</h2>
            <p>Unica diferença entre o fluid grid e o default grid, é que o fluid grid usa larguras percentuais, o que é recomendável. Para setar essa configuração, basta usar a <code>.row-fluid</code> no lugar de <code>.row</code>.</p>
            <div class="bs-docs-grid">
                <div class="row-fluid show-grid">
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                    <div class="span1">span1</div>
                </div>
                <div class="row-fluid show-grid">
                    <div class="span2">span2</div>
                    <div class="span3">span3</div>
                    <div class="span3">span3</div>
                    <div class="span4">span4</div>
                </div>
                <div class="row-fluid show-grid">
                    <div class="span5">span5</div>
                    <div class="span6">span6</div>
                    <div class="span1">span1</div>
                </div>
                <div class="row-fluid show-grid">
                    <div class="span12">span12</div>
                </div>
            </div>
            
            <h3>HTML Básico</h3>
            <p>Make any row "fluid" by changing <code>.row</code> to <code>.row-fluid</code>. The column classes stay the exact same, making it easy to flip between fixed and fluid grids.</p>
            <pre>&lt;div class="row-fluid"&gt;
    &lt;div class="span4"&gt;...&lt;/div&gt;
    &lt;div class="span8"&gt;...&lt;/div&gt;
&lt;/div&gt;</pre>
            
            <h2>Fluid offset</h2>
            <p>Segue o mesmo esquema do <code>.offset*</code> no default grid, mas utilizando larguras percentuais.</p>
            <div class="bs-docs-grid">
                <div class="row-fluid show-grid">
                    <div class="span4">span4</div>
                    <div class="span3 offset2">span3 offset2</div>
                </div>
                <div class="row-fluid show-grid">
                    <div class="span3 offset3">span3 offset3</div>
                    <div class="span3 offset3">span3 offset3</div>
                </div>
                <div class="row-fluid show-grid">
                    <div class="span6 offset6">span6 offset6</div>
                </div>
            </div>
            <pre>&lt;div class="row-fluid"&gt;
    &lt;div class="span4"&gt;...&lt;/div&gt;
    &lt;div class="span4 offset2"&gt;...&lt;/div&gt;
&lt;/div&gt;</pre>
            
        </section>
        
        
        
        
        <!-- Responsive design
        ================================================== -->
        <section id="responsive">
            <div class="page-header">
                <h1 id="responsive">Design Responsivo</h1>
            </div>
            
            <h2>Dispositivos Suportados</h2>
            <p>Media queries:</p>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Label</th>
                        <th>Layout width</th>
                        <th>Column width</th>
                        <th>Gutter width</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Large display</td>
                        <td>1200px and up</td>
                        <td>70px</td>
                        <td>30px</td>
                    </tr>
                    <tr>
                        <td>Default</td>
                        <td>980px and up</td>
                        <td>60px</td>
                        <td>20px</td>
                    </tr>
                    <tr>
                        <td>Portrait tablets</td>
                        <td>768px and above</td>
                        <td>42px</td>
                        <td>20px</td>
                    </tr>
                    <tr>
                        <td>Phones to tablets</td>
                        <td>767px and below</td>
                        <td class="muted" colspan="2">Fluid columns, no fixed widths</td>
                    </tr>
                    <tr>
                        <td>Phones</td>
                        <td>480px and below</td>
                        <td class="muted" colspan="2">Fluid columns, no fixed widths</td>
                    </tr>
                </tbody>
            </table>
            <pre>/* Large desktop */
@media (min-width: 1200px) { ... }
            
/* Portrait tablet to landscape and desktop */
@media (min-width: 768px) and (max-width: 979px) { ... }
            
/* Landscape phone to portrait tablet */
@media (max-width: 767px) { ... }
            
/* Landscape phones and down */
@media (max-width: 480px) { ... }</pre>
            
            
            <h2>Classes Uteis</h2>
            <p>Em caso de dúvidas, procurem por <code>bootstrap-responsive.scss</code>.</p>
            <table class="table table-bordered table-striped responsive-utilities">
                <thead>
                <tr>
                <th>Class</th>
                <th>Phones <small>767px and below</small></th>
                <th>Tablets <small>979px to 768px</small></th>
                <th>Desktops <small>Default</small></th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <th><code>.visible-phone</code></th>
                        <td class="is-visible">Visible</td>
                        <td class="is-hidden">Hidden</td>
                        <td class="is-hidden">Hidden</td>
                    </tr>
                    <tr>
                        <th><code>.visible-tablet</code></th>
                        <td class="is-hidden">Hidden</td>
                        <td class="is-visible">Visible</td>
                        <td class="is-hidden">Hidden</td>
                    </tr>
                    <tr>
                        <th><code>.visible-desktop</code></th>
                        <td class="is-hidden">Hidden</td>
                        <td class="is-hidden">Hidden</td>
                        <td class="is-visible">Visible</td>
                    </tr>
                    <tr>
                        <th><code>.hidden-phone</code></th>
                        <td class="is-hidden">Hidden</td>
                        <td class="is-visible">Visible</td>
                        <td class="is-visible">Visible</td>
                    </tr>
                    <tr>
                        <th><code>.hidden-tablet</code></th>
                        <td class="is-visible">Visible</td>
                        <td class="is-hidden">Hidden</td>
                        <td class="is-visible">Visible</td>
                    </tr>
                    <tr>
                        <th><code>.hidden-desktop</code></th>
                        <td class="is-visible">Visible</td>
                        <td class="is-visible">Visible</td>
                        <td class="is-hidden">Hidden</td>
                    </tr>
                </tbody>
            </table>
            
        </section>
        
        <div class="row-fluid">
            <div class="span4">
                <div class="well">
                    <h1>h1. Heading 1</h1>
                    <h2>h2. Heading 2</h2>
                    <h3>h3. Heading 3</h3>
                    <h4>h4. Heading 4</h4>
                    <h5>h5. Heading 5</h5>
                    <h6>h6. Heading 6</h6>
                </div>
            </div>
            
            <div class="span4">
                <h3>Examplo de texto</h3>
                <p>TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example.</p>
                <p>TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example.</p>
            </div>
                
            <div class="span4">
                <h3>Example addresses</h3>
                <address>
                    <strong>TCCMF, LTDA.</strong><br>
                    795 Folsom Ave, Suite 600<br>
                    San Francisco, CA 94107<br>
                    <abbr title="Phone">P:</abbr> (123) 456-7890
                </address>
                <address>
                    <strong>E-mail</strong><br>
                    <a href="mailto:#">support@tccmf.com</a>
                </address>
            </div>
        </div>
        
        <section id="buttons">
            <div class="page-header">
                <h1 id="buttons">Botões</h1>
            </div>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Button</th>
                        <th>Large Button</th>
                        <th>Small Button</th>
                        <th>Disabled Button</th>
                        <th>Button with Icon</th>
                        <th>Split Button</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><a class="btn" href="#">Default</a></td>
                        <td><a class="btn btn-large" href="#">Default</a></td>
                        <td><a class="btn btn-small" href="#">Default</a></td>
                        <td><a class="btn disabled" href="#">Default</a></td>
                        <td><a class="btn" href="#"><i class="icon-cog"></i> Default</a></td>
                        <td>
                            <div class="btn-group">
                                <a class="btn" href="#">Default</a>
                                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div><!-- /btn-group -->
                        </td>
                    </tr>
                    <tr>
                        <td><a class="btn btn-primary" href="#">Primary</a></td>
                        <td><a class="btn btn-primary btn-large" href="#">Primary</a></td>
                        <td><a class="btn btn-primary btn-small" href="#">Primary</a></td>
                        <td><a class="btn btn-primary disabled" href="#">Primary</a></td>
                        <td><a class="btn btn-primary" href="#"><i class="icon-shopping-cart icon-white"></i> Primary</a></td>
                        <td>
                            <div class="btn-group">
                                <a class="btn btn-primary" href="#">Primary</a>
                                <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div><!-- /btn-group -->
                        </td>
                    </tr>
                    <tr>
                        <td><a class="btn btn-info" href="#">Info</a></td>
                        <td><a class="btn btn-info btn-large" href="#">Info</a></td>
                        <td><a class="btn btn-info btn-small" href="#">Info</a></td>
                        <td><a class="btn btn-info disabled" href="#">Info</a></td>
                        <td><a class="btn btn-info" href="#"><i class="icon-exclamation-sign icon-white"></i> Info</a></td>
                        <td>
                            <div class="btn-group">
                                <a class="btn btn-info" href="#">Info</a>
                                <a class="btn btn-info dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div><!-- /btn-group -->
                        </td>
                    </tr>
                    <tr>
                        <td><a class="btn btn-success" href="#">Success</a></td>
                        <td><a class="btn btn-success btn-large" href="#">Success</a></td>
                        <td><a class="btn btn-success btn-small" href="#">Success</a></td>
                        <td><a class="btn btn-success disabled" href="#">Success</a></td>
                        <td><a class="btn btn-success" href="#"><i class="icon-ok icon-white"></i> Success</a></td>
                        <td>
                            <div class="btn-group">
                                <a class="btn btn-success" href="#">Success</a>
                                <a class="btn btn-success dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                                </div><!-- /btn-group -->
                        </td>
                    </tr>
                    <tr>
                        <td><a class="btn btn-warning" href="#">Warning</a></td>
                        <td><a class="btn btn-warning btn-large" href="#">Warning</a></td>
                        <td><a class="btn btn-warning btn-small" href="#">Warning</a></td>
                        <td><a class="btn btn-warning disabled" href="#">Warning</a></td>
                        <td><a class="btn btn-warning" href="#"><i class="icon-warning-sign icon-white"></i> Warning</a></td>
                        <td>
                            <div class="btn-group">
                                <a class="btn btn-warning" href="#">Warning</a>
                                <a class="btn btn-warning dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div><!-- /btn-group -->
                        </td>
                    </tr>
                    <tr>
                        <td><a class="btn btn-danger" href="#">Danger</a></td>
                        <td><a class="btn btn-danger btn-large" href="#">Danger</a></td>
                        <td><a class="btn btn-danger btn-small" href="#">Danger</a></td>
                        <td><a class="btn btn-danger disabled" href="#">Danger</a></td>
                        <td><a class="btn btn-danger" href="#"><i class="icon-remove icon-white"></i> Danger</a></td>
                        <td>
                            <div class="btn-group">
                                <a class="btn btn-danger" href="#">Danger</a>
                                <a class="btn btn-danger dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div><!-- /btn-group -->
                        </td>
                    </tr>
                    <tr>
                        <td><a class="btn btn-inverse" href="#">Inverse</a></td>
                        <td><a class="btn btn-inverse btn-large" href="#">Inverse</a></td>
                        <td><a class="btn btn-inverse btn-small" href="#">Inverse</a></td>
                        <td><a class="btn btn-inverse disabled" href="#">Inverse</a></td>
                        <td><a class="btn btn-inverse" href="#"><i class="icon-random icon-white"></i> Inverse</a></td>
                        <td>
                            <div class="btn-group">
                                <a class="btn btn-inverse" href="#">Inverse</a>
                                <a class="btn btn-inverse dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div><!-- /btn-group -->
                        </td>
                    </tr>
                </tbody>
            </table>
        </section>
        
        
        <section id="forms">
            <div class="page-header">
            <h1 id="forms">Formulários</h1>
            </div>
            
            <div class="row-fluid">
                <div class="span7 offset1">
                
                    <form class="well form-search">
                        <input type="text" class="input-medium search-query">
                        <button type="submit" class="btn">Search</button>
                    </form>
                
                    <form class="well form-search">
                        <input type="text" class="input-small" placeholder="Email">
                        <input type="password" class="input-small" placeholder="Password">
                        <button type="submit" class="btn">Go</button>
                    </form>
                
                
                    <form class="form-horizontal well">
                        <fieldset>
                            <div class="control-group">
                                <label class="control-label" for="input01">Text</label>
                                <div class="controls">
                                    <input type="text" class="input-xlarge" id="input01">
                                </div>
                            </div>
                            
                            <div class="control-group">
                                <label class="control-label" for="optionsCheckbox">Checkbox</label>
                                <div class="controls">
                                    <label class="checkbox">
                                        <input type="checkbox" id="optionsCheckbox" value="option1"> TÁ COM PROBLEMA AINDA
                                    </label>
                                </div>
                            </div>
                            
                            <div class="control-group">
                                <label class="control-label" for="select01">Select</label>
                                <div class="controls">
                                    <select id="select01">
                                        <option>something</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                            </div>
                            
                            <div class="control-group">
                                <label class="control-label" for="multiSelect">Multi-select</label>
                                <div class="controls">
                                    <select multiple="multiple" id="multiSelect">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                            </div>
                            
                            <div class="control-group">
                                <label class="control-label" for="fileInput">File</label>
                                <div class="controls">
                                    <input class="input-file" id="fileInput" type="file">
                                </div>
                            </div>
                            
                            <div class="control-group">
                                <label class="control-label" for="textarea">Textarea</label>
                                <div class="controls">
                                    <textarea class="input-xlarge" id="textarea" rows="3"></textarea>
                                </div>
                            </div>
                            
                            <div class="control-group">
                                <label class="control-label" for="focusedInput">Focused input</label>
                                <div class="controls">
                                    <input class="input-xlarge focused" id="focusedInput" type="text" value="TCC MOTHERFUCKER">
                                </div>
                            </div>
                            
                            <div class="control-group">
                                <label class="control-label">Uneditable input</label>
                                <div class="controls">
                                    <span class="input-xlarge uneditable-input">TCC MOTHERFUCKER</span>
                                </div>
                            </div>
                            
                            <div class="control-group">
                                <label class="control-label" for="disabledInput">Disabled input</label>
                                <div class="controls">
                                    <input class="input-xlarge disabled" id="disabledInput" type="text" placeholder="TCC MOTHERFUCKER" disabled>
                                </div>
                            </div>
                            
                            <div class="control-group">
                                <label class="control-label" for="optionsCheckbox2">Disabled checkbox</label>
                                <div class="controls">
                                    <label class="checkbox">
                                        <input type="checkbox" id="optionsCheckbox2" value="option1" disabled>
                                        TÁ COM PROBLEMA AINDA
                                    </label>
                                </div>
                            </div>
                            
                            <div class="control-group warning">
                                <label class="control-label" for="inputWarning">Input warning</label>
                                <div class="controls">
                                    <input type="text" id="inputWarning">
                                    <span class="help-inline">TCC MOTHERFUCKER</span>
                                </div>
                            </div>
                            
                            <div class="control-group error">
                                <label class="control-label" for="inputError">Input error</label>
                                <div class="controls">
                                    <input type="text" id="inputError">
                                    <span class="help-inline">TCC MOTHERFUCKER</span>
                                </div>
                            </div>
                            
                            <div class="control-group success">
                                <label class="control-label" for="inputSuccess">Input success</label>
                                <div class="controls">
                                    <input type="text" id="inputSuccess">
                                    <span class="help-inline">IRRÁ!</span>
                                </div>
                            </div>
                            
                            <div class="control-group success">
                                <label class="control-label" for="selectError">Select success</label>
                                <div class="controls">
                                    <select id="selectError">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                    <span class="help-inline">IRRÁ!</span>
                                </div>
                            </div>
                            
                            <div class="form-actions">
                                <button type="submit" class="btn btn-primary">Salvar</button>
                                <button type="reset" class="btn">Cancelar</button>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        
        </section>
        
        
        <section id="miscellaneous">
            <div class="page-header">
                <h1 id="misc">Miscellaneous - não sei por que tem esse nome. enfim...</h1>
            </div>
            
            <div class="row-fluid">
                <div class="span5">
                    <h3 id="breadcrumbs">Breadcrumbs</h3>
                    <ul class="breadcrumb">
                        <li class="active">Início</li>
                    </ul>
                    <ul class="breadcrumb">
                        <li><a href="#">Início</a> <span class="divider">/</span></li>
                        <li class="active">Sobre</li>
                    </ul>
                    <ul class="breadcrumb">
                        <li><a href="#">Início</a> <span class="divider">/</span></li>
                        <li><a href="#">Sobre</a> <span class="divider">/</span></li>
                        <li class="active">Recursos</li>
                    </ul>
                </div>
                
                <div class="span6 offset1">
                    <h3 id="pagination">Paginação</h3>
                    <div class="pagination">
                        <ul>
                            <li class="disabled"><a href="#">&laquo;</a></li>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">&raquo;</a></li>
                        </ul>
                    </div>
                        
                    <div class="pagination">
                        <ul>
                            <li><a href="#">&larr;</a></li>
                            <li class="active"><a href="#">10</a></li>
                            <li class="disabled"><a href="#">...</a></li>
                            <li><a href="#">20</a></li>
                            <li><a href="#">&rarr;</a></li>
                        </ul>
                    </div>
                        
                    <div class="pagination pagination-centered">
                        <ul>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            
            
            
            <div class="row-fluid add-bottom">
                <div class="span12">
                    <h3 id="labels">Labels</h3>
                    
                    <span class="label">Default</span>
                    <span class="label label-success">Sucesso!</span>
                    <span class="label label-warning">Alerta</span>
                    <span class="label label-important">Importante</span>
                    <span class="label label-info">Info</span>
                </div>
            </div>
            
            <h3 id="progressbars">Progress bars</h3>
            
            <div class="row-fluid add-bottom">
                <div class="span4">
                    <div class="progress">
                        <div class="bar" style="width: 60%;"></div>
                    </div>
                </div>
                
                <div class="span4">
                    <div class="progress progress-info progress-striped">
                        <div class="bar" style="width: 20%;"></div>
                    </div>
                </div>
                
                <div class="span4">
                    <div class="progress progress-danger progress-striped active">
                        <div class="bar" style="width: 45%"></div>
                    </div>
                </div>
            </div>
            
            
            <h3 id="alerts">Alertas</h3>
            
            <div class="row-fluid">
                <div class="span12">
                    <div class="alert alert-block">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <h4 class="alert-heading">Alerta!</h4>
                        <p>TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example. TCC motherfucker text example.</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="span4">
                    <div class="alert alert-error">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Erro!</strong> TCC motherfucker text example.
                    </div>
                </div>
                <div class="span4">
                    <div class="alert alert-success">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Sucesso!</strong> TCC motherfucker text example.
                    </div>
                </div>
                <div class="span4">
                    <div class="alert fade in">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>Alerta!</strong> TCC motherfucker text example.
                    </div>
                </div>
            </div>
        
        </section>
    
    </div></div>
    
    <section id="all-icons" class="row">
        <div class="span12">
			<h1>Icones - Aguardar para usar (está com font-awesome, mas será usuado icon-moon)</h1>
        </div>
        
        <div class="span12">
			<h3>Web Application Icons</h3>
        </div>
        
        <div class="span3">
            <ul class="the-icons">
              <li><i class="icon-adjust"></i> icon-adjust</li>
              <li><i class="icon-asterisk"></i> icon-asterisk</li>
              <li><i class="icon-ban-circle"></i> icon-ban-circle</li>
              <li><i class="icon-bar-chart"></i> icon-bar-chart</li>
              <li><i class="icon-barcode"></i> icon-barcode</li>
              <li><i class="icon-beaker"></i> icon-beaker</li>
              <li><i class="icon-bell"></i> icon-bell</li>
              <li><i class="icon-bolt"></i> icon-bolt</li>
              <li><i class="icon-book"></i> icon-book</li>
              <li><i class="icon-bookmark"></i> icon-bookmark</li>
              <li><i class="icon-bookmark-empty"></i> icon-bookmark-empty</li>
              <li><i class="icon-briefcase"></i> icon-briefcase</li>
              <li><i class="icon-bullhorn"></i> icon-bullhorn</li>
              <li><i class="icon-calendar"></i> icon-calendar</li>
              <li><i class="icon-camera"></i> icon-camera</li>
              <li><i class="icon-camera-retro"></i> icon-camera-retro</li>
              <li><i class="icon-certificate"></i> icon-certificate</li>
              <li><i class="icon-check"></i> icon-check</li>
              <li><i class="icon-check-empty"></i> icon-check-empty</li>
              <li><i class="icon-cloud"></i> icon-cloud</li>
              <li><i class="icon-cog"></i> icon-cog</li>
              <li><i class="icon-cogs"></i> icon-cogs</li>
              <li><i class="icon-comment"></i> icon-comment</li>
              <li><i class="icon-comment-alt"></i> icon-comment-alt</li>
              <li><i class="icon-comments"></i> icon-comments</li>
              <li><i class="icon-comments-alt"></i> icon-comments-alt</li>
              <li><i class="icon-credit-card"></i> icon-credit-card</li>
              <li><i class="icon-dashboard"></i> icon-dashboard</li>
              <li><i class="icon-download"></i> icon-download</li>
              <li><i class="icon-download-alt"></i> icon-download-alt</li>
              <li><i class="icon-edit"></i> icon-edit</li>
              <li><i class="icon-envelope"></i> icon-envelope</li>
              <li><i class="icon-envelope-alt"></i> icon-envelope-alt</li>
            </ul>
        </div>
        <div class="span3">
            <ul class="the-icons">
              <li><i class="icon-exclamation-sign"></i> icon-exclamation-sign</li>
              <li><i class="icon-external-link"></i> icon-external-link</li>
              <li><i class="icon-eye-close"></i> icon-eye-close</li>
              <li><i class="icon-eye-open"></i> icon-eye-open</li>
              <li><i class="icon-facetime-video"></i> icon-facetime-video</li>
              <li><i class="icon-film"></i> icon-film</li>
              <li><i class="icon-filter"></i> icon-filter</li>
              <li><i class="icon-fire"></i> icon-fire</li>
              <li><i class="icon-flag"></i> icon-flag</li>
              <li><i class="icon-folder-close"></i> icon-folder-close</li>
              <li><i class="icon-folder-open"></i> icon-folder-open</li>
              <li><i class="icon-gift"></i> icon-gift</li>
              <li><i class="icon-glass"></i> icon-glass</li>
              <li><i class="icon-globe"></i> icon-globe</li>
              <li><i class="icon-group"></i> icon-group</li>
              <li><i class="icon-hdd"></i> icon-hdd</li>
              <li><i class="icon-headphones"></i> icon-headphones</li>
              <li><i class="icon-heart"></i> icon-heart</li>
              <li><i class="icon-heart-empty"></i> icon-heart-empty</li>
              <li><i class="icon-home"></i> icon-home</li>
              <li><i class="icon-inbox"></i> icon-inbox</li>
              <li><i class="icon-info-sign"></i> icon-info-sign</li>
              <li><i class="icon-key"></i> icon-key</li>
              <li><i class="icon-leaf"></i> icon-leaf</li>
              <li><i class="icon-legal"></i> icon-legal</li>
              <li><i class="icon-lemon"></i> icon-lemon</li>
              <li><i class="icon-lock"></i> icon-lock</li>
              <li><i class="icon-unlock"></i> icon-unlock</li>
              <li><i class="icon-magic"></i> icon-magic</li>
              <li><i class="icon-magnet"></i> icon-magnet</li>
              <li><i class="icon-map-marker"></i> icon-map-marker</li>
              <li><i class="icon-minus"></i> icon-minus</li>
              <li><i class="icon-minus-sign"></i> icon-minus-sign</li>
            </ul>
        </div>
        <div class="span3">
            <ul class="the-icons">
              <li><i class="icon-money"></i> icon-money</li>
              <li><i class="icon-move"></i> icon-move</li>
              <li><i class="icon-music"></i> icon-music</li>
              <li><i class="icon-off"></i> icon-off</li>
              <li><i class="icon-ok"></i> icon-ok</li>
              <li><i class="icon-ok-circle"></i> icon-ok-circle</li>
              <li><i class="icon-ok-sign"></i> icon-ok-sign</li>
              <li><i class="icon-pencil"></i> icon-pencil</li>
              <li><i class="icon-picture"></i> icon-picture</li>
              <li><i class="icon-plane"></i> icon-plane</li>
              <li><i class="icon-plus"></i> icon-plus</li>
              <li><i class="icon-plus-sign"></i> icon-plus-sign</li>
              <li><i class="icon-print"></i> icon-print</li>
              <li><i class="icon-pushpin"></i> icon-pushpin</li>
              <li><i class="icon-qrcode"></i> icon-qrcode</li>
              <li><i class="icon-question-sign"></i> icon-question-sign</li>
              <li><i class="icon-random"></i> icon-random</li>
              <li><i class="icon-refresh"></i> icon-refresh</li>
              <li><i class="icon-remove"></i> icon-remove</li>
              <li><i class="icon-remove-circle"></i> icon-remove-circle</li>
              <li><i class="icon-remove-sign"></i> icon-remove-sign</li>
              <li><i class="icon-reorder"></i> icon-reorder</li>
              <li><i class="icon-resize-horizontal"></i> icon-resize-horizontal</li>
              <li><i class="icon-resize-vertical"></i> icon-resize-vertical</li>
              <li><i class="icon-retweet"></i> icon-retweet</li>
              <li><i class="icon-road"></i> icon-road</li>
              <li><i class="icon-rss"></i> icon-rss</li>
              <li><i class="icon-screenshot"></i> icon-screenshot</li>
              <li><i class="icon-search"></i> icon-search</li>
              <li><i class="icon-share"></i> icon-share</li>
              <li><i class="icon-share-alt"></i> icon-share-alt</li>
              <li><i class="icon-shopping-cart"></i> icon-shopping-cart</li>
            </ul>
        </div>
        <div class="span3">
            <ul class="the-icons">
              <li><i class="icon-signal"></i> icon-signal</li>
              <li><i class="icon-signin"></i> icon-signin</li>
              <li><i class="icon-signout"></i> icon-signout</li>
              <li><i class="icon-sitemap"></i> icon-sitemap</li>
              <li><i class="icon-sort"></i> icon-sort</li>
              <li><i class="icon-sort-down"></i> icon-sort-down</li>
              <li><i class="icon-sort-up"></i> icon-sort-up</li>
              <li><i class="icon-star"></i> icon-star</li>
              <li><i class="icon-star-empty"></i> icon-star-empty</li>
              <li><i class="icon-star-half"></i> icon-star-half</li>
              <li><i class="icon-tag"></i> icon-tag</li>
              <li><i class="icon-tags"></i> icon-tags</li>
              <li><i class="icon-tasks"></i> icon-tasks</li>
              <li><i class="icon-thumbs-down"></i> icon-thumbs-down</li>
              <li><i class="icon-thumbs-up"></i> icon-thumbs-up</li>
              <li><i class="icon-time"></i> icon-time</li>
              <li><i class="icon-tint"></i> icon-tint</li>
              <li><i class="icon-trash"></i> icon-trash</li>
              <li><i class="icon-trophy"></i> icon-trophy</li>
              <li><i class="icon-truck"></i> icon-truck</li>
              <li><i class="icon-umbrella"></i> icon-umbrella</li>
              <li><i class="icon-upload"></i> icon-upload</li>
              <li><i class="icon-upload-alt"></i> icon-upload-alt</li>
              <li><i class="icon-user"></i> icon-user</li>
              <li><i class="icon-user-md"></i> icon-user-md</li>
              <li><i class="icon-volume-off"></i> icon-volume-off</li>
              <li><i class="icon-volume-down"></i> icon-volume-down</li>
              <li><i class="icon-volume-up"></i> icon-volume-up</li>
              <li><i class="icon-warning-sign"></i> icon-warning-sign</li>
              <li><i class="icon-wrench"></i> icon-wrench</li>
              <li><i class="icon-zoom-in"></i> icon-zoom-in</li>
              <li><i class="icon-zoom-out"></i> icon-zoom-out</li>
            </ul>
        </div>
        
        <div class="span12">
        <h3>Text Editor Icons</h3>
        </div>
        <div class="span3">
            <ul class="the-icons">
              <li><i class="icon-file"></i> icon-file</li>
              <li><i class="icon-cut"></i> icon-cut</li>
              <li><i class="icon-copy"></i> icon-copy</li>
              <li><i class="icon-paste"></i> icon-paste</li>
              <li><i class="icon-save"></i> icon-save</li>
              <li><i class="icon-undo"></i> icon-undo</li>
              <li><i class="icon-repeat"></i> icon-repeat</li>
              <li><i class="icon-paper-clip"></i> icon-paper-clip</li>
            </ul>
        </div>
        <div class="span3">
            <ul class="the-icons">
              <li><i class="icon-text-height"></i> icon-text-height</li>
              <li><i class="icon-text-width"></i> icon-text-width</li>
              <li><i class="icon-align-left"></i> icon-align-left</li>
              <li><i class="icon-align-center"></i> icon-align-center</li>
              <li><i class="icon-align-right"></i> icon-align-right</li>
              <li><i class="icon-align-justify"></i> icon-align-justify</li>
              <li><i class="icon-indent-left"></i> icon-indent-left</li>
              <li><i class="icon-indent-right"></i> icon-indent-right</li>
            </ul>
        </div>
        <div class="span3">
            <ul class="the-icons">
              <li><i class="icon-font"></i> icon-font</li>
              <li><i class="icon-bold"></i> icon-bold</li>
              <li><i class="icon-italic"></i> icon-italic</li>
              <li><i class="icon-strikethrough"></i> icon-strikethrough</li>
              <li><i class="icon-underline"></i> icon-underline</li>
              <li><i class="icon-link"></i> icon-link</li>
              <li><i class="icon-columns"></i> icon-columns</li>
              <li><i class="icon-table"></i> icon-table</li>
            </ul>
        </div>
        <div class="span3">
            <ul class="the-icons">
              <li><i class="icon-th-large"></i> icon-th-large</li>
              <li><i class="icon-th"></i> icon-th</li>
              <li><i class="icon-th-list"></i> icon-th-list</li>
              <li><i class="icon-list"></i> icon-list</li>
              <li><i class="icon-list-ol"></i> icon-list-ol</li>
              <li><i class="icon-list-ul"></i> icon-list-ul</li>
              <li><i class="icon-list-alt"></i> icon-list-alt</li>
            </ul>
        </div>
        
        <div class="span12">
        <h3>Directional Icons</h3>
        </div>
        <div class="span3">
            <ul class="the-icons">
              <li><i class="icon-arrow-down"></i> icon-arrow-down</li>
              <li><i class="icon-arrow-left"></i> icon-arrow-left</li>
              <li><i class="icon-arrow-right"></i> icon-arrow-right</li>
              <li><i class="icon-arrow-up"></i> icon-arrow-up</li>
              <li><i class="icon-chevron-down"></i> icon-chevron-down</li>
            </ul>
        </div>
        <div class="span3">
        <ul class="the-icons">
          <li><i class="icon-circle-arrow-down"></i> icon-circle-arrow-down</li>
          <li><i class="icon-circle-arrow-left"></i> icon-circle-arrow-left</li>
          <li><i class="icon-circle-arrow-right"></i> icon-circle-arrow-right</li>
          <li><i class="icon-circle-arrow-up"></i> icon-circle-arrow-up</li>
          <li><i class="icon-chevron-left"></i> icon-chevron-left</li>
        </ul>
        </div>
        <div class="span3">
        <ul class="the-icons">
          <li><i class="icon-caret-down"></i> icon-caret-down</li>
          <li><i class="icon-caret-left"></i> icon-caret-left</li>
          <li><i class="icon-caret-right"></i> icon-caret-right</li>
          <li><i class="icon-caret-up"></i> icon-caret-up</li>
          <li><i class="icon-chevron-right"></i> icon-chevron-right</li>
        </ul>
        </div>
        <div class="span3">
        <ul class="the-icons">
          <li><i class="icon-hand-down"></i> icon-hand-down</li>
          <li><i class="icon-hand-left"></i> icon-hand-left</li>
          <li><i class="icon-hand-right"></i> icon-hand-right</li>
          <li><i class="icon-hand-up"></i> icon-hand-up</li>
          <li><i class="icon-chevron-up"></i> icon-chevron-up</li>
        </ul>
        </div>
        
        <div class="span12">
        <h3>Video Player Icons</h3>
        </div>
        <div class="span3">
        <ul class="the-icons">
          <li><i class="icon-play-circle"></i> icon-play-circle</li>
          <li><i class="icon-play"></i> icon-play</li>
          <li><i class="icon-pause"></i> icon-pause</li>
          <li><i class="icon-stop"></i> icon-stop</li>
        </ul>
        </div>
        <div class="span3">
        <ul class="the-icons">
          <li><i class="icon-step-backward"></i> icon-step-backward</li>
          <li><i class="icon-fast-backward"></i> icon-fast-backward</li>
          <li><i class="icon-backward"></i> icon-backward</li>
          <li><i class="icon-forward"></i> icon-forward</li>
        </ul>
        </div>
        <div class="span3">
        <ul class="the-icons">
          <li><i class="icon-fast-forward"></i> icon-fast-forward</li>
          <li><i class="icon-step-forward"></i> icon-step-forward</li>
          <li><i class="icon-eject"></i> icon-eject</li>
        </ul>
        </div>
        <div class="span3">
        <ul class="the-icons">
          <li><i class="icon-fullscreen"></i> icon-fullscreen</li>
          <li><i class="icon-resize-full"></i> icon-resize-full</li>
          <li><i class="icon-resize-small"></i> icon-resize-small</li>
        </ul>
        </div>
        
        <div class="span12">
        <h3>Social Icons</h3>
        </div>
        <div class="span3">
        <ul class="the-icons">
          <li><i class="icon-phone"></i> icon-phone</li>
          <li><i class="icon-phone-sign"></i> icon-phone-sign</li>
          <li><i class="icon-facebook"></i> icon-facebook</li>
          <li><i class="icon-facebook-sign"></i> icon-facebook-sign</li>
        </ul>
        </div>
        <div class="span3">
        <ul class="the-icons">
          <li><i class="icon-twitter"></i> icon-twitter</li>
          <li><i class="icon-twitter-sign"></i> icon-twitter-sign</li>
          <li><i class="icon-github"></i> icon-github</li>
          <li><i class="icon-github-sign"></i> icon-github-sign</li>
        </ul>
        </div>
        <div class="span3">
        <ul class="the-icons">
          <li><i class="icon-linkedin"></i> icon-linkedin</li>
          <li><i class="icon-linkedin-sign"></i> icon-linkedin-sign</li>
          <li><i class="icon-pinterest"></i> icon-pinterest</li>
          <li><i class="icon-pinterest-sign"></i> icon-pinterest-sign</li>
        </ul>
        </div>
        <div class="span3">
        <ul class="the-icons">
          <li><i class="icon-google-plus"></i> icon-google-plus</li>
          <li><i class="icon-google-plus-sign"></i> icon-google-plus-sign</li>
          <li><i class="icon-sign-blank"></i> icon-sign-blank</li>
        </ul>
        </div>
        
        </section>
</div><!--Ends Master Container-->

<%@ include file="/includes/footer.jsp" %>