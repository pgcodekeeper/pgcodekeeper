CREATE VIEW public.test AS
SELECT * FROM (
    SELECT v.id AS base_id,
    (SELECT ct.c1 FROM 
        (public.v1 wa
             LEFT JOIN public.v2 ct ON ((wa.c1 = ct.c2)))
          WHERE ((ct.c1 <> 4) AND (wa.c2 = v.id))
          ORDER BY wa.c1 LIMIT 1) AS c2,
         
    (''::text || (sum(CASE WHEN (v.c3 = 1) THEN 1 ELSE 0 END))::text) AS c3,
    
    sum(COALESCE(v.c4, 0)) AS c4      
   FROM ( SELECT st.c1 as id, 
            CASE WHEN (public.f1('second'::text, st.c2) > 0) THEN 1 ELSE 0 END AS c2,
            st.c3,
            st.c4,
            st.c5
           FROM public.t2 st) v
           
  WHERE (v.id = public.f2())
  GROUP BY v.id, v.c2, v.c3, v.c4, v.c5
) t LEFT JOIN public.t1 tx ON t.base_id = tx.id;