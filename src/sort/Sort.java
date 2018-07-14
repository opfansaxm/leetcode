package sort;

public class Sort {
    public static void quickSort(int array[], int low, int high) {
        if (low > high) return;
        int start = low;
        int end = high;

        int key = array[low];

        while (low < high) {
            while (low <= high && array[high] > key) {
                high--;
            }

            if (low < high) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
                low++;
            }

            while (low <= high && array[low] < key) {
                low++;
            }

            if (low < high) {
                int temp = array[high];
                array[high] = array[low];
                array[low] = temp;
                high--;
            }
        }

        quickSort(array, start, high - 1);
        quickSort(array, high + 1, end);
    }

    public static void mergeSort(int[] array, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] tempArr = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int newTempArrIndex = 0;

        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                tempArr[newTempArrIndex++] = arr[left++];
            } else {
                tempArr[newTempArrIndex++] = arr[right++];
            }
        }

        while (left <= mid) {
            tempArr[newTempArrIndex++] = arr[left++];
        }

        while (right <= end) {
            tempArr[newTempArrIndex++] = arr[right++];
        }


        System.arraycopy(tempArr, 0, arr, start, tempArr.length);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 4, 5, 6, 77, 8, 11, 34, 5, 7};
        Sort.quickSort(arr, 0, arr.length - 1);
        for (int ele : arr) {
            System.out.println(ele);
        }
    }
}