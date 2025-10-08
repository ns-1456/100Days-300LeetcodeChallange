package problems.day_004;

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1; // Base case: target not found
        }

        int mid = left + (right - left) / 2; // Safe midpoint calculation

        if (nums[mid] == target) {
            return mid; // Target found
        } 
        else if (target < nums[mid]) {
            return binarySearch(nums, left, mid - 1, target); // Search left half
        } 
        else {
            return binarySearch(nums, mid + 1, right, target); // Search right half
        }
    }
}
