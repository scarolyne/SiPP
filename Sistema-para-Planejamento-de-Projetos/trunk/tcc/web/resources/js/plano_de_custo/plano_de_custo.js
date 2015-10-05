jQuery(document).ready(function() {

    jQuery(".excluir").on("click", function() {

        if ( confirm("Deseja excluir este profissional?") ) {
            var url = jQuery(this).attr("url");
            window.location = url;
        }

    });

    jQuery(".salvar").on("click", function() {

        var url = jQuery(this).attr("url");
        var idAtividade = jQuery(this).attr("atividade");
        var profissional = jQuery("#saveProfissional" + idAtividade + " :selected").val();
        var quantidadeHoras = jQuery("#saveQuantidadeHoras" + idAtividade).val();

        url += "/profissional/" + profissional;
        url += "/quantidadeHoras/" + quantidadeHoras;
        url += "/atividade/" + idAtividade;
        window.location = url;

    });

});