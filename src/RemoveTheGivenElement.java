public class RemoveTheGivenElement {
    public static void main(String[] args) {
        // Call the method. nums = [3,2,2,3], val = 3
        int[] nums = {3,2,2,3};
        System.out.println(removeGivenElement(nums, 3));
    }

    public static int removeGivenElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        // Create a pointer
        int count = 0;
        for (int num : nums) {
            if (num != val) {
                nums[count] = num;
                count++;

            }
        }
        return count;
    }
}
