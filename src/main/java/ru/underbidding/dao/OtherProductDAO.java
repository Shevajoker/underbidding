package ru.underbidding.dao;

import java.util.List;

public interface OtherProductDAO <Entity>{
	public void saveOtherProbuct(Entity product);
	public void updateOtherProduct(Entity product);
	public Entity getOtherProductById(int id);
	public void deleteOtherProduct(Entity product);
	
	public Entity getOtherProductByAnrexArticle(String anrexArticle);
	public boolean checkOtherProductExist (Entity product);
	public List<Entity> getAllOtherProducts();
}
