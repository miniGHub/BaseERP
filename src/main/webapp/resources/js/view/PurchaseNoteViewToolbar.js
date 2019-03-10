Ext.define('AppIndex.view.PurchaseNoteViewToolbar',{
    extend: 'Ext.toolbar.Toolbar',
    xtype:'app_purchase_note_view_toolbar',

    items:[
        {
            text:'加载',
            iconCls:'icon_load',
            handler: 'PurchaseNoteLoad'
        },
        {
            text:'提交',
            iconCls: 'icon_add',
            handler: 'PurchaseNoteSubmit'
        },
        {
            text:'打印',
            iconCls:'icon_printer',
            handler: 'PurchaseNotePrint'
        }
    ]
});