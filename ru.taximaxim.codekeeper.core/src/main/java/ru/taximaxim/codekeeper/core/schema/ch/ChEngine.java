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
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

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

    public static void appendAlterSQL(StringBuilder sb, ChEngine oldEngine, ChEngine newEngine,
            AtomicBoolean isNeedDepcies, String prefix) {
        compareSampleBy(sb, oldEngine.getSampleBy(), newEngine.getSampleBy(), isNeedDepcies, prefix);
        if (isNeedDepcies.get()) {
            return;
        }
        compareTtl(sb, oldEngine.getTtl(), newEngine.getTtl(), prefix);
        compareOptions(sb, oldEngine.options, newEngine.options, prefix);
    }

    private static void compareSampleBy(StringBuilder sb, String oldSampleBy, String newSampleBy,
            AtomicBoolean isNeedDepcies, String prefix) {
        if (Objects.equals(oldSampleBy, newSampleBy)) {
            return;
        }
        if (newSampleBy == null) {
            sb.append(prefix);
            sb.append("\n\tREMOVE SAMPLE BY");
        } else if (oldSampleBy == null) {
            sb.append(prefix);
            sb.append("\n\tMODIFY SAMPLE BY ").append(newSampleBy);
        } else {
            isNeedDepcies.set(true);
            return;
        }
        sb.append(';');
    }

    private static void compareTtl(StringBuilder sb, String oldTtl, String newTtl, String prefix) {
        if (Objects.equals(oldTtl, newTtl)) {
            return;
        }
        sb.append(prefix);
        if (newTtl == null) {
            sb.append("\n\tREMOVE TTL");
        } else {
            sb.append("\n\tMODIFY TTL ").append(newTtl);
        }
        sb.append(';');
    }

    private static void compareOptions(StringBuilder sb, Map<String, String> oldOptions, Map<String, String> newOptions,
            String prefix) {
        if (oldOptions.equals(newOptions)) {
            return;
        }
        
        Set<String> resetOptions = new HashSet<>();
        Map<String, String> modifyOptions = new HashMap<>();
        
        String newValue;
        for (String option : oldOptions.keySet()) {
            // added to reset if in new condition havn't this option
            if (!newOptions.containsKey(option)) {
                resetOptions.add(option);
                continue;
            }

            // add to modify if options have different values
            newValue = newOptions.get(option);
            if (!Objects.equals(newValue, oldOptions.get(option))) {
                modifyOptions.put(option, newValue);
            }
        }

        // add to modify if old condition havn't this option
        for (String key : newOptions.keySet()) {
            if (!oldOptions.containsKey(key)) {
                modifyOptions.put(key, newOptions.get(key));
            }
        }

        appendAlterOptions(sb, resetOptions, modifyOptions, prefix);
    }

    private static void appendAlterOptions(StringBuilder sb, Set<String> resetOptions,
            Map<String, String> modifyOptions, String prefix) {
        if (!resetOptions.isEmpty()) {
            sb.append(prefix)
              .append("\n\tRESET SETTING");
            for(String key : resetOptions) {
                sb.append(' ').append(key).append(',');
            }
            sb.setLength(sb.length() - 1);
            sb.append(';');
        }
        
        if (modifyOptions.isEmpty()) {
            return;
        }
        
        sb.append(prefix)
          .append("\n\tMODIFY SETTING");
        for (Entry<String, String> option : modifyOptions.entrySet()) {
            sb.append(' ').append(option.getKey()).append('=').append(option.getValue()).append(',');
        }
        sb.setLength(sb.length() - 1);
        sb.append(';');
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

    public static boolean compareUnalterable(ChEngine oldEngine, ChEngine newEngine) {
        return !Objects.equals(oldEngine.getPrimaryKey(), newEngine.getPrimaryKey())
                || !Objects.equals(oldEngine.getOrderBy(), newEngine.getOrderBy())
                || !Objects.equals(oldEngine.getName(), newEngine.getName())
                || !Objects.equals(oldEngine.body, newEngine.body)
                // TODO remove it when it will be done
                || !Objects.equals(oldEngine.getPartitionBy(), newEngine.getPartitionBy());
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
