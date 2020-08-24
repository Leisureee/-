<%@ page contentType="text/html;charset=UTF-8" %>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-title">
            <h1 class="text-center">添加员工记录</h1>
        </div>
        <div class="modal-body">
            <form class="form-group" action="EmployeeController" method="post">
                <div class="form-group">
                    <label>员工编号</label>
                    <input class="form-control" type="text" placeholder="员工编号"
                           name="no">
                </div>
                <div class="form-group">
                    <label>员工名</label>
                    <input class="form-control" type="text" placeholder="员工名"
                           name="name">
                </div>
                <div class="form-group">
                    <label>类别</label>
                    <input class="form-control" type="text" placeholder="类别"
                           name="category">
                </div>
                <div class="form-group">
                    <label>年龄</label>
                    <input class="form-control" type="text" placeholder="年龄"
                           name="age">
                </div>
                <div class="form-group">
                    <label>联系电话</label>
                    <input class="form-control" type="text" placeholder="联系电话"
                           name="tel">
                </div>
                <div class="form-group">
                    <label>月工资</label>
                    <input class="form-control" type="text" placeholder="月工资"
                           name="wage">
                </div>
                <div class="form-group">
                    <label>性别</label><br>
                    <input type="radio" name="sex" value="男">男
                    <input type="radio" name="sex" value="女">女
                </div>
                <div class="text-left">
                    <button class="btn btn-warning" type="reset">重置</button>
                </div>
                <div class="text-right">
                    <button class="btn btn-primary" type="submit" name="action"
                            value="insert">提交
                    </button>
                    <button class="btn btn-danger" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
    </div>
</div>
