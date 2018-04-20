package cz.startnet.utils.pgdiff.schema.system;

/**
 * Indicates what contexts the cast can be invoked in.
 */
public enum CastContext {
    /**
     * explicit cast (using CAST or :: syntax)
     */
    EXPLICIT,
    /**
     * used implicitly in assignment to a target column, as well as explicitly
     */
    ASSIGNMENT,
    /**
     * used implicitly in expressions, as well as the other cases
     */
    IMPLICIT;
}
