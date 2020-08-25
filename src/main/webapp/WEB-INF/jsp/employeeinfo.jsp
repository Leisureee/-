<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th>#</th>
        <th>员工编号</th>
        <th>员工名</th>
        <th>类别</th>
        <th>年龄</th>
        <th>性别</th>
        <th>联系电话</th>
        <th>月工资</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeeList}" var="v">
        <tr class="table-danger">
            <td>${v["id"]}</td>
            <td>${v["no"]}</td>
            <td>${v["name"]}</td>
            <td>${v["category"]}</td>
            <td>${v["age"]}</td>
            <td>${v["sex"]}</td>
            <td>${v["tel"]}</td>
            <td>${v["wage"]}</td>
            <td>
                <button type="button" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#update${v["id"]}">
                    修改
                </button>
            </td>
            <td>
                <form action="EmployeeController" method="post">
                    <input type="hidden" name="id" value="${v["id"]}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-sm btn-danger" name="action" value="delete">
                        删除
                    </button>
                </form>
            </td>
            <div id="update${v["id"]}" class="modal fade" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-title">
                            <h1 class="text-center">修改员工信息</h1>
                        </div>
                        <div class="modal-body">
                            <form class="form-group" action="EmployeeController" method="post">
                                <input type="hidden" name="id" value="${v["id"]}">
                                <div class="form-group">
                                    <label>员工编号</label>
                                    <input class="form-control" type="text" placeholder="员工编号" name="no" value="${v["no"]}">
                                </div>
                                <div class="form-group">
                                    <label>员工名</label>
                                    <input class="form-control" type="text" placeholder="员工名" name="name" value="${v["name"]}">
                                </div>
                                <div class="form-group">
                                    <label>类别</label>
                                    <input class="form-control" type="text" placeholder="类别" name="category" value="${v["category"]}">
                                </div>
                                <div class="form-group">
                                    <label>年龄</label>
                                    <input class="form-control" type="text" placeholder="年龄" name="age" value="${v["age"]}">
                                </div>
                                <div class="form-group">
                                    <label>电话</label>
                                    <input class="form-control" type="text" placeholder="电话" name="tel" value="${v["tel"]}">
                                </div>
                                <div class="form-group">
                                    <label>月工资</label>
                                    <input class="form-control" type="text" placeholder="月工资" name="wage" value="${v["wage"]}">
                                </div>
                                <div class="form-group">
                                    <label>性别</label><br>
                                    <input type="radio" name="sex" value="男" ${v["sex"]=="男"?"checked":""}>男
                                    <input type="radio" name="sex" value="女" ${v["sex"]=="女"?"checked":""}>女
                                </div>
                                <div class="text-left">
                                    <button class="btn btn-warning" type="reset">重置
                                    </button>
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-primary" type="submit" name="action" value="update">
                                        提交
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