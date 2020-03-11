package DataLab;

public class WestNile {
		
	private String area;
	private int virusTotal;
	
	public WestNile(String area, int total) {
		setArea(area);
		setVirusTotal(total);
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getVirusTotal() {
		return virusTotal;
	}

	public void setVirusTotal(int virusTotal) {
		this.virusTotal = virusTotal;
	}

}
