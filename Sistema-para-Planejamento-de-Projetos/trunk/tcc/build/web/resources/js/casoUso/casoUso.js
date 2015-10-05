jQuery(document).ready(function() {

    jQuery.ajax({
        url: "../../Bootstrap/CasoDeUso/ajaxBuscaUCsessao",
        type: "POST",
        dataType: 'json'
    }).success(function(data) {
        atualizaTabela(data);
    });


    $('#adicionaUC').click(function() {
        var tipo = $('#tipo').val();
        var nome = $('#nome').val();
        var complexidade = $('#complexidade').val();

        var dadosAjax = {
            'escolha': tipo,
            'nomeTipo': nome,
            'complexidade': complexidade
        };
        $.ajax({
            url: "../../Bootstrap/CasoDeUso/adicionaUcAjax",
            type: "POST",
            dataType: 'json',
            data: {
                dadosUC: JSON.stringify(dadosAjax)
            }
        }).success(function(data) {
            atualizaTabela(data);
            $('#tipo').val('');
            $('#nome').val('');
            $('#complexidade').val('');

        });
    });

});


function atualizaTabela(data) {

    var linhaTabelaProduto = "";
    $.each(data, function(key, value) {
        linhaTabelaProduto += "<tr>";
        linhaTabelaProduto += "    <td>" + (key + 1) + "</td>";
        linhaTabelaProduto += "    <td>" + value.tipo + "</td>";
        linhaTabelaProduto += "    <td>" + value.nome + "</td>";
        linhaTabelaProduto += "    <td>" + value.complexidade + "</td>";
        linhaTabelaProduto += "    <td> <a href='javascript:remover(" + value.id + ")'><span class='icon-remove'></span></a></td>";
        linhaTabelaProduto += "</tr>";

    });
    $('#tableUC').html(linhaTabelaProduto);

}


function remover(id) {
    var id = id;

    var dadosAjax = {
        'id': id
    };
    $.ajax({
        url: "../../Bootstrap/CasoDeUso/excluirDaSessao",
        type: "POST",
        dataType: 'json',
        data: {
            dadosUC: JSON.stringify(dadosAjax)
        }
    }).success(function(data) {
        atualizaTabela(data);
    });

}