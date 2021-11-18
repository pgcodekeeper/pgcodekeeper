package cz.startnet.utils.pgdiff.formatter;

enum IndentDirection {
    /**
     * First token in new block
     */
    BLOCK_START,
    /**
     * Last token in block
     */
    BLOCK_STOP,
    /**
     * New line in block
     */
    BLOCK_LINE,
    /**
     * Last token in this and parent block
     * Example:
     *  EXCEPTION
     *    WHEN x THEN
     *      begin end;
     * end closes both its block and the WHEN block
     */
    REDUCE_TWICE,
}