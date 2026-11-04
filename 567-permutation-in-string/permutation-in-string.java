
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        int k = s1.length();

        for (int right = 0; right < s2.length(); right++) {

            freq[s2.charAt(right) - 'a']--;

            if (right - left + 1 > k) {
                freq[s2.charAt(left) - 'a']++;
                left++;
            }

            if (right - left + 1 == k) {

                boolean valid = true;

                for (int i = 0; i < 26; i++) {
                    if (freq[i] != 0) {
                        valid = false;
                        break;
                    }
                }

                if (valid) return true;
            }
        }

        return false;
    }
}
