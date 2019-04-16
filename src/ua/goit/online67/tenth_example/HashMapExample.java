package ua.goit.online67.tenth_example;

import java.util.*;

/**
 * Example for hash maps.
 *
 * @author andreymi on 3/13/2017.
 */
public class HashMapExample {
    // In java exists also structure which is puts relations between one value to other value.
    // It is called map. This is general name, that was expired from c++ STL map.
    // So map put relation between key and value.
    private static Map<Long, String> map;
    // First type parameter is type of key, second is type of value.
    // Upper example creates map between string and string.
    // In java exists three main map implementations: hash map, tree map and enum map.
    // Lets start from hash map.
    //
    // k -> v.
    // array = (k, v)[].
    //
    // Idea of using hash map comes from hash table: for each key calculated some value named hash and stored
    // hash table mapped hash code to key and key to value.
    // But reality faces problem named hash collisions: when two elements can have same hash keys.
    // Hash collision has more serious consciences then just java hash maps: this is birthday attacks,
    // crypto collisions and soon.
    //
    // Return back to java:
    // Java map is not hash table. In classic hash table to get (add or remove) element you have to spend
    // maximum of O (1) operations. In java you might get O(N) (for large N from java8 - O (log(N)))
    //
    // How java hash map implemented and why O(N).
    // 1. Class Node actually form linked list of nodes.
    // 2. Linked lists of nodes are formed into array of buckets.
    // 3. To get element you calculate hash code X = object.hashCode()
    // 4. Calculate linked list by X % buckets.lenght
    // 5. Traverse list of node until found needed element.
    //
    // So when all elements have same hash code you will simply get same bucket and traverse of linked list
    // will always give you O(N).
    //
    // Lets create hash map and step-by-step check all possible API.
    private static Map<String, String> hashMap = new HashMap<>();
//    private static Map<String, String> hashMap = new Hashtable<>();


