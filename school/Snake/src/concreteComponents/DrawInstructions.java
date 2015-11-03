package concreteComponents;

import java.awt.Graphics;

public interface DrawInstructions 
{
	public void Draw(RenderComponent caller, Graphics g);
}
