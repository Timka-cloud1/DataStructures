package map.hashmap;



import java.util.*;

/**
 * Some of the features of HashMap are:
 *
 * The keys should be unique.
 * HashMap allows only one null key.
 * The values can be null or duplicate.
 * The keys are stored in random order.
 *
 * The first and foremost requirement for a good key is that it should follow the hashcode() and equals() contract. The contract says:
 *
 * If two objects are equal, then they must have the same hash code.
 * If two objects have the same hash code, they may or may not be equal.
 * This means that the class that is being used as a key must override both equals() and hashcode() methods.
 */

public class Main {
    public static void main(String[] args) {
        //The simplest way to create a HashMap is by using the no-arg constructor.
        // This constructor creates a HashMap with an initial capacity of 16 and load factor of 0.75.

    }

    public static void sorting() {
//        Map<Integer, String> employeeMap = new HashMap<>();
//        employeeMap.put(123, "Alex");
//        employeeMap.put(342, "Ryan");
//        employeeMap.put(143, "Joe");
//        employeeMap.put(234, "Allen");
//        employeeMap.put(432, "Roy");
//
//        List<Integer> keyList = new ArrayList<>(employeeMap.keySet());
//        Collections.sort(keyList);
//        System.out.println(keyList);
//
//
//        List<String> valuesList = new ArrayList<>(employeeMap.values());
//        Collections.sort(valuesList);
//        System.out.println(valuesList);
        Map<Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(123, "Alex");
        employeeMap.put(342, "Ryan");
        employeeMap.put(143, "Joe");
        employeeMap.put(234, "Allen");
        employeeMap.put(432, "Roy");

        System.out.println("Sorting by key");
        employeeMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey())
                .forEach(System.out::println);

        System.out.println("Sorting by value");
        employeeMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }

    public static void putElement() {
        Map<String, Integer> stockPrice = new HashMap<>();
        stockPrice.put("Oracle", 56); //Inserting share price of Oracle in the Map.
        System.out.println(stockPrice);

        stockPrice.put("Oracle", 60); //Inserting share price of Oracle again. This will update the value.
        System.out.println(stockPrice);

        stockPrice.putIfAbsent("Oracle", 70); //Inserting share price of Oracle again using putIfAbsent() method. This will not update the value.
        System.out.println(stockPrice);
    }

    public static void updateValue() {
        Map<String, Integer> stockPrice = new HashMap<>();

        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);

        // This will not replace the value of Oracle because current value is not 70.
        stockPrice.replace("Oracle", 70, 76);
        System.out.println(stockPrice.get("Oracle"));

        // This will replace the value of Oracle because current value is 56.
        stockPrice.replace("Oracle", 56, 76);
        System.out.println(stockPrice.get("Oracle"));

        // This will replace the value of Fiserv as current value does not matter.
        stockPrice.replace("Fiserv", 100);
        System.out.println(stockPrice.get("Fiserv"));

        // Using the replaceAll() method to add 10 to the price of each stock.
        //Using the replaceAll(BiFunction<? super K, ? super V, ? extends V> function) method#
        //This method takes a BiFunction as input and replaces the values of all the keys with the result of the given function.
        // Suppose we need to add ten to the stock price of each company. Instead of updating the value for each stock one by one,
        // we can use this method.
        stockPrice.replaceAll((k,v) -> v + 10);
        System.out.println(stockPrice);
    }

    public static void removeValue() {
        // An element can be easily removed for the HashMap using the remove(Object key) method.
        // It takes a key as a parameter and removes that key from the map. This method returns the value of the key that was removed.
        // If the key is not present, then it returns null.
        //
        //Another overloaded version of this method remove(Object key, Object value) was added in Java 8.
        // This method removes a key only if it is currently mapped to the specified value.
        // This method returns true if the key is removed; otherwise, it returns false.


        Map<String, Integer> stockPrice = new HashMap<>();

        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);

        //This will remove Oracle from the Map and return 56.
        System.out.println(stockPrice.remove("Oracle"));

        //This will return null as Google is not present in the Map.
        System.out.println(stockPrice.remove("Google"));

        //This will return false because the value passed does not match the value of BMW in the Map.
        System.out.println(stockPrice.remove("BMW", 45));
    }

    public static void computeExample() {
        Map<String, Integer> map = new HashMap<>();
        map.put("India", 5);
        map.put("USA", 3);
        map.put("China", 5);
        map.put("Russia", 6);

        // This will increment the value of India by 1 as it is present in the Map
        map.compute("India", (k, v) -> v == null ? 10 : v + 1);

        // This will insert Vietnam in the Map with default value of 10.
        map.compute("Vietnam", (k, v) -> v == null ? 10 : v + 1);

        System.out.println(map);

    }

    public static void keyHaveToBeImmutable() {
        //It is not mandatory for a HashMap key to be immutable, but it is suggested that key objects are immutable. Immutability allows us to get the same hash code every time for a key object.
        //
        //All the wrapper classes such as String, Integer, etc., are immutable, so they are considered good key candidates.
        //
        //Let’s look at an example to understand what happens when a key object is not immutable.
        // In the below example, we are using an Employee object as a key. After inserting the employee object into the HashMap,
        // we will make a change in the Employee object. After that, we will try to get the value for this key from the HashMap.
        Employee emp1 = new Employee(123, "Jane");

        Map<Employee, Integer> employeeMap = new HashMap<>();

        employeeMap.put(emp1, 56000);

        emp1.empName = "Alex";

        System.out.println(employeeMap.get(emp1));
        //When we run the above program, null is returned. The reason is when we change the Employee object its hashcode also changes.
        // Therefore, when we try to search for the Employee object, a different bucket is returned.
        // So, although the object was present in the HashMap, it is not returned.
        //If we are using a custom object as the HashMap key, then either the class should be immutable, or the fields that are used to calculate the hashcode should be made final.

    }

    public static void loop() {

//        Map<String, Integer> stockPrice = new HashMap<>();
//
//        stockPrice.put("Oracle", 56);
//        stockPrice.put("Fiserv", 117);
//        stockPrice.put("BMW", 73);
//        stockPrice.put("Microsoft", 213);
//
//        Set<Map.Entry<String, Integer>> entrySet = stockPrice.entrySet(); // Returns a Set of Entries
//
//        for (Map.Entry<String, Integer> entry : entrySet) {
//            System.out.println("Company Name: " + entry.getKey() + " Stock Price: " + entry.getValue());
//        }

        Map<String, Integer> stockPrice = new HashMap<>();

        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);

        Set<Map.Entry<String, Integer>> entrySet = stockPrice.entrySet(); // Returns a Set of Entries

        Iterator<Map.Entry<String, Integer>> itr = entrySet.iterator(); //Getting the iterator

        while (itr.hasNext()) {
            Map.Entry<String,Integer> entry = itr.next();
            System.out.println("Company Name: " + entry.getKey() + " Stock Price: " + entry.getValue());

            if(entry.getKey().equals("Oracle")) {
                itr.remove();
            }
        }
        System.out.println(stockPrice);

