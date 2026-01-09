import java.util.Arrays;

public class MergeApproach {
    public static int[] union(int[] a1, int[] a2) {
        if (a1 == null || a2 == null) {
            throw new IllegalArgumentException();
        }

        Sort.selectionSort(a1);
        Sort.selectionSort(a2);

        int[] result = new int[a1.length + a2.length];
        int index = 0;
        
        int i = 0, j = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                if (index == 0 || result[index - 1] != a1[i]) {
                    result[index++] = a1[i];
                }
                i++;
            } else if (a1[i] > a2[j]) {
                if (index == 0 || result[index - 1] != a2[j]) {
                    result[index++] = a2[j];
                }
                j++;
            } else {
                if (index == 0 || result[index - 1] != a1[i]) {
                    result[index++] = a1[i];
                }
                i++;
                j++;
            }
        }

        while (i < a1.length) {
            if (index == 0 || result[index - 1] != a1[i]) {
                result[index++] = a1[i];
            }
            i++;
        }

        while (j < a2.length) {
            if (index == 0 || result[index - 1] != a2[j]) {
                result[index++] = a2[j];
            }
            j++;
        }

        for (int k = index; k < result.length; k++) {
            result[k] = 0;
        }

        return result;
           
    }

    public static int[] intersect(int[] a1, int[] a2){
        if(a1 == null || a2 == null){
            throw new IllegalArgumentException();
        }

        Sort.selectionSort(a1);
        Sort.selectionSort(a2);

        int len;
        if(a1.length < a2.length){
            len = a1.length;
        }
        else{
            len = a2.length;
        }
        int[] result = new int[len];
        int index = 0;

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<a1.length && j<a2.length){
            while(i<a1.length-1 && a1[i+1]==a1[i]){
                i++;
            }       
            while(j<a2.length-1 && a2[j+1]==a2[j]){
                j++;
            }
            if (i < a1.length && j < a2.length) {
                if (a1[i] < a2[j]) {
                    i++;
                } else if (a1[i] > a2[j]) {
                    j++;
                } else {
                    result[k++] = a1[i];
                    i++;
                    j++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a1 = {10, 5, 7, 5, 9, 4};
        int[] a2 = {7, 5, 15, 7, 7, 9, 10};
        int[] result1 = union(a1, a2);
        System.out.println("result1: " + Arrays.toString(result1));

        int[] a3 = {0, 2, -4, 6, 10, 8};
        int[] a4 = {12, 0, -4, 8};
        int[] result2 = union(a3, a4);
        System.out.println("result2: " + Arrays.toString(result2));

        int[] a5 = {1, 2, 3, 3, 3};
        int[] a6 = {3, 4, 5};
        int[] result3 = union(a5, a6);
        System.out.println("result3: " + Arrays.toString(result3));

        int[] a7 = {10, 5, 7, 5, 9, 4};
        int[] a8 = {7, 5, 15, 7, 7, 9, 10};
        int[] result4 = intersect(a7, a8);
        System.out.println("result4: " + Arrays.toString(result4));

        int[] a9 = {0, 2, -4, 6, 10, 8};
        int[] a10 = {12, 0, -4, 8};
        int[] result5 = intersect(a9, a10);
        System.out.println("result5: " + Arrays.toString(result5));
    }
}