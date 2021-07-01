package ru.underbidding.dao;

public interface AnrexProductDAO <Entity>{
	
	public void saveAnrexProbuct(Entity product);
	public void updateAnrexProduct(Entity product);
	public Entity getAnrexProductById(int id);
	public void deleteAnrexProduct(Entity product);
	

}
