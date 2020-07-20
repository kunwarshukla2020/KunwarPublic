package com.mycode.java8;

interface FirstInterface {
	String talk();

	default String whispher() {
		return talk() + ",but softner";
	}

	default String yell() {
		return talk() + ",but louder";
	}
}

interface SecondInterface {
	String talk();

	default String whispher() {
		return talk() + ",but less annoying";
	}

	default String shout() {
		return talk() + ",but more annoying";
	}
}

// Ques is what methods needs to be implemented for two interfaces
public class InterfaceDefaultMethods implements FirstInterface, SecondInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String talk() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String whispher() {
		// TODO Auto-generated method stub
		return SecondInterface.super.whispher();
	}

}
