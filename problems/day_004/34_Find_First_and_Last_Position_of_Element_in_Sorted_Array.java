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

    public int[] searchRange(int[] nums, int target) {
    int foundIndex = binarySearch(nums, 0, nums.length - 1, target);
    if (foundIndex == -1) {
        return new int[]{-1, -1};
    }

    int leftIndex = foundIndex;
    int rightIndex = foundIndex;

    // Expand to the left
    while (leftIndex > 0 && nums[leftIndex - 1] == target) {
        leftIndex--;
    }

    // Expand to the right
    while (rightIndex < nums.length - 1 && nums[rightIndex + 1] == target) {
        rightIndex++;
    }

    return new int[]{leftIndex, rightIndex};
}

}
