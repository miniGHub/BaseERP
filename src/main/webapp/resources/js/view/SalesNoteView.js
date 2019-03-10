Ext.define('AppIndex.view.SalesNoteView',{
    extend:'Ext.panel.Panel',
    xtype:'app_sales_note_view',
    controller:'sales_note_view',
    requires:[
        'AppIndex.controller.SalesNoteController',
        'AppIndex.view.SalesNoteViewToolbar',
        'AppIndex.view.SalesNoteViewForm',
        'AppIndex.view.SalesNoteViewGrid'
    ],

    title: '销售单',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    layout: {
        type:'border'
    },

    items:[
        {
            region:'north',
            xtype:'app_sales_note_view_toolbar'
        },
        {
            region:'north',
            xtype:'app_sales_note_view_form'
        },
        {
            region:'center',
            xtype:'app_sales_note_view_grid'
        }
    ]
});