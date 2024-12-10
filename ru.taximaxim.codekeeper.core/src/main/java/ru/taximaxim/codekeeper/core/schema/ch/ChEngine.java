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

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.hashers.IHashable;
import ru.taximaxim.codekeeper.core.hashers.JavaHasher;
import ru.taximaxim.codekeeper.core.script.SQLScript;

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

        if (!options.isEmpty()) {
            sb.append("\nSETTINGS ");
            for (var option : options.entrySet()) {
                sb.append(option.getKey()).append(" = ").append(option.getValue()).append(",\n\t");
            }
            sb.setLength(sb.length() - 3);
        }
    }

    public void appendAlterSQL(ChEngine newEngine, String prefix, SQLScript script) {
        compareSampleBy(newEngine.sampleBy, prefix, script);
        compareTtl(newEngine.ttl, prefix, script);
        compareOptions(newEngine.options, prefix, script);
    }

    private void compareSampleBy(String newSampleBy, String prefix, SQLScript script) {
        if (Objects.equals(sampleBy, newSampleBy)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (newSampleBy == null) {
            sb.append(prefix);
            sb.append("\n\tREMOVE SAMPLE BY");
        } else {
            sb.append(prefix);
            sb.append("\n\tMODIFY SAMPLE BY ").append(newSampleBy);
        }
        script.addStatement(sb);
    }

    private void compareTtl(String newTtl, String prefix, SQLScript script) {
        if (Objects.equals(ttl, newTtl)) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        if (newTtl == null) {
            sb.append("\n\tREMOVE TTL");
        } else {
            sb.append("\n\tMODIFY TTL ").append(newTtl);
        }
        script.addStatement(sb);
    }

    private void compareOptions(Map<String, String> newOptions, String prefix, SQLScript script) {
        if (options.equals(newOptions)) {
            return;
        }

        Set<String> resetOptions = new HashSet<>();
        Map<String, String> modifyOptions = new HashMap<>();

        String newValue;
        for (String option : options.keySet()) {
            // added to reset if in new condition havn't this option
            if (!newOptions.containsKey(option)) {
                resetOptions.add(option);
                continue;
            }

            // add to modify if options have different values
            newValue = newOptions.get(option);
            if (!Objects.equals(newValue, options.get(option))) {
                modifyOptions.put(option, newValue);
            }
        }

        // add to modify if old condition havn't this option
        for (String key : newOptions.keySet()) {
            if (!options.containsKey(key)) {
                modifyOptions.put(key, newOptions.get(key));
            }
        }

        appendAlterOptions(resetOptions, modifyOptions, prefix, script);
    }

    private void appendAlterOptions(Set<String> resetOptions, Map<String, String> modifyOptions, String prefix,
            SQLScript script) {
        if (!resetOptions.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(prefix).append("\n\tRESET SETTING");
            for(String key : resetOptions) {
                sb.append(' ').append(key).append(',');
            }
            sb.setLength(sb.length() - 1);
            script.addStatement(sb);
        }

        if (modifyOptions.isEmpty()) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append("\n\tMODIFY SETTING");
        for (Entry<String, String> option : modifyOptions.entrySet()) {
            sb.append(' ').append(option.getKey()).append('=').append(option.getValue()).append(',');
        }
        sb.setLength(sb.length() - 1);
        script.addStatement(sb);
    }

    public boolean containsOption(String key) {
        return options.containsKey(key);
    }

    public boolean isModifybleSampleBy(String newSampleBy) {
        return !Objects.equals(sampleBy, newSampleBy) && (newSampleBy == null || sampleBy == null);
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
        hasher.put(primaryKey);
        hasher.put(orderBy);
        hasher.put(body);
        hasher.put(partitionBy);
        hasher.put(sampleBy);
        hasher.put(ttl);
        hasher.put(options);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof final ChEngine engine && compareUnalterable(engine)
                && Objects.equals(sampleBy, engine.getSampleBy())
                && Objects.equals(ttl, engine.getTtl())
                && Objects.equals(options, engine.options);
    }

    public boolean compareUnalterable(ChEngine newEngine) {
        return Objects.equals(name, newEngine.getName())
                && Objects.equals(primaryKey, newEngine.getPrimaryKey())
                && Objects.equals(orderBy, newEngine.getOrderBy())
                && Objects.equals(body, newEngine.body)
                && Objects.equals(partitionBy, newEngine.getPartitionBy());
    }
}
