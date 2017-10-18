
package minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Actions implements ActionListener,MouseListener {
    
    
    private Mining mine;  // Declare Variable of Mining 
    
    // Initialized mine with m Object Of Class Mining
    public Actions (Mining m)
    {
        mine=m;
    }

    
    
    /* Function Override from Actions Event take Object as parameter 
    * from class ActionEvent **/

    @Override
    public void actionPerformed(ActionEvent e) {
        
	mine.reset();
 
	mine.refresh();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getButton() == 1)
		{
			int x = e.getX() / 20;
			int y = e.getY() / 20;
 
			mine.select(x, y);
		}
 
		if (e.getButton() == 3)
		{
			int x = e.getX() / 20;
			int y = e.getY() / 20;
 
			mine.mark(x, y);
		}
 
		mine.refresh();
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
         
    }
  
    }

