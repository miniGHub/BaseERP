Ext.define('AppIndex.view.dic.RoleDicView',{
    extend:'Ext.panel.Panel',
    xtype:'app_role_dic_view',
    itemId: 'app_role_dic_view_item_id',
    controller:'role_dic_view',

    requires:[
        'AppIndex.controller.dic.RoleDicController',
        'AppIndex.view.dic.RoleDicViewGrid',
    ],

    title: '角色管理',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    closable:true,

    layout: {
        type:'border'
    },

    items:[
        {
            region:'center',
            xtype:'app_role_dic_view_grid'
        }
    ]
});