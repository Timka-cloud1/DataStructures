package list.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {
    /**
     * Time complexity:
     * 1) Adding elements is O(1) time in most of the cases.
     * It will take more time if the ArrayList is full and needs to be resized.
     * In that scenario, a new array will be created, and elements will be copied from the old array to the new array.
     * add(index, element) – on average runs in O(n) time
     *
     * 2) The remove operation has O(n) complexity in the worst case and O(1) in the best case.
     * There are two overloaded versions of the remove() method in ArrayList:
     * The first one takes the index of the element that needs to be removed as input. The element can be found in O(1) time using the index,
     * but when the element is removed, the other elements need to be moved to the left. So, if the last element is removed the complexity will be O(1)
     * otherwise, O(n)
     * In the second case, the remove() method takes the element that needs to be removed as input.
     * The array is scanned from the beginning to find the first occurrence of that element, and then it is removed. This has a complexity of O(n)
     *
     * 3) Fetching an element from an array using an index is O(1) constant-time operation. So, fetching an element from an ArrayList takes constant time.
     *
     * 4) indexOf() is O(n), contains is also O(n), set method is also O(n)
     */
    public static void main(String[] args) {


    }

    public static void replaceAllMethod() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.replaceAll((element) -> element.toUpperCase());
        System.out.println(list);
        //  This method takes a single UnaryOperator type argument.
        //  The UnaryOperator interface is a functional interface that has a single abstract method, apply(), that returns a result
        //  of the same object type as the operand.
        //  Let’s say we have an ArrayList that contains String objects; we need to make all the elements in this list uppercase.
        //  In this case, we can use the replaceAll() method and provide it with a lambda expression that converts each element into uppercase.
    }
}
