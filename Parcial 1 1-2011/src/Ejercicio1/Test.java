package Ejercicio1;

public class Test {
	public static void main(String[] args) {
		VersionableMap<String, String> map = new VersionableMapImpl<String, String>();
		map.put("key1", "value1"); // version 1
		map.put("key2", "value2"); // version 2
		map.put("key1", "another"); // version 3
		map.remove("key2"); // version 4
		System.out.println(map.get("key1", 0)); // null
		System.out.println(map.get("key1", 1)); // value1
		System.out.println(map.get("key1", 2)); // value1
		System.out.println(map.get("key1", 3)); // another
		System.out.println(map.get("key1", 4)); // another
		System.out.println(" ");
		System.out.println(map.get("key2", 0)); // null
		System.out.println(map.get("key2", 1)); // null
		System.out.println(map.get("key2", 2)); // value2
		System.out.println(map.get("key2", 3)); // value2
		System.out.println(map.get("key2", 4)); // null
	}
}
