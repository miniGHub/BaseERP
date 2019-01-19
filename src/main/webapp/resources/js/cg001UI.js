Ext.onReady(function(){
    var mycolumns=[];
    mycolumns.push(Ext.create('Ext.grid.RowNumberer'));// 添加行号列，不需要导入外部插件
    mycolumns.push( {
        header : '采购单号',
        dataIndex : "purchase_note_id",
        flex : 2
    });
    mycolumns.push( {
        header : '销售订单',
        dataIndex : "sales_order_note_id",
        flex : 2
    });
    mycolumns.push( {
        header : '供应商',
        dataIndex : "supplier_id",
        flex : 2
    });
    mycolumns.push({
        header : "仓库",
        dataIndex : "repository_id",
        flex : 2
    });
    mycolumns.push({
        header : "创建日期",
        dataIndex : "entry_date",
        flex : 2
    });
    mycolumns.push({
        header : "操作员",
        dataIndex : "operator_id",
        flex : 2
    });

    var store = Ext.create('Ext.data.Store', {
        fields : ["purchase_note_id", "sales_order_note_id", "supplier_id", "repository_id", "entry_date", "operator_id"],
        autoLoad : true,
        proxy : {
            type : 'ajax',
            url : '../../cg001/showCG001.do',
            headers : {"Accept": 'application/json', 'Content-Type':'application/json'},
            reader : {
                type : 'json'
            },
            extraParams : {
                "purchase_note_id" : "LC-20181230-0002"
            },
            actionMethods: {
                create : 'POST',
                read   : 'POST', // by default GET
                update : 'POST',
                destroy: 'POST'
            },
            paramsAsJson : true,
            noCache:false
        }
    });

    var grid=Ext.create('Ext.grid.Panel',{
//        layout:'anchor',
        disableSelection: true,
        title:'采购单',
        columns:mycolumns,
        renderTo:Ext.get('maininfor'),
        store:store,
        width:Ext.getBody().getWidth(),
        height:Ext.getBody().getHeight()
    });
});