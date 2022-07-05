package set.treeset;

import java.util.Set;
import java.util.TreeSet;

/**
 * Java TreeSet class implements the Set interface that uses a tree for storage. It inherits the AbstractSet class and implements the NavigableSet interface.
 *
 * Some of the features of TreeSet are:
 *
 * TreeSet does not allow duplicate elements.
 * TreeSet class doesn’t allow null elements.
 * Since elements are stored in a tree, the access and retrieval times are quite fast in a TreeSet.
 * The elements are stored in ascending order in a TreeSet.
 *
 * Difference between a HashSet and TreeSet#
 * The HashSet allows one null element, whereas a TreeSet does not allow a null element.
 * The elements are stored in random order in a HashSet, whereas it is stored in sorted order in TreeSet.
 * HashSet is faster than Treeset for the operations like add, remove, contains, size, etc.
 */
public class Main {
    // When an instance of TreeSet is created using the no-arg constructor it internally creates an empty instance of TreeMap.
    public static void main(String[] args) {
        int[] numbers = {1,4,5,2,34,66,5,4,33,45,6,8,56,76,78,98,34,37,12,12,23,43,54,56};

        TreeSet<Integer> set = new TreeSet<>();
        for(int num : numbers) {
            set.add(num);
        }
        System.out.println(set.tailSet(50));
        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println(set);


        //If the objects that we are storing in a TreeSet do not implement the Comparable interface or if we need to store the elements in descending order,
        // then we can provide a custom Comparator while creating the TreeSet. Now when the elements are stored in the TreeSet,
        // they are sorted as per the logic provided by the Comparator.


    }

    public static void getElement() {
        //Fetching the first element#
        //We can fetch the first element in the TreeSet using the first() method. If the TreeSet is empty, then NoSuchElementException is thrown.
        //
        //Fetching the last element#
        //We can fetch the last element in the TreeSet using the last() method. If the TreeSet is empty, then NoSuchElementException is thrown.
        //
        //Fetching the subset of elements#
        //We can use the subSet(E fromElement, E toElement) method to fetch a subset of TreeSet within a given range. This method will return the elements ranging from fromElement to toElement. Note that fromElement is inclusive and toElement is exclusive.
        //
        //Fetching elements that are smaller than the given element#
        //The headSet(E toElement) method returns all the elements that are smaller than the provided element. The toElement is not inclusive.
        //
        //Fetching elements that are greater than the given element#
        //The tailSet(E fromElement) method returns all the elements which are greater than the provided element. The fromElement is not inclusive.

        TreeSet<Integer> set = new TreeSet<>();
        set.add(21);
        set.add(32);
        set.add(44);
        set.add(11);
        set.add(54);
        set.add(3);
        set.add(9);
        set.add(41);

        System.out.println("Fetching the first element in TreeSet " + set.first());
        System.out.println("Fetching the last element in TreeSet " + set.last());
        System.out.println("Fetching all the elements less than 40 " + set.headSet(40));
        System.out.println("Fetching all the elements greater than 40 " + set.tailSet(40));
    }
}
