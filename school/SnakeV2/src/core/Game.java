package core;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;

import enter.Segment;
import enter.Snake;
import enter.Wall;
import enter.WorldObject;

public class Game 
{
	
	private Snake snake;
	
	private static Game instance;

	ArrayList<WorldObject> wObjects = new ArrayList<WorldObject>();
	
	public static Game getInstance() {
		return instance == null ? new Game() : instance;
	}

	
	private Game() {
		instance = this;
		JFrame frame = new JFrame();
		frame.setSize(500, 400);
		frame.add(GameView.getInstance());
		frame.setVisible(true);
		setup();
		while(true)
		{
			frame.repaint();
			afterRepaint();
		}
	}

	
	public void register(WorldObject worldObject) {
		// TODO Auto-generated method stub
		wObjects.add(worldObject);
	}

	public void remove(WorldObject worldObject) {
		// TODO Auto-generated method stub
		wObjects.remove(worldObject);
	}
	
	private void setup()
	{
		snake = new Snake();
		new Wall(new Point(5, 5), new Point(15, 15));
		new Segment(new Point(20, 20), new Point(40, 45));
	}
	
	private void afterRepaint()
	{
		
	}
	
}
