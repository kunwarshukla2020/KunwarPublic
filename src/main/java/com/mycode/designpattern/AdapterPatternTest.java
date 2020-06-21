package com.mycode.designpattern;

interface SocketAdapter {
	public Volt get120Volt();
	public Volt get12Volt();
	public Volt get3Volt();
}

class Volt {
	private int volts;
	public Volt(int v) {
		this.volts = v;
	}
	public int getVolts() {
		return volts;
	}
	public void setVolts(int volts) {
		this.volts = volts;
	}
}

class Socket {
	public Volt getVolt() {
		return new Volt(120);
	}
}

//Using inheritance for adapter pattern
class SocketClassAdapterImpl extends Socket implements SocketAdapter {

	@Override
	public Volt get120Volt() {
		return getVolt(); // calling Socket method
	}

	@Override
	public Volt get12Volt() {
		Volt v = getVolt(); // calling Socket method
		return convertVolt(v, 10); // creating new Volt here
	}

	@Override
	public Volt get3Volt() {
		Volt v = getVolt(); // calling Socket method
		return convertVolt(v, 40); // creating new Volt here
	}

	private Volt convertVolt(Volt v, int i) { // creating new Volt here
		return new Volt(v.getVolts() / i);
	}

}

//Object Adapter Implementation:
class SocketObjectAdapterImpl implements SocketAdapter {

	// Using Composition for adapter pattern
	Socket sock = new Socket();

	@Override
	public Volt get120Volt() {
		return sock.getVolt(); // calling Socket method
	}

	@Override
	public Volt get12Volt() {
		Volt v = sock.getVolt(); // calling Socket method
		return convertVolt(v, 10);
	}

	@Override
	public Volt get3Volt() {
		Volt v = sock.getVolt(); // calling Socket method
		return convertVolt(v, 40);
	}

	private Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVolts() / i);
	}
}

//Notice that both the adapter implementations are almost same and they implement the SocketAdapter interface. The adapter interface can also be an abstract class.
/*OUTPUT:
v3 volts using Class Adapter=3
v12 volts using Class Adapter=12
v120 volts using Class Adapter=120
v3 volts using Object Adapter=3
v12 volts using Object Adapter=12
v120 volts using Object Adapter=120*/

public class AdapterPatternTest {
	public static void main(String[] args) {

		testClassAdapter();
		testObjectAdapter();
	}

	private static void testClassAdapter() {
		SocketAdapter sockAdapter = new SocketClassAdapterImpl();
		Volt v3 = getVolt(sockAdapter, 3); // or sockAdapter.get3Volt()
		Volt v12 = getVolt(sockAdapter, 12);
		Volt v120 = getVolt(sockAdapter, 120);
		System.out.println("v3 volts using Class Adapter=" + v3.getVolts());
		System.out.println("v12 volts using Class Adapter=" + v12.getVolts());
		System.out.println("v120 volts using Class Adapter=" + v120.getVolts());
	}

	private static void testObjectAdapter() {
		SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
		Volt v3 = getVolt(sockAdapter, 3);
		Volt v12 = getVolt(sockAdapter, 12);
		Volt v120 = getVolt(sockAdapter, 120);
		System.out.println("v3 volts using Object Adapter=" + v3.getVolts());
		System.out.println("v12 volts using Object Adapter=" + v12.getVolts());
		System.out.println("v120 volts using Object Adapter=" + v120.getVolts());
	}

	private static Volt getVolt(SocketAdapter sockAdapter, int i) {
		switch (i) {
		case 3:
			return sockAdapter.get3Volt();
		case 12:
			return sockAdapter.get12Volt();
		case 120:
			return sockAdapter.get120Volt();
		default:
			return sockAdapter.get120Volt();
		}
	}
}
