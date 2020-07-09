package com.mycode.designpattern;

// ----120v-->|Adapter|=====> 3v
// ----240v-->|		  |
// Input can be USVolt,IndiaVolt and adapter return correct volt say 3v..
class Adapter {
	public IVolt convert(IVolt v) {
		IVolt outputVolt = null;
		if (v.getVolts() == 120) {
			outputVolt = new USVolt(3);
		}
		return outputVolt;
	}
}

interface IVolt {
	int getVolts();
}

class USVolt implements IVolt { // Similarly can be IndiaVolt
	int i;// Instead of int, can create Volt class, try that

	public USVolt() {
		this.i = 120;
	}

	public USVolt(int i) {
		this.i = i;
	}

	public int getVolts() {
		return i;
	}
}

public class AdapterPattern {
	public static void main(String[] args) {
		IVolt usObj = new USVolt();
		Adapter a = new Adapter();
		IVolt output = a.convert(usObj);
		System.out.println(output.getVolts());
	}

}
