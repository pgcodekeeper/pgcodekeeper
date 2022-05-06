package cz.startnet.utils.pgdiff.schema;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgUserMapping extends PgStatement implements PgForeignOptionContainer {
    private final String user;
    private final String server;
    private final Map<String, String> options = new LinkedHashMap<>();

    public PgUserMapping(String user, String server) {
        super(user + " SERVER " + server);
        this.user = user;
        this.server = server;
    }

    public String getUser() {
        return user;
    }

    public String getServer() {
        return server;
    }

    @Override
    public String getQualifiedName() {
        return PgDiffUtils.getQuotedName(user) + " SERVER " + PgDiffUtils.getQuotedName(server);
    }

    @Override
    public void addOption(String key, String value) {
        this.options.put(key, value);
        resetHash();
    }

    @Override
    public Map<String, String> getOptions() {
        return options;
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.USER_MAPPING;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(user);
        hasher.put(server);
        hasher.put(options);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PgUserMapping && super.compare(obj)) {
            PgUserMapping usm = (PgUserMapping) obj;
            return Objects.equals(user, usm.getUser())
                    && Objects.equals(server, usm.getServer())
                    && Objects.equals(options, usm.getOptions());
        }
        return false;
    }

    @Override
    public PgDatabase getDatabase() {
        return (PgDatabase)getParent();
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CREATE USER MAPPING ");
        appendIfNotExists(sb);
        sb.append("FOR ").append(getQualifiedName());
        if (!options.isEmpty()) {
            sb.append(" OPTIONS (");
            for (Entry<String, String> entry : options.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                sb.append(key)
                .append(" ")
                .append(value)
                .append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(")");
        }
        sb.append(";");
        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgUserMapping newUsm = (PgUserMapping) newCondition;

        if (!Objects.equals(newUsm.getUser(), getUser()) ||
                !Objects.equals(newUsm.getServer(), getServer())) {
            isNeedDepcies.set(true);
            return true;
        }

        if (!Objects.equals(newUsm.getOptions(), getOptions())) {
            compareOptions(newUsm, sb);
        }
        return sb.length() > startLength;
    }

    @Override
    protected String getDropSQL(boolean generateExists) {
        final StringBuilder sbString = new StringBuilder();
        sbString.append("DROP USER MAPPING ");
        if (generateExists) {
            sbString.append("IF EXISTS ");
        }
        sbString.append("FOR ").append(getQualifiedName());
        sbString.append(';');
        return sbString.toString();
    }

    @Override
    public PgStatement shallowCopy() {
        PgUserMapping copyUsm = new PgUserMapping(getUser(), getServer());
        copyBaseFields(copyUsm);
        copyUsm.options.putAll(options);
        return copyUsm;
    }

    @Override
    public String getAlterHeader() {
        return "\n\nALTER USER MAPPING FOR " + getQualifiedName();
    }
}
