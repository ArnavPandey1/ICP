class Solution {
    public boolean isPerfectSquare(int num) {
        int lb=1;int ub=(int)Math.sqrt(num);
        while(lb<=ub){
            int mid=lb+(ub-lb)/2;
            if(mid*mid==num){
                return true;
            }           
            else if(mid*mid>num){
                ub=mid-1;
            }
            else{
                lb=mid+1;
            }
        }
        return false;
    }
}