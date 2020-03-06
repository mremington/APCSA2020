package Graphics;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Font; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovingShapePanel extends JPanel implements Runnable
{
	private Shape sh;
	ArrayList<Shape> shapes;

	public MovingShapePanel()
	{
		setBackground(Color.WHITE);
		setVisible(true);

		//refer sh to a new Shape
		sh = new Shape(300,300,50,50,Color.black,5,5);
		Shape sh2 = new Shape(200,200,20,20,Color.black,5,5);
		Shape sh3 = new Shape(400,400,80,80,Color.black,5,5);
		
		shapes = new ArrayList<Shape>();
		
		shapes.add(sh);
		shapes.add(sh2);
		shapes.add(sh3);


		new Thread(this).start();
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("CREATE YOUR OWN SHAPE!",40,40);

		//tell sh to move and draw
		//sh.moveAndDraw(window);
		for(Shape s:shapes) {
			s.moveAndDraw(window);
		

			//this code handles the left and right walls uncomment once Shape is built
			 
			if(!(s.getX()>=10 && s.getX()<=getWidth() - s.getWidth()))
			{
				s.setXSpeed(-s.getXSpeed());
			}
			
	
			//add code to handle the top and bottom walls
			if(!(s.getY()>=10 && s.getY()<=getHeight() - s.getHeight()))
			{
				s.setYSpeed(-s.getYSpeed());
			}
		}

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(10);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}