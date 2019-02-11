Ext.define('AppIndex.model.SalesOrderNoteModelGrid', {
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
        {name: 'batch_id', type: 'string'},
        {name: 'product_id', type: 'string'},
        {name: 'product_name',  type: 'string'},
        {name: 'client_id',  type: 'string'},
        {name: 'amount', type: 'int'},
        {name: 'unit_price',  type: 'float'},
        {name: 'balance',  type: 'float'},
        {name: 'discount',  type: 'float'},
        {name: 'discount_unit_price',  type: 'float'},
        {name: 'discount_balance',  type: 'float'},
        {name: 'rate',  type: 'float'},
        {name: 'rate_balance',  type: 'float'},
        {name: 'barcode',  type: 'string'},
        {name: 'state',  type: 'int'},
        {name: 'comment',  type: 'string'}
    ]
});
