import java.util.Map;
import java.util.HashMap;
class LongestSubstringWithoutRepeatingChars{
    private static int longestSubstring(String s){
        int hash[]=new int[256];
        for(int i=0;i<256;i++) hash[i]=-1;
        int l=0, r=0, maxlen=0;
        while(r<s.length()){
            char c=s.charAt(r);
            if(hash[c]!=-1){
                if(hash[c]>=l){
                    l=hash[c]+1;
                }
            }
            maxlen=Math.max(r-l+1,maxlen);
            hash[c]=r;
            r++;
        }
        return maxlen;
        /**
         * 
         * Map<Character, Integer> map=new HashMap<>();
        int l=0, r=0, maxlen=0;
        while(r<s.length()){
            char c=s.charAt(r);
            if(map.containsKey(c)){
                l=map.get(c)+1;
                map.put(c, r);
            }
            if(!map.containsKey(c)){
                map.put(c, r);
                maxlen=Math.max(maxlen, r-l+1);
            }
        }
        return maxlen;
         */
    }
    public static void main(String[] args){
        String s="cadbzabcd";
        int longest=longestSubstring(s);
        System.out.println("Longest substring length: "+longest);
    }
    
}

/**
 * private static int longestSubstring(String s){
        int max=0, slen=s.length();
        for(int i=0;i<slen;i++){
            int hash[]=new int[256];
            for(int j=i;j<slen;j++){
                char c=s.charAt(j); 
                //already present in hash array
                if(hash[c]!=0) break;
                hash[c]=1;
                max=Math.max(j-i+1, max);
            }
        }

        
        return max;
    }
 */

/**
 * private static int longestSubstring(String s){
        //already present in hash
        //TC=O(n)+O(n)=O(2n) SC=O(256)
        int l=0, r=0, maxlen=0, slen=s.length();
        int hash[]=new int[256];
        while(r<slen){
            char c=s.charAt(r);
            if(hash[c]!=0){
                while(hash[c]!=0){
                    if(hash[l]==hash[c]){
                        hash[c]=0;
                    }
                    l++;
                }
            }
            if(hash[c]==0){
                hash[c]=1;
                maxlen=Math.max(maxlen, r-l+1);
            }
            r++;
        }
        return maxlen;
    }
 */