package Ejercicio3;

import Ejercicio3.Packages.PackageList;

public class Test {
	public static void main(String[] args) {
		PackageList list = new PackageList();
		list.addPackage(5, 15);
		list.addPackage(5,15);
		//list.addPackage(5, 10);
		list.addPackage(5, 5);
		//list.addPackage(5, 10);
		//list.addPackage(4, 13);
		list.addPackage(4, 7);
		//list.addPackage(4, 5);
		//list.addPackage(4, 5);
		//list.addPackage(4, 10);
		//list.addPackage(4, 15);
		list.addPackage(4, 5);
		list.addPackage(4, 3);
		list.addPackage(4, 2);
		Packages data = new Packages();
		data.getBestPackage(20, list);
	}

}
