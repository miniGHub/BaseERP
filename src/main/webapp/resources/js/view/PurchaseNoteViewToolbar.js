Ext.define('AppIndex.view.PurchaseNoteViewToolbar',{
    extend: 'Ext.toolbar.Toolbar',
    xtype:'app_purchase_note_view_toolbar',

    items:[
        {
            text:'加载',
            //iconCls:'x-fa fa-plus',
            handler: 'PurchaseNoteLoad'
        },
        {
            text:'提交',
            //iconCls:'x-fa fa-plus',
            handler: 'PurchaseNoteSubmit'
        },
        {
            text:'修改',
            //iconCls:'x-fa fa-plus',
            handler: 'PurchaseNoteModify'
        },
        {
            text:'打印',
            //iconCls:'x-fa fa-plus',
            handler: 'PurchaseNotePrint'
        }
    ]
});