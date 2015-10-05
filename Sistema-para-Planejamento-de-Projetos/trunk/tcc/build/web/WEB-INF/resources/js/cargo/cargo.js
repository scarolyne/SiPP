jQuery(document).ready(function() {

    jQuery("#limpar").on("click", function() {
        jQuery("#cargo").val("");
        jQuery("#preco").val("");
    });

    jQuery(".excluir").on("click", function() {

        if (confirm("Deseja excluir esta função?")) {
            var url = jQuery(this).attr("url");
            window.location = url;
        }

    });

    jQuery('.money').mask('0.000,00',
            {
                reverse: true
            }
    );

});