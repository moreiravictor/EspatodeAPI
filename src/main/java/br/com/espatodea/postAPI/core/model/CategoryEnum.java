package br.com.espatodea.postAPI.core.model;

public enum CategoryEnum {
	Environment(1),
	Tips(2),
	Projects(3),
	OurProjects(4),
	OtherProjects(5),
	Entertainment(6),
	Food(7),
	FoodTips(8),
	FoodReceits(9);
	
	public int categoryValue;
	
	CategoryEnum(int value) {
		categoryValue = value;
	}
}
