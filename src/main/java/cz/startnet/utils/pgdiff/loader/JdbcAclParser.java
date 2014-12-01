package cz.startnet.utils.pgdiff.loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Parser for aclItem arrays
 * 
 * @author ryabinin_av
 */
public class JdbcAclParser {
    private final String ACL_ASSIGNMENT_SIGN = "=";
    
    public enum PrivilegeTypes {
        a("INSERT"), r("SELECT"), w("UPDATE"), d("DELETE"), D("TRUNCATE"), x("REFERENCES"), 
        t("TRIGGER"), X("EXECUTE"), U("USAGE"), C("CREATE"), T("CREATE_TEMP"), c("CONNECT");
        private String privilegeType;

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
    public ArrayList<Privilege> parse(String aclArrayAsString, int maxTypes, String order, String owner){
        ArrayList<Privilege> privileges = new ArrayList<Privilege>();
        
        // skip "empty" acl strings, such as "{}"
        if (aclArrayAsString.length() < 3){
            return privileges;
        }
        
        ArrayList<String> acls = new ArrayList<String>(
                Arrays.asList(aclArrayAsString.replaceAll("[{}]", "").split(Pattern.quote(","))));
        
        // move owner's grants to front
        for (String s : acls){
            if (s.startsWith(owner + ACL_ASSIGNMENT_SIGN)){
                acls.remove(s);
                acls.add(0, s);
                break;
            }
        }
        
        for(String s : acls){
            int indexPos = s.indexOf("/");
            int assignmentPos = s.indexOf(ACL_ASSIGNMENT_SIGN);
            String grantee = PgDiffUtils.getQuotedName(s.substring(0, assignmentPos));
            if (grantee.isEmpty()){
                grantee = "PUBLIC";
            }
            String grantor = s.substring(indexPos + 1, s.length());
            
            String grantsString = s.substring(assignmentPos + 1, indexPos);
            
            // reorder chars according to order, split to two lists based on WITH GRANT OPTION
            List<Character> grantTypeCharsWithoutGo = new ArrayList<Character>(grantsString.length());
            List<Character> grantTypeCharsWithGo = new ArrayList<Character>(grantsString.length());
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
                privileges.add(new Privilege(grantee, new ArrayList<String>(Arrays.asList("ALL")), 
                        false, false));
                
            }else if (grantTypeCharsWithGo.size() == maxTypes){
                privileges.add(new Privilege(grantee, new ArrayList<String>(Arrays.asList("ALL")), 
                        true, grantee.equals(owner) && grantor.equals(owner)));
                
            }else if (grantTypeCharsWithoutGo.size() < maxTypes && grantTypeCharsWithGo.size() < maxTypes){
                ArrayList<String> grantTypesParsed = new ArrayList<String>();
                
                // add all grants without grant option
                for(int i = 0; i < grantTypeCharsWithoutGo.size(); i++){
                    char c = grantTypeCharsWithoutGo.get(i);
                    grantTypesParsed.add(PrivilegeTypes.valueOf(String.valueOf(c)).toString());
                }
                if (!grantTypesParsed.isEmpty()){
                    privileges.add(new Privilege(grantee, grantTypesParsed, false, false));
                }

                grantTypesParsed = new ArrayList<String>();
                
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
}

class Privilege {
    String grantee;
    ArrayList<String> grantValues;
    boolean isGo;
    /**
     * Default value - if grantor = grantee = owner and isGo is true (WITH GRANT OPTION)
     */
    private boolean isDefault;
    
    public Privilege(String grantee, ArrayList<String> grantValues, boolean isOG, boolean isDefault) {
        this.grantee = grantee;
        this.grantValues = grantValues;
        this.isGo = isOG;
        this.isDefault = isDefault;
    }
    
    public boolean isDefaultGrant(){
        return this.isDefault;
    }
}
