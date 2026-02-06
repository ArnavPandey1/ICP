class Solution {
    public int minimumPairRemoval(int[] nums) {
        int c = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                c++;
                break;
            }
        }
        if (c == 0)
            return 0;
        ArrayList<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            l1.add(nums[i]);
        }
        int idx = -1;
        int s = Integer.MAX_VALUE;
        boolean flag = true; c=0;
        while (flag) {
            s = Integer.MAX_VALUE;
            for (int i = l1.size() - 2; i >= 0; i--) {
                int sum = l1.get(i) + l1.get(i + 1);
                if (sum <= s) {
                    s = sum;
                    idx = i;
                }
            }
            if(idx==-1)
            break;
            //count
            c++;
            //delete
            l1.remove(idx);
            l1.remove(idx);
            l1.add(idx,s);
            //add sum
            if(isValid(l1)){
               flag=false;
            }
        }
        return c;
    }
    public boolean isValid(List<Integer>l1){
        for(int i=1;i<l1.size();i++){
            if(l1.get(i)<l1.get(i-1)){
                return false;
            }
        }
        return true;
    }
}