package a_selfStudy_Code_Leet_Hacker.hackerRank;

// https://www.hackerrank.com/challenges/java-bitset/problem
//Java's BitSet Class implements a vector of bit values (i.e.: false (0) or true (1)) that grows as needed, allowing us to easily
//        manipulate bits while optimizing space (when compared to other collections). Any element having a bit value of 1 is called a set bit.
public class BitSet {
    /*
    public static void main(String[] args) {
        ScannerTest sc = new ScannerTest(System.in);
        int setSize = sc.nextInt();
        int noOps = sc.nextInt();
        BitSet[] bitSets = new BitSet[]{new BitSet(setSize), new BitSet(setSize)};
        Map<String, BiConsumer<Integer,Integer>> ops = new HashMap<>();
        ops.put("AND", (index1, index2) -> bitSets[index1-1].and(bitSets[index2-1]));
        ops.put("OR", (index1, index2) -> bitSets[index1-1].or(bitSets[index2-1]));
        ops.put("XOR", (index1, index2) -> bitSets[index1-1].xor(bitSets[index2-1]));
        ops.put("SET", (index1, index2) -> bitSets[index1-1].set(index2));
        ops.put("FLIP", (index1, index2) -> bitSets[index1-1].flip(index2));
        for (int i = 0; i < noOps; i++){
            ops.get(sc.next()).accept(sc.nextInt(), sc.nextInt());
            System.out.println(bitSets[0].cardinality() + " " + bitSets[1].cardinality());
        }
    }*/

}
/*
import java.util.BitSet;
        import java.util.ScannerTest;

public class Solution {

    public static void main(String[] args) {
        ScannerTest get = new ScannerTest(System.in);
        int n = get.nextInt();
        int m = get.nextInt();

        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        BitSet[] bitset = new BitSet[3];

        bitset[1] = b1;
        bitset[2] = b2;

        while ( 0 < m-- ) {
            String op = get.next();
            int x = get.nextInt();
            int y = get.nextInt();

            switch (op) {
                case "AND":
                    bitset[x].and(bitset[y]);
                    break;
                case "OR":
                    bitset[x].or(bitset[y]);
                    break;
                case "XOR":
                    bitset[x].xor(bitset[y]);
                    break;
                case "FLIP":
                    bitset[x].flip(y);
                    break;
                case "SET":
                    bitset[x].set(y);
            }

            System.out.printf("%d %d%n", b1.cardinality(), b2.cardinality());
        }
    }
}*/