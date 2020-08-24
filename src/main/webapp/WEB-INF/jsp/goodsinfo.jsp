<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th>#</th>
        <th>商品编号</th>
        <th>商品名</th>
        <th>类别</th>
        <th>售价</th>
        <th>进价</th>
        <th>库存</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${goodsList}" var="v">
        <tr class="table-danger">
            <td>${v["id"]}</td>
            <td>${v["no"]}</td>
            <td>${v["name"]}</td>
            <td>${v["category"]}</td>
            <td>${v["price"]}</td>
            <td>${v["purchasePrice"]}</td>
            <td>${v["inventory"]}</td>
            <td>
                <button type="button" class="btn btn-sm btn-primary" data-toggle="modal"
                        data-target="#update${v["id"]}">修改
                </button>
            </td>
            <td>
                <form action="GoodsController" method="post">
                    <input type="hidden" name="id" value="${v["id"]}">
                    <button type="submit" class="btn btn-sm btn-danger" name="action"
                            value="delete">删除
                    </button>
                </form>
            </td>
            <div id="update${v["id"]}" class="modal fade" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-title">
                            <h1 class="text-center">修改商品记录</h1>
                        </div>
                        <div class="modal-body">
                            <form class="form-group" action="GoodsController"
                                  method="post">
                                <input type="hidden" name="id" value="${v["id"]}">
                                <div class="form-group">
                                    <label>商品编号</label>
                                    <input class="form-control" type="text"
                                           placeholder="商品编号" name="no"
                                           value="${v["no"]}">
                                </div>
                                <div class="form-group">
                                    <label>商品名</label>
                                    <input class="form-control" type="text"
                                           placeholder="商品名" name="name"
                                           value="${v["name"]}">
                                </div>
                                <div class="form-group">
                                    <label>类别</label>
                                    <input class="form-control" type="text"
                                           placeholder="类别" name="category"
                                           value="${v["category"]}">
                                </div>
                                <div class="form-group">
                                    <label>售价</label>
                                    <input class="form-control" type="text"
                                           placeholder="售价" name="price"
                                           value="${v["price"]}">
                                </div>
                                <div class="form-group">
                                    <label>进价</label>
                                    <input class="form-control" type="text"
                                           placeholder="进价" name="pprice"
                                           value="${v["purchasePrice"]}">
                                </div>
                                <div class="form-group">
                                    <label>库存</label>
                                    <input class="form-control" type="text"
                                           placeholder="库存" name="inventory"
                                           value="${v["inventory"]}">
                                </div>
                                <div class="text-left">
                                    <button class="btn btn-warning" type="reset">重置
                                    </button>
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-primary" type="submit"
                                            name="action" value="update">提交
                                    </button>
                                    <button class="btn btn-danger" data-dismiss="modal">
                                        取消
                                    </button>
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
