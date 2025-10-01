import java.util.Arrays;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : s1.toCharArray()) count1[c - 'a']++;
        int l = 0, r = 0;
        while (r < s2.length()) {
            count2[s2.charAt(r) - 'a']++;
            if (r - l + 1 > s1.length()) {
                count2[s2.charAt(l) - 'a']--;
                l++;
            }
            if (Arrays.equals(count1, count2)) return true;
            r++;
        }
        return false;
    }
}
