Ext.define('AppIndex.view.StorageInViewForm', {
    extend: 'Ext.form.Panel',
    xtype: 'app_storage_in_view_form',
    requires: [
        'AppIndex.store.GetPurchaseNoteInApproval'
    ],

    border: false,
    layout: 'anchor',
    reference: 'form', //指定组件层级
    defaults: {
        xtype: 'textfield',
        style: 'float:left;padding-top:5px;',
        anchor: '16%'
    },
    fieldDefaults: {
        labelAlign: 'right',
        labelWidth: 70
    },
    tbar: [
        {
            text:'入库',
            iconCls:'icon_add',
            handler: 'StorageInSubmit'
        }, '-',
        {
            text:'打印',
            iconCls:'icon_printer',
            handler: 'StorageInPrint'
        }
    ],
    items:[
        {
            xtype: 'combo',
            fieldLabel: '采购进货',
            itemId: 'purchase_note_id',
            name: 'purchase_note_id',
            displayField: 'purchase_note_id',
            valueField : 'purchase_note_id',
            editable: true,
            forceSelection : true,
            triggerAction : 'all',
            selectOnFocus : true,
            matchFieldWidth:false,
            store: {
                type:'get_purchase_note_in_approval'
            },
            listeners: {
                select: 'StorageInLoad'
            },
            queryMode : 'local',
            allowBlank: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '销售退货'
        },
        {
            xtype: 'textfield',
            fieldLabel: '销售换货'
        }
        ]
});