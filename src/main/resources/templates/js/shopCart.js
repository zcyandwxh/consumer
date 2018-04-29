/**
 * Created by huixing on 2018/4/29.
 */
$(document).ready(function(){
    $.ajax({
        url:"",
        dataType: "json",
        success: function (data) {
            $.each(data.data, function(key, val){
                $("<div></div>").append(
                    $("<ul></ul>")
                        .append($("<div></div>").append($("<li></li>").append($("<input/>").attr("type", "checkbox").val(val.productId))))
                        .append($("<div></div>").append($("<li></li>").append($("<img>").attr("src", val.pictureUrl))))
                        .append($("<div></div>").append($("<li></li>").append($("<a></a>").text(val.priductName))))
                        .append($("<div></div>").append($("<li></li>").append($("<span></span>").text(val.num))))
                )
            });
        },
        fail: function () {
            alert("查询购物车详情出错");
        }
    })
})