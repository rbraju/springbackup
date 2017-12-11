package com.spring.di.factory.type2;

public class PrintableFactory {

	public static Printable getPrintable() {
		return new Az(); // Can return instance of either Az or Bz
	}
}
