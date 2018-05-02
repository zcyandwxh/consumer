/**
 * Created by huixing on 2018/4/30.
 */
$(document).ready(function () {

    $("#page-inner").append(
        $("<div></div>").append($("<button>新增</button>").val("新增").attr("data-toggle", "modal").attr("data-target", "#myModal").addClass("btn btn-primary btn-lg").attr("id", "add"))
    ).delegate("#add", 'click', function () {
        $.ajax({
            url:"/",
            dataType:"json",
            success: function (data) {
                $.each(data.data, function (key, val) {
                    if (data.data == null) {
                        alert("无商品");
                    }
                    $("#one").append($("<option></option>").val(val.id).text(val.product).on("click", function () {
                        $.ajax({
                            url:"",
                            dataType: "json",
                            success: function (data) {
                                if (data.data == null) {
                                    alert("无商品");
                                }
                                $.each(data.data, function(key, val){
                                    $("#two").append($("<option></option>").val(val.id).text(val.product).on("click", function () {
                                        $.ajax({
                                            url:"",
                                            dataType: "json",
                                            success: function (data) {
                                                if (data.data == null) {
                                                    alert("无商品");
                                                }
                                                $.each(data.data, function (key, val) {
                                                    $("#three").append($("<option></option>").val(val.id).text(val.product));
                                                })
                                            }
                                        })
                                    }))
                                })
                            }
                        })
                    }))
                })
            }
        })
    }).delegate("#detail", 'click', function () {
        $.ajax({
            url:"/provider/detail",
            dataType: "json",
            success: function (data) {
                if (data.data == null) {
                    alert("无数据");
                }
                $.each(data.data, function (key, val) {
                    $("#detailBody").append(
                        $("<div></div>")
                            .append($("<input type='checkbox'/>").val(val.id))
                            .append($("<span></span>").text(val.product))
                            .append($("<span></span>").text(val.price))
                    );
                })
            }
        })
    }).delegate('#delete', 'click', function () {
        $.ajax({
            url:"/provider/delete?",
            dataType: "json",
            success: function (data) {
                alert(data.desc);
            }
        });
    });

    $.ajax({
        url:"/provider/showProvider",
        dataType: "json",
        success: function (data) {
            $.each(data.data, function (key, val) {
                $("#page-inner")
                        .append(
                        $("<table></table>").addClass("table table-hover").append(
                            $("<thead></thead>").append(
                                $("<tr></tr>")
                                    .append($("<th></th>").text("经销商名称"))
                                    .append($("<th></th>").text("经销商信用"))
                                    .append($("<th></th>").text("经销商联系方式"))
                                    .append($("<th></th>").text("操作"))
                            )
                        ).append(
                            $("<tbody></tbody>").append(
                                $("<tr></tr>")
                                    .append($("<td></td>").text(val.providerName))
                                    .append($("<td></td>").text(val.credit))
                                    .append($("<td></td>").text(val.contact))
                                    .append(
                                        $("<td></td>")
                                            .append($("<button>详情</button>").val("详情").attr("data-toggle", "modal").attr("data-target", "#detailModel").addClass("btn btn-primary btn-lg").attr("id", "detail"))
                                            .append($("<button>删除</button>").val("删除").addClass("btn btn-primary btn-lg").attr("id", "delete"))
                                    )
                            )
                        )
                    )
            })
        }
    })

    var $delete = $("#delete");
    var $add = $("#add");
    var $detail = $("#detail");
    var $submit = $("#submit");


    $submit.on("click", function () {
        $.ajax({
            url: "/provider/submit",
            type: "POST",
            data: $("#addBody").serialize(),
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                alert(data.desc);
            }
        })
    })
})

function productKind() {

}