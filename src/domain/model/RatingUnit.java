package domain.model;

public class RatingUnit {
	private int samenwerking;
	private int creativiteit;
	private int kwaliteit3;
	private int kwaliteit4;
	private int kwaliteit5;
	private int kwaliteit6;
	
	public RatingUnit() {
		
	}
	
	public int getSamenwerking() {
		return samenwerking;
	}
	
	public void setSamenwerking(int samenwerking) {
		this.samenwerking = clamp(samenwerking, 0, 6);
	}
	
	public int getCreativiteit() {
		return creativiteit;
	}
	
	public void setCreativiteit(int creativiteit) {
		this.creativiteit = clamp(creativiteit, 0, 6);
	}

	public int getKwaliteit3() {
		return kwaliteit3;
	}

	public void setKwaliteit3(int kwaliteit3) {
		this.kwaliteit3 = clamp(kwaliteit3, 0, 6);
	}

	public int getKwaliteit4() {
		return kwaliteit4;
	}

	public void setKwaliteit4(int kwaliteit4) {
		this.kwaliteit4 = clamp(kwaliteit4, 0, 6);
	}

	public int getKwaliteit5() {
		return kwaliteit5;
	}

	public void setKwaliteit5(int kwaliteit5) {
		this.kwaliteit5 = clamp(kwaliteit5, 0, 6);
	}

	public int getKwaliteit6() {
		return kwaliteit6;
	}

	public void setKwaliteit6(int kwaliteit6) {
		this.kwaliteit6 = clamp(kwaliteit6, 0, 6);
	}
	
	private Integer clamp(int input, int min, int max) {
		if (input < min) {
			return min;
		}
		if (input > max) {
			return max;
		}
		return input;
	}

}
