package enter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Wall extends WorldObject{

	public Wall(Point min, Point max) {
		super(min, max);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.gray);
		g.fillRect(min.x, min.y, max.x - min.x, max.y - min.y);
		g.setColor(Color.BLACK);
	}

}
