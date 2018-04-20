package ru.taximaxim.codekeeper.apgdiff.ignoreparser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.RuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.IgnoreListParser;
import cz.startnet.utils.pgdiff.parsers.antlr.IgnoreListParser.BlackContext;
import cz.startnet.utils.pgdiff.parsers.antlr.IgnoreListParser.FlagContext;
import cz.startnet.utils.pgdiff.parsers.antlr.IgnoreListParser.Hide_ruleContext;
import cz.startnet.utils.pgdiff.parsers.antlr.IgnoreListParser.Rule_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.IgnoreListParser.Rule_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.IgnoreListParser.Show_ruleContext;
import cz.startnet.utils.pgdiff.parsers.antlr.IgnoreListParser.WhiteContext;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;

public class IgnoreParser {

    private final IgnoreList list;

    public IgnoreList getIgnoreList() {
        return list;
    }

    public IgnoreParser() {
        this(new IgnoreList());
    }

    public IgnoreParser(IgnoreList list) {
        this.list = list;
    }

    public IgnoreParser parse(Path listFile) throws IOException {
        return parse(Files.newInputStream(listFile), listFile.toString());
    }

    public IgnoreParser parse(InputStream stream, String parsedObjectName) throws IOException {
        IgnoreListParser parser = AntlrParser.makeBasicParser(
                IgnoreListParser.class, stream, "UTF-8", parsedObjectName);
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
        for (FlagContext flag : ruleRest.flags().flag()) {
            if (flag.CONTENT() != null) {
                ignoreContent = true;
            } else if (flag.REGEX() != null) {
                isRegular = true;
            }
        }
        String dbRegex = ruleRest.db == null ? null : ruleRest.db.getText();

        List<String> objTypes = ruleRest.type.stream().map(RuleContext::getText)
                .collect(Collectors.toList());
        list.add(new IgnoredObject(ruleRest.obj.getText(), dbRegex,
                isShow, isRegular, ignoreContent, objTypes));
    }
}
