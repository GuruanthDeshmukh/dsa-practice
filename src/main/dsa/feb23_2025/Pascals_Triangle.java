package src.main.dsa.feb23_2025;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resp = new ArrayList<>(numRows);
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        resp.add(temp);
        if (numRows == 1)
            return resp;
        temp = new ArrayList<>();
        temp.add(1);
        temp.add(1);
        resp.add(temp);
        if (numRows == 2)
            return resp;
        int k = 2;
        while (k < numRows) {
            temp = new ArrayList<>();
            temp.add(1);
            List<Integer> stored = resp.getLast();
            for (int i = 1; i < stored.size(); i++) {
                temp.add(stored.get(i)+stored.get(i-1));
            }
            temp.add(1);
            resp.add(temp);
            k++;
        }
        return resp;
    }
}
