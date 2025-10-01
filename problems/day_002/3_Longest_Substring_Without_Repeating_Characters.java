class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] s_arr = s.toCharArray();

        int L = 0;
        int R = 0;
        int max = 0;
        while (R < s.length()) {
            if (isUnique(s_arr ,L ,R)) {
                max = Math.max(max, R - L + 1);
                R++;
            } else {
                L++;
            }
        }

        return max;
    }

    public boolean isUnique(char[] s, int start, int end) {
        for (int i = start; i < end; i++) {
            if (s[i] == s[end]) {return false;}
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
}