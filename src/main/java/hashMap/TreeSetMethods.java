package hashMap;

import java.util.TreeSet;

public class TreeSetMethods {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(10);
        treeSet.add(15);
        treeSet.add(20);

        System.out.println(treeSet);
        System.out.println(treeSet.floor(5));
        System.out.println(treeSet.ceiling(5));
        System.out.println(treeSet.subSet(4, true, 10, true));
    }
}
