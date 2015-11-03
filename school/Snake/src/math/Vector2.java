package math;

public class Vector2
{
	public float x = 0;
	public float y = 0;
	
	
	public Vector2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector2()
	{
		this(0, 0);
	}
	
	public Vector2 add(Vector2 other)
	{
		return new Vector2(x + other.x, other.y + y);
	}
	
	public Vector2 subtract(Vector2 other)
	{
		return new Vector2(x - other.x, y - other.y);
	}
	
}
