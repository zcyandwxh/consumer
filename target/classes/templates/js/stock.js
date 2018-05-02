/**
 * Created by huixing on 2018/4/29.
 */
$(document).ready(function(){
    $.ajax({
        url:"/stockProduct/{}",
        dataType: "json",
        success: function (data) {
            $.each(data.data, function(key, val){
                var $table = $("<table></table>");
                $table.append($("<tr></tr>").append($("<td></td>").text(val.material))
                    .append($("<td></td>").text(val.picture))
                    .append($("<td></td>").text(val.price))
                    .append($("<td></td>").text(val.num))
                    .append($("<td></td>").text(val.modifyTime))
                    .append($("<td></td>").append($("<a>删除</a>")).append($("<a>编辑</a>"))))
            })
        }
    })
})