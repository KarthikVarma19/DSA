class Solution {
    public boolean buddyStrings(String s, String goal) {
        int l1 = s.length();
        int l2 = goal.length();
        if(l1 != l2) return false;
        if(s.equals(goal)){
            Set<Character> st = new HashSet<Character>();
            for(char c: s.toCharArray()) st.add(c);
            return st.size() < s.length();
        }
        int firstIndex = 0;
        int secondIndex = 0;
        int diffs = 0;
        for(int i = 0; i < l1; i++){
            if(s.charAt(i) != goal.charAt(i)){
                diffs++;
                if(diffs > 2) return false;
                else if(diffs == 1){
                    firstIndex = i;
                }
                else{
                    secondIndex = i;
                }
            }
        }
        return firstIndex != secondIndex && (s.charAt(firstIndex) == goal.charAt(secondIndex) 
                &&
                s.charAt(secondIndex) == goal.charAt(firstIndex));
    }
}