// /**
//  * Created by huixing on 2018/4/30.
//  */
// $(function() {
//     to_page(1);
//     $("#emp_update_btn").click(function() {
//         $.ajax({
//             url : "/ssm/emps/" + $(this).attr("edit_id"),
//             type : "POST",
//             data : $("#empUpdateModal form").serialize() + "&_method=PUT",
//             statusCode : {
//                 204 : function() {
//                     $("#empUpdateModal").modal('hide');
//                     to_page(1);
//                 }
//             }
//
//         })
//
//     });
//
//     $("#check_all").click(function() {
//         // 获取属性
//         $(".check_item").prop("checked", $(this).prop("checked"));
//     });
//
//     $(document).on("click", ".check_item", function() {
//         var flag = $(".check_item:checked").length == $(".check_item").length;
//         $("#check_all").prop("checked", flag);
//     })
//
//     $("#emp_delete_all").click(function() {
//         var empNames = "";
//         var empId = "";
//         $.each($(".check_item:checked"), function() {
//             empNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
//             empId += $(this).parents("tr").find("td:eq(1)").text() + "-";
//         });
//         //empId = empId.substring(0, empId.length-1);
//         if (confirm("确认删除 " + empNames + "吗？")) {
//             alert(empId);
//             $.ajax({
//                 url:"/ssm/emps/"+empId,
//                 type:"DELETE",
//                 statusCode:{
//                     204:function(){
//                         alert("删除成功");
//                         to_page(1);
//                     }
//                 }
//             });
//         }
//     })
// })
//
// function to_page(pn) {
//
//     $.ajax({
//         url : "/ssm/emps",
//         data : "pn=" + pn,
//         type : "GET",
//         statusCode : {
//             200 : function(data) {
//                 emps_info(data);
//
//                 page_info(data);
//
//                 page_nav(data);
//             },
//             500 : function() {
//                 console.log("失败");
//             }
//         }
//     });
//
// }
//
// function emps_info(data) {
//     // 清空table
//     $("#emps_table tbody").empty();
//     var emps = data.list;
//     $
//         .each(
//             emps,
//             function(index, emp) {
//                 var checkbox = $("<td><input type='checkbox' class='check_item'/></td>");
//                 var empId = $("<td></td>").append(emp.empId);
//                 var empName = $("<td></td>").append(emp.empName);
//                 var gender = $("<td></td>").append(
//                     emp.gender == "M" ? "男" : "女");
//                 var email = $("<td></td>").append(emp.email);
//                 var deptName = $("<td></td>").append(
//                     emp.department.deptName);
//                 var btn_edit = $("<button>编辑</button>").addClass(
//                     "btn