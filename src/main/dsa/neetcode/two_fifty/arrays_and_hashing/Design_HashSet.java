package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

public class Design_HashSet {

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)

    }
}

class MyHashSet {

    private final List<Integer> setList;

    public MyHashSet() {
        setList = new ArrayList<>();
    }

    public void add(int key) {
        if (!setList.contains(key))
            setList.add(key);
    }

    public void remove(int key) {
        if (setList.contains(key))
            setList.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        return setList.contains(key);
    }

    @Override
    public String toString() {
        return "MyHashSet [" +
                "setList=" + setList +
                ']';
    }
}