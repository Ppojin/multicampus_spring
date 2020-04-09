package workshop.animal.entity;

public class Fish extends Animal implements Pet {
	private String name;
	public Fish(String name) {
		super(0);
		this.name = name;
		// TODO Auto-generated constructor stub
	}
	
	public Fish() {
		this("");
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void play() {
		System.out.println("헤엄치면서 놀아요.");
	}

	@Override
	public void eat() {
		System.out.println("물고기밥을 먹어요.");
	}

	@Override
	public void walk() {
		System.out.println("물속을 헤엄친다.");
	}
}
