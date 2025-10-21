class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            int k=0;
            while(!st.isEmpty() && arr[i]<0 && st.peek()>0){
                if(Math.abs(arr[i])>Math.abs(st.peek())){
                    st.pop();   
                }
                else if(Math.abs(arr[i])==Math.abs(st.peek())){
                      st.pop();
                      k=1;
                      break;
                }
                else{
                    k=1;
                     break;
                }
            }
            if(k==0)
            st.push(arr[i]);
        }
        int a[]=new int[st.size()];int l=0;
        for(int i:st){
            a[l++]=i;
        }
        return a;
    }
}