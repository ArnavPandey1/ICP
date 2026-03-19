class Solution {
    public int matrixSum(int[][] nums) {
        List<List<Integer>>l1=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            l1.add(new ArrayList<>());
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                l1.get(i).add(nums[i][j]);
            }
            Collections.sort(l1.get(i));
        }
        int score=0;
        while(l1.get(0).size()>=1){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<l1.size();i++){
               max=Math.max(max,l1.get(i).get(l1.get(i).size()-1));
               l1.get(i).remove(l1.get(i).size()-1);
            }
            score+=max;
        }
        return score;
    }
}