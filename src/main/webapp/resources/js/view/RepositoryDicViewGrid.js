Ext.define('AppIndex.view.RepositoryDicViewGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'app_repository_dic_view_grid',

    requires: [
        'AppIndex.store.GetAllRepositoryDicStore'
    ],

    store:{
        type:'get_all_repository_dic_store'
    },
    selModel: {
        selType: 'cellmodel'
    },
    stripeRows:true, //斑马线效果
    tbar:[{
        text:'新增',
        iconCls: 'icon_add',
        handler: 'onClickAdd'
    },'-',{
        text:'删除',
        iconCls: 'icon_delete',
        handler: 'onClickDelete'
    },'-',{
        text:'保存',
        iconCls: 'icon_save',
        handler: 'onClickSave'
    },'-',{
        text:'刷新',
        iconCls: 'icon_refresh',
        handler: 'onClickRefresh'
    }
    ],
    plugins:[
        Ext.create('Ext.grid.plugin.CellEditing',{
            id:'depart_cell_editing',
            clicksToEdit:1,
            destroy: function() {
                console.log('repository destroy');
                this.fireEvent('beforedestroy', this);
            }
        })
    ],
    columns: [
        {
            text: '仓库类别',
            dataIndex: 'repository_type',
            editor: 'textfield',
            align: 'center',
            menuDisabled: true,
            sortable:false
        },
        {
            text: '仓库分类名称',
            dataIndex: 'repository_name',
            editor: 'textfield',
            width: 400,
            align: 'center',
            menuDisabled: true,
            sortable:false
        }
    ],
    onRender: function () {
        console.log("onRender repository info");
        this.callParent(arguments);

        // hide product_type
        var columns = this.getView().up('app_repository_dic_view_grid').getColumns();
        columns[0].hidden = true;
        columns[0].hide();
    }
});