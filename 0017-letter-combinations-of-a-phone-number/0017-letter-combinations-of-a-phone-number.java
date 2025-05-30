class Solution {
    public List<String> letterCombinations(String digits) {
         Map<Character,String> map = getMap();
         List<String> ans = new ArrayList<>();
         if(digits == null || digits.length() == 0){
            return ans;
         }
         backtrack(digits, 0, new StringBuilder(), ans, map);
         return ans;
    }
    public void backtrack(String digits, int idx, StringBuilder comb, List<String> ans, Map<Character,String> map){
        if(idx == digits.length()){
            ans.add(comb.toString());
            return;
        }
        String letters = map.get(digits.charAt(idx));
        for(char letter: letters.toCharArray()){
            comb.append(letter);
            backtrack(digits, idx+1, comb, ans, map);
            comb.deleteCharAt(comb.length()-1);
        }

    }

    public Map<Character,String> getMap(){
        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz"); 
        return map;
    }
}