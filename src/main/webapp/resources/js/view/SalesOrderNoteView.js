Ext.define('AppIndex.view.SalesOrderNoteView',{
    extend:'Ext.panel.Panel',
    xtype:'app_sales_order_note_view',
    controller:'sales_order_note_view',
    requires:['AppIndex.controller.SalesOrderNoteController',
        'AppIndex.view.SalesOrderNoteViewToolbar',
        'AppIndex.view.SalesOrderNoteViewForm',
        'AppIndex.view.SalesOrderNoteViewGrid'
    ],

    title: '销售订单',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    layout: {
        type:'border'
    },

    items:[
        {
            region:'north',
            xtype:'app_sales_order_note_view_toolbar'
        },
        {
            region:'north',
            xtype:'app_sales_order_note_view_form'
        },
        {
            region:'center',
            xtype:'app_sales_order_note_view_grid'
        }
    ]
});