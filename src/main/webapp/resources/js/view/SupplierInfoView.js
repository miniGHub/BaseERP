Ext.define('AppIndex.view.SupplierInfoView',{
    extend:'Ext.panel.Panel',
    xtype:'app_supplier_info_view',
    itemId: 'app_supplier_info_view_item_id',
    controller:'supplier_info_view',

    requires:[
        'AppIndex.controller.SupplierInfoController',
        'AppIndex.view.SupplierInfoViewGrid',
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
            xtype:'app_supplier_info_view_grid'
        }
    ]
});