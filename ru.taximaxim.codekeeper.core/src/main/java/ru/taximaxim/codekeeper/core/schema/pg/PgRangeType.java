/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractType;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public final class PgRangeType extends AbstractType {

    private String subtype;
    private String subtypeOpClass;
    private String collation;
    private String canonical;
    private String subtypeDiff;
    private String multirange;

    public PgRangeType(String name) {
        super(name);
    }

    @Override
    protected void appendDef(StringBuilder sb) {
        // lowercase keywords follow pg_dump format here
        sb.append(" AS RANGE (")
        .append("\n\tsubtype = ").append(subtype);
        appendStringOption(sb, "subtype_opclass", subtypeOpClass);
        appendStringOption(sb, "collation", collation);
        appendStringOption(sb, "canonical", canonical);
        appendStringOption(sb, "subtype_diff", subtypeDiff);
        appendStringOption(sb, "multirange_type_name", multirange);
        sb.append("\n)");
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
        resetHash();
    }

    public String getSubtypeOpClass() {
        return subtypeOpClass;
    }

    public void setSubtypeOpClass(String subtypeOpClass) {
        this.subtypeOpClass = subtypeOpClass;
        resetHash();
    }

    public String getCollation() {
        return collation;
    }

    public void setCollation(String collation) {
        this.collation = collation;
        resetHash();
    }

    public String getCanonical() {
        return canonical;
    }

    public void setCanonical(String canonical) {
        this.canonical = canonical;
        resetHash();
    }

    public String getSubtypeDiff() {
        return subtypeDiff;
    }

    public void setSubtypeDiff(String subtypeDiff) {
        this.subtypeDiff = subtypeDiff;
        resetHash();
    }

    public String getMultirange() {
        return multirange;
    }

    public void setMultirange(String multirange) {
        this.multirange = multirange;
        resetHash();
    }

    @Override
    protected AbstractType getTypeCopy() {
        PgRangeType copy = new PgRangeType(getName());
        copy.setSubtype(getSubtype());
        copy.setSubtypeOpClass(getSubtypeOpClass());
        copy.setCollation(getCollation());
        copy.setCanonical(getCanonical());
        copy.setSubtypeDiff(getSubtypeDiff());
        copy.setMultirange(getMultirange());
        return copy;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgRangeType type && super.compare(type)) {
            return compareUnalterable(type);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(subtype);
        hasher.put(subtypeOpClass);
        hasher.put(collation);
        hasher.put(canonical);
        hasher.put(subtypeDiff);
        hasher.put(multirange);
    }

    @Override
    protected boolean compareUnalterable(AbstractType newType) {
        PgRangeType type = (PgRangeType) newType;
        return Objects.equals(subtype, type.getSubtype())
                && Objects.equals(subtypeOpClass, type.getSubtypeOpClass())
                && Objects.equals(collation, type.getCollation())
                && Objects.equals(canonical, type.getCanonical())
                && Objects.equals(subtypeDiff, type.getSubtypeDiff())
                && Objects.equals(multirange, type.getMultirange());
    }
}
