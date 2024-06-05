CREATE TABLE default.lineitem
(
    l_orderkey      Int32,
    l_suppkey       Int32,
    l_linenumber    Int32,
    l_extendedprice Decimal(18,2),
    l_discount      Decimal(18,2),
    l_shipdate      Date,
    l_receiptdate   Date
) engine = MergeTree
ORDER BY (l_shipdate, l_receiptdate, l_orderkey, l_linenumber);

create view default.revenue0 as
    select
        l_suppkey,
        sum(l_extendedprice * (1 - l_discount))
    from
        default.lineitem
    where
        l_shipdate >= date '1996-01-01'
        and l_shipdate < date '1996-01-01' + interval '3' month
    group by
        l_suppkey;
