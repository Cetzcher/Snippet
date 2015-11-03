package core;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.JFrame;

import concreteComponents.RenderComponent;

/***
 * 
 * @author Rieger
 * @use controlls Jframe with attached GameView
 */

public class Window extends JFrame
{

	public static final int WIDTH = 620;
	public static final int HEIGHT = 520;
	private ConcurrentLinkedQueue<RenderComponent> toRender = new ConcurrentLinkedQueue<RenderComponent>();
	
	BufferStrategy buffer;
	
	public Window()
	{
		super();
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
	
	
	void put(RenderComponent instructon) {
		toRender.add(instructon);
	}

	void updateView() {
		this.repaint();
		
		toRender.clear();
	}
	
	
	@Override
	public void paint(Graphics g) {
		if(buffer == null)
		{
			createBufferStrategy(3);
			buffer = getBufferStrategy();
		}
		super.paint(g);
		Graphics2D g2 = null;
		do {
		    try{
		        g2 = (Graphics2D) buffer.getDrawGraphics();
				while (!toRender.isEmpty())
					toRender.poll().render(g2);
		    } finally {
		           g2.dispose();
		    }
		    buffer.show();
		} while (buffer.contentsLost());

	}
	
}
