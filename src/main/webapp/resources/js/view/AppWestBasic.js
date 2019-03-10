Ext.define("AppIndex.view.AppWestBasic",{
    extend:'Ext.tree.Panel',
    xtype:'app_west_basic',

    requires:[
        'AppIndex.view.ProductInfoView',
        'AppIndex.view.RepositoryInfoView'
    ],

    title:'基本信息',
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
        id:'AppWestBasicStore',
        animate:true,
        root: {
            expanded: true,
            id:'app_west_basic_root',
            children: [
                {
                    text: "数据维护",
                    children:[
                        {text:"商品信息", id: "app_product_info_view", leaf: true},
                        {text:"仓库信息", id: "app_repository_info_view", leaf: true}
                    ]
                }
            ]
        }
        })
});