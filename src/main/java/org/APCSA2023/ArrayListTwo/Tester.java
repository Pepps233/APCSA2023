/*
* Jiale Yu
* 2/8/24
* AP COMP SCI A
*/

package org.APCSA2023.ArrayListTwo;

import java.util.Random;

public class Tester {
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();

        Random random = new Random();
        int boundary = 100;

        for(int i = 0; i < 20; i++) {
            arrayList.add(random.nextInt(boundary));
        }

        System.out.println(arrayList);
        arrayList.clear();

        arrayList.add(10);
        arrayList.add(9);
        arrayList.set(1, 100);
        arrayList.remove(1);

        System.out.println(arrayList);

        System.out.println(arrayList.get(0));

        arrayList.clear();
        System.out.println(arrayList);
    }
}
