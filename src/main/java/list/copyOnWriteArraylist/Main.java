package list.copyOnWriteArraylist;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    /**
     * it's a thread safe list
     * @param args
     */
    public static void main(String[] args) {
//        List<String> list = new CopyOnWriteArrayList<>();
//        list.add("Apple");
//        list.add("Banana");
//        list.add("Orange");
//
//        //Created an iterator
//        Iterator<String> itr = list.iterator();
//        //Adding elements after creating iterator. ConcurrentModificationException will not be thrown.
//        list.add("Papaya");
//
//        //Iterating the list through the iterator that was created earlier. Papaya will not be present.
//        while(itr.hasNext()) {
//            System.out.println(itr.next());
//        }
//
//        System.out.println("Again getting the iterator");
//        //Again creating the iterator. This time papaya will be present.
//        itr = list.iterator();
//        while(itr.hasNext()) {
//            System.out.println(itr.next());
//        };

        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
            list.remove("Orange");
        }
        System.out.println("Again creating the iterator");
        //Created an iterator
        itr = list.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());

        }

    }

}
