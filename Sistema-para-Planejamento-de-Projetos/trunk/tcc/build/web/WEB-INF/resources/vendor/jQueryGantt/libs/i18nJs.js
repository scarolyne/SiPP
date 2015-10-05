


  function dateToRelative(localTime){
    var diff=new Date().getTime()-localTime;
    var ret="";

    var min=60000;
    var hour=3600000;
    var day=86400000;
    var wee=604800000;
    var mon=2629800000;
    var yea=31557600000;

    if (diff<-yea*2)
      ret ="em ## anos".replace("##",(-diff/yea).toFixed(0));

    else if (diff<-mon*9)
      ret ="em ## meses".replace("##",(-diff/mon).toFixed(0));

    else if (diff<-wee*5)
      ret ="em ## semanas".replace("##",(-diff/wee).toFixed(0));

    else if (diff<-day*2)
      ret ="em ## dias".replace("##",(-diff/day).toFixed(0));

    else if (diff<-hour)
      ret ="em ## horas".replace("##",(-diff/hour).toFixed(0));

    else if (diff<-min*35)
      ret ="em quase uma hora";

    else if (diff<-min*25)
      ret ="em quase meia hora";

    else if (diff<-min*10)
      ret ="em alguns minutos";

    else if (diff<-min*2)
      ret ="em poucos minutos";

    else if (diff<=min)
      ret ="agora";

    else if (diff<=min*5)
      ret ="poucos minutos atrás";

    else if (diff<=min*15)
      ret ="alguns minutos atrás";

    else if (diff<=min*35)
      ret ="quase meia hora atrás";

    else if (diff<=min*75)
      ret ="quase uma hora atrás";

    else if (diff<=hour*5)
      ret ="poucas horas atrás";

    else if (diff<=hour*24)
      ret ="## horas atrás".replace("##",(diff/hour).toFixed(0));

    else if (diff<=day*7)
      ret ="## dias atrás".replace("##",(diff/day).toFixed(0));

    else if (diff<=wee*5)
      ret ="## semanas atrás".replace("##",(diff/wee).toFixed(0));

    else if (diff<=mon*12)
      ret ="## meses atrás".replace("##",(diff/mon).toFixed(0));

    else
      ret ="## anos atrás".replace("##",(diff/yea).toFixed(0));

    return ret;
  }

  //override date format i18n
  
  Date.monthNames = ["Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"];
  // Month abbreviations. Change this for local month names
  Date.monthAbbreviations = ["Jan","Fev","Mar","Abr","Maio","Jun","Jul","Ago","Set","Out","Nov","Dez"];
  // Full day names. Change this for local month names
  Date.dayNames =["Domingo","Segunda","Terça","Quarta","Quinta","Sexta","Sábado"];
  // Day abbreviations. Change this for local month names
  Date.dayAbbreviations = ["Dom","Seg","Ter","Qua","Qui","Sex","Sab"];
  // Used for parsing ambiguous dates like 1/2/2000 - default to preferring 'American' format meaning Jan 2.
  // Set to false to prefer 'European' format meaning Feb 1
  Date.preferAmericanFormat = false;

  Date.firstDayOfWeek =1;
  Date.defaultFormat = "dd/MM/yyyy";


  Number.decimalSeparator = ".";
  Number.groupingSeparator = ",";
  Number.minusSign = "-";
  Number.currencyFormat = "##0.00";



  var millisInWorkingDay =36000000;
  var workingDaysPerWeek =5;

  function isHoliday(date) {
    var friIsHoly =false;
    var satIsHoly =true;
    var sunIsHoly =true;

    pad = function (val) {
      val = "0" + val;
      return val.substr(val.length - 2);
    };

    var holidays = "#01_01#04_25#08_15#11_01#12_25#12_26#06_02#12_08#05_01#2010_04_05#2010_10_19#2010_05_15#2011_04_04#";

    var ymd = "#" + date.getFullYear() + "_" + pad(date.getMonth() + 1) + "_" + pad(date.getDate()) + "#";
    var md = "#" + pad(date.getMonth() + 1) + "_" + pad(date.getDate()) + "#";
    var day = date.getDay();

    return  (day == 5 && friIsHoly) || (day == 6 && satIsHoly) || (day == 0 && sunIsHoly) || holidays.indexOf(ymd) > -1 || holidays.indexOf(md) > -1;
  }


  
  var i18n = {
    FORM_IS_CHANGED:"Você possui alguns dados não salvos na página!",
    YES:"sim",
    NO:"não",
    FLD_CONFIRM_DELETE:"deseja realmente excluir?",
    INVALID_DATA:"Os dados inseridos são inválidos para o formato do campo.",
    ERROR_ON_FIELD:"Erro no campo",
    CLOSE_ALL_CONTAINERS:"fechar todos?",



    DO_YOU_CONFIRM:"Você confirma?"
  };

  