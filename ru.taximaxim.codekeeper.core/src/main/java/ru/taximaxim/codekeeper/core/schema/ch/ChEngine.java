/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.schema.ch;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.hashers.IHashable;
import ru.taximaxim.codekeeper.core.hashers.JavaHasher;

/**
 * Subclass when need to reset hashes
 * (like when setting hashed fields after adding the arg to its container).
 */
public final class ChEngine implements Serializable, IHashable {

    private static final long serialVersionUID = -2826863138724898463L;

    private String name;
    private String body;

    private String partitionBy;
    private String primaryKey;
    private String orderBy;
    private String sampleBy;
    // TODO with action, where or group by, maybe better someway split it and save
    // where and group by part separate. maybe Map<String, String> with keys: name,
    // expr, where, group by and etc. but we can have more then one expr with all
    // options. append counter for keys?
    private String ttl;
    private Map<String, String> options = new HashMap<>();

    public ChEngine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setPartitionBy(String partitionBy) {
        this.partitionBy = partitionBy;
    }

    public String getPartitionBy() {
        return partitionBy;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setSampleBy(String sampleBy) {
        this.sampleBy = sampleBy;
    }

    public String getSampleBy() {
        return sampleBy;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getTtl() {
        return ttl;
    }

    public void addOption(String option, String value) {
        options.put(option, value);
    }

    public void appendCreationSQL(StringBuilder sb) {
        // maybe better will be when engineBody be between parens
        sb.append("\nENGINE = ").append(name);
        if (body != null) {
            sb.append(" (").append(body).append(')');
        }
        if (partitionBy != null) {
            sb.append("\nPARTITION BY ").append(partitionBy);
        }
        if (primaryKey != null) {
            sb.append("\nPRIMARY KEY ").append(primaryKey);
        }
        if (orderBy != null) {
            sb.append("\nORDER BY ").append(orderBy);
        }
        if (sampleBy != null) {
            sb.append("\nSAMPLE BY ").append(sampleBy);
        }
        if (ttl != null) {
            sb.append("\nTTL ").append(ttl);
        }

        // it's must be every time? is important order by?
        if (!options.isEmpty()) {
            sb.append("\nSETTINGS ");
            // in DB stored not like Map. settings can be duplicate. example in table `primary`
            for (var option : options.entrySet()) {
                // in db stored in one line
                sb.append(option.getKey()).append(" = ").append(option.getValue()).append(",\n\t");
            }
            sb.setLength(sb.length() - 3);
        }
    }

    public static void appendAlterSQL(ChEngine engine, ChEngine newEngine) {
        // TODO add later
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof ChEngine) {
            final ChEngine engine = (ChEngine) obj;
            eq = Objects.equals(name, engine.getName())
                    && Objects.equals(body, engine.body)
                    && Objects.equals(partitionBy, engine.getPartitionBy())
                    && Objects.equals(primaryKey, engine.getPrimaryKey())
                    && Objects.equals(orderBy, engine.getOrderBy())
                    && Objects.equals(sampleBy, engine.getSampleBy())
                    && Objects.equals(ttl, engine.getTtl())
                    && Objects.equals(options, engine.options);
        }

        return eq;
    }

    @Override
    public int hashCode() {
        JavaHasher hasher = new JavaHasher();
        computeHash(hasher);
        return hasher.getResult();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(body);
        hasher.put(partitionBy);
        hasher.put(primaryKey);
        hasher.put(orderBy);
        hasher.put(sampleBy);
        hasher.put(ttl);
        hasher.put(options);
    }

    public static boolean isAlterable(ChEngine engine, ChEngine newEngine) {
        if (Objects.equals(engine, newEngine)) {
            return true;
        }
        if (engine == null || newEngine == null) {
            return false;
        }

        return Objects.equals(engine.name, newEngine.name)
                && Objects.equals(engine.body, newEngine.body);
    }

}
