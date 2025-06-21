class Solution {
    public String getHint(String secret, String guess) {
        char sec[] = secret.toCharArray();
        char gue[] = guess.toCharArray();
        int bulls = 0;
        int map1[] = new int[10];
        int map2[] = new int[10];
        for(int i = 0; i < sec.length; i++){
            if(sec[i] == gue[i]){
                bulls++;
            }else {
                map1[sec[i]-'0']++;
                map2[gue[i]-'0']++;
            }
        }
        int cows = 0;
        for(int i = 0; i < 10; i++){
            cows += Math.min(map1[i], map2[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }
}