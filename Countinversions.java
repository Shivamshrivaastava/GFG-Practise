class CountInversions {
    public static int countInversions(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0; // No inversions in an empty or single-element array
        }

        int[] temp = new int[arr.length]; // Temporary array for merging
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Count inversions in left sub-array
            invCount += mergeSort(arr, temp, left, mid);
            // Count inversions in right sub-array
            invCount += mergeSort(arr, temp, mid + 1, right);
            // Merge the two sorted halves and count inversions
            invCount += merge(arr, temp, left, mid, right);
        }
        return invCount;
    }

    private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left; // Index for the left sub-array
        int j = mid + 1; // Index for the right sub-array
        int k = left; // Index for the merged array
        int invCount = 0;

        // Merge two sub-arrays into the temp array
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1); // Count inversions
            }
        }

        // Copy remaining elements of left sub-array if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right sub-array if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy merged elements back to the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        int inversions = countInversions(arr);
        System.out.println("Number of inversions: " + inversions);
    }
}