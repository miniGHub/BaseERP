Ext.define('AppIndex.model.PurchaseNoteModelForm', {
    extend: 'Ext.data.Model',

    /***** type *****
     *  auto
     *  string
     *  int
     *  float
     *  boolean
     *  date
     ****************/
    fields: [
        {name: 'entry_date', type: 'date'},
        {name: 'purchase_note_id', type: 'string'},
        {name: 'sales_order_note_id', type: 'string'},
        {name: 'supplier_id',  type: 'string'},
        {name: 'repository_id',  type: 'string'},
        {name: 'pay_date', type: 'date'},
        {name: 'pay_id',  type: 'string'},
        {name: 'pay_balance',  type: 'float'},
        {name: 'contact_id',  type: 'string'},
        {name: 'contact_pay_id', type: 'string'},
        {name: 'contact_pay_balance', type: 'float'},
        {name: 'discount_balance',  type: 'float'},
        {name: 'operator_id',  type: 'string'},
        {name: 'depart_id', type: 'string'},
        {name: 'remark',  type: 'string'},
        {name: 'addition',  type: 'string'}
    ],
    validations:[
        {type:'length',field:'purchase_note_id',min:1,max:18},
        {type:'length',field:'sales_order_note_id',min:1,max:19},
        {type:'length',field:'contact_id',min:0,max:50}
    ]
});
