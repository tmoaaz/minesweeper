
package minesweeper;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Board extends JPanel{
    
    private static final long serialVersionUID = 1L;
    private Mining mine;
    private Cell[][] cells;
    
    /*initialized the values of variables */
    public Board (Mining m)
    {
        mine=m;
        cells=mine.getCells();
        addMouseListener(new Actions(mine));
        setPreferredSize(new Dimension(mine.getX() * 20, mine.getY() * 20));
    }
    
    /* Draw Graphics */
    
    @Override
    public void paintComponent(Graphics g)
    {
        cells = mine.getCells();
        for(int i=0; i<mine.getX(); i++)
        {
            for (int j=0; j<mine.getY(); i++)
            {
                Cell current = cells[i][j];
                if(current.isFlagged())
                {
                    if(current.isMine() && mine.isFinished())
                    {
                        g.setColor(Color.ORANGE);
                        g.fillRect(i*20, j*20, i*20+20, j*20+20);
                        g.setColor(Color.black);
                        
                        g.drawLine(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
			g.drawLine(i * 20, j * 20 + 20, i * 20 + 20, j * 20);
                    }
                    else if (mine.isFinished())
                    {
                        g.setColor(Color.GREEN);
	        	g.fillRect(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
         		g.setColor(Color.BLACK);
                    }
                    else
                    {
                        g.setColor(Color.YELLOW);
			g.fillRect(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
			g.setColor(Color.BLACK);
                    }
                }   
                else if (current.isObsecured())
                {
                    g.setColor(Color.GRAY);
		    g.fillRect(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
	            g.setColor(Color.BLACK);
                }
                else if(current.isMine())
                {
                    g.setColor(Color.RED);
		    g.fillRect(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
                    g.setColor(Color.BLACK);
                    g.drawLine(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
                    g.drawLine(i * 20, j * 20 + 20, i * 20 + 20, j * 20);
                }
                else 
                {
                    g.setColor(Color.LIGHT_GRAY);
		    g.fillRect(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
		    g.setColor(Color.BLACK);
                }
                if(!current.isObsecured())
                {
                    if (current.getNumber()==1)
                    {
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
		    }
		    else if (current.getNumber() == 2)
		    {
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
			g.drawLine(i * 20 + 7, j * 20 + 11, i * 20 + 7, j * 20 + 15);	//5
			g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);	//7
		    }
		    else if (current.getNumber() == 3)
		    {
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
			g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);	//7
	            }
		    else if (current.getNumber() == 4)
		    {
			g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);		//1
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
		    }
		    else if (current.getNumber() == 5)
		    {
			g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);		//1
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
			g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);	//7
		    }
		    else if (current.getNumber() == 6)
		    {
			g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);		//1
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
			g.drawLine(i * 20 + 7, j * 20 + 11, i * 20 + 7, j * 20 + 15);	//5
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
			g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);	//7
		    }
	            else if (current.getNumber() == 7)
		    {
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
		    }
		    else if (current.getNumber() == 8)
		    {
			g.drawLine(i * 20 + 7, j * 20 + 5, i * 20 + 7, j * 20 + 9);		//1
			g.drawLine(i * 20 + 8, j * 20 + 4, i * 20 + 12, j * 20 + 4);	//2
			g.drawLine(i * 20 + 13, j * 20 + 5, i * 20 + 13, j * 20 + 9);	//3
			g.drawLine(i * 20 + 8, j * 20 + 10, i * 20 + 12, j * 20 + 10);	//4
			g.drawLine(i * 20 + 7, j * 20 + 11, i * 20 + 7, j * 20 + 15);	//5
			g.drawLine(i * 20 + 13, j * 20 + 11, i * 20 + 13, j * 20 + 15);	//6
			g.drawLine(i * 20 + 8, j * 20 + 16, i * 20 + 12, j * 20 + 16);	//7
		    }
                }
                g.setColor(Color.black);
                g.drawRect(i * 20, j * 20, i * 20 + 20, j * 20 + 20);
                    
            }
        }
        
    }
    
    
    
    }
    

