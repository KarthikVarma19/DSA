class LockingTree {
    int[] parent;
    int[] locked;
    ArrayList<Integer>[] child;
    public LockingTree(int[] parent) {
        this.parent = parent;
        this.locked = new int[parent.length];
        this.child = new ArrayList[parent.length];

        for(int i=0;i<child.length;i++){
            child[i] = new ArrayList<>();
        }

        for(int i=1;i<parent.length;i++){
            child[parent[i]].add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(locked[num] == 0){
            locked[num] = user;
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if(locked[num] == user){
            locked[num] = 0;
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        if(locked[num] != 0){
            return false;
        }
        int ancestor = parent[num];
        while(ancestor != -1){
            if(locked[ancestor] != 0){
                return false;
            }
            ancestor = parent[ancestor];
        }
        if(!hasLockedDescendant(num)){
            return false;
        }
        locked[num] = user;
        return true;
    }
    
    //returns true if any of the child is locked
    public boolean hasLockedDescendant(int num){
        if(locked[num] != 0){
            return true;
        }
        for(int x: child[num]){
            if(hasLockedDescendant(x)){
                unlockAll(num);
                return true;
            }
        }
        return false;
    }
    //unlockes all the child nodes regardless of the user
    public void unlockAll(int num){
        locked[num] = 0;
        for(int x: child[num]){
            unlockAll(x);
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */