package array;

public class Array {
    // {1,-2,3,10,-4,7,2,-5}
    public static int FindGreatestSumOfSubArray(int[] array) {
        int length = array.length;
        int max = Integer.MIN_VALUE;
        if (length == 1) {
            return array[0];
        }
        int currentMax = array[0];
        for (int i = 1; i < length; i++) {
            currentMax = Math.max((currentMax + array[i]), array[i]);
            max = Math.max(currentMax, max);
        }
        return max;
    }
}