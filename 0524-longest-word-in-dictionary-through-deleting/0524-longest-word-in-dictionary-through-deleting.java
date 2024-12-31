class Solution {
    public String findLongestWord(String s, List<String> dict) {
        Collections.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(a.length() == b.length()){
                    return a.compareTo(b);
                }
                return b.length()-a.length();
            }
        });
        int maxLen = 0;
        for(int i=0;i<dict.size();i++){
            String word = dict.get(i);
            if(checkPossibility(word,s)){
                return word;
            }
        }
        return "";
    }
    public boolean checkPossibility(String word, String s){
        int i = 0, j = 0;
        while(i<word.length() && j<s.length()){
            if(word.charAt(i) == s.charAt(j)){
                i++;
            }
            j++;
        }
        return i==word.length();
    }
}