package com.mycode.designpattern;

interface Dollar {
	public void dispense(int i);
	public void setNext(Dollar d);
}

class FifetyDollar implements Dollar {
	Dollar d;
	int i;

	@Override
	public void dispense(int i) {
		System.out.println("Dispensing: " + i);
		int r = i % 50;
		System.out.println("Remaining: " + r);
		d.dispense(r);
	}

	@Override
	public void setNext(Dollar n) {
		d = n;
	}

}

class TwentyDollar implements Dollar {
	@Override
	public void dispense(int i) {
		System.out.println("Dispensing: " + i);
		int r = i % 20;
		System.out.println("Remaining: " + r);
	}

	@Override
	public void setNext(Dollar d) {

	}

}

class TenDollar{
	
}

class ChainOfResponsibility {
	public static void main(String args[]) {
		FifetyDollar f = new FifetyDollar();
		TwentyDollar t = new TwentyDollar();
		f.setNext(t);
		f.dispense(80);
	}

}
