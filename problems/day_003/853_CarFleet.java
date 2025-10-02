class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Step 1: find maximum position for bucket array
        int maxPos = 0;
        for (int pos : position) {
            if (pos > maxPos) maxPos = pos;
        }

        // Step 2: create buckets for positions
        // Each bucket holds the time to reach target
        double[] timeBuckets = new double[maxPos + 1];
        for (int i = 0; i <= maxPos; i++) {
            timeBuckets[i] = -1;  // -1 means no car at this position
        }

        // Step 3: fill the buckets
        for (int i = 0; i < n; i++) {
            timeBuckets[position[i]] = (double)(target - position[i]) / speed[i];
        }

        // Step 4: iterate from closest to target (maxPos) backward
        int fleets = 0;
        double leadTime = 0;

        for (int pos = maxPos; pos >= 0; pos--) {
            if (timeBuckets[pos] < 0) continue; // no car here
            double time = timeBuckets[pos];
            if (time > leadTime) {
                fleets++;
                leadTime = time;
            }
            // else: merges with fleet ahead, do nothing
        }

        return fleets;
    }
}
