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
package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.PrivilegesParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.PrivilegesParser.PrivilegeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.PrivilegesParser.PrivilegesContext;

/**
 * Parser for aclItem arrays
 *
 * @author ryabinin_av
 */
final class JdbcPrivilege {

    enum PrivilegeTypes {

        INSERT('a'),
        SELECT('r'),
        UPDATE('w'),
        DELETE('d'),
        TRUNCATE('D'),
        REFERENCES('x'),
        TRIGGER('t'),
        EXECUTE('X'),
        USAGE('U'),
        CREATE('C'),
        CREATE_TEMP('T'),
        CONNECT('c'),
        MAINTAIN('m');

        private final char privilegeLetter;

        PrivilegeTypes(char privilegeLetter) {
            this.privilegeLetter = privilegeLetter;
        }

        static String valueOf(char letter) {
            for (PrivilegeTypes type : values()) {
                if (type.privilegeLetter == letter) {
                    return type.toString();
                }
            }

            throw new IllegalArgumentException(
                    "No enum constant " + PrivilegeTypes.class.getCanonicalName() + "." + letter);
        }
    }

    private final String grantee;
    private final List<String> grantValues;
    private final boolean isGO;
    /**
     * Default value - if grantor = grantee = owner and isGO is true (WITH GRANT OPTION)
     */
    private final boolean isDefault;

    private JdbcPrivilege(String grantee, List<String> grantValues, boolean isGO, boolean isDefault) {
        this.grantee = grantee;
        this.grantValues = grantValues;
        this.isGO = isGO;
        this.isDefault = isDefault;
    }

    public String getGrantee() {
        return grantee;
    }

    public List<String> getGrantValues() {
        return Collections.unmodifiableList(grantValues);
    }

    public boolean isGO() {
        return isGO;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public boolean isGrantAllToPublic() {
        return "PUBLIC".equals(grantee) && "ALL".equals(grantValues.get(0));
    }

    public String getGrantString(String column) {
        return grantValues.stream().collect(Collectors.joining(column + ',', "", column));
    }

    /**
     * Receives AclItem[] as String and parses it to list of Privilege objects.
     *
     * @param aclArrayAsString
     *            String representation of AclItem array
     * @param order
     *            Target order for privileges inside the privilege string (not a result list sorting)
     * @param owner
     *            Owner name (owner's privileges go first)
     * @return list of privilege
     */
    public static List<JdbcPrivilege> parse(String aclArrayAsString, String order, String owner) {
        List<JdbcPrivilege> privileges = new ArrayList<>();

        // skip "empty" acl strings, such as "{}"
        if (aclArrayAsString.length() <= "{}".length()) {
            return privileges;
        }

        PrivilegesContext ctx = AntlrParser.makeBasicParser(PrivilegesParser.class, aclArrayAsString, "jdbc privileges")
                .privileges();

        for (PrivilegeContext acl : ctx.acls) {
            String grantor;
            String grantee = "";
            if (acl.qgrantor != null) {
                if (acl.qname != null) {
                    grantee = acl.qname.getText();
                }
                grantor = acl.qgrantor.getText();
            } else {
                if (acl.name != null) {
                    grantee = acl.name.getText();
                }
                grantor = acl.grantor.getText();
            }

            String grantsString = acl.priv.getText();

            Consumer<JdbcPrivilege> adder = grantee.equals(owner) ? p -> privileges.add(0, p) : privileges::add;
            grantee = PgDiffUtils.getQuotedName(grantee);

            if (grantee.isEmpty()) {
                grantee = "PUBLIC";
            }

            // reorder chars according to order, split to two lists based on WITH GRANT OPTION
            List<Character> grantTypeCharsWithoutGo = new ArrayList<>(grantsString.length());
            List<Character> grantTypeCharsWithGo = new ArrayList<>(grantsString.length());
            for (int i = 0; i < order.length(); i++) {
                int index = grantsString.indexOf(String.valueOf(order.charAt(i)));
                if (index > -1) {
                    if (grantsString.length() > index + 1 && grantsString.charAt(index + 1) == '*') {
                        grantTypeCharsWithGo.add(order.charAt(i));
                    } else {
                        grantTypeCharsWithoutGo.add(order.charAt(i));
                    }
                }
            }

            int maxTypes = order.length();
            if (grantTypeCharsWithoutGo.size() == maxTypes) {
                adder.accept(new JdbcPrivilege(grantee, Arrays.asList("ALL"),
                        false, grantee.equals(owner) && grantor.equals(owner)));

            } else if (grantTypeCharsWithGo.size() == maxTypes) {
                adder.accept(new JdbcPrivilege(grantee, Arrays.asList("ALL"), true, false));

            } else if (grantTypeCharsWithoutGo.size() < maxTypes && grantTypeCharsWithGo.size() < maxTypes) {
                // add all grants without grant option
                addAllGrants(false, grantTypeCharsWithoutGo, grantee, adder);

                // add all grants with grant option
                addAllGrants(true, grantTypeCharsWithGo, grantee, adder);
            }
        }
        return privileges;
    }

    private static void addAllGrants(boolean isGO, List<Character> grantTypeChars,
            String grantee, Consumer<JdbcPrivilege> adder) {
        List<String> grantTypesParsed = new ArrayList<>();
        for (int i = 0; i < grantTypeChars.size(); i++) {
            char c = grantTypeChars.get(i);
            grantTypesParsed.add(PrivilegeTypes.valueOf(c));
        }
        if (!grantTypesParsed.isEmpty()) {
            adder.accept(new JdbcPrivilege(grantee, grantTypesParsed, isGO, false));
        }
    }
}
