class Solution {
    public int[] productExceptSelf1(int[] nums) {

        // TC -> O(N), where N is the length of nums
        // SC -> O(N)

        int l = nums.length;
        int[] res = new int[l];
        int[] left = new int[l];
        int[] right = new int[l];
        
        
        if(nums == null || nums.length < 2) return res;


        // Loop Left Product
        left[0] = 1;
        for(int i=1; i<l; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        // Loop Right Product
        right[l-1] = 1;
        for(int j=l-2; j>=0; j--){
            right[j] = right[j+1] * nums[j+1];
        }

        // Left X Right
        for(int i=0; i<l; i++){
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public int[] productExceptSelf(int[] nums) {

        // Running Product
        // TC -> O(N), where N is the length of nums
        // SC -> O(1), removed left and right arrays.
        
        int l = nums.length, rp = 1;
        int[] res = new int[l];
        
        if(nums == null || nums.length < 2) return res;

        // Loop Left Product
        res[0] = 1;
        for(int i=1; i<l; i++){
            rp *= nums[i-1];
            res[i] = rp;
        }

        // Loop Right Product
        rp = 1;
        for(int j=l-2; j>=0; j--){
            rp *= nums[j+1];
            res[j] *= rp;
        }
        return res;
    }
}
