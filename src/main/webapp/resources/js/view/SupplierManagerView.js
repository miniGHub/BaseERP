Ext.define('AppIndex.view.SupplierManagerView',{
    extend:'Ext.panel.Panel',
    xtype:'app_supplier_manager_view',
    itemId: 'app_supplier_manager_view_item_id',
    controller:'supplier_manager_view',

    requires:[
        'AppIndex.controller.SupplierManagerController',
        'AppIndex.view.SupplierManagerViewGrid',
    ],

    title: '供应商管理',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    closable:true,

    layout: {
        type:'border'
    },

    items:[
        {
            region:'center',
            xtype:'app_supplier_manager_view_grid'
        }
    ]
});