package org.APCSA2023.ArrayListTwo;

import java.util.ArrayList;

public class MyArrayList {
    private final ArrayList<Integer> arrayList;

    public MyArrayList() { arrayList = new ArrayList<>(); }

    public void add(int val) { arrayList.add(val); }
    public void clear() { arrayList.clear(); }
    public void set(int index, int val) { arrayList.set(index, val); }
    public void remove(int index) { arrayList.remove(index); }
    public int length() { return arrayList.size(); }
    public int get(int index) { return arrayList.get(index); }
    public String toString() {
        String output = "";
        output += "The array list has a size of: " + length();
        output += "\n";
        for(int i : arrayList) {
            output += i + " ";
        }
        return output;
    }
}
