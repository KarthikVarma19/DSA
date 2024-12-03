class Solution {
    public String addSpaces(String s, int[] spaces) {
        int spaceIndex = 0;
        char[] result = new char[s.length() + spaces.length];
        int resultIndex = 0;
        for(int i=0;i<s.length();i++){
            if(spaceIndex<spaces.length && i == spaces[spaceIndex]){
                result[resultIndex++] = ' ';
                spaceIndex++;
            }
            result[resultIndex++] = s.charAt(i);
        }
        return new String(result);
   }
}