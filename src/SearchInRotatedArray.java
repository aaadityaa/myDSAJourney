public class SearchInRotatedArray {

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2}; // Rotated 4 times
        int[] nums2 = {0,1,2,4,5,6,7}; // 7 times
        int target = 0;
        int result;
        result = SearchInRotatedArray.search(nums, target);
        System.out.println(result);

    }
    public static int search(int[] nums, int target) {
        int ans = -1;
        int n = nums.length;
        int l = 0, h = n - 1;

        while (l <= h) {

            int mid = (l + h) / 2;
            if (nums[mid] == target)
                return mid;
            // if duplicates are there then nums[l] == nums[mid] == nums[high] {3,2,1,3,3,3,3}
            if (nums[l] == nums[mid] && nums[mid] == nums[h]) {
                l++;
                h--;
                continue;
            }

            // Identify the sorted half
            if (nums[l] <= nums[mid]) {
                //sorted
                if (nums[l] <= target && target <= nums[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                //Unsorted
                if (nums[mid] <= target && target <= nums[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }

            }

        }
        return -1;
    }
}
