<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th>#</th>
        <th>会员编号</th>
        <th>会员名</th>
        <th>卡内余额</th>
        <th>卡密码</th>
        <th>注册时间</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${vipList}" var="v">
        <tr class="table-danger">
            <td>${v["id"]}</td>
            <td>${v["no"]}</td>
            <td>${v["name"]}</td>
            <td>${v["balance"]}</td>
            <td>${v["password"]}</td>
            <td>${v["registerDate"]}</td>
            <td>
                <button type="button" class="btn btn-sm btn-primary" data-toggle="modal"
                        data-target="#update${v["id"]}">修改
                </button>
            </td>
            <td>
                <form action="VipController" method="get">
                    <input type="hidden" name="id" value="${v["id"]}">
                    <button type="submit" class="btn btn-sm btn-danger" name="action" value="delete">删除</button>
                </form>
            </td>
            <div id="update${v["id"]}" class="modal fade" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-title">
                            <h1 class="text-center">修改会员信息</h1>
                        </div>
                        <div class="modal-body">
                            <form class="form-group" action="VipController" method="get">
                                <input type="hidden" name="id" value="${v["id"]}">
                                <div class="form-group">
                                    <label>会员编号</label>
                                    <input class="form-control" type="text" placeholder="会员编号" name="no"
                                           value="${v["no"]}">
                                </div>
                                <div class="form-group">
                                    <label>会员名</label>
                                    <input class="form-control" type="text" placeholder="会员名" name="name"
                                           value="${v["name"]}">
                                </div>
                                <div class="form-group">
                                    <label>卡内余额</label>
                                    <input class="form-control" type="text" placeholder="卡内余额" name="balance"
                                           value="${v["balance"]}">
                                </div>
                                <div class="form-group">
                                    <label>卡密码</label>
                                    <input class="form-control" type="text" placeholder="卡密码" name="password"
                                           value="${v["password"]}">
                                </div>
                                <div class="form-group">
                                    <label>注册时间</label>
                                    <input class="form-control" type="date" placeholder="注册时间" name="registerDate"
                                           value="${v["registerDate"]}">
                                </div>
                                <div class="text-left">
                                    <button class="btn btn-warning" type="reset">重置</button>
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-primary" type="submit" name="action" value="update">提交
                                    </button>
                                    <button class="btn btn-danger" data-dismiss="modal">取消</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </tr>
    </c:forEach>
    </tbody>
</table>