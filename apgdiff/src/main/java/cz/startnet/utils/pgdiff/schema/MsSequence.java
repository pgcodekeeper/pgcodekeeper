package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;

public class MsSequence extends PgSequence {

    public MsSequence(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getQualifiedName() {
        return MsDiffUtils.getQuotedName(getContainingSchema().getName()) + '.' + MsDiffUtils.getQuotedName(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE SEQUENCE ");
        sbSQL.append(getQualifiedName());

        if (!"bigint".equals(getDataType())) {
            sbSQL.append("\n\tAS ").append(getDataType());
        }

        fillSequenceBody(sbSQL);

        sbSQL.append(GO);

        //appendOwnerSQL(sbSQL);
        //appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsSequence newSequence;
        if (newCondition instanceof MsSequence) {
            newSequence = (MsSequence) newCondition;
        } else {
            return false;
        }
        StringBuilder sbSQL = new StringBuilder();
        sbSQL.setLength(0);

        if (compareSequenceBody(newSequence, this, sbSQL)) {
            sb.append("\n\nALTER SEQUENCE " + getQualifiedName() + sbSQL.toString() + GO);
        }

        if (!Objects.equals(getOwner(), newSequence.getOwner())) {
            sb.append("\nALTER AUTHORIZATION ON OBJECT :: ")
            .append(getQualifiedName()).append("\nTO ")
            .append(MsDiffUtils.getQuotedName(newSequence.getOwner())).append(GO);
        }

        //  alterPrivileges(newSequence, sb);
        return sb.length() > startLength;
    }

    @Override
    public String getDropSQL() {
        return "DROP SEQUENCE " + getQualifiedName() + GO;
    }
}
