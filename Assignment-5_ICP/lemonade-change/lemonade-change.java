class Solution {
    public boolean lemonadeChange(int[] arr) {
        int r5=0;
        int r10=0;
        for(int i=0;i<arr.length;i++){
            int amt_ret=arr[i]-5;
            if(amt_ret==0){
               r5++;
            }
            else if(amt_ret==5){
                if(r5>=1){
                    r5--;
                    r10++;
                }
                else{
                    return false;
                }
            }
            else{
               if(r5>=1 && r10>=1){
                r5--;
                r10--;
               }
               else if(r5>=3){
                r5=r5-3;
               }
               else{
                return false;
               }
            }
        }
        return true;
    }
}