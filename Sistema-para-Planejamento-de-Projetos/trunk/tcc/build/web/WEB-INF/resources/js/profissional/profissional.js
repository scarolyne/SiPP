jQuery(document).ready(function() {

    jQuery("#limpar").on("click", function() {
        jQuery("#nome").val("");
        jQuery("#cargo :selected").prop("selected", false);
    });

    jQuery(".excluir").on("click", function() {

        if ( confirm("Deseja excluir este profissional?") ) {
            var url = jQuery(this).attr("url");
            window.location = url;
        }

    });

});