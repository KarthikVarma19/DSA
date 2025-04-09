class Solution {
    public int myAtoi(String s) {
        // Remove WhiteSpaces
        s = s.trim();
        // if s is empty return 0
        if(s.isEmpty()){
            return 0;
        }
        int i = 0; 
        // assuming sign is positive
        int sign = 1;
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            sign = (s.charAt(i) == '-')?-1:1;
            i++;
        }

        int n = s.length();
        long num = 0;
        while(i < n && Character.isDigit(s.charAt(i)) == true){
            num = (num * 10) + (s.charAt(i)-'0');
            i++;
            if((sign*num) > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if((sign*num) < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int)num*sign;
    }
}