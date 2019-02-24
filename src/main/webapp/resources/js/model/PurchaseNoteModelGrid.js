Ext.define('AppIndex.model.PurchaseNoteModelGrid', {
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
        {name: 'purchase_note_id', type: 'string'},
        {name: 'product_id',  type: 'string'},
        {name: 'repository_id',  type: 'string'},
        {name: 'amount', type: 'int'},
        {name: 'unit_price',  type: 'float'},
        {name: 'balance',  type: 'float'},
        {name: 'invoice_balance',  type: 'float'},
        {name: 'barcode',  type: 'string'},
        {name: 'state',  type: 'int'},
        {name: 'comment',  type: 'string'}
    ]
});
