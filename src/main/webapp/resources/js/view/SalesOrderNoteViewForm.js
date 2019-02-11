Ext.define('AppIndex.view.SalesOrderNoteViewForm',{
    extend: 'Ext.form.Panel',
    xtype:'app_sales_order_note_view_form',

    border:false,
    layout: 'anchor',
    reference: 'form', //指定组件层级
    defaults:{
        xtype:'textfield',
        style:'float:left;padding-top:5px;',
        anchor:'16%'
    },
    fieldDefaults:{
        labelAlign:'right',
        labelWidth:70
    },

    items:[
        {
            fieldLabel: '录单日期',
            name: 'entry_date',
            xtype: 'datefield',
            format: 'Y-m-d',
            allowBlank: false
        },
        {
            fieldLabel: '单据编号',
            name: 'sales_order_note_id',
            allowBlank: false
        },
        {
            fieldLabel: '购买单位',
            name: 'client_id'
        },
        {
            fieldLabel: '发货仓库',
            name: 'repository_id'
        },
        {
            fieldLabel: '经办人',
            name: 'operator_id'
        },
        {
            fieldLabel: '交货日期',
            name: 'delivery_date',
            format: 'Y-m-d',
            xtype: 'datefield'
        },
        {
            fieldLabel: '摘要',
            name: 'remark'
        },
        {
            fieldLabel: '附加说明',
            name: 'addition'
        }
    ]
});