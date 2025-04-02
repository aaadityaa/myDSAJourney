public class MinInRotatedSortedArray {

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2}; // Rotated 4 times
        int[] nums2 = {0,1,2,4,5,6,7}; // 7 times
        int result;
        result = findMin(nums);
        System.out.println(result);

    }


    public static int findMin(int[] nums) {

        // here we use binary array bcos here we eliminate one half - left or right
        // we do it in sorted array.
        // also we need to segregate the sorted and non sorted side.
        int ans = Integer.MAX_VALUE;
        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;
            // this below is additional confition to check for completely rotated array
            // here nums[l] <= nums[h] can also be used.
            if (nums[l] <= nums[mid] && nums[mid] <= nums[h]) {
                ans = Math.min(ans, nums[l]);
            }
            if (nums[l] <= nums[mid]) {
                ans = Math.min(ans, nums[l]);
                l = mid + 1;
            // this statement will run for sorted half
            } else {
                ans = Math.min(ans, nums[mid]);
                h = mid - 1;
            // this statement will run when the unsorted half is being used
            }

        }
        return ans;
    }
}
