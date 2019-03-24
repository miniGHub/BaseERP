Ext.define('AppIndex.view.ProductInfoManagerView',{
    extend:'Ext.panel.Panel',
    xtype:'app_product_info_manager_view',
    itemId: 'app_product_info_manager_view_item_id',
    controller:'product_info_manager_view',

    requires:[
        'AppIndex.controller.ProductInfoManagerController',
        'AppIndex.view.ProductInfoManagerViewGrid'
    ],

    title: '商品信息管理',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    closable:true,

    layout: {
        type:'border'
    },

    items:[
        {
            region:'center',
            xtype:'app_product_info_manager_view_grid'
        }
    ]
});