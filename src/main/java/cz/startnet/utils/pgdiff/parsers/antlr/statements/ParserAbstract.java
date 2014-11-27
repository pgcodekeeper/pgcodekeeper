package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.PGObjLocation;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public abstract class ParserAbstract {
    private final PgDatabase db;
    private final Path filePath;
    
    public ParserAbstract(PgDatabase db, Path filePath) {
        this.db = db;
        this.filePath = filePath;
    }
    
    public abstract PgStatement getObject();

    protected void fillObjLocation(String objName, int startIndex) {
        db.addObjLocation(new PGObjLocation(objName, startIndex, filePath));
    }
    
    protected String getFullCtxText(ParserRuleContext ctx) {
        Interval interval = new Interval(ctx.start.getStartIndex(),
                ctx.stop.getStopIndex());
        ctx.start.getInputStream().getText(interval);
        return ctx.start.getInputStream().getText(interval);
    }

    protected String getName(Schema_qualified_nameContext name) {
        int i = 0;
        if (name == null) {
            return null;
        }
        while (name.identifier(i + 1) != null) {
            i++;
        }
        return name.identifier(i).getText();
    }
}
