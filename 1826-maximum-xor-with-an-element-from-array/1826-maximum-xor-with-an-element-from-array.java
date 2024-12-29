class Node{
    Node left;
    Node right;
    Node(){
        left = null;
        right = null;
    }
    boolean contains(int bit){
        if(bit == 0){
            return left!=null;
        }
        return right!=null;
    }
    void createNode(int bit, Node newNode){
        if(bit == 0){
            left = newNode;
            return;
        }
        right = newNode;
    }
    Node get(int bit){
        if(bit == 0){
            return left;
        }
        return right;
    }
}
class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    void insert(int num){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1;
            if(!node.contains(bit)){
                node.createNode(bit,new Node());
            }
            node = node.get(bit);
        }
    }
    int getMax(int x){
        Node node = root;
        int xor = 0;
        for(int i=31;i>=0;i--){
            int bit = (x>>i) & 1;
            int reqBit = 1 - bit;
            if(node.contains(reqBit)){
                node = node.get(reqBit);
                xor = xor | (1<<i);
            }
            else{
                node = node.get(bit);
            }
        }
        return xor;
    }
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        int ans[] = new int[n];
        Arrays.sort(nums);
        ArrayList<int[]> offlineQueries = new ArrayList<>();
        for(int i=0;i<n;i++){
            offlineQueries.add(new int[]{queries[i][0],queries[i][1],i});
        }
        offlineQueries.sort(new Comparator<int[]>(){
            @Override 
            public int compare(int a[], int b[]){
                return a[1]-b[1];
            }
        });
        Trie t = new Trie();
        int p = 0;
        for(int[] it: offlineQueries){
            while(p<nums.length && nums[p] <= it[1]){
                t.insert(nums[p]);
                p++;
            }
            if(p != 0){
                ans[it[2]] = t.getMax(it[0]);
            }
            else{
                //if no elements got inserted
                ans[it[2]] = -1;
            }
            
        }
        return ans;
    }
}