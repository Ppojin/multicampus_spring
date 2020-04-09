package workshop.animal.entity;

/*
 * Pet pet = new Pet(); 	(x)
 * Pet pet = new Fish(); 	(o)
 */
public interface Pet {
	public abstract void setName(String name);
	String getName();
	void play();
	void eat();
}