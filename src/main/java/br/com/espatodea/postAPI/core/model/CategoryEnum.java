package br.com.espatodea.postAPI.core.model;

public enum CategoryEnum {	
	Environment(0),
	EnvironmentTips(1),
	Projects(2),
	OurProjects(3),
	OtherProjects(4),
	Entertainment(5),
	Food(6),
	FoodTips(7),
	FoodReceits(8);
	
	public int categoryValue;
	
	CategoryEnum(int value) {
		categoryValue = value;
	}
}
