package concreteComponents;

import java.awt.Graphics;

import components.CoreComponent;

public class RenderComponent extends CoreComponent
{

	private DrawInstructions instruction;
	
	@Override
	public String getName()
	{
		return "Render";
	}
	
	public RenderComponent(DrawInstructions instruction)
	{
		this.instruction = instruction;
	}
	
	public void render(Graphics plane)
	{
		instruction.Draw(this, plane);
	}
	
}
