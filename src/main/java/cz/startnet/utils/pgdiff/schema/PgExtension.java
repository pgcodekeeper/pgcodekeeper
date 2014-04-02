package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Stores extension information.
 *
 * @author Alexander Levsha
 */
public class PgExtension extends PgStatement {

	private String schema;
	private String version;
	private String oldVersion;
	private String comment;

	public PgExtension(String name, String rawStatement) {
		super(name, rawStatement);
	}
	
	public String getSchema() {
		return schema;
	}
	
	public void setSchema(final String schema) {
		this.schema = schema;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(final String version) {
		this.version = version;
	}
	
	public String getOldVersion() {
		return oldVersion;
	}
	
	public void setOldVersion(final String oldVersion) {
		this.oldVersion = oldVersion;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(final String comment) {
		this.comment = comment;
	}
	
	public String getCreationSQL() {
		final StringBuilder sbSQL = new StringBuilder(50);
		sbSQL.append("CREATE EXTENSION ");
		sbSQL.append(PgDiffUtils.getQuotedName(getName()));
		
		if(getSchema() != null && !getSchema().isEmpty()) {
			sbSQL.append(" SCHEMA ");
			sbSQL.append(getSchema());
		}
		
		if(getVersion() != null && !getVersion().isEmpty()) {
			sbSQL.append(" VERSION ");
			sbSQL.append(getVersion());
		}
		
		if(getOldVersion() != null && !getOldVersion().isEmpty()) {
			sbSQL.append(" FROM ");
			sbSQL.append(getOldVersion());
		}
		
		sbSQL.append(';');
		
		if(getComment() != null && !getComment().isEmpty()) {
			sbSQL.append("\n\nCOMMENT ON EXTENSION ");
			sbSQL.append(PgDiffUtils.getQuotedName(getName()));
			sbSQL.append(" IS ");
			sbSQL.append(comment);
			sbSQL.append(';');
		}
		
		return sbSQL.toString();
	}
	
	@Override
	public boolean compare(PgStatement obj) {
        boolean eq = false;
        
        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgExtension) {
            PgExtension ext = (PgExtension) obj;
            eq = Objects.equals(name, ext.getName()) 
                    && Objects.equals(schema, ext.getSchema())
                    && Objects.equals(version, ext.getVersion())
                    && Objects.equals(oldVersion, ext.getOldVersion());
        }
        
        return eq;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((oldVersion == null) ? 0 : oldVersion.hashCode());
        result = prime * result + ((schema == null) ? 0 : schema.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        return result;
    }

	@Override
	public PgExtension shallowCopy() {
	    PgExtension extDst = new PgExtension(getName(), getRawStatement());
        extDst.setSchema(getSchema());
        extDst.setVersion(getVersion());
        extDst.setOldVersion(getOldVersion());
        extDst.setComment(getComment());
        return extDst;
	}
	
	@Override
	public PgExtension deepCopy() {
	    return shallowCopy();
	}
}
