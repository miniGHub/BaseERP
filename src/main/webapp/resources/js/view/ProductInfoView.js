Ext.define('AppIndex.view.ProductInfoView',{
    extend:'Ext.panel.Panel',
    xtype:'app_product_info_view',
    controller:'product_info_view',

    requires:[
        'AppIndex.controller.ProductInfoController',
        'AppIndex.view.ProductInfoViewGrid'
    ],

    title: '商品信息',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    layout: {
        type:'border'
    },

    items:[
        {
            region:'center',
            xtype:'app_product_info_view_grid'
        }
    ]
});