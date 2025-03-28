public class MaximumSubarrayProduct {


    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {5, 4, -1, 7, 8};
        int[] nums3 = {7};
        int result;
        result = maxProductBrute(nums);
        System.out.println(result);

    }


    public static int maxProductBrute(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int prod = 1;
                for(int k = i; k <= j;k++){
                    prod = prod * nums[k];
                }
                if(prod > maxProd){
                    maxProd = prod;
                }

            }
        }
        return maxProd;
    }

    public static int maxProductBetter(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = i; j < nums.length; j++) {
                prod = prod * nums[j];
                if (prod > maxProd) {
                    maxProd = prod;
                }
            }
        }
        return maxProd;
    }

    public int maxProductOptimal(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - i - 1];

            maxProd = Math.max(maxProd, Math.max(prefix, suffix));

        }
        return maxProd;
    }

    public int maxProductModifiedKadanes(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int min = 1, max = 1;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            maxProd = Math.max(maxProd, max);

        }
        return maxProd;
    }

}

