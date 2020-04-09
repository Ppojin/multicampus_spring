package workshop.account.entity;

public class Account {
    private String cusId;
	private String accId;
    private int balnce;

    public Account(){}

    public Account(String cusId, String accId, int balnce) {
        this.cusId = cusId;
        this.accId = accId;
        this.balnce = balnce;
    }

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public int getBalnce() {
		return balnce;
	}

	public void setBalnce(int balnce) {
		this.balnce = balnce;
	}

	//입금
	public void deposite(int amount){
    	this.balnce += amount;
	}

	//출금
	public void withdraw(int amount){
    	if(this.balnce-amount >= 0){
    		this.balnce -= amount;
		}
	}

	@Override
	public String toString() {
		return "Account [cusId=" + cusId + ", accId=" + accId + ", balnce=" + balnce + "]";
	}

//	@Override
//	public String toString() {
//		return "Account{" +
//				"cusId='" + cusId + '\'' +
//				", accId='" + accId + '\'' +
//				", balnce=" + balnce +
//				'}';
//	}
	
	
}
