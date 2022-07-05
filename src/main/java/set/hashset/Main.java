package set.hashset;

import java.util.*;

/**
 * HashSet does not allow duplicate elements.
 * HashSet allows only one null element.
 * The elements are inserted in random order in a HashSet.
 * A HashSet is internally backed by a HashMap.
 */
public class Main {
    public static void main(String[] args) {
        //The simplest way to create a HashSet is by using the no-arg constructor.
        //This constructor creates a HashSet with an initial capacity of 16 and a load factor of 0.75.

        //Load factor is a number that defines when a Set should be resized.
        //If the load factor is 0.75, then the Set should be resized when it is 75% full.

        Set<Integer> set= new HashSet<>();
        System.out.println("Inserting 23 in the HashSet:  " + set.add(23));
        System.out.println("Inserting 34 in the HashSet:  " + set.add(34));
        System.out.println("Inserting 23 in the HashSet:  " + set.add(23));

        System.out.println(set);

        //Unlike ArrayList, there is no get() method in a HashSet because a HashSet is not backed by an array.
        // The elements are stored in random order in a HashSet, and we can’t get a particular element.
        // If we want to check whether a particular element is in the HashSet or not, then we can use the contains() method.
        System.out.println(set.contains(23));

        //Since a HashSet stores the elements in random order, it is not possible to store the elements in a HashSet in sorted order.
        // If we want to sort the elements of a HashSet, then we should convert it into some other Collection such as a List, TreeSet, or LinkedHashSet.
        List<Integer> list = new ArrayList<>(set);
        // Sorting the list.
        Collections.sort(list);

        list.forEach(System.out::println);

        int[] data = {12, 34, 1, 56, 43, 34, 65};
        int duplicate = 0;
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < data.length; i++) {
            if(!set1.add(data[i])) {
              duplicate = data[i];
              break;
            }
        }


        System.out.println(duplicate);
    }
}
