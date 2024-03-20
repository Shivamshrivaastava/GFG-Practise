class KthSmallestElement {
    public static int findKthSmallest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int pivotIndex = partition(nums, left, right);
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 7, 1, 9, 5, 8};
        int k = 3;
        int kthSmallest = findKthSmallest(nums, k);
        System.out.println("The " + k + "th smallest element is: " + kthSmallest);
    }
}
