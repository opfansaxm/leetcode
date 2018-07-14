package sort;

public class SortTest {
    public void quickSort(int[] arr, int start, int end) {
        if (start > end)
            return;
        int low = start;
        int high = end;
        int base = arr[low];

        while (start < end) {
            while (start <= end && arr[end] > base) {
                end--;
            }

            if (start < end) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                start++;
            }

            while (start <= end && arr[start] < base) {
                start++;
            }

            if (start < end) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                end--;
            }
        }

        quickSort(arr, low, end - 1);
        quickSort(arr, end + 1, high);
    }

    public void mergeSort(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public void merge(int[] arr, int start, int mid, int end) {
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
}
