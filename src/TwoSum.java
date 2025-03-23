import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {


        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = new int[2];

//        result = twoSum(nums,target);

        result = twoSumWithMap(nums, target);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    public static int[] twoSumWithMap(int[] nums, int target) {

        int l = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < l; i++) {
            int a = nums[i];
            int more = target - a;

            if (map.containsKey(more)) {
                return new int[]{map.get(more), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};

    }


    public static int[] twoSumBruteForce(int[] nums, int target) {
        int l = nums.length;
        int result[] = new int[2];
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;

                    return result;
                }
            }
        }
        return result;
    }

    public static int[] twoSum2pointer(int[] nums, int target) {

        // here after sorting the indexes are lost so we need to conserve it.
        // But if we need to just tell if solution exist or not we can do that
        Arrays.sort(nums);

        int l = nums.length;
        int i = 0;
        int j = l - 1;

        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1, -1};
    }
}