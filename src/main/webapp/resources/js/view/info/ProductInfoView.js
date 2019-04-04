Ext.define('AppIndex.view.info.ProductInfoView',{
    extend:'Ext.panel.Panel',
    xtype:'app_product_info_view',
    itemId: 'app_product_info_view_item_id',
    controller:'product_info_view',

    requires:[
        'AppIndex.controller.info.ProductInfoController',
        'AppIndex.view.info.ProductInfoViewGrid'
    ],

    title: '商品信息',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    closable:true,

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