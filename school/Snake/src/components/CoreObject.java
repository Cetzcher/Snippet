package components;

import java.util.HashMap;
import java.util.Map;

import core.GameHandler;

public final class CoreObject implements Component
{

	private Map<String, CoreComponent> components;
	
	public CoreObject()
	{
		components =  new HashMap<String, CoreComponent>();
		GameHandler.getInstance().addCoreObject(this);
		init();
	}

	public void delete()
	{
		for(Map.Entry<String, CoreComponent> e : components.entrySet())
		{
			removeComponent(e.getValue().getName());
		}
		GameHandler.getInstance().removeCoreObject(this);
	}
	
	@Override
	public String getName() 
	{
		return "NONE";
	}

	/**
	 *  Adds a component to the CoreObject
	 */
	@Override
	public void addComponent(CoreComponent comp)
	{
		comp.internalStart(this);
		components.put(comp.getName(), comp);
	}
	
	
	/**
	 * Removes a component from the CoreObject
	 */
	@Override
	public void removeComponent(String name)
	{
		CoreComponent comp = components.get(name);
		comp.onRemove();
		components.remove(name);
	}

	/**
	 * called once the object is constructed.
	 */
	@Override
	public final void init() 
	{
		
	}

	/**
	 * Dispatches calls to all attached Components
	 */
	@Override
	public final void update() 
	{
		for(Map.Entry<String, CoreComponent> e : components.entrySet())
		{
			e.getValue().update();
		}
	}

	@Override
	public CoreComponent getComponent(String name) 
	{
		return components.get(name);
	}

	
}
