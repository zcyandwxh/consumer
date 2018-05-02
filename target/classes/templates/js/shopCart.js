/**
 * Created by huixing on 2018/4/29.
 */
$(document).ready(function(){
    $("#submit").on('click', function () {
        var shopCartIds = document.getElementsByName("shopCartId");
        var saveDataAry = [];
        for (var i=0; i<shopCartIds.length;i++) {
            alert($(shopCartIds[i]).val());
            saveDataAry.push($(shopCartIds[i]).val());
        }
        $.ajax({
            url:"/production/order/create",
            dataType: "json",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(saveDataAry),
            success: function (data) {

            }
        })
    })

})