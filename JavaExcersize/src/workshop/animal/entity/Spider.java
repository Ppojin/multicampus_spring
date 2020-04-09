package workshop.animal.entity;

public class Spider extends Animal {

	public Spider() {
		super(8);
	}

	@Override
	public void eat() {
		System.out.println("벌레를 잡아먹어요.");
	}

}
