class StockSpanner {
    Stack<Integer>st;
    List<Integer>l1=new ArrayList<>();
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        l1.add(price);
        int c=0;
        for(int i=l1.size()-1;i>=0;i--){
            if(l1.get(i)<=price)
            c++;
            else
            break;
        }
        return c;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */