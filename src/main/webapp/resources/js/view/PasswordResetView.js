Ext.define('AppIndex.view.PasswordResetView',{
    extend:'Ext.panel.Panel',
    xtype:'app_password_reset_view',
    itemId: 'app_password_reset_view_item_id',                        // for tab panel
    controller:'password_reset_view',
    requires:[
        'AppIndex.controller.PasswordResetController',
        'AppIndex.view.PasswordResetViewGrid'
    ],

    title: '重置密码',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    closable:true,

    layout: {
        type:'border'
    },

    items:[
        {
            region:'center',
            xtype:'app_password_reset_view_grid'
        }
    ]
});