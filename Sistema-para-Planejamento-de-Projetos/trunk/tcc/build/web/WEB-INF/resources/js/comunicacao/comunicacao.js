jQuery(document).ready(function() {

    jQuery(".excluir").on("click", function() {

        if ( confirm("Deseja excluir este Plano de Comunicacao?") ) {
            var url = jQuery(this).attr("url");
            window.location = url;
        }

    });

});
