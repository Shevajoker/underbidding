package ru.underbidding.dao;

import java.util.List;

public interface AnrexProductDAO <Entity>{
	
	public void saveAnrexProbuct(Entity product);
	public void updateAnrexProduct(Entity product);
	public Entity getAnrexProductById(int id);
	public Entity getAnrexProductByArticle(String article);
	public void deleteAnrexProduct(Entity product);
	public boolean checkAnrexProductExist(Entity product);
	public List<Entity> getAllAnrexProducts();
	

}
