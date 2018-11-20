SELECT
--general
t.schema_id AS schema_oid,
t.name AS name,
p.name AS owner,
aa.acl,

-- assembly type
ay.assembly_class,
a.name AS assembly,

-- wrapper type
t.is_nullable,
basetypes.name AS type,
CASE WHEN basetypes.name IN (N'nchar', N'nvarchar') AND t.max_length >= 0 THEN t.max_length/2 ELSE t.max_length END AS size,
t.precision AS prec,
t.scale AS scale,

-- type table
cc.cols,
ch.checks,
ii.indices,
ttt.is_memory_optimized

FROM sys.types t WITH (NOLOCK)
LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=t.principal_id
LEFT JOIN sys.types basetypes WITH (NOLOCK) ON t.system_type_id=basetypes.system_type_id AND basetypes.system_type_id=basetypes.user_type_id
LEFT JOIN sys.assembly_types ay WITH (NOLOCK) ON ay.user_type_id=t.user_type_id
LEFT JOIN sys.assemblies a WITH (NOLOCK) ON a.assembly_id=ay.assembly_id
LEFT JOIN sys.table_types ttt WITH (NOLOCK) ON ttt.user_type_id=t.user_type_id

-- type table columns
CROSS APPLY ( 
    SELECT * FROM (
        SELECT
            c.name,
            c.column_id AS id,
            ss.name AS ts,
            usrt.name AS type,
            usrt.is_user_defined AS ud,
            CASE WHEN c.max_length >= 0 AND baset.name IN (N'nchar', N'nvarchar') THEN c.max_length/2 ELSE c.max_length END AS size,
            c.precision AS pr,
            c.scale AS sc,
            c.collation_name AS cn,
            object_definition(c.default_object_id) AS dv,
            c.is_nullable AS nl,
            c.is_identity AS ii,
            ic.seed_value AS s,
            ic.increment_value AS i,
            ic.is_not_for_replication AS nfr,
            c.is_rowguidcol AS rgc,
            cc.is_persisted AS ps,
            cc.definition AS def
        FROM sys.all_columns c
        LEFT OUTER JOIN sys.computed_columns cc WITH (NOLOCK) ON cc.object_id = c.object_id AND cc.column_id = c.column_id
        LEFT OUTER JOIN sys.identity_columns ic WITH (NOLOCK) ON ic.object_id = c.object_id AND ic.column_id = c.column_id
        LEFT OUTER JOIN sys.types usrt WITH (NOLOCK) ON usrt.user_type_id = c.user_type_id
        LEFT OUTER JOIN sys.schemas ss WITH (NOLOCK) ON ss.schema_id = usrt.schema_id
        LEFT OUTER JOIN sys.types baset WITH (NOLOCK) ON (baset.user_type_id = c.system_type_id AND baset.user_type_id = baset.system_type_id) 
        OR (baset.system_type_id = c.system_type_id AND baset.user_type_id = c.user_type_id AND baset.is_user_defined = 0 AND baset.is_assembly_type = 1) 
        WHERE ttt.type_table_object_id=c.object_id
    ) cc ORDER BY cc.id
    FOR XML RAW, ROOT
) cc (cols)

-- type table check constraints
CROSS APPLY ( 
    SELECT c.definition
    FROM sys.check_constraints c WITH (NOLOCK)    
    WHERE c.parent_object_id=ttt.type_table_object_id
    FOR XML RAW, ROOT
) ch (checks)

-- type table check indices, pk, unique 
CROSS APPLY ( 
    SELECT * FROM (
        SELECT
            si.name,
            si.is_primary_key,
            si.is_unique,
            si.is_unique_constraint,
            INDEXPROPERTY(si.object_id, si.name, 'IsClustered') AS is_clustered,
            ccc.cols,
            si.filter_definition
        FROM sys.indexes AS si
        LEFT JOIN sys.objects o WITH (NOLOCK) ON si.object_id = o.object_id
        CROSS APPLY ( 
            SELECT * FROM (
                SELECT
                  c.index_column_id AS id,
                  sc.name,
                  c.is_descending_key AS is_desc
                FROM sys.index_columns c WITH (NOLOCK)
                JOIN sys.columns sc WITH (NOLOCK) ON c.object_id = sc.object_id AND c.column_id = sc.column_id
                WHERE c.object_id = si.object_id AND c.index_id = si.index_id
            ) cc ORDER BY cc.id
            FOR XML RAW, ROOT
        ) ccc (cols)
        WHERE si.object_id=ttt.type_table_object_id AND si.index_id > 0 AND si.is_hypothetical = 0
    ) ii  
    FOR XML RAW, ROOT
) ii (indices)

-- type privileges
CROSS APPLY (
    SELECT * FROM (
        SELECT  
            perm.state_desc AS sd,
            perm.permission_name AS pn,
            roleprinc.name AS r
        FROM sys.database_principals roleprinc WITH (NOLOCK)
        JOIN sys.database_permissions perm WITH (NOLOCK) ON perm.grantee_principal_id = roleprinc.principal_id
        WHERE major_id = t.user_type_id AND perm.class = 6
    ) aa 
    FOR XML RAW, ROOT
) aa (acl)

WHERE t.is_user_defined=1