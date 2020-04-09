package workshop.book.entity;

public class Magazine extends Publication {
	private String publicshingPeriod; 

	public Magazine() {
		// TODO Auto-generated constructor stub
	}

	public Magazine(String title, String publishingDate, int page, int price, String publicshingPeriod) {
		super(title, publishingDate, page, price);
		this.publicshingPeriod = publicshingPeriod;
		// TODO Auto-generated constructor stub
	}

	public String getPublicshingPeriod() {
		return publicshingPeriod;
	}

	public void setPublicshingPeriod(String publicshingPeriod) {
		this.publicshingPeriod = publicshingPeriod;
	}
}
