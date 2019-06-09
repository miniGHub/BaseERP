Ext.define('AppIndex.view.xs.SalesOrderNoteViewToolbar',{
    extend: 'Ext.toolbar.Toolbar',
    xtype:'app_sales_order_note_view_toolbar',

    items:[
        {
            text:'  打印',
            iconCls:'icon_printer',
            handler: 'onClickPrint'
        },'-',
        {
            text:'新增',
            iconCls: 'icon_add',
            handler: 'onClickAddDetail'
        },'-',
        {
            text:'修改',
            iconCls:'icon_edit',
            handler: 'onClickEditDetail'
        },'-',
        {
            text:'删除',
            iconCls: 'icon_delete',
            handler: 'onClickDeleteDetail'
        },'->',
        {
            text:'提交',
            iconCls: 'icon_add',
            handler: 'onClickSubmit'
        }
    ]
});