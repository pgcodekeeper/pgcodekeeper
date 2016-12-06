package cz.startnet.utils.pgdiff.loader.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Parser for aclItem arrays
 *
 * @author ryabinin_av
 */
final class JdbcAclParser {

    public enum PrivilegeTypes {
        // SONAR-OFF
        a("INSERT"), r("SELECT"), w("UPDATE"), d("DELETE"), D("TRUNCATE"), x("REFERENCES"),
        t("TRIGGER"), X("EXECUTE"), U("USAGE"), C("CREATE"), T("CREATE_TEMP"), c("CONNECT");
        // SONAR-ON
        private final String privilegeType;

        PrivilegeTypes(String privilegeType) {
            this.privilegeType = privilegeType;
        }

        @Override
        public String toString() {
            return privilegeType;
        }
    }

    /**
     * Receives AclItem[] as String and parses it to list of Privilege objects.
     *
     * @param aclArrayAsString  String representation of AclItem array
     * @param maxTypes  Maximum available privilege bits for target DB object
     * @param order     Target order for privileges inside the privilege string
     *                  (not a result list sorting)
     * @param owner     Owner name (owner's privileges go first)
     * @return
     */
    public static List<Privilege> parse(String aclArrayAsString, int maxTypes, String order, String owner){
        List<Privilege> privileges = new ArrayList<>();

        // skip "empty" acl strings, such as "{}"
        if (aclArrayAsString.length() <= "{}".length()){
            return privileges;
        }

        ArrayList<String> acls = new ArrayList<>(
                Arrays.asList(aclArrayAsString.replaceAll("[{}]", "").split(",")));

        // move owner's grants to front
        for (String s : acls){
            if (s.startsWith(owner + '=')){
                acls.remove(s);
                acls.add(0, s);
                break;
            }
        }

        for(String s : acls){
            int indexPos = s.indexOf('/');
            int assignmentPos = s.indexOf('=');
            String grantee = PgDiffUtils.getQuotedName(s.substring(0, assignmentPos));
            if (grantee.isEmpty()){
                grantee = "PUBLIC";
            }
            String grantor = s.substring(indexPos + 1, s.length());

            String grantsString = s.substring(assignmentPos + 1, indexPos);

            // reorder chars according to order, split to two lists based on WITH GRANT OPTION
            List<Character> grantTypeCharsWithoutGo = new ArrayList<>(grantsString.length());
            List<Character> grantTypeCharsWithGo = new ArrayList<>(grantsString.length());
            for(int i = 0; i < order.length(); i++){
                int index = grantsString.indexOf(String.valueOf(order.charAt(i)));
                if (index > -1){
                    if (grantsString.length() > index + 1 && grantsString.charAt(index + 1) == '*'){
                        grantTypeCharsWithGo.add(order.charAt(i));
                    }else{
                        grantTypeCharsWithoutGo.add(order.charAt(i));
                    }
                }
            }

            if (grantTypeCharsWithoutGo.size() == maxTypes){
                privileges.add(new Privilege(grantee, Arrays.asList("ALL"),
                        false, false));

            }else if (grantTypeCharsWithGo.size() == maxTypes){
                privileges.add(new Privilege(grantee, Arrays.asList("ALL"),
                        true, grantee.equals(owner) && grantor.equals(owner)));

            }else if (grantTypeCharsWithoutGo.size() < maxTypes && grantTypeCharsWithGo.size() < maxTypes){
                List<String> grantTypesParsed = new ArrayList<>();

                // add all grants without grant option
                for(int i = 0; i < grantTypeCharsWithoutGo.size(); i++){
                    char c = grantTypeCharsWithoutGo.get(i);
                    grantTypesParsed.add(PrivilegeTypes.valueOf(String.valueOf(c)).toString());
                }
                if (!grantTypesParsed.isEmpty()){
                    privileges.add(new Privilege(grantee, grantTypesParsed, false, false));
                }

                grantTypesParsed = new ArrayList<>();

                // add all grants with grant option
                for(int i = 0; i < grantTypeCharsWithGo.size(); i++){
                    char c = grantTypeCharsWithGo.get(i);
                    grantTypesParsed.add(PrivilegeTypes.valueOf(String.valueOf(c)).toString());
                }
                if (!grantTypesParsed.isEmpty()){
                    privileges.add(new Privilege(grantee, grantTypesParsed, true, false));
                }
            }
        }
        return privileges;
    }

    private JdbcAclParser() {
    }
}

class Privilege {
    final String grantee;
    final List<String> grantValues;
    final boolean isGO;
    /**
     * Default value - if grantor = grantee = owner and isGO is true (WITH GRANT OPTION)
     */
    final boolean isDefault;

    public Privilege(String grantee, List<String> grantValues, boolean isGO, boolean isDefault) {
        this.grantee = grantee;
        this.grantValues = grantValues;
        this.isGO = isGO;
        this.isDefault = isDefault;
    }
}
