class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}