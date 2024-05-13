package com.educacionit.singleton;

public class Singleton {

	private static Singleton _instance;
	private String funcionlidad2;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (_instance == null) {
			_instance = new Singleton();
		}
		return _instance;
	}

	public void funcionlidad1() {
		System.out.println("Soy la funcionalidad1");
	}

	public String funcionlidad2() {
		funcionlidad2 = "Hola Mundo";
		return funcionlidad2;
	}
}
