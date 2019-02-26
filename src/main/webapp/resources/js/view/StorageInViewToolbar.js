Ext.define('AppIndex.view.StorageInViewToolbar',{
    extend: 'Ext.toolbar.Toolbar',
    xtype:'app_storage_in_view_toolbar',

    items:[
        {
            text:'加载',
            //iconCls:'x-fa fa-plus',
            handler: 'StorageInLoad'
        },
        {
            text:'入库',
            //iconCls:'x-fa fa-plus',
            handler: 'StorageInSubmit'
        },
        {
            text:'打印',
            //iconCls:'x-fa fa-plus',
            handler: 'StorageInPrint'
        }
    ]
});