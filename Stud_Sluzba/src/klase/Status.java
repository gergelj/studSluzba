package klase;

public enum Status {
	B(1), S(2);
	int status;
	private Status() {}
	private Status(int i) {
		this.status = i;
	}
	private String[] opis = {"budžet", "samofinansiranje"};
	
	@Override
	public String toString() {
		return opis[this.ordinal()];
	}
}
