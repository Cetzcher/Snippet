package enter;

import java.awt.Point;
import java.util.LinkedList;



public class Snake
{
	LinkedList<Segment> segments = new LinkedList<Segment>();
	public final Segment HEAD;
	
	public static final int MOVEMENT_SPEED = 1;
	
	public Snake() {
		// TODO Auto-generated constructor stub
		HEAD = new Segment(new Point(0, 0), new Point(20, 20));
	}
	
	
}
