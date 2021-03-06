var ge;  //this is the hugly but very friendly global var for the gantt editor
$(function() {

  //load templates
  $("#ganttemplates").loadTemplates();

  // here starts gantt initialization
  ge = new GanttMaster();
  var workSpace = $("#workSpace");
  workSpace.css({width:$(window).width() - 20,height:$(window).height() - 100});
  ge.init(workSpace);

  //inject some buttons (for this demo only)
  $(".ganttButtonBar div").append("<button onclick='clearGantt();' class='submit'>Limpar</button>")
  $(".ganttButtonBar div").addClass('buttons');
  //overwrite with localized ones
  loadI18n();

  //simulate a data load from a server.
  loadGanttFromServer();

  //fill default Teamwork roles if any
  if (!ge.roles || ge.roles.length == 0) {
    setRoles();
  }

  //fill default Resources roles if any
  if (!ge.resources || ge.resources.length == 0) {
    setResource();
  }


  /*/debug time scale
  $(".splitBox2").mousemove(function(e){
    var x=e.clientX-$(this).offset().left;
    var mill=Math.round(x/(ge.gantt.fx) + ge.gantt.startMillis)
    $("#ndo").html(x+" "+new Date(mill))
  });*/

  $(window).resize(function(){
    workSpace.css({width:$(window).width() - 1,height:$(window).height() - workSpace.position().top});
    workSpace.trigger("resize.gantt");
  }).oneTime(150,"resize",function(){$(this).trigger("resize")});

});


function loadGanttFromServer(taskId, callback) {

  //this is a simulation: load data from the local storage if you have already played with the demo or a textarea with starting demo data
  //loadFromLocalStorage();

  //this is the real implementation
  /*
  //var taskId = $("#taskSelector").val();
  var prof = new Profiler("loadServerSide");
  prof.reset();

  $.getJSON("ganttAjaxController.jsp", {CM:"LOADPROJECT",taskId:taskId}, function(response) {
    //console.debug(response);
    if (response.ok) {
      prof.stop();

      ge.loadProject(response.project);
      ge.checkpoint(); //empty the undo stack

      if (typeof(callback)=="function") {
        callback(response);
      }
    } else {
      jsonErrorHandling(response);
    }
  });


    var prof = new Profiler("loadServerSide");
    prof.reset();
  */
    jQuery.ajax({
        url: 'Gantt/carregarProjetoAjax',
        type: 'POST',
        dataType: 'JSON',
        data: {
            projeto: 1
        },
        success: function(response){

            ge.loadProject(response);

            ge.checkpoint(); //empty the undo stack

        },
        error: function(response){
            jsonErrorHandling(response);
        }
    });

}


function saveGanttOnServer() {
  if(!ge.canWrite)
    return;

  //this is a simulation: save data to the local storage or to the textarea
  //saveInLocalStorage();


  /*
  var prj = ge.saveProject();

  delete prj.resources;
  delete prj.roles;

  var prof = new Profiler("saveServerSide");
  prof.reset();

  if (ge.deletedTaskIds.length>0) {
    if (!confirm("TASK_THAT_WILL_BE_REMOVED\n"+ge.deletedTaskIds.length)) {
      return;
    }
  }

  $.ajax("ganttAjaxController.jsp", {
    dataType:"json",
    data: {CM:"SVPROJECT",prj:JSON.stringify(prj)},
    type:"POST",

    success: function(response) {
      if (response.ok) {
        prof.stop();
        if (response.project) {
          ge.loadProject(response.project); //must reload as "tmp_" ids are now the good ones
        } else {
          ge.reset();
        }
      } else {
        var errMsg="Errors saving project\n";
        if (response.message) {
          errMsg=errMsg+response.message+"\n";
        }

        if (response.errorMessages.length) {
          errMsg += response.errorMessages.join("\n");
        }

        alert(errMsg);
      }
    }

  });
  */

  var prj = ge.saveProject();

  delete prj.resources;
  delete prj.roles;

  if (ge.deletedTaskIds.length>0) {
    var mensagem = "";
    if (ge.deletedTaskIds.length==1) {
      mensagem = "1 atividade será removida. Confirmar?\n";
    } else {
      mensagem = ge.deletedTaskIds.length + " atividades serão removidas. Confirmar?\n";
    }
    if (!confirm(mensagem)) {
      return;
    }
  }

    jQuery.ajax({
        url: 'Gantt/salvarProjetoAjax',
        type: 'POST',
        dataType: 'JSON',
        data: {
            projeto: 1,
            projeto_json: JSON.stringify(prj)
        },
        success: function(response) {

            ge.loadProject(response); //must reload as "tmp_" ids are now the good ones

        },
        error: function(response){
            var errMsg = "Errors saving project\n";
            if (response.message) {
              errMsg = errMsg + response.message + "\n";
            }

            if (response.errorMessages.length) {
              errMsg += response.errorMessages.join("\n");
            }

            alert(errMsg);
        }
    });

}


//-------------------------------------------  Create some demo data ------------------------------------------------------
function setRoles() {
  ge.roles = [
    {
      id:"tmp_1",
      name:"Project Manager"
    },
    {
      id:"tmp_2",
      name:"Worker"
    },
    {
      id:"tmp_3",
      name:"Stakeholder/Customer"
    }
  ];
}

function setResource() {
  var res = [];
  for (var i = 1; i <= 10; i++) {
    res.push({id:"tmp_" + i,name:"Resource " + i});
  }
  ge.resources = res;
}


function editResources(){

}

function clearGantt() {
  ge.reset();
}

