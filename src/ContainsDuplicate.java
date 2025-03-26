import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {


    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
        int[] nums2 = {7,6,4,3,1};
        int[] nums3 = {7,1,5,3,6,3};
        boolean result;
        result = containsDuplicateHashSet(nums2);
        System.out.println(result);


    }

    public static boolean containsDuplicateHashMap(int[] nums) {

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i =1; i<n; i++){
            if(map.containsKey(nums[i])){
                return true;
            }else{
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static boolean containsDuplicateHashSet(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i =0; i<n; i++){
            if(set.add(nums[i])){
            } else {
                return true;
            }
        }
        return false;
    }

}
