package ru.taximaxim.codekeeper.ui.generators;

/**
 * An implementation of a PostgreSql data generator for unimplemented types.
 *
 * @since 3.11.5
 * @author galiev_mr
 */
public class CustomPgData extends PgData {

    @Override
    public String generateValue() {
        switch (generator) {
        case CONSTANT: return start;
        default: return null;
        }
    }

    @Override
    public int getMaxValues() {
        return 1;
    }

}
