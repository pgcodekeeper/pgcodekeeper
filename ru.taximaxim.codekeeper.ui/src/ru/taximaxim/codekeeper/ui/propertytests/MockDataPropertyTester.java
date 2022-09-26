package ru.taximaxim.codekeeper.ui.propertytests;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class MockDataPropertyTester extends PropertyTester {

    @Override
    public boolean test(Object receiver, String property, Object[] args,
            Object expectedValue) {
        IFile file = (IFile) receiver;
        return PgDbParser.getParser(file)
                .getDefsForPath(file.getLocation().toOSString())
                .stream()
                .anyMatch(e -> e.getStatementType() == DbObjType.TABLE);
    }
}