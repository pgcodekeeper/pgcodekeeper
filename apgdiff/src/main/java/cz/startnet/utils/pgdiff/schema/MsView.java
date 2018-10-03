package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.hashers.Hasher;

public class MsView extends AbstractView {

    private String firstPart;
    private String secondPart;

    public MsView(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sbSQL = new StringBuilder();
        sbSQL.append(getViewFullSQL(true));

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);
        return sbSQL.toString();
    }

    private String getViewFullSQL(boolean isCreate) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("SET QUOTED_IDENTIFIER ").append(isQuotedIdentified() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(isAnsiNulls() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');

        sbSQL.append(firstPart);
        sbSQL.append(isCreate ? "CREATE" : "ALTER");
        sbSQL.append(secondPart);
        sbSQL.append(GO);

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsView newView;
        if (newCondition instanceof MsView) {
            newView = (MsView) newCondition;
        } else {
            return false;
        }

        if (!Objects.equals(getFirstPart(), newView.getFirstPart())
                || !Objects.equals(getSecondPart(), newView.getSecondPart())) {
            sb.append(newView.getViewFullSQL(false));
        }

        if (!Objects.equals(getOwner(), newView.getOwner())) {
            sb.append(newView.getOwnerSQL());
        }
        alterPrivileges(newView, sb);

        return sb.length() > startLength;
    }

    @Override
    public String getDropSQL() {
        return "DROP VIEW " + getQualifiedName() + GO;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsView && super.compare(obj)) {
            MsView view = (MsView) obj;
            return Objects.equals(getFirstPart(), view.getFirstPart())
                    && Objects.equals(getSecondPart(), view.getSecondPart());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(getFirstPart());
        hasher.put(getSecondPart());
    }

    @Override
    protected AbstractView getViewCopy() {
        MsView view = new MsView(getName(), getRawStatement());
        view.setFirstPart(getFirstPart());
        view.setSecondPart(getSecondPart());
        return view;
    }

    public String getFirstPart() {
        return firstPart;
    }

    public void setFirstPart(String firstPart) {
        this.firstPart = firstPart;
        resetHash();
    }

    public String getSecondPart() {
        return secondPart;
    }

    public void setSecondPart(String secondPart) {
        this.secondPart = secondPart;
        resetHash();
    }
}
