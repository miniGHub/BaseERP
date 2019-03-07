Ext.define('AppIndex.view.SalesOrderNoteViewToolbar',{
    extend: 'Ext.toolbar.Toolbar',
    xtype:'app_sales_order_note_view_toolbar',

    items:[
        {
            text:'提交',
            iconCls: 'icon_add',
            handler: 'SalesOrderNoteSubmit'
        },
        {
            text:'修改',
            iconCls:'icon_edit',
            handler: 'SalesOrderNoteModify'
        },
        {
            text:'打印',
            iconCls:'icon_printer',
            handler: 'SalesOrderNotePrint'
        }
    ]
});