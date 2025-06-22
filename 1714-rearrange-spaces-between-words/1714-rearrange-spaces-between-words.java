class Solution {
    public String reorderSpaces(String text) {
        int spaces = 0;
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == ' ') spaces++;
        }
        text = text.trim();
        String words[] = text.split("\\s+");
        if(words.length == 1){
            return words[0] + " ".repeat(spaces);
        }
        int equiSpace = spaces/(words.length-1);
        int extra = spaces%(words.length-1);
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            ans.append(words[i]);
            if(i != words.length-1){
                ans.append(" ".repeat(equiSpace));
            }
        }
        ans.append(" ".repeat(extra));
        return ans.toString();
    }
}