package workshop.animal.entity;

public class Cat extends Animal implements Pet{
	private String name;
	
	public Cat(String name) {
		super(4);
		this.name = name;
	}
	
	public Cat() {
		this("");
	}
	
	@Override
	public void eat() {
		System.out.println("쥐를 잡아먹는다.");
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void play() {
		System.out.println("우다다다 하고 논다.");
	}
}