function loadI18n() {
  GanttMaster.messages = {
    "CANNOT_WRITE":"SEM ACESSO DE ESCRITA.",
    "CHANGE_OUT_OF_SCOPE":"SEM ACESSO PARA ESTA AÇÃO.",
    "START_IS_MILESTONE":"START_IS_MILESTONE",
    "END_IS_MILESTONE":"END_IS_MILESTONE",
    "TASK_HAS_CONSTRAINTS":"ATIVIDADE TEM DEPENDENCIAS.",
    "GANTT_ERROR_DEPENDS_ON_OPEN_TASK":"DEPENDE DE ATIVIDADE ABERTA.",
    "GANTT_ERROR_DESCENDANT_OF_CLOSED_TASK":"DESCENDENTE DE ATIVIDADE FECHADA.",
    "TASK_HAS_EXTERNAL_DEPS":"ATIVIDADE TEM DEPENDENCIAS EXTERNAS.",
    "GANTT_ERROR_LOADING_DATA_TASK_REMOVED":"CARREGAMENTO DOS DADOS DA ATIVIDADE REMOVIDO.",
    "ERROR_SETTING_DATES":"ERRO NA DEFINIÇÃO DE DATAS.",
    "CIRCULAR_REFERENCE":"REFERENCIA CIRCULAR.",
    "CANNOT_DEPENDS_ON_ANCESTORS":"NÃO É POSSÍVEL DEFINIR UM PACOTE COMO DEPENDENTE DE UMA ATIVIDADE.",
    "CANNOT_DEPENDS_ON_DESCENDANTS":"UM PACOTE NÃO PODE DAS SUAS ATIVIDADES.",
    "INVALID_DATE_FORMAT":"FORMATO DE DATA INVÁLIDO.",
    "TASK_MOVE_INCONSISTENT_LEVEL":"TENTATIVA DE MOVER ATIVIDADE PARA NIVEL INVALIDO.",

    "GANTT_QUARTER_SHORT":"trim.",
    "GANTT_SEMESTER_SHORT":"sem."
  };
}



//-------------------------------------------  Get project file as JSON (used for migrate project from gantt to Teamwork) ------------------------------------------------------
function getFile() {
  $("#gimBaPrj").val(JSON.stringify(ge.saveProject()));
  $("#gimmeBack").submit();
  $("#gimBaPrj").val("");

  /*  var uriContent = "data:text/html;charset=utf-8," + encodeURIComponent(JSON.stringify(prj));
   neww=window.open(uriContent,"dl");*/
}


//-------------------------------------------  LOCAL STORAGE MANAGEMENT (for this demo only) ------------------------------------------------------
Storage.prototype.setObject = function(key, value) {
  this.setItem(key, JSON.stringify(value));
};


Storage.prototype.getObject = function(key) {
  return this.getItem(key) && JSON.parse(this.getItem(key));
};


function loadFromLocalStorage() {
  var ret;
  if (localStorage) {
    if (localStorage.getObject("teamworkGantDemo")) {
      ret = localStorage.getObject("teamworkGantDemo");
    }
  } else {
    $("#taZone").show();
  }
  if (!ret || !ret.tasks || ret.tasks.length == 0){
    ret = JSON.parse($("#ta").val());


    //actualiza data
    var offset=new Date().getTime()-ret.tasks[0].start;
    for (var i=0;i<ret.tasks.length;i++)
      ret.tasks[i].start=ret.tasks[i].start+offset;


  }
  ge.loadProject(ret);
  ge.checkpoint(); //empty the undo stack
}


function saveInLocalStorage() {
  var prj = ge.saveProject();
  if (localStorage) {
    localStorage.setObject("teamworkGantDemo", prj);
  } else {
    $("#ta").val(JSON.stringify(prj));
  }
}


//-------------------------------------------  Open a black popup for managing resources. This is only an axample of implementation (usually resources come from server) ------------------------------------------------------

function editResources(){

  //make resource editor
  var resourceEditor = $.JST.createFromTemplate({}, "RESOURCE_EDITOR");
  var resTbl=resourceEditor.find("#resourcesTable");

  for (var i=0;i<ge.resources.length;i++){
    var res=ge.resources[i];
    resTbl.append($.JST.createFromTemplate(res, "RESOURCE_ROW"))
  }


  //bind add resource
  resourceEditor.find("#addResource").click(function(){
    resTbl.append($.JST.createFromTemplate({id:"new",name:"resource"}, "RESOURCE_ROW"))
  });

  //bind save event
  resourceEditor.find("#resSaveButton").click(function(){
    var newRes=[];
    //find for deleted res
    for (var i=0;i<ge.resources.length;i++){
      var res=ge.resources[i];
      var row = resourceEditor.find("[resId="+res.id+"]");
      if (row.size()>0){
        //if still there save it
        var name = row.find("input[name]").val();
        if (name && name!="")
          res.name=name;
        newRes.push(res);
      } else {
        //remove assignments
        for (var j=0;j<ge.tasks.length;j++){
          var task=ge.tasks[j];
          var newAss=[];
          for (var k=0;k<task.assigs.length;k++){
            var ass=task.assigs[k];
            if (ass.resourceId!=res.id)
              newAss.push(ass);
          }
          task.assigs=newAss;
        }
      }
    }

    //loop on new rows
    resourceEditor.find("[resId=new]").each(function(){
      var row = $(this);
      var name = row.find("input[name]").val();
      if (name && name!="")
        newRes.push (new Resource("tmp_"+new Date().getTime(),name));
    });

    ge.resources=newRes;

    closeBlackPopup();
    ge.redraw();
  });


  var ndo = createBlackPage(400, 500).append(resourceEditor);
}