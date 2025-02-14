class ProductOfNumbers {
    
    List<Integer> prod;

    public ProductOfNumbers() {
        prod = new ArrayList<>();
        prod.add(1);
    }
    
    public void add(int num) {
        if(num == 0){
            prod = new ArrayList<>();
            prod.add(1);
        }
        else{
            prod.add(prod.get(prod.size()-1) * num);
        }
    }
    
    public int getProduct(int k) {
        int n = prod.size();
        if(n <= k){
            return 0;
        }
        return prod.get(n-1)/prod.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */