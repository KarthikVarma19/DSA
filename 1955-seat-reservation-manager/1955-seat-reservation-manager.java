class SeatManager {

    PriorityQueue<Integer> pq;
    int curSeats = 2;
    int totSeats;
    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        pq.add(1);
        totSeats = n;
    }
    
    public int reserve() {
        int peek = pq.poll();
        if(pq.isEmpty()){
            for(int i = curSeats;i<curSeats+10 && i<=totSeats; i++){
                pq.add(i);
            }
            curSeats = curSeats + 10;
        }
        return peek;
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */