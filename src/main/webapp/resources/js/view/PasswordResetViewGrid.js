Ext.define('AppIndex.view.PasswordResetViewGrid',{
    extend: 'Ext.grid.Panel',
    xtype:'app_password_reset_view_grid',

    requires: [
        'AppIndex.store.GetAllUserPasswordStorePage'
    ],

    store:{
        type:'get_all_user_password_store_page'
    },
    selModel: {
        selType: 'checkboxmodel'
    },
    stripeRows:true, //斑马线效果
    tbar:[
        {
            text:'重置密码',
            iconCls: 'icon_accept',
            handler: 'onClickReset'
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
            text: '密码状态',
            dataIndex: 'password_state',
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

        var grid = this.getView().up('app_password_reset_view_grid');

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