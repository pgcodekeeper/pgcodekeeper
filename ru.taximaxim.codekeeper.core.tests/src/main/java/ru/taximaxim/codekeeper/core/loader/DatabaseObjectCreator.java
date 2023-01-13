package ru.taximaxim.codekeeper.core.loader;


import ru.taximaxim.codekeeper.core.schema.PgDatabase;

/**
 * An abstract 'factory' that creates 'artificial' PgDatabase objects for specific test-cases.
 *
 * @author Alexander Levsha
 */
interface DatabaseObjectCreator {

    /**
     * The method makes up a PgDatabase object specific to the test needs.
     */
    PgDatabase getDatabase();
}