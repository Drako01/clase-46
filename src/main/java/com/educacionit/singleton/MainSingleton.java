package com.educacionit.singleton;

public class MainSingleton {

	public static void main(String[] args) {

		Singleton miSingleton = Singleton.getInstance();
		miSingleton.funcionlidad1();
		System.out.println(miSingleton.funcionlidad2());

		Singleton miSingleton2 = Singleton.getInstance();
		miSingleton2.funcionlidad1();
		System.out.println(miSingleton2.funcionlidad2());
		
		if (miSingleton == miSingleton2) {
			System.out.println("Los Objetos son Iguales.");
		}

	}

}
