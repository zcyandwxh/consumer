$(document).ready(function(){

    /**
     * <nav aria-label="Page navigation">
         <ul class="pagination">
             <li>
                 <a href="#" aria-label="Previous">
                 <span aria-hidden="true">&laquo;</span>
                 </a>
             </li>
             <li><a href="#">1</a></li>
             <li><a href="#">2</a></li>
             <li><a href="#">3</a></li>
             <li><a href="#">4</a></li>
             <li><a href="#">5</a></li>
             <li>
             <a href="#" aria-label="Next">
             <span aria-hidden="true">&raquo;</span>
             </a>
             </li>
         </ul>
       </nav>
     */

    toPage(1);

    $previous = $("<li></li>")
        .append($("<a href='#' aria-label='Previous'></a>").append($("<span aria-hidden='true'></span>").text("&laquo;")));
    $back = $("<li></li>")
        .append($("<a href='#' aria-label='Next'></a>").append($("<span aria-hidden='true'></span>").text("&raquo;")));

    $("#page").append(
        $("<nav></nav>").attr("aria-label", "Page navigation").append(
            $("<ul></ul>").addClass("pagination")
                .append($previous)
                .append($back)
        )
    )

    $("#page-inner").append(
        $("<div></div>").append(
            $("<button></button>")
                .text("新增")
                .attr("data-toggle", "modal")
                .attr("data-target", "#myModal")
                .addClass("btn btn-primary btn-lg")
                .attr("id", "add")
        )
    ).delegate("#add", "click", function () {
        $.ajax({
            url:"",
            dataType: "json",
            success: function (data) {
                $("#shopCartBody").append(
                    $("<input type='hidden' id='id'/>").val(data.id)
                ).append(
                    $("<div></div>")
                        .append($("<img/>").attr("src", data.pictureUrl))
                        .append($("<span></span>").text("商品名称:" + data.productName + " 经销商:" + data.providerName))
                ).append(
                    $("<input type='text' id='num'/>").val(data.num)
                ).append(
                    $("<input type='hidden' id='providerId'/>").val(data.providerId)
                );
            }

        })
    });

    $("#addShopCart").on('click', function () {
        var ids = $(this).val();
        alert(ids)
        $.ajax({
            url:"/production/shopCart",
            dataType:"json",
            type: "POST",
            contentType: "application/json",
            data: ids,
            success: function (data) {
                if (data.flag == true) {
                    alert("新增购物车成功");
                } else {
                    alert("新增购物车失败");
                }
            }
        })
    })
})

function toPage(page){

}