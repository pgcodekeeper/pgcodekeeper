package cz.startnet.utils.pgdiff.schema;

import java.util.Map;

public interface PgOptionContainer {
    void addOption(String key, String value);
    Map<String, String> getOptions();
}
