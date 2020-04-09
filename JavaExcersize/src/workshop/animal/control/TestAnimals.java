package workshop.animal.control;

import workshop.animal.entity.Animal;
import workshop.animal.entity.Cat;
import workshop.animal.entity.Pet;

public class TestAnimals {

	public TestAnimals() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat1 = new Cat();
		cat1.setName("아이유");
		System.out.println(cat1.getName());
		cat1.play();
		cat1.eat();
		cat1.walk();
		
		Animal cat2 = new Cat("고대신");
		cat2.eat();
		cat2.walk();
		
		Pet cat3 = new Cat();
		cat3.setName("먀몸미");
		System.out.println(cat3.getName());
		cat3.play();
	}
}
