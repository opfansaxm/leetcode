package xiaowangba;

import java.util.Arrays;

public class Odd {
    public static void reOrderArray(int[] array) {
        int len = array.length;
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            while (i < len && array[i] % 2 == 1)
                i++;
            if (i >= len)
                break;
            j = i + 1;
            while (j < len && array[j] % 2 == 0) {
                j++;
            }
            if (j >= len)
                break;
            //往后移
            int tmp = array[j];
            for (int k = j - 1; k >= i; k--)
                array[k + 1] = array[k];
            array[i] = tmp;
            i++;
        }

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] a = {2,1,8,0,3,5,6,7};
        reOrderArray(a);
    }
}
