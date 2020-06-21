package com.mycode.designpattern;

abstract class DataParser {

	/**
	 * template method- final so you can't override it.
	 */
	public final void parseDataAndGenerateOutput() {
		readData();// Super class calling subclass method
		writeData();
	}

	/**
	 * This methods will be implemented by its subclass. if commented then compile error - method readData() is undefined
	 * for the type DataParser because we calling it from above parseDataAndGenerateOutput
	 */
	abstract void readData();

	/**
	 * This step is common to all so implementing in super class
	 */
	public void writeData() {
		System.out.println("Output generated,writing to CSV"); // prints 2nd
	}
}

/**
 * Output - Reading data from csv file Output generated,writing to CSV
 */
class TemplateDesignPattern extends DataParser {

	public static void main(String[] args) {
		TemplateDesignPattern t = new TemplateDesignPattern();
		t.parseDataAndGenerateOutput();
	}

	void readData() {
		System.out.println("Reading data from csv file"); // prints 1st
	}
}
