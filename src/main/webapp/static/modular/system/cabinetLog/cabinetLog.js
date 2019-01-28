/**
 * 管理初始化
 */
var CabinetLog = {
    id: "CabinetLogTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
CabinetLog.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '智能工具柜编号', field: 'cabinetCode', visible: true, align: 'center', valign: 'middle'},
            {title: '柜门编码', field: 'doorCode', visible: true, align: 'center', valign: 'middle'},
            {title: '小柜子编号', field: 'boxCode', visible: true, align: 'center', valign: 'middle'},
            {title: '借  还', field: 'operate', visible: true, align: 'center', valign: 'middle'},
            {title: '操作时间', field: 'operateTime', visible: true, align: 'center', valign: 'middle'},
            {title: '预留字段', field: 'extRemark', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
CabinetLog.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        CabinetLog.seItem = selected[0];
        return true;
    }
};

CabinetLog.selectInit = function () {
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
/**
 * 查询表单提交参数对象
 * @returns {{}}
 */
CabinetLog.formParams = function() {
    var queryData = {};
    queryData['cabinetCode'] = $("#cabinetCode").val();
    return queryData;
}
/**
 * 查询列表
 */
CabinetLog.search = function () {
    CabinetLog.table.refresh({query: CabinetLog.formParams()});
};

$(function () {
	CabinetLog.selectInit();
    var defaultColunms = CabinetLog.initColumn();
    var table = new BSTable(CabinetLog.id, "/cabinetLog/list", defaultColunms);
    table.setPaginationType("client");
    CabinetLog.table = table.init();
});
