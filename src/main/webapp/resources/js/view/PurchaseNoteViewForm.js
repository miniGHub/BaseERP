Ext.define('AppIndex.view.PurchaseNoteViewForm',{
    extend: 'Ext.form.Panel',
    xtype:'app_purchase_note_view_form',
    requires: [
        'AppIndex.store.GetSalesOrderNoteApprovalingStore',
        'AppIndex.store.GetAllSupplierStore'
    ],

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
    tbar: [
        {
            text:'提交',
            iconCls: 'icon_add',
            handler: 'PurchaseNoteSubmit'
        },'-',
        {
            text:'打印',
            iconCls:'icon_printer',
            handler: 'PurchaseNotePrint'
        }
    ],
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
            name: 'purchase_note_id',
            editable: false,
            allowBlank: false
        },
        {
            xtype: 'combo',
            fieldLabel: '销售单号',
            itemId: 'sales_order_note_id',
            name: 'sales_order_note_id',
            displayField: 'sales_order_note_id',
            valueField : 'sales_order_note_id',
            editable: true,
            forceSelection : true,
            triggerAction : 'all',
            selectOnFocus : true,
            matchFieldWidth:false,
            store: {
                type:'get_sales_order_note_approvaling_store'
            },
            queryMode : 'remote',
            allowBlank: true,
            listeners : {
                select: 'PurchaseNoteLoad'
            }
        },
        {
            xtype: 'combo',
            fieldLabel: '供应商',
            itemId: 'supplier_id',
            displayFiled: 'supplier_name',
            valueFiled: 'supplier_id',
            name: 'supplier_id',
            editable: true,
            forceSelection : true,
            triggerAction : 'all',
            selectOnFocus : true,
            matchFieldWidth:false,
            store: {
                type:'get_all_supplier_store'
            },
            queryMode : 'remote',
            allowBlank: true
        },
        {
            fieldLabel: '仓库编号',
            name: 'repository_id',
            allowBlank: false
        },
        {
            fieldLabel: '付款日期',
            name: 'pay_date',
            xtype: 'datefield',
            format: 'Y-m-d',
            allowBlank: false
        },
        {
            fieldLabel: '付款账号',
            name: 'pay_id',
            allowBlank: false
        },
        {
            fieldLabel: '付款金额',
            name: 'pay_balance',
            allowBlank: false
        },
        {
            fieldLabel: '往来单位',
            name: 'contact_id',
            allowBlank: false
        },
        {
            fieldLabel: '往来单位账号',
            name: 'contact_pay_id',
            allowBlank: false
        },
        {
            fieldLabel: '往来单位金额',
            name: 'contact_pay_balance',
            allowBlank: false
        },
        {
            fieldLabel: '优惠金额',
            name: 'discount_balance',
            allowBlank: false
        },
        {
            fieldLabel: '经办人',
            name: 'operator_id',
            allowBlank: false
        },
        {
            fieldLabel: '部门编号',
            name: 'depart_id',
            allowBlank: false
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