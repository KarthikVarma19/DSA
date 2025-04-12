class Solution {
    class Node{
        char cur;
        Node child[];
        ArrayList<String> ls;
        Node(){
            this.child = new Node[26];
            this.ls = new ArrayList<>();
        }
        Node(char cur){
            this();
            this.cur = cur;
        }
        void addWord(String word){
            this.ls.add(word);
        }
        boolean wordsPresent(){
            return ls.size()>0;
        }
        ArrayList<String> getWords(){
            return ls;
        }
        boolean containsChild(char ch){
            return child[ch-'a']!=null;
        }
        void addChild(char ch){
            child[ch-'a'] = new Node();
        }
        Node getChild(char ch){
            return child[ch-'a'];
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // If You Sort In Before Hand Only All Will be in Sorted Order
        Arrays.sort(products);
        
        Node root = new Node();

        for(String eachProduct: products){
            Node temp = root;
            for(char eachChar: eachProduct.toCharArray()){
                if(!temp.containsChild(eachChar)){
                    temp.addChild(eachChar);
                }
                temp = temp.getChild(eachChar);
                temp.addWord(eachProduct);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();

        Node temp = root;
        for(int i = 0; i < searchWord.length(); i++){
            char eachChar = searchWord.charAt(i);
            List<String> in = new ArrayList<>();
            //Edge Case If Word is Not Present
            if(!temp.containsChild(eachChar)){
                // Edge Case If Current Word is Not Present Obviously Next Will Not be Present
                for(int j = i; j < searchWord.length(); j++)
                    ans.add(new ArrayList<>(in));
                break;
                
            }
            temp = temp.getChild(eachChar);
            int limit = 3;
            for(String each: temp.getWords()){
                if(limit == 0) break;
                in.add(each);
                limit--;
            }
            ans.add(new ArrayList<>(in));
        }

        return ans;
    }
}