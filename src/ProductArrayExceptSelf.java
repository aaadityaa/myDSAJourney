public class ProductArrayExceptSelf {

    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
        int[] nums2 = {7,6,4,3,1};
        int[] nums3 = {7,1,5,3,6,3};
        int[] result;
        result = productExceptSelfBruteForce(nums2);
        for (int j : result) {
            System.out.println(j);
        }

    }



    public static int[] productExceptSelfBruteForce(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int prod = 1;
            for (int j = 0; j < nums.length; j++){
                if (i==j){
                    continue;
                }
                prod = prod*nums[j];
            }
            arr[i] = prod;
        }
        return arr;
    }

    public int[] productExceptSelfWith3Loops(int[] nums) {
        int[] result = new int[nums.length];
        int[] arrLeft  = new int[nums.length];
        int[] arrRight = new int[nums.length];
        arrLeft[0] = 1; // bcos no element before first!
        arrRight[arrRight.length-1] = 1; // bcos no element after last!
        for(int i = 1; i < nums.length; i++){
            arrLeft[i] = nums[i-1] * arrLeft[i-1];
        }
        for(int i = nums.length-2; i >= 0 ; i--){
            arrRight[i] = nums[i+1] * arrRight[i+1];
        }
        for(int i = 0; i < nums.length ; i++){
            result[i] = arrLeft[i] * arrRight[i];
        }
        return result;
    }

}
