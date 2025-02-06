package src.main.dsa.gfg.gfg_160_series.arrays_gfg_160;

// revision needed
public class D011_Maximum_Product_Subarray {

    public static void main(String[] args) {
        System.out.println(maxProductV2(new int[]{-2, 6, -3, -10, 0, 2}));
    }

    public static int maxProductV2(int[] arr) {
        int prod = Integer.MIN_VALUE;
        int tempProdPre = 1;
        int tempProdSuf = 1;
        for (int j = 0; j < arr.length; j++) {
            tempProdPre *= arr[j];
            tempProdSuf *= arr[arr.length - 1 - j];
            prod = Math.max(prod, Math.max(tempProdPre, tempProdSuf));
            if (tempProdPre == 0) {
                tempProdPre = 1;
            }
            if (tempProdSuf == 0) {
                tempProdSuf = 1;
            }
        }
        return prod;
    }

}