//        Map<String, Integer> stockPrice = new HashMap<>();
//
//        stockPrice.put("Oracle", 56);
//        stockPrice.put("Fiserv", 117);
//        stockPrice.put("BMW", 73);
//        stockPrice.put("Microsoft", 213);
//
//        stockPrice.forEach((key, value) -> System.out
//                .println("Company Name: " + key + " Stock Price: " + value));

    }

    public static void mergeExample() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Jay", 5000);
        map1.put("Rahul", 3000);
        map1.put("Nidhi", 4500);
        map1.put("Amol", 60000);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Jay", 7000);
        map2.put("Rahul", 4500);
        map2.put("Nidhi", 1200);
        map2.put("Saurav", 25000);

        map1.forEach((key,value) -> map2.merge(key, value, (v1, v2) -> v1 + v2));

        System.out.println(map2);
    }

    public static void howItWorks() {
        //Основным принципом, используемым HashMap для хранения элементов, является хеширование.
        // Хэширование — это способ присвоения уникального кода любой переменной или объекту после применения какой-либо формулы к его свойствам. Уникальный код называется HashCode.
        //
        //Вот некоторые из свойств HashCode:
        //
        //Если два объекта равны, то они должны иметь одинаковый хэш-код.
        //Если два объекта имеют одинаковый хэш-код, то они не обязательно должны быть равными.

        //When an element is inserted into the Hashmap for the first time, the array table is initialized with size 16. So now there are 16 buckets from index 0 to 15.
        //
        //If the key that we are inserting is null, then it is inserted at index 0 because the hashcode of null is 0. If the key is not null, then the hash of the key is calculated, and based on the hash value the bucket is decided.
        //
        //If there is no other element in that bucket, then a new Node is created, and it is inserted in that bucket.

        //При изменении размера HashMap его емкость всегда удваивается. Таким образом, если текущая емкость равна 16, то новая емкость будет равна 32. Теперь все элементы, хранящиеся в HashMap, будут перераспределены среди этих 32 сегментов. Это трудоемкая операция, так как сегмент для каждого ключа вычисляется и переставляется.
    }
}
