package com.example.lessons.mapentry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEntryDemo {
    public static void main(String[] args) {

        // Maps store Map.Entry objects, or make them accessible via the entrySet method ---
        // a map, in general, stores (key,value) pairs in objects that belong to a class that implements this interface.
        // Each Entry object supports getKey() and getValue methods for retrieving these.

        // Create a hash map
        Map<String,Double> hm = new HashMap<>();
        // Put elements to the map
        hm.put("Zara", 3434.34);
        hm.put("Mahnaz", 123.22);
        hm.put("Ayan", 1378.00);
        hm.put("Daisy", 99.22);
        hm.put("Qadir", -19.08);

        // Get a set of the entries
        Set<Map.Entry<String, Double>> set = hm.entrySet();
        // Get an iterator
        Iterator<Map.Entry<String, Double>> i = set.iterator();
        // Display elements
        while(i.hasNext()) {
            Map.Entry<String, Double> me = i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        System.out.println();
        // Deposit 1000 into Zara's account
        double balance = hm.get("Zara");
        hm.put("Zara", balance + 1000);
        System.out.println("Zara's new balance: " + hm.get("Zara"));
        System.out.println("Zara's new balance: " + hm.get("Zara"));
    }
}
