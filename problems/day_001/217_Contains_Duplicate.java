import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store unique elements
        Set<Integer> set = new HashSet<>();

        // Iterate through the array
        for (int num : nums) {
            // If the element is already in the set, it's a duplicate
            if (set.contains(num)) {
                return true;
            }
            // Otherwise, add it to the set
            set.add(num);
        }

        // No duplicates found
        return false;
    }
}