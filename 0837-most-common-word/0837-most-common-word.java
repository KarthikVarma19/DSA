class Solution {
    public String mostCommonWord(String para, String[] banned) {
        HashSet<String> ban = new HashSet<>();
        for(String each: banned){
            ban.add(each);
        }
        String words[] = para.split("[ !?',;.]");
        HashMap<String,Integer> hm = new HashMap<>();
        String common = "";
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            if(words[i] == "" || words[i] == " ") continue;
            if(ban.contains(words[i])){
                words[i] = "";
            }
            else{
                hm.put(words[i],hm.getOrDefault(words[i],0) + 1);
                if(hm.get(words[i]) > max){
                    max = hm.get(words[i]);
                    common = words[i];
                }
            }

        }
        return common;
        
    }
}