package workshop.animal.entity;


/*
 * 추상클래스
 * 추상클래스는 스스로 객체를 생성할 수 없다.
 * Animal ani = new Animal(); (x)
 * Animal cat = new Cat(); (o)
 * 추상메서드가 없어도 된다. 
 * body 가 있는 concreate method(구현 메서드) 를 선언할 수 있다.
 */
public abstract class Animal {
	public Animal(int legs) { this.legs = legs; }
	protected int legs;
	public abstract void eat();
	public void walk() {
		System.out.println("Animal은 " + this.legs + "로 걷는다.");
	}
}
