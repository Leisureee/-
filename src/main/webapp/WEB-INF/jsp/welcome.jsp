<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>仪表盘</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="${pageContext.request.contextPath}/webjars/jquery/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/js/bootstrap.min.js"></script>
    <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <style>
        body {
            background-color: #C7EDCC;
            font-family: "microsoft yahei", "serif";
            /*min-width: 800px;*/
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark static-top">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href="#">欢迎来到超市管理系统</a>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/account/logout">安全登出</a>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="#">修改密码</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">修改资料</a></li>
                    </ul>
                    <form class="form-inline">
                        <input class="form-control mr-sm-2" type="text"/>
                        <button class="btn btn-primary my-2 my-sm-0" type="button">
                            Search
                        </button>
                    </form>
                </div>
            </nav>
            <div class="row">
                <div class="col-md-2">
                    <div id="card-1">
                        <div class="card">
                            <div class="card-header">
                                <a class="card-link" data-toggle="collapse" data-parent="#card-1" href="#card-element-1">
                                    商品管理
                                </a>
                            </div>
                            <div id="card-element-1" class="collapse">
                                <div class="card-body card-block">
                                    <a class="collapsed card-link" href="GoodsController?action=show">
                                        查看所有商品信息
                                    </a>
                                </div>
                                <div class="card-body card-block">
                                    <a class="collapsed card-link" data-toggle="modal" data-target="#addGoods" href="">
                                        新添一条商品记录
                                    </a>
                                </div>
                                <div id="addGoods" class="modal fade" tabindex="-1">
                                    <jsp:include page="modal/goods_modal.jsp"/>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <a class="collapsed card-link" data-toggle="collapse" data-parent="#card-1" href="#card-element-2">
                                    员工管理
                                </a>
                            </div>
                            <div id="card-element-2" class="collapse">
                                <div class="card-body card-block">
                                    <a class="collapsed card-link" href="EmployeeController?action=show">
                                        查看所有员工信息
                                    </a>
                                </div>
                                <div class="card-body card-block">
                                    <a class="collapsed card-link" data-toggle="modal" data-target="#addEmployee" href="#">
                                        新添一条员工记录
                                    </a>
                                </div>
                                <div id="addEmployee" class="modal fade" tabindex="-1">
                                    <jsp:include page="modal/employee_modal.jsp"/>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <a class="collapsed card-link" data-toggle="collapse" data-parent="#card-1" href="#card-element-3">
                                    会员管理
                                </a>
                            </div>
                            <div id="card-element-3" class="collapse">
                                <div class="card-body card-block">
                                    <a class="collapsed card-link" href="VipController?action=show">
                                        查看所有会员信息
                                    </a>
                                </div>
                                <div class="card-body card-block">
                                    <a class="collapsed card-link" data-toggle="modal" data-target="#addVip" href="#">
                                        新添一条会员记录
                                    </a>
                                </div>
                                <div id="addVip" class="modal fade" tabindex="-1">
                                    <jsp:include page="modal/vip_modal.jsp"/>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <a class="collapsed card-link" data-toggle="collapse" data-parent="#card-1" href="#card-element-4">
                                    用户管理
                                </a>
                            </div>
                            <div id="card-element-4" class="collapse">
                                <div class="card-body card-block">
                                    <a class="collapsed card-link" href="#">查看所有用户信息</a>
                                </div>
                                <div class="card-body card-block">
                                    <a class="collapsed card-link" data-toggle="modal" data-target="#" href="#">
                                        新添一条用户记录
                                    </a>
                                </div>
                                <div id="addUser" class="modal fade" tabindex="-1">
                                    <jsp:include page="modal/user_modal.jsp"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-10">
                    <c:choose>
                        <c:when test="${goodsList!=null}"><!-- if condition -->
                            <jsp:include page="goodsinfo.jsp"/>
                        </c:when>
                        <c:when test="${employeeList!=null}"><!-- else if condition -->
                            <jsp:include page="employeeinfo.jsp"/>
                        </c:when>
                        <c:when test="${vipList!=null}"><!-- else if condition -->
                            <jsp:include page="vipinfo.jsp"/>
                        </c:when>
                        <c:otherwise><!-- else condition -->
                            <div class="text-center text-info" style="padding: 60px">
                                <h3>No elements to show!</h3>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>