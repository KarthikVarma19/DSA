class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> st = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(st.contains(ch)){
                return ch;
            }
            st.add(ch);
        }
        return ' ';
    }
}