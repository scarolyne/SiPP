function onlyNumber(str) {
    str = str.toString();
    return str.replace(/\D/g, '');
}

function getPos(ele, tipo) {
    x = 0;
    y = 0;

    while(true) {
        x += ele.offsetLeft;
        y += ele.offsetTop;
        if (ele.offsetParent === null) {
            break;
        }
        ele = ele.offsetParent;
    }
    if (tipo == 'x') {
        return x;
    }
    else {
        return y;
    }
}

function addPacote() {
    count = document.getElementById('count_pacotes');
    ret = document.createElement('div');
    ret.className = 'ret ret_1';
    ret.id = 'PP' + count.value;

    lineTop = document.createElement('div');
    lineTop.className = 'lineTop';

    input = document.createElement('textarea');
    input.className = 'input-eap';
    input.name = 'pacote_' + count.value;
    input.value = 'PACOTE ' + (Number(count.value) + 1);

    appbtn = document.createElement('div');
    appbtn.className = 'appButton';

    btn1 = document.createElement('button');
    btn1.className = 'btnAdd';
    btn1.type = 'button';
    btn1.innerHTML = '+';
    btn1.setAttribute('onclick', "addAtivi('" + 'PP' + count.value + "', " + count.value + "); return false;");

    btn2 = document.createElement('button');
    btn2.className = 'btnDel';
    btn2.type = 'button';
    btn2.innerHTML = 'x';
    btn2.setAttribute('onclick', "if (confirmAction('Esta ação irá excluir o pacote PACOTE " + Number((Number(count.value) + 1)) + " e todas as atividades vinculadas a ele. Deseja prosseguir?')) { delPacote('" + 'PP' + count.value + "', " + count.value + "); }");

    appbtn.appendChild(btn1);
    appbtn.appendChild(btn2);

    ret.appendChild(lineTop);
    ret.appendChild(input);
    ret.appendChild(appbtn);

    /*
    hr = document.getElementById('lineHr');
    w2 = onlyNumber(hr.style.width) * 1;
    w2 = (w2 + 112) * count;
    alert(w2);
    hr.style.width = w2 + 'px';
    */

    document.getElementById('pacotes').appendChild(ret);
    count.value = Number(count.value) + 1;

    document.getElementById('lineBottom').style.background = '#CCC';
}

function delPacote(id, count) {
    del1 = document.getElementById(id);
    del2 = document.getElementById('div-' + id);
    parent1 = del1.parentNode;
    parent2 = del2.parentNode;

    while (del2.firstChild){
        del2.removeChild(del2.firstChild);
    }

    document.getElementById('count_pacotes_del').value = Number(document.getElementById('count_pacotes_del').value) + 1;

    parent1.removeChild(del1);
    parent2.removeChild(del2);
    ajustarDiv('PP');
}

function ajustarDiv(pp) {
    count = document.getElementById('count_pacotes').value;
    dev = getPos(document.getElementById('menos-dev'), 'x');
    count2 = 0;
    for (i = 0; i < count; i++) {
        if (document.getElementById(pp + i)) {
            //alert(count);
            left = getPos(document.getElementById(pp + i), 'x') - (3 * count2) - dev;
            if (document.getElementById('div-' + pp + i)) {
                div = document.getElementById('div-' + pp + i);
                div.style.left = left + 'px';
            }
            else {
                div = document.createElement('div');
                div.id = 'div-' + pp + i;
                div.className = 'div-pacote';
                div.style.left = left + 'px';
                div.innerHTML = '&nbsp;';
            }
            document.getElementById('master-div').appendChild(div);
            count2 = count2 + 1;
        }
    }
}

function addAtivi(ppc, pac) {
    
    document.getElementById('div-' + ppc).style.background = '#CCC';
    ret = document.createElement('div');
    ret.className = 'ret ret_2';

    if (document.getElementsByName('pacote_' + pac + '_atividade[]')) {
        nr_ativ = document.getElementsByName('pacote_' + pac + '_atividade[]').length + 1;
    }
    else {
        nr_ativ = 1;
    }

    ret.id = ppc + '_atv_' + nr_ativ;

    input = document.createElement('textarea');
    input.className = 'input-eap';
    input.name = 'pacote_' + pac + '_atividade[]';
    input.value = 'Pacote ' + (Number(pac) + 1) + ' - Atividade ' + nr_ativ;

    appbtn = document.createElement('div');
    appbtn.className = 'appButton';

    btn2 = document.createElement('button');
    btn2.className = 'btnDel';
    btn2.innerHTML = 'x';
    btn2.type = 'button';
    btn2.setAttribute('onclick', "if (confirmAction('Deseja realmente excluir a atividade Pacote " + (Number(pac) + 1) + ' - Atividade ' + nr_ativ + "?')) { delAtivi('" + ppc + '_atv_' + nr_ativ + "', " + nr_ativ + ");}");

    appbtn.appendChild(btn2);

    ret.appendChild(input);
    ret.appendChild(appbtn);

    document.getElementById('div-' + ppc).appendChild(ret);
    ajustarDiv('PP');
    
    master = document.getElementById('master-div');
    w2 = onlyNumber(master.style.height) * 1;
    w2 = (w2 + 100);
    master.style.height = w2 + 'px';
    
    return false;
}

function delAtivi(id, count) {
    del1 = document.getElementById(id);
    parent1 = del1.parentNode;
    parent1.removeChild(del1);
}

function delAtiviBd (id) {
    hid = document.createElement("input");
    hid.type = "hidden";
    hid.name = "excluirAtividade[]";
    hid.value = id;
}