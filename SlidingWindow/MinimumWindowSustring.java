import java.util.Map;
import java.util.HashMap;
class MinimumWindowSustring{
    private static String minString(String s, String t){
        int minlength=Integer.MAX_VALUE;
        int startIndex=-1;
        for(int i=0;i<s.length();i++){
            int hash[]=new int[256];
            for(int j=0;j<t.length();j++){
                hash[t.charAt(j)]++;
            }
            int count=0;
            for(int j=i;j<s.length();j++){
                if(hash[s.charAt(j)]>0) count++;
                hash[s.charAt(j)]--;
                if(count==t.length()){
                    if(j-i+1<minlength){
                        minlength=j-i+1;
                        startIndex=i;
                    }
                    break;
                }
            }
        }
        if(startIndex==-1) return "";
        return s.substring(startIndex, startIndex+minlength);
    }
    public static void main(String[] args){
        String s="ddaaabbca", t="abc";
        String res=minString(s, t);
        System.out.println("Minimum substring in s containing all characters in t: "+res);
    }
}

/**
 * private static String minString(String s, String t){
        String res="";
        int minlength=Integer.MAX_VALUE, startIndex=-1;
        for(int i=0;i<s.length();i++){
            Map<Character, Integer> map=new HashMap<>();
            for(char c : t.toCharArray()){
                map.put(c, map.getOrDefault(c, 0)+1);
            }
            for(int j=i;j<s.length();j++){
                if(map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j), map.get(s.charAt(j))-1);
                    if(map.get(s.charAt(j))==0) map.remove(s.charAt(j));
                }
                if(map.size()==0){
                    if(minlength>j-i+1){
                        minlength=j-i+1;
                        startIndex=i;
                    }
                }
            }
        }
        return s.substring(startIndex, minlength);
    }
 * 
 */