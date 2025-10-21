class MinStack {
     Stack<int[]>st=new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        int a[]=new int[2];
        if(st.size()==0){
          a[0]=val;
          a[1]=val;
        }
        else{
            a[0]=val;
            a[1]=Math.min(val,st.peek()[1]);
        }
        st.push(a);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
         if(st.size()==0){
            return -1;
        }
        return st.peek()[0];
    }
    
    public int getMin() {
         if(st.size()==0){
            return -1;
        }
        return st.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */