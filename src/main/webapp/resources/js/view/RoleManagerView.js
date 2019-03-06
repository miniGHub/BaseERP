Ext.define('AppIndex.view.RoleManagerView',{
    extend:'Ext.panel.Panel',
    xtype:'app_role_manager_view',
    controller:'role_manager_view',

    requires:[
        'AppIndex.controller.RoleManagerController',
        'AppIndex.view.RoleManagerViewGrid',
    ],

    title: '角色管理',
    width: window.innerWidth - 300,
    height: window.innerHeight,
    layout: {
        type:'border'
    },

    items:[
        {
            region:'center',
            xtype:'app_role_manager_view_grid'
        }
    ]
});