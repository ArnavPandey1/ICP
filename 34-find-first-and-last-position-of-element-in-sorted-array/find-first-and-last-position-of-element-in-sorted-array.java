class Solution {
    public int[] searchRange(int[] a, int t) {
        int l = 0, r = a.length - 1, f = -1, s = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == t) {
                f = m;
                r = m - 1;
            } else if (a[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        l = 0; r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == t) {
                s = m;
                l = m + 1;
            } else if (a[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return new int[]{f, s};
    }
}
