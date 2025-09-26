class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int ans[] = new int[arr.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            if (dq.isEmpty()) {
                dq.addLast(i);
            } else {
                while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                    dq.removeLast();
                dq.addLast(i);
            }
        }
        int l=0;
        for (int i = k - 1; i < arr.length; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                dq.removeLast();
            dq.addLast(i);
            if(dq.peekFirst()<=i-k){
                dq.removeFirst();
            }
            ans[l++]=arr[dq.peekFirst()];
        }
        return ans;
    }
}

/*
TC: O(n)
SC: O(k) (excluding the result array, which is required output).
*/
