public class BinarySearch {

    public int search(int[] nums, int target) {

        if(nums.length == 1 && nums[0] == target){
            return 0;
        }

        int high = nums.length - 1;
        int low = 0;
        int mid;

        while (low != high){
            mid = (high + low)/2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
