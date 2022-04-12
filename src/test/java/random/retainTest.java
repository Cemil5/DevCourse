package random;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class retainTest {
    public static void main(String[] args) {
        Set<Object> a = new HashSet<>();
        Set<Object> b = new HashSet<>();
        Collections.addAll(a, "El", "em", "Er", "Ey", "ek");
        Collections.addAll(b, "Er", "Ey", "ek");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("getIntersection(a, b) = " + getIntersection(a, b));

    }

    public static Set<Object> getIntersection(Set<Object> a, Set<Object> b){
        if (a.size() > a.size()){
            a.retainAll(b);
            return a;
        } else {
            b.retainAll(a);
            return b;
        }

    }



}
