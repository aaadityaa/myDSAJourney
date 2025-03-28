public class MaximumSubarray {

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {5,4,-1,7,8};
        int[] nums3 = {7};
        int result;
        result = maxSubArrayBrute(nums);
            System.out.println(result);

}
    public int maxSubArrayBrute(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            for (int j=i; j<nums.length; j++){
                int sum =0;
                for(int k = i; k <= j ; k++){
                    sum += nums[k];
                    if(sum > max){
                        max =sum;
                    }
                }
            }

        }
        return max;
    }


    public int maxSubArrayBetter(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }

        }
        return max;
    }


    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        int sIndex = -1, lIndex = -1;
        for (int i = 0; i < nums.length; i++) {

            if (sum == 0)
                sIndex = i; // added to find the subArray

            sum += nums[i];

            if (sum > max) {
                max = sum;
                lIndex = i;
            }

            if (sum < 0) {
                sum = 0;
            }

        }
        return max;
    }



}
