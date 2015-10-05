/*     
 *  Document   : functions
 *  Created on : 29/10/2014, 21:38:42
 *  Author     : Carol
 */

/*
 * function showGuider: guia (tutorial) de utilização do sistema
 * 
 * @param {integer} h - índice do guia que deve desaparecer
 * @param {integer} s - índice do guia que deve aparecer
 * @returns {guider}
 */
function showGuider(h, s) {
    hidden = document.getElementById('guider_' + h);
    show = document.getElementById('guider_' + s);

    show.style.display = "inline";
    hidden.style.display = "none";
}

/*
 * function addElement
 * 
 * @param {string} element - input|input|label|input // elementos a serem adicionados, na ordem em que devem ser adicionados, separados por pipe
 * @param {string} type - text|checkbox|0|radio // no caso de input, por exemplo. Se não houver, usar 0
 * @param {string} name - aprovador|nome|texto|teste[] // se não houver, usar 0
 * @param {string} placeholder - aprovador|nome|texto|teste // se não houver, usar 0
 * @param {string} required - 0|0|1|0 // 1 para sim, 0 para não
 * @param {string} appendType - ul, table... O tipo do elemento que conterá as informações
 * @param {string} appendId - elementId // id do elemento onde serão alocados os novos elementos
 * @returns {line}
 */
function addElement(element, type, name, placeholder, required, className, inner, appendType, appendId) {

    auxElem = element.split('|');
    auxType = type.split('|');
    auxName = name.split('|');
    auxPlac = placeholder.split('|');
    auxRequ = required.split('|');
    auxClass = className.split('|');
    auxInner = inner.split('|');
    
    switch(appendType) {
        case 'table':
            fim = document.createElement("tr");
            td = document.createElement("td");
            for(i = 0; i < auxElem.length; i++) {
                x = document.createElement(auxElem[i]);
                if (auxType[i] != 0) {
                    x.type = auxType[i];
                }
                if (auxName[i] != 0) {
                    x.name = auxName[i];
                }
                if (auxPlac[i] != 0) {
                    x.placeholder = auxPlac[i];
                }
                if (auxRequ[i] != 0) {
                    x.required = true;
                }
                if (auxClass[i] != 0) {
                    x.className = auxClass[i];
                }
                td.appendChild(x);
            }
            fim.appendChild(td);
            break;
        case 'ul':
            fim = document.createElement("li");
            for(i = 0; i < auxElem.length; i++) {
                x = document.createElement(auxElem[i]);
                if (auxType[i] != 0) {
                    x.type = auxType[i];
                }
                if (auxName[i] != 0) {
                    x.name = auxName[i];
                }
                if (auxPlac[i] != 0) {
                    x.placeholder = auxPlac[i];
                }
                if (auxRequ[i] != 0) {
                    x.required = true;
                }
                if (auxClass[i] != 0) {
                    x.className = auxClass[i];
                }
                if (auxInner[i] != '') {
                    x.innerHTML = auxInner[i];
                }
                fim.appendChild(x);
            }
            break;
    }
    
    document.getElementById(appendId).appendChild(fim);
}

function addAprovador() {

    li = document.createElement("li");
    label = document.createElement("label");
    aprov = document.createElement("input");
    aprov.type = "text";
    aprov.name = "aprovador[]";
    aprov.placeholder = "Aprovador";
    li.appendChild(label);
    li.appendChild(aprov);

    document.getElementById("ulForm1").appendChild(li);
}

function addEntrega() {

    li = document.createElement("li");
    label = document.createElement("label");
    span = document.createElement("span");
    span.innerHTML = "&nbsp;";
    
    data = document.createElement("input");
    data.type = "date";
    data.name = "data[]";
    data.className = "input-medium";
    
    entrega = document.createElement("input");
    entrega.type = "text";
    entrega.name = "entrega[]";
    entrega.className = "input-medium";
    entrega.placeholder = "Entrega";

    id = document.createElement("input");
    id.type = "hidden";
    id.name = "id_entrega[]";
    id.value= "0";

    //li.appendChild(label);
    li.appendChild(data);
    li.appendChild(span);
    li.appendChild(entrega);
    li.appendChild(id);

    document.getElementById("ulForm").appendChild(li);
}

function addAprovador() {

        li = document.createElement("li");
        label = document.createElement("label");
        aprov = document.createElement("input");
        aprov.type = "text";
        aprov.name = "aprovador[]";
        aprov.placeholder = "Aprovador";
        li.appendChild(label);
        li.appendChild(aprov);

        document.getElementById("ulForm1").appendChild(li);
    }

