class ValidPalindrome 
    private static boolean palindromeOrNot(String s, int left, int right){
        if(left>=right) return true;
        if(s.charAt(left)!=s.charAt(right)) return false;
        return palindromeOrNot(s, left+1, right-1);
    }
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))) sb.append(s.charAt(i));
        }
        String res=sb.toString();
        return palindromeOrNot(res, 0, res.length()-1);
    }
}