

Schema: public

  View: nums_1_100
    RelationColumns : 
     n - integer

  View: nums_1_100_f
    RelationColumns : 
     n - integer
     m - integer

  View: myview
    RelationColumns : 
     col1 - integer
     col2 - integer

  View: geo_recurs
    RelationColumns : 
     name - character varying(1000)

  View: viewttt
    RelationColumns : 
     c1__integer - integer
     c2__text - text
     func__integer - integer
     func__text - text
     schema__name - name
     is_other_temp_schema__boolean - boolean
     func2__double - double precision
     func2__text - text
     tester_func2__real - real
     tester_func2__integer - integer
     dev__integer - integer
     summ__numeric - numeric
     summ__integer - integer
     funcsum__double - double precision
     public_func__integer - integer
     round__text - text
     pgcatalogggg_round__double - double precision
     vex_op_vex__boolean - boolean
     op_vex__numeric - numeric
     vex_op_2__numeric - numeric
     operrrr__integer - integer
     func_user_type_return__custom_type - public.custom_type
     recurs__character_varying_1000 - character varying(1000)
     recurs_myview___integer - integer
     recurs_nums_1_100_fn___integerr - integer
     recurs_nums_1_100_fm___integerr - integer
     recurs_nums_1_100___integerr - integer

  View: testview1
    RelationColumns : 
     summ1 - numeric
     summ2 - integer
     summ3 - smallint
     summ4 - bigint

  View: testview2
    RelationColumns : 
     t1 - text
     t2 - text
     format - text

  View: testview3
    RelationColumns : 
     a - integer
     b - text

  View: testview4
    RelationColumns : 
     a - integer
     b - text

  View: testview5
    RelationColumns : 
     z - integer
     x - text

  View: testview6
    RelationColumns : 
     num1 - integer
     text1 - text

  View: testview
    RelationColumns : 
     c1 - public.inventory_item
     c2 - public.test_composite1
     c3 - public.test_composite
     c4 - public.complex
     c5 - double precision