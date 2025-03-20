class Solution {
    record Pair(String a, int b){}

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        int n = words.size();
        words.addAll(wordList);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        words.remove(beginWord);
        while(!q.isEmpty()){
            String peek = q.peek().a();
            int level = q.peek().b();
            q.remove();
            if(peek.equals(endWord)){
                return level;
            }
            char top[] = peek.toCharArray();
            for(int i = 0; i < top.length; i++){
                char org = top[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    top[i] = ch;
                    String newWord = new String(top);
                    if(words.contains(newWord)){
                        q.add(new Pair(newWord, level+1));
                        words.remove(newWord);
                    }
                }
                top[i] = org;
            }
        }
        return 0;
    }
}