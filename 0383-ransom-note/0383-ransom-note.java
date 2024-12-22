class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int freq[] = new int[26];
        for(int i=0;i<magazine.length();i++){
            char cur = magazine.charAt(i);
            freq[cur-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            char cur = ransomNote.charAt(i);
            freq[cur-'a']--;
            if(freq[cur-'a'] < 0) return false;
        }
        return true;
    }
}