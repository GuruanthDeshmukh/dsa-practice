package src.main.dsa.striver.a2zdsa.arrays.l2medium;

public class P003FindTheMajorityElementThatOccursMoreThanN_2Times {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 4, 4, 2, 4, 3, 4, 2, 3, 2, 2, 2}));
    }

    public static int majorityElement(int[] arr) {
        int count = 0;
        int element = -1;
        for (int i : arr) {
            if (count == 0) {
                element = i;
            }

            if (element == i) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }
}
