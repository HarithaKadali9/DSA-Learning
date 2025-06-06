class ReverseArrayUsingRecursion {
    private static int[] reverse(int nums[], int left, int right){
        if(left>=right) return nums;
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
        return reverse(nums, left+1, right-1);
    }
    public static void main(String[] args) {
        int nums[]={5, 4, 3, 2, 1};
        System.out.println("Before reverse an array: ");
        for(int i : nums) System.out.print(i+" ");
        
        System.out.println();
        reverse(nums, 0, nums.length-1);
        
        System.out.println("Reverse an array : ");
        for(int i : nums) System.out.print(i+" ");
    }
}

/**
 * private static int[] reverseRecursive(int[] nums) {
        int[] result = new int[nums.length];
        fillReverse(nums, result, 0);
        return result;
    }

    private static void fillReverse(int[] nums, int[] result, int index) {
        if (index == nums.length) return;
        result[nums.length - 1 - index] = nums[index];
        fillReverse(nums, result, index + 1);
    }
 */