package src.main.dsa.striver.a2zdsa.arrays.easy;

import java.util.*;

public class P009FindTheUnion {

    public static void main(String[] args) {
        System.out.println(findUnionV3(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 6, 7}, 5, 5));
    }

    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        // add your code here
        ArrayList<Integer> resp = new ArrayList<>(n + m);
        int index1 = 0;
        int index2 = 0;

        while (index1 < n && index2 < m) {
            if (arr1[index1] == arr2[index2] && !resp.contains(arr2[index2])) {
                resp.add(arr1[index1]);
                index2++;
                index1++;
            } else if (arr1[index1] < arr2[index2] && !resp.contains(arr1[index1])) {
                resp.add(arr1[index1]);
                index1++;
            } else if (arr1[index1] > arr2[index2] && !resp.contains(arr2[index2])) {
                resp.add(arr2[index2]);
                index2++;
            } else {
                index1++;
                index2++;
            }
        }

        while (index1 < n) {
            if (!resp.contains(arr1[index1])) {
                resp.add(arr1[index1]);
            }
            index1++;
        }

        while (index2 < m) {
            if (!resp.contains(arr2[index2])) {
                resp.add(arr2[index2]);
            }
            index2++;
        }

        return resp;
    }

    public static ArrayList<Integer> findUnionV2(int[] arr1, int[] arr2, int n, int m) {
        // add your code here
        ArrayList<Integer> resp = new ArrayList<>();
        int i, j;
        i = j = 0;
        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                if (!resp.contains(arr1[i])) {
                    resp.add(arr1[i]);
                }
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                if (!resp.contains(arr1[i])) {
                    resp.add(arr1[i]);
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (!resp.contains(arr2[j])) {
                    resp.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < n) {
            if (!resp.contains(arr1[i])) {
                resp.add(arr1[i]);
            }
            i++;
        }

        while (j < m) {
            if (!resp.contains(arr2[j])) {
                resp.add(arr2[j]);
            }
            j++;
        }

        return resp;
    }

    public static ArrayList<Integer> findUnionV3(int[] arr1, int[] arr2, int n, int m) {
        // add your code here
        ArrayList<Integer> resp = new ArrayList<>();
        int i, j;
        i = j = 0;
        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                if ((resp.isEmpty() || resp.get(resp.size() - 1) != arr1[i])) {
                    resp.add(arr1[i]);
                }
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                if (resp.isEmpty() || resp.get(resp.size() - 1) != arr1[i]) {
                    resp.add(arr1[i]);
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                if ((resp.isEmpty() || resp.get(resp.size() - 1) != arr2[j])) {
                    resp.add(arr2[j]);
                }
                j++;
            }
        }

        if (resp.isEmpty())
            return resp;

        while (i < n) {
            if (resp.get(resp.size() - 1) != arr1[i]) {
                resp.add(arr1[i]);
            }
            i++;
        }

        while (j < m) {
            if (resp.get(resp.size() - 1) != arr2[j]) {
                resp.add(arr2[j]);
            }
            j++;
        }

        return resp;
    }
}
