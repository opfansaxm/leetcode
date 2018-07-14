package xiaowangba;

public class TreeSerial {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        int len = sequence.length;
        if (len == 0)
            return false;
        return verifyArr(sequence, 0, len - 1);
    }

    public static boolean verifyArr(int[] seq, int start, int end) {
        if (start >= end)
            return true;
        int middle = seq[end];
        int i = 0;
        while (seq[i] < middle)
            i++;
        int j = i;
        while (j <= end - 1) {
            if (seq[j] < middle)
                return false;
            j++;
        }

        return verifyArr(seq, start, i - 1) && verifyArr(seq, i, end - 1);
    }

    public static void main(String[] args) {
        int a[] = {4};
        System.out.println(VerifySquenceOfBST(a));
    }
}
