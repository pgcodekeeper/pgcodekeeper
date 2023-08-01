/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.utils.Pair;

/**
 * Stores sequence information.
 */
public abstract class AbstractSequence extends PgStatementWithSearchPath implements IRelation {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractSequence.class);

    protected static final String BIGINT = "bigint";

    private static final List<Pair<String, String>> relationColumns = List.of(
                    new Pair<>("sequence_name", "name"), new Pair<>("last_value", BIGINT),
                    new Pair<>("start_value", BIGINT), new Pair<>("increment_by", BIGINT),
                    new Pair<>("max_value", BIGINT), new Pair<>("min_value", BIGINT),
                    new Pair<>("cache_value", BIGINT), new Pair<>("log_cnt", BIGINT),
                    new Pair<>("is_cycled", "boolean"), new Pair<>("is_called", "boolean"));

    private String cache;
    protected String increment;
    protected String maxValue;
    protected String minValue;
    private String startWith;
    private boolean cycle;
    private String dataType = BIGINT;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.SEQUENCE;
    }

    protected AbstractSequence(String name) {
        super(name);
    }

    public void setCache(final String cache) {
        this.cache = cache;
        resetHash();
    }

    public String getCache() {
        return cache;
    }

    @Override
    public Stream<Pair<String, String>> getRelationColumns() {
        return relationColumns.stream();
    }

    public void setCycle(final boolean cycle) {
        this.cycle = cycle;
        resetHash();
    }

    public boolean isCycle() {
        return cycle;
    }

    public abstract void setMinMaxInc(long inc, Long max, Long min, String dataType,
            long presicion);

    protected long getBoundaryTypeVal(String type, boolean needMaxVal, long presicion) {
        switch (type) {
        case "tinyint":
            return needMaxVal ? 255 : 0;
        case "smallint":
            return needMaxVal ? Short.MAX_VALUE : Short.MIN_VALUE;
        case "int":
        case "integer":
            return needMaxVal ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        case "numeric":
        case "decimal":
            // It used for MS SQL.
            long boundaryTypeVal = (long) (Math.pow(10, presicion)) - 1;
            return needMaxVal ? boundaryTypeVal : - boundaryTypeVal;
        default:
            LOG.warn("Unsupported sequence type: {}", type);
            // $FALL-THROUGH$
        case BIGINT:
            return needMaxVal ? Long.MAX_VALUE : Long.MIN_VALUE;
        }
    }

    public String getIncrement() {
        return increment;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setStartWith(final String startWith) {
        this.startWith = startWith;
        resetHash();
    }

    public String getStartWith() {
        return startWith;
    }

    public void setDataType(final String dataType) {
        this.dataType = dataType;
        resetHash();
    }

    public String getDataType() {
        return dataType;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractSequence && super.compare(obj)) {
            AbstractSequence seq = (AbstractSequence) obj;
            return cycle == seq.isCycle()
                    && Objects.equals(increment, seq.getIncrement())
                    && Objects.equals(minValue, seq.getMinValue())
                    && Objects.equals(maxValue, seq.getMaxValue())
                    && Objects.equals(startWith, seq.getStartWith())
                    && Objects.equals(cache, seq.getCache())
                    && Objects.equals(dataType, seq.getDataType());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(cache);
        hasher.put(cycle);
        hasher.put(increment);
        hasher.put(maxValue);
        hasher.put(minValue);
        hasher.put(startWith);
        hasher.put(dataType);
    }

    @Override
    public AbstractSequence shallowCopy() {
        AbstractSequence sequenceDst = getSequenceCopy();
        copyBaseFields(sequenceDst);
        sequenceDst.setCache(getCache());
        sequenceDst.setCycle(isCycle());
        sequenceDst.increment = getIncrement();
        sequenceDst.maxValue = getMaxValue();
        sequenceDst.minValue = getMinValue();
        sequenceDst.dataType = getDataType();
        sequenceDst.setStartWith(getStartWith());
        return sequenceDst;
    }

    protected abstract AbstractSequence getSequenceCopy();

    public abstract void fillSequenceBody(StringBuilder sbSQL);

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent();
    }
}
