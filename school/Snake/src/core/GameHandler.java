package core;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import components.CoreObject;
import concreteComponents.RenderComponent;
import enter.GameSetup;

public class GameHandler implements Runnable{
	private Window window;
	private ArrayList<CoreObject> objects = new ArrayList<CoreObject>();
	private static GameHandler instance;

	private long lastUpdate = 0;
	private long updateTime = (1 * 1000) / 60;
	private static float delta;

	public static float deltaTime() {
		return delta;
	}

	public static GameHandler getInstance() {
		return instance == null ? new GameHandler() : instance;
	}

	private GameHandler() {
		instance = this;
		window = new Window();
	}

	public void run() {
		if (lastUpdate + updateTime <= System.currentTimeMillis()) {
			float start = System.currentTimeMillis();
			window.updateView();
			for (CoreObject obj : objects) {
				obj.update();
				RenderComponent comp = (RenderComponent) obj
						.getComponent("Render");
				if (comp != null)
					window.put(comp);
			}
			lastUpdate = System.currentTimeMillis();
			delta = lastUpdate - start;
		}

	}

	public void addCoreObject(CoreObject coreObject) {
		objects.add(coreObject);
	}

	public void removeCoreObject(CoreObject coreObject) {
		objects.remove(coreObject);
	}

	public void setup(GameSetup gameSetup) {
		gameSetup.onSetup();
		
		while (true)
		{
			window.repaint();
			SwingUtilities.invokeLater(this);
		}

	}
}
