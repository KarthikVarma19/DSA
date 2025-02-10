class Solution {
    public String clearDigits(String s) {
        char charArray[] = s.toCharArray();
        int curPointer = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = charArray[i];
            if(Character.isDigit(ch)){
                curPointer = Math.max(0, curPointer-1);
            }else{
                charArray[curPointer++] = ch;
            }
        }
        return new String(charArray, 0, curPointer);
    }
}