Ext.define('AppIndex.view.PurchaseNoteView',{
    extend:'Ext.panel.Panel',
    xtype:'app_purchase_note_view',
    controller:'purchase_note_view',
    requires:['AppIndex.controller.PurchaseNoteController',
        'AppIndex.view.PurchaseNoteViewToolbar',
        'AppIndex.view.PurchaseNoteViewForm',
        'AppIndex.view.PurchaseNoteViewGrid'
    ],

    title: '进货单',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    layout: {
        type:'border'
    },

    items:[
        {
            region:'north',
            xtype:'app_purchase_note_view_toolbar'
        },
        {
            region:'north',
            xtype:'app_purchase_note_view_form'
        },
        {
            region:'center',
            xtype:'app_purchase_note_view_grid'
        }
    ]
});