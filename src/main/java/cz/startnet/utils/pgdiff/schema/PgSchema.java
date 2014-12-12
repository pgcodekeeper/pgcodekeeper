/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.CreateFunctionParser;
import cz.startnet.utils.pgdiff.parsers.Parser;
import cz.startnet.utils.pgdiff.parsers.ParserUtils;

/**
 * Stores schema information.
 *
 * @author fordfrog
 */
public class PgSchema extends PgStatement {

    private final List<PgFunction> functions = new ArrayList<>();
    private final List<PgSequence> sequences = new ArrayList<>();
    private final List<PgTable> tables = new ArrayList<>();
    private final List<PgView> views = new ArrayList<>();

    private String authorization;
    private String definition;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.SCHEMA;
    }
    
    public PgSchema(String name, String rawStatement) {
        super(name, rawStatement);
    }

    public void setAuthorization(final String authorization) {
        this.authorization = authorization;
        resetHash();
    }

    public String getAuthorization() {
        return authorization;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(final String definition) {
        this.definition = definition;
        resetHash();
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE SCHEMA ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));

        if (getAuthorization() != null) {
            sbSQL.append(" AUTHORIZATION ");
            sbSQL.append(PgDiffUtils.getQuotedName(getAuthorization()));
        }

        sbSQL.append(';');

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\nCOMMENT ON SCHEMA ");
            sbSQL.append(PgDiffUtils.getQuotedName(name));
            sbSQL.append(" IS ");
            sbSQL.append(comment);
            sbSQL.append(';');
        }

        return sbSQL.toString();
    }
    
    @Override
    public String getDropSQL() {
        return "DROP SCHEMA "
                + PgDiffUtils.getQuotedName(getName()) + ';';
    }
    
    /**
     * Finds function according to specified function {@code signature}.
     *
     * @param signature signature of the function to be searched
     *
     * @return found function or null if no such function has been found
     */
    public PgFunction getFunction(final String signature) {
        Parser p = new Parser(signature);
        // TODO qualified names here?
        PgFunction tmp = new PgFunction(
                ParserUtils.getObjectName(p.parseIdentifier()), null, null);
        CreateFunctionParser.parseArguments(p, tmp);
        
        for (PgFunction function : functions) {
            if (function.getBareName().equals(tmp.getBareName()) && 
                    function.compareSignature(tmp)) {
                return function;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #functions}. The list cannot be modified.
     *
     * @return {@link #functions}
     */
    public List<PgFunction> getFunctions() {
        return Collections.unmodifiableList(functions);
    }

    /**
     * Finds sequence according to specified sequence {@code name}.
     *
     * @param name name of the sequence to be searched
     *
     * @return found sequence or null if no such sequence has been found
     */
    public PgSequence getSequence(final String name) {
        for (PgSequence sequence : sequences) {
            if (sequence.getName().equals(name)) {
                return sequence;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #sequences}. The list cannot be modified.
     *
     * @return {@link #sequences}
     */
    public List<PgSequence> getSequences() {
        return Collections.unmodifiableList(sequences);
    }

    /**
     * Finds table according to specified table {@code name}.
     *
     * @param name name of the table to be searched
     *
     * @return found table or null if no such table has been found
     */
    public PgTable getTable(final String name) {
        for (PgTable table : tables) {
            if (table.getName().equals(name)) {
                return table;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #tables}. The list cannot be modified.
     *
     * @return {@link #tables}
     */
    public List<PgTable> getTables() {
        return Collections.unmodifiableList(tables);
    }

    /**
     * Finds view according to specified view {@code name}.
     *
     * @param name name of the view to be searched
     *
     * @return found view or null if no such view has been found
     */
    public PgView getView(final String name) {
        for (PgView view : views) {
            if (view.getName().equals(name)) {
                return view;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #views}. The list cannot be modified.
     *
     * @return {@link #views}
     */
    public List<PgView> getViews() {
        return Collections.unmodifiableList(views);
    }

    public void addFunction(final PgFunction function) {
        functions.add(function);
        function.setParent(this);
        resetHash();
    }

    public void addSequence(final PgSequence sequence) {
        sequences.add(sequence);
        sequence.setParent(this);
        resetHash();
    }

    public void addTable(final PgTable table) {
        tables.add(table);
        table.setParent(this);
        resetHash();
    }

    public void addView(final PgView view) {
        views.add(view);
        view.setParent(this);
        resetHash();
    }

    public boolean containsFunction(final String signature) {
        return getFunction(signature) != null;
    }

    public boolean containsSequence(final String name) {
        return getSequence(name) != null;
    }

    public boolean containsTable(final String name) {
        return getTable(name) != null;
    }

    public boolean containsView(final String name) {
        return getView(name) != null;
    }
    
    void replaceDef(PgSchema newSchema) {
        if (!getName().equals(newSchema.getName())) {
            throw new IllegalStateException("Replacing schema must have the same name");
        }
        
        privileges.clear();
        for (PgPrivilege priv : newSchema.privileges) {
            addPrivilege(priv.shallowCopy());
        }
        
        setAuthorization(newSchema.getAuthorization());
        setDefinition(newSchema.getDefinition());
        setComment(newSchema.getComment());
    }
    
    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;
        
        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgSchema) {
            PgSchema schema = (PgSchema) obj;
            
            eq = Objects.equals(name, schema.getName())
                    && Objects.equals(authorization, schema.getAuthorization())
                    && Objects.equals(definition, schema.getDefinition())
                    && privileges.equals(schema.privileges)
                    && Objects.equals(comment, schema.getComment());
        }
        
        return eq;
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        
        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgSchema) {
            PgSchema schema = (PgSchema) obj;
            
            eq = super.equals(obj)
                    
                    && new HashSet<>(sequences).equals(new HashSet<>(schema.sequences))
                    && new HashSet<>(functions).equals(new HashSet<>(schema.functions))
                    && new HashSet<>(views).equals(new HashSet<>(schema.views))
                    && new HashSet<>(tables).equals(new HashSet<>(schema.tables));
        }
        
        return eq;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((privileges == null) ? 0 : privileges.hashCode());
        result = prime * result + ((authorization == null) ? 0 : authorization.hashCode());
        result = prime * result + ((definition == null) ? 0 : definition.hashCode());
        result = prime * result + new HashSet<>(functions).hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + new HashSet<>(sequences).hashCode();
        result = prime * result + new HashSet<>(tables).hashCode();
        result = prime * result + new HashSet<>(views).hashCode();
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }

    @Override
    public PgSchema shallowCopy() {
        PgSchema schemaDst = new PgSchema(getName(), getRawStatement());
        schemaDst.setAuthorization(getAuthorization());
        schemaDst.setDefinition(getDefinition());
        schemaDst.setComment(getComment());
        for (PgPrivilege priv : privileges) {
            schemaDst.addPrivilege(priv.shallowCopy());
        }
        schemaDst.setOwner(getOwner());
        return schemaDst;
    }
    
    @Override
    public PgSchema deepCopy() {
        PgSchema copy = shallowCopy();
        
        for(PgSequence seq : sequences) {
            copy.addSequence(seq.deepCopy());
        }
        for(PgFunction func : functions) {
            copy.addFunction(func.deepCopy());
        }
        for(PgView view : views) {
            copy.addView(view.deepCopy());
        }
        for(PgTable table : tables) {
            copy.addTable(table.deepCopy());
        }
        
        return copy;
    }
}
