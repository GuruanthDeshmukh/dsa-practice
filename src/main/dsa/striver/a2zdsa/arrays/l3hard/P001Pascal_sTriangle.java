package src.main.dsa.striver.a2zdsa.arrays.l3hard;

import java.util.ArrayList;
import java.util.List;

public class P001Pascal_sTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resp = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        if (numRows < 1)
            return resp;
        firstRow.add(1);
        resp.add(firstRow);
        if (numRows == 1)
            return resp;
        List<Integer> secondRow = new ArrayList<>();
        secondRow.add(1);
        secondRow.add(1);
        resp.add(secondRow);
        if (numRows == 2)
            return resp;

        for (int i = 3; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> earlierRow = resp.get(i - 2);
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(earlierRow.get(j - 1) + earlierRow.get(j - 2));
                }
            }
            resp.add(temp);
        }

        return resp;
    }
}
