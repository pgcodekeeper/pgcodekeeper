/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffScript;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.Parser;

/**
 * Stores schema information.
 *
 * @author fordfrog
 */
public class PgSchema extends PgStatement {

    private final List<PgDomain> domains = new ArrayList<>();
    private final List<PgFunction> functions = new ArrayList<>();
    private final List<PgSequence> sequences = new ArrayList<>();
    private final List<PgTable> tables = new ArrayList<>();
    private final List<PgView> views = new ArrayList<>();
    private final List<PgType> types = new ArrayList<>();

    private String definition;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.SCHEMA;
    }
    
    public PgSchema(String name, String rawStatement) {
        super(name, rawStatement);
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

        sbSQL.append(';');

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }
    
    @Override
    public String getDropSQL() {
        return "DROP SCHEMA "
                + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    /**
     * Finds domain according to specified domain {@code name}.
     *
     * @param name name of the domain to be searched
     *
     * @return found domain or null if no such domain has been found
     */
    public PgDomain getDomain(String name) {
        for (PgDomain dom : domains) {
            if (name.equals(dom.getName())) {
                return dom;
            }
        }
        return null;
    }
    
    /**
     * Getter for {@link #domains}. The list cannot be modified.
     *
     * @return {@link #domains}
     */
    public List<PgDomain> getDomains() {
        return Collections.unmodifiableList(domains);
    }
    
    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgSchema newSchema;
        if (newCondition instanceof PgSchema) {
            newSchema = (PgSchema) newCondition;
        } else {
            return false;
        }
        PgSchema oldSchema = this;
        PgDiffScript script = new PgDiffScript();
        if (!Objects.equals(oldSchema.getOwner(), newSchema.getOwner())) {
            script.addStatement(newSchema.getOwnerSQL());
        }
        
        if (!oldSchema.getGrants().equals(newSchema.getGrants())
                || !oldSchema.getRevokes().equals(newSchema.getRevokes())) {
            script.addStatement(newSchema.getPrivilegesSQL());
        }
        
        PgDiff.diffComments(oldSchema, newSchema, script);
        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        script.printStatements(writer);
        sb.append(diffInput.toString().trim());
        return sb.length() > startLength;
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
                PgDiffUtils.getObjectName(p.parseIdentifier()), null);
        PgSchema.parseArguments(p, tmp);
        
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

    /**
     * Finds type according to specified type {@code name}.
     *
     * @param name name of the type to be searched
     *
     * @return found type or null if no such type has been found
     */
    public PgType getType(final String name) {
        for (PgType type : types) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return null;
    }
    /**
     * Getter for {@link #types}. The list cannot be modified.
     *
     * @return {@link #types}
     */
    public List<PgType> getTypes() {
        return Collections.unmodifiableList(types);
    }
    
    public void addDomain(PgDomain dom) {
        domains.add(dom);
        dom.setParent(this);
        resetHash();
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

    public void addType(final PgType type) {
        types.add(type);
        type.setParent(this);
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
    
    public boolean containsType(final String name) {
        return getType(name) != null;
    }
    
    public boolean containsDomain(final String name) {
        return getDomain(name) != null;
    }
    
    void replaceDef(PgSchema newSchema) {
        if (!getName().equals(newSchema.getName())) {
            throw new IllegalStateException("Replacing schema must have the same name");
        }
        revokes.clear();
        for (PgPrivilege priv : newSchema.revokes) {
            addPrivilege(priv.shallowCopy());
        }
        grants.clear();
        for (PgPrivilege priv : newSchema.grants) {
            addPrivilege(priv.shallowCopy());
        }
        
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
                    && Objects.equals(definition, schema.getDefinition())
                    && grants.equals(schema.grants)
                    && revokes.equals(schema.revokes)
                    && Objects.equals(owner, schema.getOwner())
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
                    
                    && new HashSet<>(domains).equals(new HashSet<>(schema.domains))
                    && new HashSet<>(sequences).equals(new HashSet<>(schema.sequences))
                    && new HashSet<>(functions).equals(new HashSet<>(schema.functions))
                    && new HashSet<>(views).equals(new HashSet<>(schema.views))
                    && new HashSet<>(tables).equals(new HashSet<>(schema.tables))
                    && new HashSet<>(types).equals(new HashSet<>(schema.types));
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
        result = prime * result + ((grants == null) ? 0 : grants.hashCode());
        result = prime * result + ((revokes == null) ? 0 : revokes.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((definition == null) ? 0 : definition.hashCode());
        result = prime * result + new HashSet<>(domains).hashCode();
        result = prime * result + new HashSet<>(functions).hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + new HashSet<>(sequences).hashCode();
        result = prime * result + new HashSet<>(tables).hashCode();
        result = prime * result + new HashSet<>(views).hashCode();
        result = prime * result + new HashSet<>(types).hashCode();
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }

    @Override
    public PgSchema shallowCopy() {
        PgSchema schemaDst = new PgSchema(getName(), getRawStatement());
        schemaDst.setDefinition(getDefinition());
        schemaDst.setComment(getComment());
        for (PgPrivilege priv : revokes) {
            schemaDst.addPrivilege(priv.shallowCopy());
        }
        for (PgPrivilege priv : grants) {
            schemaDst.addPrivilege(priv.shallowCopy());
        }
        schemaDst.setOwner(getOwner());
        return schemaDst;
    }
    
    @Override
    public PgSchema deepCopy() {
        PgSchema copy = shallowCopy();
        
        for (PgDomain dom : domains) {
            copy.addDomain(dom.deepCopy());
        }
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
        for (PgType type : types) {
            copy.addType(type.deepCopy());
        }
        return copy;
    }

    private static void parseArguments(Parser parser, PgFunction function) {
        parser.expect("(");
    
        while (!parser.expectOptional(")")) {
            final String mode;
    
            if (parser.expectOptional("IN")) {
                mode = "IN";
            } else if (parser.expectOptional("OUT")) {
                mode = "OUT";
            } else if (parser.expectOptional("INOUT")) {
                mode = "INOUT";
            } else if (parser.expectOptional("VARIADIC")) {
                mode = "VARIADIC";
            } else {
                mode = null;
            }
    
            final int position = parser.getPosition();
            String argumentName = null;
            String dataType = parser.parseDataType();
    
            final int position2 = parser.getPosition();
    
            if (!parser.expectOptional(")") && !parser.expectOptional(",")
                    && !parser.expectOptional("=")
                    && !parser.expectOptional("DEFAULT")) {
                parser.setPosition(position);
                argumentName = PgDiffUtils.getObjectName(parser.parseIdentifier());
                dataType = parser.parseDataType();
            } else {
                parser.setPosition(position2);
            }
    
            final String defaultExpression;
    
            if (parser.expectOptional("=") || parser.expectOptional("DEFAULT")) {
                defaultExpression = parser.getExpression();
            } else {
                defaultExpression = null;
            }
    
            final PgFunction.Argument argument = new PgFunction.Argument();
            argument.setDataType(dataType);
            argument.setDefaultExpression(defaultExpression);
            argument.setMode(mode);
            argument.setName(argumentName);
            function.addArgument(argument);
    
            if (parser.expectOptional(")")) {
                break;
            } else {
                parser.expect(",");
            }
        }
    }
}
