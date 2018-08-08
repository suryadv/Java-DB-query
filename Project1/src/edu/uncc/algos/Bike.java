package edu.uncc.algos;

public class Bike {
	
	private String type, gear, whl_base, height, color, material;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGear() {
		return gear;
	}

	public void setGear(String gear) {
		this.gear = gear;
	}

	public String getWhl_base() {
		return whl_base;
	}

	public void setWhl_base(String whl_base) {
		this.whl_base = whl_base;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Bike(String type, String gear, String whl_base, String height, String color, String material) {
		this.type = type;
		this.gear = gear;
		this.whl_base = whl_base;
		this.height = height;
		this.color = color;
		this.material = material;
	}

	@Override
	public String toString() {
		return "Bike [type=" + type + ", gear=" + gear + ", whl_base=" + whl_base + ", height=" + height + ", color="
				+ color + ", material=" + material + "]";
	}
	
	

}
