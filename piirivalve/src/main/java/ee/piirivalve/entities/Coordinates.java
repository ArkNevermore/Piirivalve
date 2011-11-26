package ee.piirivalve.entities;

public class Coordinates {

	public Coordinates (String longitude, String latitude, String height) {
		
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}
	String longitude;
	String latitude;
	String height;
	
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
}
