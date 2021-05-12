package ru.taximaxim.codekeeper.apgdiff.formatter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cz.startnet.utils.pgdiff.formatter.FileFormatter;
import cz.startnet.utils.pgdiff.formatter.FormatConfiguration;
import cz.startnet.utils.pgdiff.formatter.FormatConfiguration.IndentType;
import cz.startnet.utils.pgdiff.formatter.FormatterException;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;

@RunWith(value = Parameterized.class)
public class FormatterTest {

    @Parameters
    public static Iterable<FormatConfigProvider[]> parameters() {
        List<FormatConfigProvider[]> p = Arrays.asList(new FormatConfigProvider[][] {
            {new DefaultConfigProvider()},
            {new IndentTypeConfigProvider()},
            {new RemoveTrailingWhitespaceConfigProvider()},
            {new AddWhitespaceAfterOpConfigProvider()},
            {new AddWhitespaceBeforeOpConfigProvider()},
            {new AddSpacesForTabsConfigProvider()},
            {new IndentSizeConfigProvider()},
            {new IndentTypeTabConfigProvider()},
        });
        return p.stream()::iterator;
    }

    private final FormatConfigProvider args;

    public FormatterTest(FormatConfigProvider args) {
        this.args = args;
    }

    @Test
    public void TestFormatterParams() throws IOException, URISyntaxException, FormatterException {
        FileFormatter fileform = new FileFormatter(args.getOldFile(), 0,
                args.getOldFile().length(), args.getConfig(), false);
        Assert.assertEquals(
                args.getClass().getSimpleName() + ": Formatted files are different. ",
                args.getNewFile(), fileform.formatText());
    }
}

interface FormatConfigProvider {
    String getOldFile() throws IOException, URISyntaxException;
    String getNewFile() throws IOException, URISyntaxException;

    void fillConfig(FormatConfiguration config);

    default FormatConfiguration getConfig() {
        FormatConfiguration config = new FormatConfiguration();
        fillConfig(config);
        return config;
    }

    default String getFileContent(String fileName) throws IOException, URISyntaxException {
        return new String(Files.readAllBytes(ApgdiffUtils.getFileFromOsgiRes(
                FormatterTest.class.getResource(fileName)).toPath()),
                StandardCharsets.UTF_8);
    }
}

/**
Testing default parameteres
 */
class DefaultConfigProvider implements FormatConfigProvider {

    @Override
    public String getNewFile() throws IOException, URISyntaxException {
        return getFileContent("new_Default_config.sql");
    }

    @Override
    public String getOldFile() throws IOException, URISyntaxException {
        return getFileContent("old_Default_config.sql");
    }

    @Override
    public void fillConfig(FormatConfiguration config) {
        config.setAddWhitespaceAfterOp(true);
        config.setAddWhitespaceBeforeOp(true);
        config.setIndentSize(2);
        config.setIndentType(IndentType.WHITESPACE);
        config.setRemoveTrailingWhitespace(true);
        config.setSpacesForTabs(2);
    }
}

/**
Testing setIndentType(IndentType.Tab)
 */
class IndentTypeConfigProvider implements FormatConfigProvider {

    @Override
    public String getOldFile() throws IOException, URISyntaxException {
        return getFileContent("old.sql" );
    }

    @Override
    public String getNewFile() throws IOException, URISyntaxException {
        return getFileContent("new_indent_type.sql");
    }
    @Override
    public void fillConfig(FormatConfiguration config) {
        config.setIndentType(IndentType.TAB);
    }
}

/**
 Testing RemoveTrailingWhitespace option
 */
class RemoveTrailingWhitespaceConfigProvider implements FormatConfigProvider {

    @Override
    public String getOldFile() throws IOException, URISyntaxException {
        return getFileContent("old_RemoveTrailingWhitespace.sql");
    }

    @Override
    public String getNewFile() throws IOException, URISyntaxException {
        return getFileContent("new_RemoveTrailingWhitespace.sql");
    }

    @Override
    public void fillConfig(FormatConfiguration config) {
        config.setRemoveTrailingWhitespace(true);
    }
}

/**
Testing AddWhitespaceAfterOp option
 */
class AddWhitespaceAfterOpConfigProvider implements FormatConfigProvider {

    @Override
    public String getOldFile() throws IOException, URISyntaxException {
        return getFileContent("old_AddWhitespaceOp.sql");
    }

    @Override
    public String getNewFile() throws IOException, URISyntaxException {
        return getFileContent("new_AddWhitespaceAfterOp.sql");
    }

    @Override
    public void fillConfig(FormatConfiguration config) {
        config.setAddWhitespaceAfterOp(true);
    }
}

/**
Testing WhitespaceBeforeOp option
 */
class AddWhitespaceBeforeOpConfigProvider implements FormatConfigProvider {

    @Override
    public String getOldFile() throws IOException, URISyntaxException {
        return getFileContent("old_AddWhitespaceOp.sql");
    }
    @Override
    public String getNewFile() throws IOException, URISyntaxException {
        return getFileContent("new_AddWhitespaceBeforeOp.sql");
    }

    @Override
    public void fillConfig(FormatConfiguration config) {
        config.setAddWhitespaceBeforeOp(true);
    }
}

/**
Testing SpacesForTabs option
 */
class AddSpacesForTabsConfigProvider implements FormatConfigProvider {

    @Override
    public String getOldFile() throws IOException, URISyntaxException {
        return getFileContent("old_SpacesForTabs.sql");
    }
    @Override
    public String getNewFile() throws IOException, URISyntaxException {
        return getFileContent("new_SpacesForTabs.sql");
    }

    @Override
    public void fillConfig(FormatConfiguration config) {
        config.setSpacesForTabs(8);
    }
}

/**
Testing IndentSize option
 */
class IndentSizeConfigProvider implements FormatConfigProvider {

    @Override
    public String getOldFile() throws IOException, URISyntaxException {
        return getFileContent("old.sql");
    }
    @Override
    public String getNewFile() throws IOException, URISyntaxException {
        return getFileContent("new_IndentSize.sql");
    }

    @Override
    public void fillConfig(FormatConfiguration config) {
        config.setIndentType(IndentType.WHITESPACE);
        config.setIndentSize(8);
    }
}

/**
Testing IndentTypeTab option
 */
class IndentTypeTabConfigProvider implements FormatConfigProvider {

    @Override
    public String getOldFile() throws IOException, URISyntaxException {
        return getFileContent("old.sql");
    }
    @Override
    public String getNewFile() throws IOException, URISyntaxException {
        return getFileContent("new_IndentTypeTab.sql");
    }

    @Override
    public void fillConfig(FormatConfiguration config) {
        config.setIndentType(IndentType.TAB);
        config.setIndentSize(1);
    }
}