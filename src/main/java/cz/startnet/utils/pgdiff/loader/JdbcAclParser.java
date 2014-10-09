package cz.startnet.utils.pgdiff.loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Parser for aclItem arrays
 * 
 * @author ryabinin_av
 */
public class JdbcAclParser {
    
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
     * Receives AclItem[] as String and parses it into map, where keys are 
     * grantee names and valuses are compiled privileges for grantee. If all 
     * available privilege bits are present in AclItem, then valuse is 
     * returned as "ALL".
     * <br><br>
     * Example:<br>
     * <code>{grantee1=arwdDxt/maindb,grantee2=arwDxt/maindb}</code>
     * and maxTypes = 7 should result in<br>
     * granteeName1 = ALL<br>
     * granteeName2 = INSERT,SELECT,UPDATE,TRUNCATE,REFERENCES,TRIGGER
     * 
     * @param aclArrayAsString  String representation of AclItem array
     * @param maxTypes  Maximum available privilege bits for target DB object
     * @param object 
     * @param owner     Owner name (owner's privileges go first)
     * @return
     */
    public LinkedHashMap <String, String> parse(String aclArrayAsString, int maxTypes, String order, String owner){
        LinkedHashMap<String, String> privileges = new LinkedHashMap<String, String>();
        ArrayList<String>  acls = new ArrayList<String>(Arrays.asList(aclArrayAsString.replace("{", "").replace("}", "").split(",")));
        
        // move owner's grants to front
        for (String s : acls){
            if (s.startsWith(owner)){
                acls.remove(s);
                acls.add(0, s);
                break;
            }
        }
        
        for(String s : acls){
            String aclExpression = s.substring(0, s.indexOf("/"));
            int indexOfEqualsSign = aclExpression.indexOf("=");
            String grantee = aclExpression.substring(0, indexOfEqualsSign);
            
            // reorder chars according to order
            String grantsString = aclExpression.substring(indexOfEqualsSign + 1);
            List<Character> grantTypeChars = new ArrayList<Character>(grantsString.length());
            for(int i = 0; i < order.length(); i++){
                if (grantsString.contains(String.valueOf(order.charAt(i)))){
                    grantTypeChars.add(order.charAt(i));
                }
            }
            
            StringBuilder grantTypesParsed = new StringBuilder();
            if (grantTypeChars.size() < maxTypes){
                for(int i = 0; i < grantTypeChars.size(); i++){
                    char c = grantTypeChars.get(i);
                    grantTypesParsed.append(PrivilegeTypes.valueOf(String.valueOf(c)));
                    if (i < grantTypeChars.size() - 1){
                        grantTypesParsed.append(",");
                    }
                }                
            }else{
                grantTypesParsed.append("ALL");
            }
            
            privileges.put(grantee.isEmpty() ? "PUBLIC" : PgDiffUtils.getQuotedName(grantee), 
                    grantTypesParsed.toString());
        }
        return privileges;
    }
}
