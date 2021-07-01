package ru.underbidding.dao;

public interface OtherProductDAO <Entity>{
	public void saveOtherProbuct(Entity product);
	public void updateOtherProduct(Entity product);
	public Entity getOtherProductById(int id);
	public void deleteOtherProduct(Entity product);
}
