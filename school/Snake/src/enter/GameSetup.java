package enter;

import java.awt.Color;
import java.awt.Graphics;




import math.Vector2;
import components.CoreComponent;
import components.CoreObject;
import concreteComponents.DrawInstructions;
import concreteComponents.RenderComponent;
import concreteComponents.SquareCollider;

public class GameSetup {
	public void onSetup() {
		// actual game code
		CoreObject c = new CoreObject();
		DrawInstructions d = new SquareDraw();
		RenderComponent comp = new RenderComponent(d);
		SquareCollider collider = new SquareCollider(new Vector2(0, 0), 50);
		MovementComponent movement = new MovementComponent();
		c.addComponent(collider);
		c.addComponent(movement);
		c.addComponent(comp);
	}
}

class SquareDraw implements DrawInstructions {

	@Override
	public void Draw(RenderComponent caller, Graphics g) {
		SquareCollider col = (SquareCollider) caller.getComponent("Collider");
		if(col != null)
		{
			Vector2 top = col.getTopLeft();
			g.drawLine((int)top.x, (int)top.y, (int)(top.x + col.getSideLength()), (int)(top.y + col.getSideLength()));
			g.drawLine((int)top.x, (int)(top.y + col.getSideLength()), (int)(top.x + col.getSideLength()), (int)(top.y + col.getSideLength()));
		}
	}

}

class MovementComponent extends CoreComponent {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Movement";
	}
	
	@Override
	public void update()
	{
		SquareCollider collider = (SquareCollider) getComponent("Collider");
		if(collider != null)
		{
			collider.getTopLeft().x += 1;
		}
	}

}