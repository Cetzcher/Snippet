package core;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import enter.WorldObject;

public class GameView extends JPanel {

	private static final long serialVersionUID = 1L;
	private static GameView instance;
	
	public static GameView getInstance() {
		return instance == null ? new GameView() : instance;
	}

	private GameView() {
		instance = this;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		for(WorldObject i : Game.getInstance().wObjects) i.draw(g);
	}



}
