/**
 * 日志管理初始化
 */
var Cabinet = {
    id: "CabinetTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Cabinet.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '智能工具柜编码', field: 'cabinetCode', align: 'center', valign: 'middle', sortable: true},
        {title: '柜门编码', field: 'doorCode', align: 'center', valign: 'middle', sortable: true},
        {title: '柜门状态', field: 'locker', align: 'center', valign: 'middle', sortable: true},
        {title: '工具箱编码', field: 'boxCode', align: 'center', valign: 'middle'},
        {title: '工具状态', field: 'status', align: 'center', valign: 'middle', sortable: true},
        {title: '创建时间', field: 'createTime', align: 'center', valign: 'middle', sortable: true},
        {title: '更新时间', field: 'version', align: 'center', valign: 'middle', sortable: true}];
};

/**
 * 检查是否选中
 */
Cabinet.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
    	Cabinet.seItem = selected[0];
        return true;
    }
};


/**
 * 查询表单提交参数对象
 * @returns {{}}
 */
Cabinet.formParams = function() {
    var queryData = {};
    queryData['cabinetCode'] = $("#cabinetCode").val();
    return queryData;
}

/**
 * 查询列表
 */
Cabinet.search = function () {

	Cabinet.table.refresh({query: Cabinet.formParams()});
};

Cabinet.selectInit = function () {
	//提交信息
    var ajax = new $ax(Feng.ctxPath + "/cabinet/cabinetCodeList", function (data) {
    	 $.each(data,function(i,result){
    		 var cabinetCode =result.cabinetCode;
    		 $("#cabinetCode").append('<option value="'+cabinetCode+'">'+cabinetCode+'</option>')
    		 }); 
    }, function (data) {
    });
    ajax.start();
}

$(function () {
	Cabinet.selectInit();
    var defaultColunms = Cabinet.initColumn();
    var table = new BSTable(Cabinet.id, "/cabinet/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(Cabinet.formParams());
    Cabinet.table = table.init();
});
