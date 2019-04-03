Ext.define('AppIndex.view.base.PasswordChangeView',{
    extend:'Ext.panel.Panel',
    xtype:'app_password_change_view',
    itemId: 'app_password_change_view_item_id',                        // for tab panel
    controller:'password_change_view',
    requires:[
        'AppIndex.controller.base.PasswordChangeController',
        'AppIndex.view.base.PasswordChangeViewForm'
    ],

    title: '修改密码',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    closable:true,

    layout: {
        type:'border'
    },

    items:[
        {
            region:'center',
            xtype:'app_password_change_view_form'
        }
    ]
});