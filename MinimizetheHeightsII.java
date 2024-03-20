import java.util.Arrays;

 class MinimizeTheHeightsII {
    public static int minimizeHeights(int[] heights, int k) {
        int n = heights.length;
        Arrays.sort(heights);

        int ans = heights[n - 1] - heights[0]; // Initialize answer with current range

        for (int i = 0; i < n - 1; i++) {
            int min = Math.min(heights[0] + k, heights[i + 1] - k);
            int max = Math.max(heights[n - 1] - k, heights[i] + k);
            ans = Math.min(ans, max - min);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] heights = {1, 5, 8, 10};
        int k = 2;
        int minHeight = minimizeHeights(heights, k);
        System.out.println("Minimum height difference after adjustments: " + minHeight);
    }
}
