package components;

public interface Component 
{
	String getName();
	
	public void addComponent(CoreComponent comp);
	public void removeComponent(String name);
	public CoreComponent getComponent(String name);
	
	public void init();
	public void update();

}
