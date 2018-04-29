/**
 * Created by huixing on 2018/3/5.
 */
$(document).ready(function(){
    $.ajax({
        url: "/production/content",
        dataType: "json",
        success: function (data) {
            /*
             <li th:each="entry : ${products.data}">
             <a href="#">
             <!--<i th:switch="${entry.key}">-->
             <!--<i th:case="${entry.key}" class="fa fa-desktop "></i>-->
             <!--</i>-->
             <span th:text="${entry.key}"></span> <span class="fa arrow"></span></a>
             <ul class="nav nav-second-level" th:each="value : ${entry.value}">
             <li>
             <a th:href="@{'production/product/' + ${value}}"><i class="fa fa-toggle-on"></i><span th:text="${value}"></span></a>
             </li>
             </ul>
             </li>
             */

            // var nodes = null;
            // $.each(data.data, function(key, val){
            //     var node = $("<li></li>").append($("<a></a>")
            //         .attr("href", "#").append($("<i></i>").addClass("fa fa-desktop ")))
            //         .append($("<span></span>").text(key)).append($("<span></span>").addClass("fa arrow"));
            //     $.each(val, function(index, type){
            //         $("#main-menu").append(node.append($("<ul></ul>")
            //             .addClass("nav nav-second-level").append($("<li></li>")
            //                 .append($("<a></a>").attr("href", "/production/product/" + type).append($("<i></i>").addClass("fa fa-toggle-on")).append($("<span></span>").append(type))))));
            //
            //     })
            // })
            // $("#main-menu").append(nodes);

            // $('#').click(function(){
            //     $(this).children('.text').slideToggle().parents('.box').siblings('.box').children('.text').hide();
            // })
        }
    })
})