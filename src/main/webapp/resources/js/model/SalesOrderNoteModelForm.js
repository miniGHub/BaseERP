Ext.define('AppIndex.model.SalesOrderNoteModelForm', {
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
        {name: 'sales_order_note_id', type: 'string'},
        {name: 'client_id',  type: 'string'},
        {name: 'repository_id',  type: 'string'},
        {name: 'operator_id', type: 'string'},
        {name: 'delivery_date',  type: 'date'},
        {name: 'remark',  type: 'string'},
        {name: 'addition',  type: 'string'}
    ],
    validations:[
        {type:'length',field:'ales_order_note_id',min:1,max:10},
        {type:'length',field:'client_id',min:0,max:50}
     ]
});
