<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="pt-br"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="pt-br"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="pt-br"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="pt-br"> <!--<![endif]-->

    <head>

        <meta charset="utf-8">
        <title>TCC</title>
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel=stylesheet href="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/platform.css" type="text/css">
        <link rel=stylesheet href="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/libs/dateField/jquery.dateField.css" type="text/css">
        <link rel=stylesheet href="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/gantt.css" type="text/css">
        <link rel=stylesheet href="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/ganttPrint.css" type="text/css" media="print">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/component.css" />

        <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>

        <script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/libs/jquery.livequery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/libs/jquery.timers.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/libs/platform.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/libs/date.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/libs/i18nJs.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/libs/dateField/jquery.dateField.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/libs/JST/jquery.JST.js"></script>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/libs/jquery.svg.css">
        <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:700,400,300,200' rel='stylesheet' type='text/css'>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/libs/jquery.svg.min.js"></script>

        <!--In case of jquery 1.7-->
        <!--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/libs/jquery.svgdom.pack.js"></script>-->

        <!--In case of jquery 1.8-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/libs/jquery.svgdom.1.8.js"></script>


        <script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/ganttUtilities.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/ganttTask.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/ganttDrawerSVG.js"></script>
        <!--<script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/ganttDrawer.js"></script>-->
        <script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/ganttGridEditor.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/ganttMaster.js"></script>
    </head>
    <body style="background-color: #fff;">


        <div id="workSpace" style="padding:0px; overflow-y:auto; overflow-x:hidden;border:1px solid #e5e5e5;position:relative;margin:0 5px"></div>

        <div id="taZone" style="display:none;" class="noprint">
            <textarea rows="8" cols="150" id="ta">
     {"tasks":[
     {"id":-1,"name":"Gantt editor","code":"","level":0,"status":"STATUS_ACTIVE","canWrite":true,"start":1396994400000,"duration":21,"end":1399672799999,"startIsMilestone":true,"endIsMilestone":false,"collapsed":false,"assigs":[],"hasChild":true}
     ,{"id":-2,"name":"coding","code":"","level":1,"status":"STATUS_ACTIVE","canWrite":true,"start":1396994400000,"duration":10,"end":1398203999999,"startIsMilestone":false,"endIsMilestone":false,"collapsed":false,"assigs":[],"description":"","progress":0,"hasChild":true}
     ,{"id":-3,"name":"gantt part","code":"","level":2,"status":"STATUS_ACTIVE","canWrite":true,"start":1396994400000,"duration":2,"end":1397167199999,"startIsMilestone":false,"endIsMilestone":false,"collapsed":false,"assigs":[],"depends":"","hasChild":false}
     ,{"id":-4,"name":"editor part","code":"","level":2,"status":"STATUS_SUSPENDED","canWrite":true,"start":1397167200000,"duration":4,"end":1397685599999,"startIsMilestone":false,"endIsMilestone":false,"collapsed":false,"assigs":[],"depends":"3","hasChild":false}
     ,{"id":-5,"name":"testing","code":"","level":1,"status":"STATUS_SUSPENDED","canWrite":true,"start":1398981600000,"duration":6,"end":1399672799999,"startIsMilestone":false,"endIsMilestone":false,"collapsed":false,"assigs":[],"depends":"2:5","description":"","progress":0,"hasChild":true}
     ,{"id":-6,"name":"test on safari","code":"","level":2,"status":"STATUS_SUSPENDED","canWrite":true,"start":1398981600000,"duration":2,"end":1399327199999,"startIsMilestone":false,"endIsMilestone":false,"collapsed":false,"assigs":[],"depends":"","hasChild":false}
     ,{"id":-7,"name":"test on ie","code":"","level":2,"status":"STATUS_SUSPENDED","canWrite":true,"start":1399327200000,"duration":3,"end":1399586399999,"startIsMilestone":false,"endIsMilestone":false,"collapsed":false,"assigs":[],"depends":"6","hasChild":false}
     ,{"id":-8,"name":"test on chrome","code":"","level":2,"status":"STATUS_SUSPENDED","canWrite":true,"start":1399327200000,"duration":2,"end":1399499999999,"startIsMilestone":false,"endIsMilestone":false,"collapsed":false,"assigs":[],"depends":"6","hasChild":false}
     ],"selectedRow":0,"canWrite":true,"canWriteOnParent":true}
            </textarea>

            <button onclick="loadGanttFromServer();">load</button>
        </div>

        <style>
            .resEdit {
                padding: 15px;
            }

            .resLine {
                width: 95%;
                padding: 3px;
                margin: 5px;
                border: 1px solid #d0d0d0;
            }

            body {
                overflow: hidden;
            }

            .ganttButtonBar h1{
                color: #000000;
                font-weight: bold;
                font-size: 28px;
                margin-left: 10px;
            }

        </style>

        <form id="gimmeBack" style="display:none;" action="../gimmeBack.jsp" method="post" target="_blank"><input type="hidden" name="prj" id="gimBaPrj"></form>

        <script src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/gantt.js"></script>

        <div id="gantEditorTemplates" style="display:none;">
            <div class="__template__" type="GANTBUTTONS"><!--
            <div class="ganttButtonBar noprint">
              <div class="buttons">
                <button onclick="$('#workSpace').trigger('undo.gantt');" class="button textual" title="desfazer"><span class="teamworkIcon">&#39;</span></button>
                <button onclick="$('#workSpace').trigger('redo.gantt');" class="button textual" title="refazer"><span class="teamworkIcon">&middot;</span></button>

                <span class="ganttButtonSeparator"></span>

                <button onclick="$('#workSpace').trigger('addAboveCurrentTask.gantt');" class="button textual" title="inserir atividade acima"><span class="teamworkIcon">l</span></button>
                <button onclick="$('#workSpace').trigger('addBelowCurrentTask.gantt');" class="button textual" title="inserir atividade abaixo"><span class="teamworkIcon">X</span></button>

                <span class="ganttButtonSeparator"></span>

                <button onclick="$('#workSpace').trigger('zoomMinus.gantt');" class="button textual" title="distanciar visão do calendário"><span class="teamworkIcon">)</span></button>
                <button onclick="$('#workSpace').trigger('zoomPlus.gantt');" class="button textual" title="aproximar visão do calendario"><span class="teamworkIcon">(</span></button>

                <span class="ganttButtonSeparator"></span>

                <button onclick="$('#workSpace').trigger('deleteCurrentTask.gantt');" class="button textual" title="excluir"><span class="teamworkIcon">&cent;</span></button>

                <span class="ganttButtonSeparator"></span>

                <button onclick="ge.gantt.showCriticalPath=!ge.gantt.showCriticalPath; ge.redraw();" class="button textual" title="caminho crítico"><span class="teamworkIcon">&pound;</span></button>

                <span class="ganttButtonSeparator"></span>

                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;

                <button onclick="saveGanttOnServer();" class="submit" title="Salvar">Salvar</button>
                <a href="${pageContext.request.contextPath}/Bootstrap/projeto/indexProjeto/id/${idProjeto}">
                  <button onclick="saveGanttOnServer();" class="submit" title="Voltar">Voltar</button>
                </a>
              </div>
            </div>
                --></div>

            <div class="__template__" type="TASKSEDITHEAD"><!--
            <table class="gdfTable" cellspacing="0" cellpadding="0">
              <thead>
              <tr style="height:40px">
                <th class="gdfColHeader" style="width:35px;"></th>
                <th class="gdfColHeader" style="width:25px;"></th>

                <th class="gdfColHeader gdfResizable" style="width:200px;">Nome</th>
                <th class="gdfColHeader gdfResizable" style="width:100px;">Início</th>
                <th class="gdfColHeader gdfResizable" style="width:100px;">Fim</th>
                <th class="gdfColHeader gdfResizable" style="width:65px;">Duração</th>
                <th class="gdfColHeader gdfResizable" style="width:100px;">Dependências</th>
                <th class="gdfColHeader gdfResizable" style="width:180px;">Profissionais</th>
              </tr>
              </thead>
            </table>
                --></div>

            <div class="__template__" type="TASKROW"><!--
            <tr taskId="(#=obj.id#)" class="taskEditRow" level="(#=level#)">
              <th class="gdfCell edit" align="right" style="cursor:pointer;"><span class="taskRowIndex">(#=obj.getRow()+1#)</span> <span class="teamworkIcon" style="font-size:12px;" >e</span></th>
              <td class="gdfCell noClip" align="center"><div class="taskStatus cvcColorSquare" status="(#=obj.status#)"></div></td>
              <td class="gdfCell indentCell" style="padding-left:(#=obj.level*10#)px;">
                <div class="(#=obj.isParent()?'exp-controller expcoll exp':'exp-controller'#)" align="center"></div>
                <input type="text" name="name" value="(#=obj.name#)">
              </td>

              <td class="gdfCell"><input type="text" name="start"  value="" class="date"></td>
              <td class="gdfCell"><input type="text" name="end" value="" class="date"></td>
              <td class="gdfCell"><input type="text" name="duration" value="(#=obj.duration#)"></td>
              <td class="gdfCell"><input type="text" name="depends" value="(#=obj.depends#)" (#=obj.hasExternalDep?"readonly":""#)></td>
              <td class="gdfCell taskAssigs">(#=obj.getAssigsString()#)</td>
            </tr>
                --></div>

            <div class="__template__" type="TASKEMPTYROW"><!--
            <tr class="taskEditRow emptyRow" >
              <th class="gdfCell" align="right"></th>
              <td class="gdfCell noClip" align="center"></td>
              <td class="gdfCell"></td>
              <td class="gdfCell"></td>
              <td class="gdfCell"></td>
              <td class="gdfCell"></td>
              <td class="gdfCell"></td>
              <td class="gdfCell"></td>
              <td class="gdfCell"></td>
            </tr>
                --></div>

            <div class="__template__" type="TASKBAR"><!--
            <div class="taskBox taskBoxDiv" taskId="(#=obj.id#)" >
              <div class="layout (#=obj.hasExternalDep?'extDep':''#)">
                <div class="taskStatus" status="(#=obj.status#)"></div>
                <div class="taskProgress" style="width:(#=obj.progress>100?100:obj.progress#)%; background-color:(#=obj.progress>100?'red':'rgb(153,255,51);'#);"></div>
                <div class="milestone (#=obj.startIsMilestone?'active':''#)" ></div>

                <div class="taskLabel"></div>
                <div class="milestone end (#=obj.endIsMilestone?'active':''#)" ></div>
              </div>
            </div>
                --></div>

            <div class="__template__" type="CHANGE_STATUS"><!--
              <div class="taskStatusBox">
                <div class="taskStatus cvcColorSquare" status="STATUS_ACTIVE" title="active"></div>
                <div class="taskStatus cvcColorSquare" status="STATUS_DONE" title="completed"></div>
                <div class="taskStatus cvcColorSquare" status="STATUS_FAILED" title="failed"></div>
                <div class="taskStatus cvcColorSquare" status="STATUS_SUSPENDED" title="suspended"></div>
                <div class="taskStatus cvcColorSquare" status="STATUS_UNDEFINED" title="undefined"></div>
              </div>
                --></div>


            <div class="__template__" type="TASK_EDITOR"><!--
            <div class="ganttTaskEditor">
                <table width="100%">
                  <tr>
                    <td valign="top">
                      <table cellpadding="5">
                        <tr>
                          <td><label for="name">Nome</label><br><input type="text" name="name" id="name" value=""  size="35" class="formElements"></td>
                        </tr>
                        <tr></tr>
                          <td>
                            <label for="description">Descrição</label><br>
                            <textarea rows="5" cols="30" id="description" name="description" class="formElements"></textarea>
                          </td>
                        </tr>
                      </table>
                    </td>
                    <td valign="top">
                      <table cellpadding="5">
                        <tr>
                            <td>
                                <label for="status">Status</label><br>
                                <div id="status" class="taskStatus" status=""></div>
                            </td>
                            <td style="padding-left:20px">
                                <label for="start">Início</label><br>
                                <input type="text" name="start" id="start"  value="" class="date" size="10" class="formElements">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="progress">Progresso</label><br>
                                <input type="text" name="progress" id="progress" value="" size="3" class="formElements">
                            </td>
                            <td style="padding-left:20px">
                                <label for="end">Fim</label><br>
                                <input type="text" name="end" id="end" value="" class="date"  size="10" class="formElements">
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td class="graph" style="padding-left:20px">
                                <label for="duration">Duração</label><br>
                                <input type="text" name="duration" id="duration" value=""  size="5" class="formElements">
                            </td>
                        </tr>
                      </table>
                    </td>
                  </tr>
                </table>

                <div id="quadroParaAtividades">
                    <h2>Profissionais</h2>
                    <table  cellspacing="1" cellpadding="0" width="100%" id="assigsTable">
                      <tr>
                        <th style="text-align: left; width:100px;">Nome</th>
                        <th style="text-align: left; width:30px;">Quantidade Horas</th>
                        <th style="width:30px;" id="addAssig"><span class="teamworkIcon" style="cursor: pointer">+</span></th>
                      </tr>
                    </table>

                    <div style="text-align: right; padding-top: 20px">
                        <button id="saveButton" class="submit">Salvar</button>
                    </div>
                </div>
            </div>
                --></div>


            <div class="__template__" type="ASSIGNMENT_ROW"><!--
            <tr taskId="(#=obj.task.id#)" assigId="(#=obj.assig.id#)" class="assigEditRow" >
              <td ><select name="resourceId"  class="formElements" (#=obj.assig.id.indexOf("tmp_")==0?"":"disabled"#) ></select></td>
              <td ><input type="text" name="effort" value="(#=getMillisInHoursMinutes(obj.assig.effort)#)" size="5" class="formElements"></td>
              <td align="center"><span class="teamworkIcon delAssig" style="cursor: pointer">d</span></td>
            </tr>
                --></div>


            <div class="__template__" type="RESOURCE_EDITOR"><!--
            <div class="resourceEditor" style="padding: 5px;">

              <h2>Project team</h2>
              <table  cellspacing="1" cellpadding="0" width="100%" id="resourcesTable">
                <tr>
                  <th style="width:100px;">Nome</th>
                  <th style="width:30px;" id="addResource"><span class="teamworkIcon" style="cursor: pointer">+</span></th>
                </tr>
              </table>

              <div style="text-align: right; padding-top: 20px"><button id="resSaveButton" class="submit">Salvar</button></div>
            </div>
                --></div>


            <div class="__template__" type="RESOURCE_ROW"><!--
            <tr resId="(#=obj.id#)" class="resRow" >
              <td ><input type="text" name="name" value="(#=obj.name#)" style="width:100%;" class="formElements"></td>
              <td align="center"><span class="teamworkIcon delRes" style="cursor: pointer">d</span></td>
            </tr>
                --></div>


        </div>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jQueryGantt/loadDecorator.js"></script>
    </body>
</html>