package com.mycode.designpattern;

interface Animal {
	public void breathe();
}

class Shark implements Animal {
	public void breathe() {
		System.out.println("I breathe in water! He he!");
	}
}

class Elephant implements Animal {
	public void breathe() {
		System.out.println("I breathe with my lungs. Its easy!");
	}
}

interface AnimalFactory {
	public Animal createAnimal();
}

class SeaFactory implements AnimalFactory {
	public Animal createAnimal() {
		return new Shark();
	}
}

class LandFactory implements AnimalFactory {
	public Animal createAnimal() {
		return new Elephant();
	}
}

//Output:I breathe in water! He he!

//Client
class AbstractFactory {
	public static void main(String args[]) {
		AnimalFactory animalFactory = createAnimalFactory("water");//First create water animal
		Animal animal = animalFactory.createAnimal(); //what animal in water to be created
		animal.breathe();
	}

	static AnimalFactory createAnimalFactory(String type) {
		if ("water".equals(type))
			return new SeaFactory();
		else
			return new LandFactory();
	}

}

//Factory creator - an indirect way of instantiating the factories
/*class Wonderland {
	public Wonderland(AnimalFactory factory) {
		Animal animal = factory.createAnimal();
		animal.breathe();
	}
}
//Client
class Test {
	public static void main(String args[]){
		new Wonderland(createAnimalFactory("water"));
	}

	public static AnimalFactorycreateAnimalFactory(String type){
		if("water".equals(type))
			return new SeaFactory();
		else
			return new LandFactory();
	}
}*/



