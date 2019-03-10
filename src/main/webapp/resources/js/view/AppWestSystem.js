Ext.define("AppIndex.view.AppWestSystem",{
    extend:'Ext.tree.Panel',
    xtype:'app_west_system',

    requires:[
        'AppIndex.view.RoleManagerView',
        'AppIndex.view.DepartManagerView'
    ],

    title:'系统管理',
    rootVisible:false,
    userArrows:true,
    // hideHeaders:true,
    width:250,
    minWidth:100,
    split:true,
    collapsible:true,
    autoScroll: true,
    animate: true,
    frame: true,

    store:
        Ext.create('Ext.data.TreeStore', {
        id:'AppWestSystemStore',
        animate:true,
        root: {
            expanded: true,
            id:'app_west_system_root',
            children: [
                {
                    text: "系统权限",
                    children:[
                        {text:"角色管理", id: "app_role_manager_view", leaf: true},
                        {text:"部门管理", id: "app_depart_manager_view", leaf: true}
                    ]
                }
            ]
        }
        })
});