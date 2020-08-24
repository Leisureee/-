<%@ page contentType="text/html;charset=UTF-8" %>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-title">
            <h1 class="text-center">添加会员记录</h1>
        </div>
        <div class="modal-body">
            <form class="form-group" action="VipController" method="post">
                <div class="form-group">
                    <label>会员编号</label>
                    <input class="form-control" type="text" placeholder="会员编号"
                           name="no">
                </div>
                <div class="form-group">
                    <label>会员名</label>
                    <input class="form-control" type="text" placeholder="会员名"
                           name="name">
                </div>
                <div class="form-group">
                    <label>卡内余额</label>
                    <input class="form-control" type="text" placeholder="卡内余额"
                           name="balance">
                </div>
                <div class="form-group">
                    <label>卡密码</label>
                    <input class="form-control" type="text" placeholder="卡密码"
                           name="password">
                </div>
                <div class="form-group">
                    <label>注册时间</label>
                    <input class="form-control" type="date" name="registerDate">
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
