class ReverseWords {
    public String reverseWords(String s) {
       StringBuilder sb=new StringBuilder();
       String arr[]=s.split("\\s+");
       System.out.println(s.split(" "));
       for(int i=arr.length-1; i>=0; i--){
           sb.append(arr[i]);
           if(i!=0) sb.append(" ");
       }
       return sb.toString().trim();
    }
}