function addUsuario(url) {
    
    document.getElementById('count_equipe').value = Number(document.getElementById('count_equipe').value) + 1;
    count = document.getElementById('count_equipe');

    ul = document.getElementById('ulForm');
    li = document.createElement('li');
    
    label = document.createElement('label');
    label.innerHTML = '&nbsp;';
    
    input = document.createElement('input');
    input.type = 'text';
    input.placeholder = 'E-mail';
    input.name = 'email[]';
    input.id = 'email_' + count.value;
    input.value = '';
    input.setAttribute("onblur", "verificarEmail('" + url + "', this.value, " + count.value + ")");
    
    hidden = document.createElement('input');
    hidden.type = 'hidden';
    hidden.name = 'usuario[]';
    hidden.id = 'usuario_' + count.value;

    li.appendChild(label);
    li.appendChild(input);
    li.appendChild(hidden);
    ul.appendChild(li);
}

function addUsuarioEdit(url) {
    
    document.getElementById('count_equipe_edit').value = Number(document.getElementById('count_equipe_edit').value) + 1;
    count = document.getElementById('count_equipe_edit');

    ul = document.getElementById('ulEquipe');
    li = document.createElement('li');
    
    label = document.createElement('label');
    label.innerHTML = '&nbsp;';
    
    input = document.createElement('input');
    input.type = 'text';
    input.placeholder = 'E-mail';
    input.name = 'email_edit[]';
    input.id = 'email_edit_' + count.value;
    input.value = '';
    input.setAttribute("onblur", "verificarEmail('" + url + "', this.value, " + "'edit_" + count.value + "', 'emailequipeok')");
    
    hidden = document.createElement('input');
    hidden.type = 'hidden';
    hidden.name = 'usuario[]';
    hidden.id = 'usuario_edit_' + count.value;

    li.appendChild(label);
    li.appendChild(input);
    li.appendChild(hidden);
    ul.appendChild(li);
}

/*
 * function editEquipe
 * @comment Mostrar / Alterar os dados de um projeto (nome / equipe)
 * @param {string} projetoId - id do projeto
 * @param {string} projetoTitulo - nome do projeto
 * @param {string} href - controller + método
 * @returns {null}
 */
function editEquipe(projetoId, projetoTitulo, href) {
    
    param =  '/id/' + projetoId + '/titulo/' + projetoTitulo;
    last = document.getElementById('lastProj');
    block = document.getElementById('editCadProjeto');

    if (last.value != projetoId && last.value && (block.style.display == 'block' || !block.style.display)){
        $("#editCadProjeto").slideToggle("slow", function(){});
    }
    $("#editCadProjeto").slideToggle("slow", function(){});
    
    last.value = projetoId;
    alterFrame(href, param);
}

function excluirUsuarioEquipe(url, email) {
    if(confirm("Deseja realmente remover " + email + " da equipe?")){
        location.replace(url);
    }
}

/*
 * function verificarEmail
 * @comment Utiliazada para verificar se determinado email existe no sistema ou não
 * @param {string} href - controller + método
 * @param {string} email - email digitado
 * @param {integer} count - quantidade de emails já digitados
 * @returns {null}
 */
function verificarEmail(href, email, count, eok) {
    if (email) {
        param = '/email/' + email + '/count/' + count + '/eok/' + eok;
        alterFrame(href, param);
    }
    else {
        document.getElementById(eok).value = 1;
    }
}

/*
 * function alterFrame
 * @comment Utiliazada para alterar o src de um frame invisível
 * @param {string} href - controller + método
 * @param {string} param - parâmetros
 * @returns {null}
 */
function alterFrame(href, param) {

    if(document.getElementById('if')) {
        document.getElementById('if').src = href + param;
    }
}

/*
 * function excluirProjeto
 * @comment Utiliazada para confirmar a ação de exclusão de um projeto
 * @param {string} url - controller + método + parâmetros
 * @param {string} proj - nome do projeto
 * @returns {null}
 */
function excluirProjeto(url, proj) {
    if(confirm("Deseja realmente excluir o projeto " + proj + " e todos os seus componentes?")){
        location.replace(url);
    }
}

function delAtivId(id) {
    hid = document.createElement("input");
    hid.type = "hidden";
    hid.name = "delAtivId[]";
    hid.value = id;
    document.getElementById("master-div").appendChild(hid);
}

function validaForm(id) {
    if (document.getElementById(id).value != 1) {
        return false;
    }
    return true;
}

function confirmAction(msg) {
    res = confirm(msg);
    if (!res) {
        return false;
    }
    return true;
}