package enter;

import java.awt.Graphics;
import java.awt.Point;

import core.Game;

public abstract class WorldObject 
{

	public Point min;
	public Point max;
	
	public abstract void draw(Graphics g);
	
	public WorldObject(Point min, Point max)
	{
		this.min = min;
		this.max = max;
		Game.getInstance().register(this);
	}
	
	public void delete()
	{
		Game.getInstance().remove(this);
	}
	
	public boolean isColliding(WorldObject other)
	{
		return false;
	}
	
}
