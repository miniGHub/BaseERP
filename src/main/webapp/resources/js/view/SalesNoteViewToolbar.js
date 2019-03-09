Ext.define('AppIndex.view.SalesNoteViewToolbar',{
    extend: 'Ext.toolbar.Toolbar',
    xtype:'app_sales_note_view_toolbar',

    items:[
        {
            text:'加载',
            iconCls: 'icon_load',
            handler: 'SalesNoteLoad'
        },
        {
            text:'提交',
            iconCls: 'icon_add',
            handler: 'SalesNoteSubmit'
        },
        {
            text:'修改',
            iconCls:'icon_edit',
            handler: 'SalesNoteModify'
        },
        {
            text:'  打印',
            iconCls:'icon_printer',
            handler: 'SalesNotePrint'
        }
    ]
});