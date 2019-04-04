Ext.define('AppIndex.view.SalesOrderNoteViewForm',{
    extend: 'Ext.form.Panel',
    xtype:'app_sales_order_note_view_form',

    border:false,
   // layout: 'anchor',

    tbar:[
        {
            text:'提交',
            iconCls: 'icon_accept',
            handler: 'SalesOrderNoteSubmit',
            // formBind: true
        },'-',
        {
            text:'打印',
            iconCls:'icon_printer',
            handler: 'SalesOrderNotePrint'
        }
    ],

    defaults:{
        style:'float:left;padding-top:5px;',
        anchor:'17%',
    },
    fieldDefaults:{
        labelAlign:'right',
        labelWidth:70
    },

    items:[
        {
            xtype: 'combo',
            fieldLabel: '单据编号',
            name: 'sales_order_note_id',
            editable: false
        },
        {
            xtype: 'combo',
            fieldLabel: '购买单位',
            name: 'client_id'
        },
        {
            xtype: 'combo',
            fieldLabel: '发货仓库',
            name: 'repository_id'
        },
        {
            xtype: 'datefield',
            fieldLabel: '录单日期',
            name: 'entry_date',
            format: 'Y-m-d',
            allowBlank: false
        },
        {
            xtype: 'datefield',
            fieldLabel: '交货日期',
            name: 'delivery_date',
            format: 'Y-m-d'
        },
        {
            xtype:'textfield',
            fieldLabel: '摘要',
            name: 'remark'
        },
        {
            xtype:'textfield',
            fieldLabel: '附加说明',
            name: 'addition'
        }
    ]
});