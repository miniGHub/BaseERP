Ext.define('AppIndex.view.ProductDicView',{
    extend:'Ext.panel.Panel',
    xtype:'app_product_dic_view',
    itemId:'app_product_dic_view_item_id',
    controller:'product_dic_view',

    requires:[
        'AppIndex.controller.ProductDicController',
        'AppIndex.view.ProductDicViewGrid'
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
            xtype:'app_product_dic_view_grid'
        }
    ]
});