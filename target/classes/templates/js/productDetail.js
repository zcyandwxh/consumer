/**
 * Created by huixing on 2018/4/29.
 */
/**
 * 展现商品详情
 */
$(document).ready(function(){

            $("#detail").click(function(e) {
                $.ajax({
                    url:"/production/detail",
                    dataType: "json",
                    success: function (data) {

                        $("#showDetail")
                            .append(
                                $("<table></table>")
                                    .append(
                                        $("<thead></thead>")
                                        .append($("<tr>" +
                                            "<th>商品名称</th>" +
                                            "<th>商品展示图</th>" +
                                            "<th>商品价格</th>" +
                                            "<th>库存</th>" +
                                            "</tr>"))
                                    )
                                    .append(
                                        $("<tbody></tbody>")
                                            .append($("<tr>" +
                                                "<td>" + data.data.product + "</td>" +
                                                "<td>" + data.data.pictureUrl + "</td>" +
                                                "<td>" + data.data.price + " </td>" +
                                                "<td>" + data.data.num + "</td>" +
                                                "</tr>"))
                                    )
                            )
                    }
                });
                e.stopPropagation();   // 阻止冒泡
                $('#wrapper').css("display", "block");   // 显示
                $("#showDetail").css("display", "block");

                $("#wrapper").bind("click", function(e) {   // 相当于点击空白消失
                    $('#wrapper').css("display", "none");
                    $("#showDetail").css("display", "none");
                });
            });

})