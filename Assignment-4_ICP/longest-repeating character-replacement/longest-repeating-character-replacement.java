class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0, r= 0;
        int maxCount = 0;
        int max= 0;
        while (r < s.length()) {
            freq[s.charAt(r) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(r) - 'A']);
            while ((r - l+ 1) - maxCount > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            max = Math.max(max,r - l + 1);
            r++;
        }
        return max;
    }
}


/*
TC=>O(N)
SC=>O(1)
 */