class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return mergeSort(prefix, 0, prefix.length, lower, upper);
    }

    private int mergeSort(long[] arr, int left, int right, int lower, int upper) {
        if (right - left <= 1) return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSort(arr, left, mid, lower, upper) +
                    mergeSort(arr, mid, right, lower, upper);

        int j = mid, k = mid, t = mid;
        long[] temp = new long[right - left];
        int idx = 0;

        for (int i = left; i < mid; i++) {
            while (k < right && arr[k] - arr[i] < lower) k++;
            while (j < right && arr[j] - arr[i] <= upper) j++;
            while (t < right && arr[t] < arr[i]) temp[idx++] = arr[t++];
            temp[idx++] = arr[i];
            count += j - k;
        }

        while (t < right) temp[idx++] = arr[t++];

        System.arraycopy(temp, 0, arr, left, idx);
        return count;
    }
    
}