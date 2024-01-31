<%@ page contentType="text/html; charset=utf-8" language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script>
    function goList() {
        $.ajax({
            url : "/shopping/ajaxList.do",     // POJO
            type : "get",
            dataType : "json",
            success : bookList,
            error : function() { alert("error"); }
        });
    }
    function bookList(data) {
        // alert(data); // 팝업 알람
        // console.log(data) // f12 -> console에 log
        var result="<table class='table table-bordered table-hover'>";
            result+="<thead>";
                result+="<tr>";
                    result+="<th>번호</th>";
                    result+="<th>제목</th>";
                    result+="<th>가격</th>";
                    result+="<th>저자</th>";
                    result+="<th>페이지</th>";
                result+="</tr>";
            result+="</thead>";
            result+="<tbody>";
            $.each(data, function(index, object){
                result+="<tr>";
                    result+="<td>"+object.num+"</td>";
                    result+="<td>"+object.title+"</td>";
                    result+="<td>"+object.price+"</td>";
                    result+="<td>"+object.name+"</td>";
                    result+="<td>"+object.page+"</td>";
                result+="</tr>";
            });
            result+="</tbody>";
        result+="</table>";
        $("#list").html(result);

        if ($("#list").css("display")=="none") {
            $("#list").css("display","block");
        }else{
            $("#list").css("display","none");
        }
    }
</script>
</head>
<body>

    <div class="container">
        <h2>MVC Framework</h2>
        <div class="card">
            <div class="card-header">
            <form class="form-inline" action="/shopping/login.do" method="post">
              <label for="text">ID :</label>
              <input type="email" class="form-control" placeholder="Enter ID" id="username" name="username">
              <label for="pwd">Password:</label>
              <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
              <button type="submit" class="btn btn-primary">Login</button>
            </form>
            </div>
            <div class="card-body">
                <table class="table table-bordered table-hover">
                    <thead class="thead thead-dark">
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>가격</th>
                            <th>저자</th>
                            <th>페이지</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${list}">
                            <tr>
                                <td>${book.num}</td>
                                <td>${book.title}</td>
                                <td>${book.price}</td>
                                <td>${book.name}</td>
                                <td>${book.page}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button class="btn btn-primary btn-sm" onclick="location.href='/shopping/register.do'">책등록</button>
                <button class="btn btn-primary btn-sm" onclick="goList()">BookList</button>
            </div>
            <div id = "list" class="container" style="display:none">
            </div>
            <div class="card-footer">FastCampus_BE7_나도윤</div>
        </div>
    </div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>