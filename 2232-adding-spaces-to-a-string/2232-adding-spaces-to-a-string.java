class Solution {
    public String addSpaces(String s, int[] spaces) {
        int spaceIndex = 0;
        StringBuilder result = new StringBuilder();
        result.ensureCapacity(s.length() + spaces.length);
        for(int i=0;i<s.length();i++){
            if(spaceIndex<spaces.length && i == spaces[spaceIndex]){
                result.append(" ");
                spaceIndex++;
            }
            result.append(s.charAt(i));
        }
        return result.toString();
   }
}