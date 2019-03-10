Ext.define('AppIndex.view.StorageInViewToolbar',{
    extend: 'Ext.toolbar.Toolbar',
    xtype:'app_storage_in_view_toolbar',

    items:[
        {
            text:'加载',
            iconCls:'icon_load',
            handler: 'StorageInLoad'
        },
        {
            text:'入库',
            iconCls:'icon_add',
            handler: 'StorageInSubmit'
        },
        {
            text:'打印',
            iconCls:'icon_printer',
            handler: 'StorageInPrint'
        }
    ]
});