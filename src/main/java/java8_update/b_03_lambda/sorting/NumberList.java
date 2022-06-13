package java8_update.b_03_lambda.sorting;

import java.util.*;

public class NumberList {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(5, 15, 3, 500, 25));

        // ascending order
        // option 1
        Collections.sort(list); // [3, 5, 15, 25, 500]
        // option 2
        list.sort(Comparator.naturalOrder());   // [3, 5, 15, 25, 500]
        // option 3
        list.sort(((o1, o2) -> o1.compareTo(o2)));

        // descending order
        // option 1
        list.sort(Collections.reverseOrder());  // reverseOrder : [500, 25, 15, 5, 3]
        // option 2
        list.sort(((o1, o2) -> o2.compareTo(o1))); // reverseOrder : [500, 25, 15, 5, 3]
        // option 3
        Collections.sort(list, ((o1, o2) -> (o1>o2) ? -1 : (o2>o1) ? 1 : 0));
        System.out.println(list);

        Collections.reverse(list);  // just reversing input order
        System.out.println("reverse " + list);  // reverse [25, 500, 3, 15, 5]


      //  Collections.sort(list, new MyComparator());
        list.sort(new MyComparator());

    }


}
