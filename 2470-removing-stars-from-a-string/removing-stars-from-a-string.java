class Solution {
    public String removeStars(String s) {
        char[] arr = s.toCharArray();
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '*') {
                idx--;   // remove previous character
            } else {
                arr[idx] = arr[i];
                idx++;
            }
        }

        return new String(arr, 0, idx);
    }
}