Ext.define('AppIndex.view.SalesNoteViewForm',{
    extend: 'Ext.form.Panel',
    xtype:'app_sales_note_view_form',

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
            fieldLabel: '销售单',
            name: 'sales_note_id',
            allowBlank: false
        },
        {
            fieldLabel: '销售订单',
            name: 'sales_order_note_id',
            allowBlank: false
        },
        {
            fieldLabel: '采购单',
            name: 'purchase_note_id',
            allowBlank: false
        },
        {
            fieldLabel: '借出转销售单',
            labelWidth:90,
            name: 'lend_sales_note_id',
            allowBlank: false
        },
        {
            fieldLabel: '客户编号',
            name: 'client_id'
        },
        {
            fieldLabel: '仓库编号',
            name: 'respority_id'
        },
        {
            fieldLabel: '录单日期',
            name: 'entry_date',
            xtype: 'datefield',
            format: 'Y-m-d',
            allowBlank: false
        },
        {
            fieldLabel: '收款日期',
            name: 'collect_date',
            xtype: 'datefield',
            format: 'Y-m-d',
            allowBlank: false
        },
        {
            fieldLabel: '收款金额',
            name: 'collect_balance'
        },
        {
            fieldLabel: '优惠金额',
            name: 'discount_balance'
        },
        {
            fieldLabel: '单据状态',
            name: 'note_status'
        },
        {
            fieldLabel: '经办人',
            name: 'operator_id'
        },
        {
            fieldLabel: '部门编号',
            name: 'depart_id'
        },
        {
            fieldLabel: '摘要',
            name: 'remark'
        },
        {
            fieldLabel: '附加说明',
            name: 'addition'
        }
    ],
    buttons: [{
        text: '登录',
        listeners: {
            click: 'onClockLogin'
        }
    }]
});