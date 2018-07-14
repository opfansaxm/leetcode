package search;

public class Search {
    public int binarySearch(int[] array, int target) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex <= endIndex) {
            int index = (startIndex + endIndex) / 2;
            if (array[index] > target)
                endIndex = index - 1;
            else if (array[index] < target)
                startIndex = index + 1;
            else
                return index;
        }
        return -1;
    }


    public int recursionBinarySearch(int[] arr, int target, int startIndex, int endIndex) {
        int low = startIndex;
        int high = endIndex;
        if (low > high)
            return -1;
        int middle = (low + high) / 2;
        if (arr[middle] > target) {
            return recursionBinarySearch(arr, target, low, middle - 1);
        } else if (arr[middle] < target) {
            return recursionBinarySearch(arr, target, middle + 1, high);
        } else {
            return middle;
        }
    }
}
