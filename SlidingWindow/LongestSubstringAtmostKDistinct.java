import java.util.Set;
import java.util.HashSet;
class LongestSubstringAtmostKDistinct{
    private static int longestAtmostK(String s, int k){
        int l=0, r=0, maxlen=0;
        return maxlen;
    }
    public static void main(String[] args){
        String s="aaaebbccd";
        int k=2;
        int res=longestAtmostK(s, k);
        System.out.println("Longest Substring atmost K distinct characters: "+res);
    }
}
/**
 * TC=~O(n*n) SC=O(3)
 * private static int longestAtmostK(String s, int k){
        int maxlen=0;
        for(int i=0;i<s.length();i++){
            Set<Character> set=new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(!set.contains(s.charAt(j)))set.add(s.charAt(j));
                if(set.size()>k) break;
                if(set.size()<=k){
                    maxlen=Math.max(maxlen, j-i+1);
                }
            }
        }
        return maxlen;
    }
 */