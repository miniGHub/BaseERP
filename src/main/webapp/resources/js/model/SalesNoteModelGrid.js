Ext.define('AppIndex.model.SalesNoteModelGrid', {
    extend: 'Ext.data.Model',

    /***** type *****
     *  auto
     *  string
     *  int
     *  float
     *  boolean
     *  date
     ****************/
    fields:[
        {name: 'product_id', type: 'string'},
        {name: 'respority_id', type: 'string'},
        {name: 'amount',  type: 'int'},
        {name: 'unit_price',  type: 'float'},
        {name: 'balance', type: 'float'},
        {name: 'discount_unit_price',  type: 'float'},
        {name: 'discount_balance',  type: 'float'},
        {name: 'invoice_balance',  type: 'float'},
        {name: 'barcode',  type: 'string'},
        {name: 'state',  type: 'int'},
        {name: 'comment',  type: 'string'}
    ]
});
