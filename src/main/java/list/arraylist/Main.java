package list.arraylist;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

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
     * 4) indexOf() is O(n), contains is also O(n), set method is also O(1)
     */
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Alex", 23, "USA"));
        list.add(new Employee("Dave", 34, "India"));
        list.add(new Employee("Carl", 21, "USA"));
        list.add(new Employee("Joe", 56, "Russia"));
        list.add(new Employee("Amit", 64, "China"));
        list.add(new Employee("Ryan", 19, "Brazil"));

        for(Employee employee : list) {
            if(employee.getAge() > 50) {
                System.out.println(employee.getName());
            }
        }

        ListIterator<Employee> employeeListIterator = list.listIterator();
        while (employeeListIterator.hasNext()) {
            Employee employee = employeeListIterator.next();
            if(employee.getCountry().equals("USA")) {
                employeeListIterator.remove();
            }
        }
        System.out.println(list);

        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getCountry().compareTo(o2.getCountry());
            }
        });
        System.out.println(list);
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

    public static void usingForLoop() {
        List <Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        for (int i = 0; i < list.size(); i++) { //Simple for loop
            System.out.println(list.get(i));
        }

        for (Integer i : list) {   //Enhanced for loop
            System.out.println(i);
        }
    }

    public static void iteratorExample() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(10);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }

        System.out.println("Iterating using forEachRemaining() method");
        Iterator<Integer> newItr = list.iterator();
        newItr.forEachRemaining(element -> System.out.println(element));
        //forEachRemaining(Consumer<? super E> action) — performs the given action for each remaining element until
        // all elements have been processed or the action throws an exception. This method’s benefit is that we do not need to check
        // if there is a next element every time.
    }

    public static void listIteratorDemo() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Getting ListIterator
        ListIterator<Integer> listIterator = list.listIterator();

        // Traversing elements
        System.out.println("Forward Direction Iteration:");
        while (listIterator.hasNext()) {
            System.out.println("index now is " + listIterator.nextIndex() + " Next element is " + listIterator.next() +
                    " and next index is " + listIterator.nextIndex());

        }
        // nextIndex() — This method returns the index of the element that would be returned by a subsequent call to next(). It returns the list size if the list iterator is at the end of the list.

        // Traversing elements, the iterator is at the end at this point
        System.out.println("Backward Direction Iteration:");
        while (listIterator.hasPrevious()) {
            System.out.println("index now is " + listIterator.previousIndex() +  " Previous element is " + listIterator.previous() +
                    " and previous index is " + listIterator.previousIndex());
        }
        // previousIndex() — This method returns the index of the element that would be returned by a subsequent call to previous(). It returns -1 if the list iterator is at the beginning of the list.

        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
            if(listIterator.nextIndex() == 1) {
                listIterator.add(50);
                listIterator.previous();
                listIterator.next();
                listIterator.next();
                listIterator.set(25);
                listIterator.previous();
                listIterator.previous();
            }

            //System.out.println(listIterator.previous());
        }
    }

    public static void sortArray() {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(12);
        list.add(9);
        list.add(76);
        list.add(29);
        list.add(75);

        //1
        Collections.sort(list);
        System.out.println("ArrayList in asc order: " + list);

        //2
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println("ArrayList in asc order: " + sortedList);

        //3
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("ArrayList in desc order: " + list);

        //4
        List<Integer> sortedList1 = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("ArrayList in asc order: " + sortedList1);
    }

    public static void sortArrayCustomClass() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Jane", 29, "USA"));
        list.add(new Employee("Alex", 54, "USA"));
        list.add(new Employee("Matt", 19, "USA"));
        list.add(new Employee("Roy", 72, "USA"));

        Collections.sort(list, Comparator.reverseOrder());
        for(Employee emp : list) {
            System.out.println("Employee Name: " + emp.getName() + ", Employee Age: " + emp.getAge());
        }
    }

    public static void sortByComparator() {
        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle("Volkswagen", 2010));
        list.add(new Vehicle("Audi", 2009));
        list.add(new Vehicle("Ford", 2001));
        list.add(new Vehicle("BMW", 2015));

        System.out.println("Sorting by brand name.");
        Collections.sort(list, new BrandComparator());
        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.getBrand() + ", Vehicle Make: " + vehicle.getMakeYear());
        }

        System.out.println("Sorting by make year.");
        Collections.sort(list, new MakeYearComparator());
       // Collections.sort(list, (o1, o2) -> o1.getBrand().compareTo(o2.getBrand())); // with lambda expression
        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.getBrand() + ", Vehicle Make: " + vehicle.getMakeYear());
        }
    }
}
