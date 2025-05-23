class NumberOfSustringContainingAllThree {
    public int numberOfSubstrings(String s) {
        if(s.length()==0 || s.length()==1) return s.length();
        int count=0, l=0, r=0;
        int hash[]={-1, -1, -1};
        while(r<s.length()){
            hash[s.charAt(r)-'a']=r;
            if(hash[0]!=-1 && hash[1]!=-1 && hash[2]!=-1){
                count+=1+(Math.min(hash[0], Math.min(hash[1], hash[2])));
            }
            r++;
        }
        return count;
    }
}

/**
Time Limit Exceeded
35 / 54 testcases passed
public int numberOfSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            int hash[]=new int[3];
            for(int j=i;j<s.length();j++){
                hash[s.charAt(j)-'a']=1;
                if(hash[0]+hash[1]+hash[2]==3){
                    count++;
                }
            }
        }
        return count;
    }
 */