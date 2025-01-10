class Solution {
    public int[] count(String word){
        int map[] = new int[26];
        for(char each: word.toCharArray()){
            map[each-'a'] += 1;
        }
        return map;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        //Step1:- Construct the HashMap for the Words2
        int bMax[] = count("");
        for(String b: words2){
            int bCount[] = count(b);
            for(int i=0;i<26;i++){
                bMax[i] = Math.max(bMax[i], bCount[i]);
            }
        }

        List<String> ans = new ArrayList<>();

        //Step2:- Validate each word in words1
        search: for(String a: words1){
                    int aCount[] = count(a);
                    for(int i=0;i<26;i++){
                        if(bMax[i] > aCount[i]){
                            continue search;
                        }
                    }
                    ans.add(a);
                }
        return ans;
    }
}