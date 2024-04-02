package org.APCSA2023.HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSet_Union {
    public static void main(String[] args) {
        Set<String> s1 =  new HashSet<>();
        s1.add("Bill");
        s1.add("Larry");
        s1.add("Adolph");
        s1.add("Regina");
        s1.add("Susie");

        Set<String> s2 = new HashSet<>();
        s2.add("Larry");
        s2.add("Jack");
        s2.add("Alice");
        s2.add("June");
        s2.add("Benny");
        s2.add("Susie");

        s1.addAll(s2);

        Iterator<String> i = s1.iterator();

        while(i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
