Ext.define('AppIndex.model.StorageInModelGrid', {
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
        {name: 'repository_id', type: 'string'},
        {name: 'in_date',  type: 'date'},
        {name: 'amount', type: 'int'},
        {name: 'purchase_note_id',  type: 'string'},
        {name: 'sales_return_note_id',  type: 'string'},
        {name: 'sales_exchange_note_id',  type: 'string'},
        {name: 'state',  type: 'int'},
        {name: 'comment',  type: 'string'}
    ]
});
