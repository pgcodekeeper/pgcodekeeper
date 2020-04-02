package cz.startnet.utils.pgdiff.schema.meta;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MetaDatabase extends MetaStatement implements IDatabase {

    private static final long serialVersionUID = 1782268749545732599L;

    private final transient Map<String, MetaSchema> schemas = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> casts = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> extensions = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> assemblies = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> roles = new LinkedHashMap<>();
    private final transient Map<String, MetaStatement> users = new LinkedHashMap<>();

    public MetaDatabase() {
        super(new GenericColumn("Meta db", DbObjType.DATABASE));
    }

    @Override
    public void addChild(MetaStatement st) {
        st.setParent(this);
        DbObjType type = st.getStatementType();
        switch (type) {
        case SCHEMA:
            addSchema((MetaSchema) st);
            break;
        case EXTENSION:
            extensions.put(st.getName(), st);
            break;
        case ASSEMBLY:
            assemblies.put(st.getName(), st);
            break;
        case ROLE:
            roles.put(st.getName(), st);
            break;
        case USER:
            users.put(st.getName(), st);
            break;
        default:
            throw new IllegalArgumentException("Unsupported child type: " + type);
        }
    }

    @Override
    public MetaStatement getChild(String name, DbObjType type) {
        switch (type) {
        case SCHEMA:
            return getSchema(name);
        case EXTENSION:
            return extensions.get(name);
        case ASSEMBLY:
            return assemblies.get(name);
        case ROLE:
            return roles.get(name);
        case USER:
            return users.get(name);
        default:
            return null;
        }
    }

    @Override
    public Collection<MetaSchema> getSchemas() {
        return Collections.unmodifiableCollection(schemas.values());
    }

    @Override
    public MetaSchema getSchema(String name) {
        return schemas.get(name);
    }

    public void addSchema(final MetaSchema schema) {
        schemas.put(schema.getName(), schema);
    }

    public boolean containsCastImplicit(String sourceType, String dataType) {
        return false;
    }
}
