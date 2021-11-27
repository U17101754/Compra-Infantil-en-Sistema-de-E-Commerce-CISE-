/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    $('tr #deleteItem').click(function (e) {
        e.preventDefault();
        var elemento = $(this);
        var idProducto = elemento.parent().find('#idArticulo').text();
        var nombreProducto = elemento.parent().find('#nombreArticulo').text();
        $.ajax({
            url: 'comcatalogo.do?txtAccion=deleteArticulo',
            type: 'POST',
            data: {idproducto : idProducto},
            success: function (r) {
                alertify.success(nombreProducto+' Eliminado del carrito');
                elemento.parent().parent().remove();
                $('#txtSubtotal').text(r);
            }
        });
    });
});




