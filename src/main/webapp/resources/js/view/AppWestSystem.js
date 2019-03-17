Ext.define("AppIndex.view.AppWestSystem",{
    extend:'Ext.tree.Panel',
    xtype:'app_west_system',

    requires:[
        'AppIndex.view.RoleManagerView',
        'AppIndex.view.DepartManagerView',
        'AppIndex.view.UserManagerView',
        'AppIndex.view.ProductDicView',
        'AppIndex.view.RepositoryDicView'
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
                        {text:"部门管理", id: "app_depart_manager_view", leaf: true},
                        {text:"用户管理", id: "app_user_manager_view", leaf: true}
                    ]
                },
                {
                    text: "密码管理",
                    children:[
                        {text:"修改密码", id: "app_change_password_view", leaf: true}
                    ]
                },
                {
                    text: "字典管理",
                    children:[
                        {text:"商品字典", id: "app_product_dic_view", leaf: true},
                        {text:"仓库字典", id: "app_repository_dic_view", leaf: true}
                    ]
                }
            ]
        }
        })
});