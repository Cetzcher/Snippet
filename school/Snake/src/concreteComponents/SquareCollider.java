package concreteComponents;

import math.Vector2;
import components.CoreComponent;

public class SquareCollider extends CoreComponent
{

	private Vector2 topLeft;
	private float sideLength;
	
	public SquareCollider(Vector2 topLeft, float side)
	{
		this.topLeft = topLeft;
		this.sideLength = side;
	}
	
	public Vector2 getTopLeft()
	{
		return topLeft;
	}
	
	public float getSideLength()
	{
		return sideLength;
	}
	
	@Override
	public String getName()
	{
		return "Collider";
	}
	
	public boolean isColliding(SquareCollider collider)
	{
		return false;
	}
	

	
}
