Ext.define('AppIndex.view.base.UserManagerViewGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'app_user_manager_view_grid',

    requires: [
        'AppIndex.store.base.GetAllUserInfoStorePage'
    ],

    store:{
        type:'get_all_user_info_store_page'
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
            text: '用户名',
            dataIndex: 'id',
            editor: 'textfield',
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '姓名',
            dataIndex: 'name',
            editor: 'textfield',
            width: 200,
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '角色',
            dataIndex: 'role_name',
            editor: 'textfield',
            width: 200,
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '部门',
            dataIndex: 'depart_name',
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
        },
        /*
        {
            text: '角色ID',
            dataIndex: 'role_id',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '部门ID',
            dataIndex: 'depart_id',
            menuDisabled: true,
            sortable:false
        }
        */
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

        var grid = this.getView().up('app_user_manager_view_grid');

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