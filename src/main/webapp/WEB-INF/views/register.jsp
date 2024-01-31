<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
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
</head>
<body>

    <div class="container">
        <h2>책 등록 화면</h2>
        <div class="card">
            <div class="card-header">Book Register(책 등록)</div>
            <div class="card-body">
                <form action="/shopping/registerPost.do" method="post">
                    <div class="form-group">
                        <label for="title">제목</label>
                        <input type="text" class="form-control" placeholder="Enter title" id="title" name="title">
                    </div>
                    <div class="form-group">
                        <label for="price">가격</label>
                        <input type="text" class="form-control" placeholder="Enter price" id="price" name="price">
                    </div>
                    <div class="form-group">
                        <label for="name">저자</label>
                        <input type="text" class="form-control" placeholder="Enter name" id="name" name="name">
                    </div>
                    <div class="form-group">
                        <label for="page">페이지수</label>
                        <input type="text" class="form-control" placeholder="Enter page" id="page" name="page">
                    </div>
                    <button type="submit" class="btn btn-primary">등록</button>
                </form>
            </div>
            <div class="card-footer">FastCampus_BE7_나도윤</div>
        </div>
    </div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>