    public static void main(String[] args) {
        // To add relation into map key -> value use put method.
        // Method put returns previously stored element by key or null when no mapping was found.
       // hashMap.put("hello", "world1");
        Object prev = hashMap.put("hello", "world");
        System.out.println(hashMap);
        System.out.println(prev);
        prev = hashMap.put("hello", "world1");
        System.out.println(prev);
        hashMap.put("hello", "world3");
        System.out.println(hashMap);
//        // To remove element from map use remove.
//        prev = hashMap.remove("hello");
//        System.out.println(hashMap);
//        System.out.println(prev);
//        // To get element by key use get method.
//        hashMap.put("1", "2");
//        System.out.println(hashMap.get("1"));
//        // To check if element or value exists in map use containsKey
//        // NOTE: values are not indexed so this method will return O(N) always.
//        System.out.println(hashMap.containsKey("1"));
//        System.out.println(hashMap.containsValue("2"));
//        // of course size and isEmpty exists...
//        System.out.println(hashMap.size());
//        System.out.println(hashMap.isEmpty());
//        // You can get set of all keys in hash map.
//        // Key-value pairs may return not in same order as they was inserted.
//        Set<String> keys = hashMap.keySet();
//        // NOTE: removing key from this set will remove key-value mapping from map.
//        // When you want to use only keys without mods: copy data from KeySet.
//        System.out.println(keys);
//        keys.remove("1");
//        System.out.println(hashMap);
//        // Also method values() exists which returns collections of all values.
//        hashMap.put("3", "4");
//        Collection<String> values = hashMap.values();
//        System.out.println(values);
//        // You can get set of key-value pairs: Map.Entry.
//        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
//        // as map do not extend iterable so using entries only option to traverse keys and values.
//        // (before java8).
//        for (Map.Entry<String, String> entry : entries) {
//            // example how to get key and value.
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
//        // In java8 added new method which can return default value when mapping not found.
//        System.out.println(hashMap.getOrDefault("5", "19"));;
//        // To remove all entries use clear()
//        hashMap.clear();
//        // Other methods uses java8 specific things and will be covered later in this course.
//        Set<Integer> integers = Collections.newSetFromMap(new HashMap<>());
//        LinkedHashMap<Integer, Integer> map1;
//        // not by hashCode. ==.
//        IdentityHashMap<Integer, Integer> map2;
//        WeakHashMap<Integer, Integer> map3;
//




        //Map<Integer, String> map = new LinkedHashMap<>();//{1=qwe, 5=dsdddde, 88=fffff, 3=fff44f, 456567=fffff5555, 4=fffffyrty6, null=fffff8888}
//Map<Integer, String> map = new TreeMap<>(); //{1=qwe, 3=fff44f, 4=fffffyrty6, 5=dsdddde, 88=fffff, 456567=fffff5555}
        Map<Integer, String> map = new HashMap<>();//{null=fffff8888, 1=qwe, 456567=fffff5555, 3=fff44f, 4=fffffyrty6, 5=dsdddde, 88=fffff}
        map.put(1, "qwe");
        map.put(5, "dsdddde");
        map.put(88, "fffff");
        map.put(3, "fff44f");
        map.put(456567, "fffff5555");
        map.put(4, "fffffyrty6");
        map.put(4, "ggggg");
        map.put(null, "fffff77777");
        map.put(null, "fffff8888");
        System.out.println(map);

        List<Integer> keyList = new ArrayList<>(map.keySet());
//лист значений
        List<String> valueList = new ArrayList<String>(map.values());
//лист ключ-значения
        List<Map.Entry<Integer,String>> entryList = new ArrayList<>(map.entrySet());
        System.out.println(keyList);
        System.out.println(valueList);
        System.out.println(entryList);
        System.out.println(entryList.get(0));







        HashMap<Dog, Integer> hashMap = new HashMap<Dog, Integer>();
        Dog d1 = new Dog("red");
        Dog d2 = new Dog("black");
        Dog d3 = new Dog("white");
        Dog d4 = new Dog("white");

        hashMap.put(d1, 10);
        hashMap.put(d2, 15);
        hashMap.put(d3, 5);
        hashMap.put(d4, 20);//разные объекты, поэтому добавится и d3 и d4,  если не переопределить в Dog hashCode и equals

        //print size
        System.out.println(hashMap.size());

        //loop HashMap
        for (Map.Entry<Dog, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry);
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
//        4
//        red dog - 10
//        white dog - 20
//        white dog - 5
//        black dog - 15




        HashMap<String, Integer> hashMap1 = new HashMap<String, Integer>();
        Dog d11 = new Dog("red");
        Dog d22 = new Dog("black");
        Dog d33 = new Dog("white");
        Dog d44 = new Dog("white");

        hashMap1.put(d11.color, 10);
        hashMap1.put(d22.color, 15);
        hashMap1.put(d33.color, 5);
        hashMap1.put(d44.color, 20);// заменит предыдущий

        //print size
        System.out.println(hashMap1.size());

        //loop HashMap
        for (Map.Entry<String , Integer> entry : hashMap1.entrySet()) {
//            System.out.println(entry);
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
//        3
//        red - 10
//        white - 20
//        black - 15
//Collections.unmodifiableList();
//Comparator
//        Comparable

//SORT BY VALUE

        LinkedList<Map.Entry<String, Integer>> list = new LinkedList<>(hashMap1.entrySet());
        Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
        Collections.sort(list, comparator.reversed());
        System.out.println(list);





        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("a", 10);
        map1.put("b", 30);
        map1.put("c", 50);
        map1.put("d", 40);
        map1.put("e", 20);
        System.out.println(map1);

        Map<String, Integer> sortedMap = sortByValue(map1);
        System.out.println(sortedMap);

    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap) {
        ValueComparator valueComparator = new ValueComparator(unsortedMap);// запихиваем map в класс,
        // который имплементирует Comparator
        System.out.println(valueComparator.getMap());
        Map<String, Integer> sortedMap = new TreeMap<String, Integer>(valueComparator);// а теперь запихиваем
        // в TreeMap компаратор ValueComparator, которій сортирует по значению (см. compare(...))
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }

}






class Dog {
    String color;

    Dog(String c) {
        color = c;
    }

    public boolean equals(Object o) {
        return ((Dog) o).color.equals(this.color);
    }

    public int hashCode() {
        return color.length();
    }

    public String toString() {
        return color + " dog";
    }
}

class ValueComparator implements Comparator {
  private Map map;

    public ValueComparator(Map map) {
        this.map = map;
    }

    public int compare(Object keyA, Object keyB) {
        Comparable valueA = (Comparable) map.get(keyA);
        Comparable valueB = (Comparable) map.get(keyB);
        return valueB.compareTo(valueA);
    }
    Map getMap() {
        return this.map;
    }
}
