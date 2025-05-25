class LargestOddNumber {
    public String largestOddNumber(String num) {
        for(int i=num.length()-1; i>=0;i--){
            if((num.charAt(i)-'0')%2==1){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
} 


 /**

 Time complexity=O(n^3) so Time limit exceeds
 String largest="";
        for(int i=0;i<num.length();i++){
            for(int j=i+1; j<=num.length();j++){
                String sub=num.substring(i, j);
                if((sub.charAt(sub.length()-1)-'0')%2==1){
                    if(sub.length()>largest.length()){
                        largest=sub;
                    }
                }
            }
        }
        return largest;
  */