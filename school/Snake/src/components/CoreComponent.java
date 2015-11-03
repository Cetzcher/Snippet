package components;

public abstract class CoreComponent implements Component
{
	private CoreObject attachedObject;
	
	public CoreObject getAttached()
	{
		return attachedObject;
	}
	
	/**
	 * Returns a name for the Component
	 */
	@Override
	public abstract String getName();

	/**
	 * Called when the object is created
	 */
	@Override
	public void init() 
	{
		
	}

	/**
	 * Called when the object receives an update
	 */
	@Override
	public void update()
	{
		
	}
	
	/**
	 * Hook for the CoreObject
	 * @param creator
	 */
	void internalStart(CoreObject creator)
	{
		attachedObject = creator;
		init();
	}
	
	@Override
	public void addComponent(CoreComponent comp) { attachedObject.addComponent(comp); }
	@Override
	public void removeComponent(String name) { attachedObject.removeComponent(name); }
	@Override
	public CoreComponent getComponent(String name) { return attachedObject.getComponent(name); }
	public void onRemove(){}
}
