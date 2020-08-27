<%@ page contentType="text/html;charset=UTF-8" %>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-title">
            <h1 class="text-center">添加商品记录</h1>
        </div>
        <div class="modal-body">
            <form class="form-group" action="GoodsController" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group">
                    <label>商品编号</label>
                    <input class="form-control" type="text" placeholder="商品编号" name="no">
                </div>
                <div class="form-group">
                    <label>商品名</label>
                    <input class="form-control" type="text" placeholder="商品名" name="name">
                </div>
                <div class="form-group">
                    <label>类别</label>
                    <input class="form-control" type="text" placeholder="类别" name="category">
                </div>
                <div class="form-group">
                    <label>售价</label>
                    <input class="form-control" type="text" placeholder="售价" name="price">
                </div>
                <div class="form-group">
                    <label>进价</label>
                    <input class="form-control" type="text" placeholder="进价" name="purchasePrice">
                </div>
                <div class="form-group">
                    <label>库存</label>
                    <input class="form-control" type="text" placeholder="库存" name="inventory">
                </div>
                <div class="text-left">
                    <button class="btn btn-warning" type="reset">重置</button>
                </div>
                <div class="text-right">
                    <button class="btn btn-primary" type="submit" name="action" value="insert">
                        提交
                    </button>
                    <button class="btn btn-danger" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div>
    </div>
</div>
