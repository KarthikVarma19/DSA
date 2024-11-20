class BrowserHistory {
    class Node{
        String url;
        Node next;
        Node prev;
        Node(String url){
            this.url = url;
        }
    }
    Node curPage;
    Node head;
    Node tail;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        tail = curPage = head;
    }
    
    public void visit(String url) {
        Node newPage = new Node(url);
        curPage.next = newPage;
        newPage.prev = curPage;
        tail = curPage = newPage;
    }
    
    public String back(int steps) {
        while(steps>0){
            if(curPage == head){
                return curPage.url;
            }
            curPage = curPage.prev;
            steps--;
        }
        return curPage.url;
    }
    
    public String forward(int steps) {
        while(steps>0){
            if(curPage == tail){
                return curPage.url;
            }
            curPage = curPage.next;
            steps--;
        }
        return curPage.url;

    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */