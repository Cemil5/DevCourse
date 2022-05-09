package javaReview.functional_Interfaces.comparator;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return (o1>o2) ? -1 : (o2<o1) ? 1 : 0;
    }
}
