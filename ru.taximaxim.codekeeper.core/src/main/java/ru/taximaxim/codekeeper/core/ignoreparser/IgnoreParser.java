package ru.taximaxim.codekeeper.core.ignoreparser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.RuleContext;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.log.Log;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.IIgnoreList;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.IgnoreListParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.IgnoreListParser.BlackContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.IgnoreListParser.FlagContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.IgnoreListParser.Hide_ruleContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.IgnoreListParser.Rule_listContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.IgnoreListParser.Rule_restContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.IgnoreListParser.Show_ruleContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.IgnoreListParser.WhiteContext;

public class IgnoreParser {

    private final IIgnoreList list;

    public IgnoreParser(IIgnoreList list) {
        this.list = list;
    }

    public IgnoreParser parse(Path listFile) throws IOException {
        return parse(Files.newInputStream(listFile), listFile.toString());
    }

    public IgnoreParser parse(InputStream stream, String parsedObjectName) throws IOException {
        IgnoreListParser parser = AntlrParser.makeBasicParser(
                IgnoreListParser.class, stream, Consts.UTF_8, parsedObjectName);
        try {
            parse(parser);
        } catch (Exception ex) {
            Log.log(Log.LOG_ERROR, "Error while analyzing parser tree for IgnoreList file: "
                    + parsedObjectName, ex);
        }
        return this;
    }

    private void parse(IgnoreListParser parser) {
        Rule_listContext rules = parser.compileUnit().rule_list();
        WhiteContext white = rules.white();
        if (white != null) {
            // white lists are hiding by default and therefore have precedence over black lists
            list.setShow(false);
            white(white);
        } else {
            black(rules.black());
        }
    }

    private void white(WhiteContext white) {
        for (Show_ruleContext showRule : white.show_rule()) {
            ruleRest(showRule.rule_rest(), true);
        }
    }

    private void black(BlackContext black) {
        for (Hide_ruleContext hideRule : black.hide_rule()) {
            ruleRest(hideRule.rule_rest(), false);
        }
    }

    private void ruleRest(Rule_restContext ruleRest, boolean isShow) {
        boolean isRegular = false;
        boolean ignoreContent = false;
        boolean isQualified = false;
        for (FlagContext flag : ruleRest.flags().flag()) {
            if (flag.CONTENT() != null) {
                ignoreContent = true;
            } else if (flag.REGEX() != null) {
                isRegular = true;
            } else if (flag.QUALIFIED() != null) {
                isQualified = true;
            }
        }
        String dbRegex = ruleRest.db == null ? null : ruleRest.db.getText();

        Set<DbObjType> objTypes = ruleRest.type.stream().map(RuleContext::getText)
                .map(DbObjType::valueOf)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(DbObjType.class)));

        list.add(new IgnoredObject(ruleRest.obj.getText(), dbRegex,
                isShow, isRegular, ignoreContent, isQualified, objTypes));
    }
}
