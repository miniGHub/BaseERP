Ext.define('AppIndex.view.RepositoryInfoViewGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'app_repository_info_view_grid',

    requires: [
        'AppIndex.store.GetAllRepositoryInfoPageStore'
    ],

    store:{
        type:'get_all_repository_info_page_store'
    },
    selModel: {
        selType: 'checkboxmodel'
    },
    stripeRows:true, //斑马线效果
    tbar:[
        {
            text:'新增',
            iconCls: 'icon_add',
            handler: 'onClickAdd'
        },'-',{
            text:'编辑',
            iconCls: 'icon_edit',
            handler: 'onClickEdit'
        },'-',{
            text:'删除',
            iconCls: 'icon_delete',
            handler: 'onClickDelete'
        },'-',{
            text:'刷新',
            iconCls: 'icon_refresh',
            handler: 'onClickRefresh'
        }
    ],
    columns: [
        {
            text: '仓库编号',
            dataIndex: 'repository_id',
            editor: 'textfield',
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '仓库分类',
            dataIndex: 'repository_type_name',
            editor: 'textfield',
            width: 200,
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '仓库名称',
            dataIndex: 'repository_name',
            editor: 'textfield',
            width: 200,
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '仓库地址',
            dataIndex: 'address',
            editor: 'textfield',
            width: 200,
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '负责人',
            dataIndex: 'manager',
            editor: 'textfield',
            width: 200,
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '联系电话',
            dataIndex: 'phone',
            editor: 'textfield',
            width: 200,
            align: 'center',
            menuDisabled: true,
            sortable:false
        }

    ],
    dockedItems:[
        {
            xtype:'pagingtoolbar',
            dock: 'bottom',
            store: this.store,
            display:true
        }
    ],
    onRender: function () {
        console.log("onRender ");
        this.callParent(arguments);

        var grid = this.getView().up('app_repository_info_view_grid');

        // hide refresh button
        var length = grid.dockedItems.keys.length;
        var refreshStr= "";
        for (var i = 0; i < length; i++) {
            if (grid.dockedItems.keys[i].indexOf("pagingtoolbar") !== -1) {
                refreshStr= grid.dockedItems.keys[i];
            }
        }
        grid.dockedItems.get(refreshStr).child('#refresh').hide(true);
    }
});