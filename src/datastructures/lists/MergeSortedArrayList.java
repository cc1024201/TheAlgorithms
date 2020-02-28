package datastructures.lists;

import java.util.List;

/**
 * @author Cc.
 * @version 1.0.0
 * @ClassName MergeSortedArrayList.java
 * @Description TODO
 * @createTime 2020-02-28 21:45
 */
public class MergeSortedArrayList {
    /* listA: [1, 3, 5, 7, 9]  */
    /* listB: [2, 4, 6, 8, 10] */
    public static void merge(List<Integer> listA, List<Integer> listB, List<Integer> listC) {
        int pa = 0;
        int pb = 0;

        while (pa < listA.size() && pb < listB.size()) {
            if (listA.get(pa) <= listB.get(pb)) {
                listC.add(listA.get(pa++));
            } else {
                listC.add(listB.get(pb++));
            }
        }
        while(pa<listA.size()){
            listC.add(listA.get(pa++));
        }
        while(pb<listB.size()){
            listC.add(listB.get(pb++));
        }
    }
}