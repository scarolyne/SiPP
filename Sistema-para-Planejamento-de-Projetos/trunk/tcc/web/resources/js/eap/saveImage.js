/*     
 *  Document   : saveImage
 *  Created on : 14/11/2014, 25:09:42
 *  Author     : Carol
 */

$(function() { 
    $("#btnSave").click(function() { 
        html2canvas($("#master-div"), {
            onrendered: function(canvas) {
                theCanvas = canvas;
                document.body.appendChild(canvas);
                // Convert and download as image 
                Canvas2Image.saveAsPNG(canvas, true); 
                $("#img-out").append(canvas);
                // Clean up 
                //document.body.removeChild(canvas);
            }
        });
        //$("#formEAPsalvar").submit();
    });
}); 