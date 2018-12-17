package domain.model;

public class Student {
	
	private String name;
	private RatingUnit huidig;
	private RatingUnit verleden;
	
	public Student() {
		huidig = new RatingUnit();
		verleden = new RatingUnit();
		setName("Onbepaald");
	}
	
	public Student(String name) {
		huidig = new RatingUnit();
		verleden = new RatingUnit();
		setName(name);
	}
	
	public int getSamenwerking() {
		return huidig.getSamenwerking();
	}
	
	public int getOudeSamenwerking() {
		return verleden.getSamenwerking();
	}
	
	public void setSamenwerking(int samenwerking) {
		verleden.setSamenwerking(huidig.getSamenwerking());
		huidig.setSamenwerking(samenwerking);
	}

	public int getCreativiteit() {
		return huidig.getCreativiteit();
	}
	
	public int getOudeCreativiteit() {
		return verleden.getCreativiteit();
	}
	
	public void setCreativiteit(int creativiteit) {
		verleden.setCreativiteit(huidig.getCreativiteit());
		huidig.setCreativiteit(creativiteit);
	}

	public int getKwaliteit3() {
		return huidig.getKwaliteit3();
	}
	
	public int getOudeKwaliteit3() {
		return verleden.getKwaliteit3();
	}

	public void setKwaliteit3(int kwaliteit3) {
		verleden.setKwaliteit3(huidig.getKwaliteit3());
		huidig.setKwaliteit3(kwaliteit3);
	}

	public int getKwaliteit4() {
		return huidig.getKwaliteit4();
	}
	
	public int getOudeKwaliteit4() {
		return verleden.getKwaliteit4();
	}

	public void setKwaliteit4(int kwaliteit4) {
		verleden.setKwaliteit4(huidig.getKwaliteit4());
		huidig.setKwaliteit4(kwaliteit4);
	}

	public int getKwaliteit5() {
		return huidig.getKwaliteit5();
	}
	
	public int getOudeKwaliteit5() {
		return verleden.getKwaliteit5();
	}

	public void setKwaliteit5(int kwaliteit5) {
		verleden.setKwaliteit5(huidig.getKwaliteit5());
		huidig.setKwaliteit5(kwaliteit5);
	}

	public int getKwaliteit6() {
		return huidig.getKwaliteit6();
	}
	
	public int getOudeKwaliteit6() {
		return verleden.getKwaliteit6();
	}

	public void setKwaliteit6(int kwaliteit6) {
		verleden.setKwaliteit6(huidig.getKwaliteit6());
		huidig.setKwaliteit6(kwaliteit6);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean hasName(String name) {
		return name.equals(this.name);
	}

}
