package com.mycode.corejavabasics;

import java.util.ArrayList;
import java.util.List;

//Final variables must be initialized either at declaration level or either in constructor. Once defined can't change its value
public class FinalVar {

	final String a;
	final List<String> al;

	FinalVar() {
		a = "abc";
		al = new ArrayList<>();
	}

	public static void main(String[] args) {
		FinalVar t = new FinalVar();
		t.show();

	}

	// Final list manipulation still allowed
	private void show() {
		al.add("a");
		al.get(0);
		al.remove(0);
		System.out.println(a);
		System.out.println(al);
	}

}

//OUTPUT-
//abc
//[]
