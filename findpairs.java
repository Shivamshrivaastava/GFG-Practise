import java.util.*;
class FindPairs {
    public static List<List<Integer>> findPairsWithSum(int[] nums, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                List<Integer> pair = new ArrayList<>();
                pair.add(num);
                pair.add(complement);
                pairs.add(pair);
            }
            map.put(num, num);
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 3, 6, 8};
        int target = 9;
        List<List<Integer>> pairs = findPairsWithSum(nums, target);

        if (pairs.isEmpty()) {
            System.out.println("No pairs found.");
        } else {
            System.out.println("Pairs with sum " + target + ":");
            for (List<Integer> pair : pairs) {
                System.out.println(pair.get(0) + ", " + pair.get(1));
            }
        }
    }
}
