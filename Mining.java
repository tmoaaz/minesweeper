package minesweeper;

import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import minesweeper.Cell;

public class Mining extends JFrame{
    
    private static final long serialVersionUID = 1L;
	private int width, height;
	private Cell[][] cells;
	private int difficulty;
	private Board board;
	private JButton reset;
	private boolean finished;
        
        public Mining (int x, int y, int d)
        {
            width=x;
            height=y;
            difficulty=d;
            cells=new Cell[width][height];
            
            reset();
            
            board = new Board(this);
            reset = new JButton("Reset");
            
            add(board, BorderLayout.CENTER);
            add(reset, BorderLayout.SOUTH);
            
            reset.addActionListener(new Actions(this));
            
            setTitle("Minsweeper");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
            pack();
            setVisible(true);
        }
        
        @Override
        public int getX()
        {
            return width;
        }
        
        @Override
        public int getY()
        {
            return height;
        }
        
        public Cell[][] getCells()
	{
		return cells;
	}
        
        public void reset()
	{
		Random random = new Random();
		finished = false;
 
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				Cell c = new Cell();
				cells[i][j] = c;
				int r = random.nextInt(100);
 
				if (r < difficulty)
				{
					cells[i][j].setMine();
				}
			}
		}
		setNumbers();
	}
        
        private void setNumbers()
	{
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				int count = 0;
 
				if (i > 0 &&	j > 0 && cells[i - 1]	[j - 1]	.isMine()) count++;
				if (j > 0 && cells[i][j - 1].isMine()) count++;
				if (i < width - 1 && j > 0 && cells[i + 1][j - 1].isMine()) count++;
 
				if (i > 0 && cells[i - 1][j].isMine()) count++;
				if (i < width - 1 && cells[i + 1][j].isMine()) count++;
 
				if (i > 0 && j < height - 1 && cells[i - 1][j + 1].isMine()) count++;
				if (j < height - 1	&& cells[i] [j + 1].isMine()) count++;
				if (i < width - 1 && j < height - 1 && cells[i + 1][j + 1].isMine()) count++;
 
				cells[i][j].setNumber(count);
 
				if (cells[i][j].isMine())
				{
					cells[i][j].setNumber(-1);
				}
 
				if (cells[i][j].getNumber() == 0)
				{
					cells[i][j].reveal();
				}
			}
		}
                
                for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				if (i > 0 &&	j > 0 && cells[i - 1][j - 1].getNumber() == 0) cells[i][j].reveal();
				if (j > 0 && cells[i][j - 1].getNumber() == 0) cells[i][j].reveal();
				if (i < width - 1 && j > 0 && cells[i + 1][j - 1].getNumber() == 0) cells[i][j].reveal();
 
				if (i > 0 && cells[i - 1][j].getNumber() == 0) cells[i][j].reveal();
				if (i < width - 1 && cells[i + 1]	[j]		.getNumber() == 0) cells[i][j].reveal();
 
				if (i > 0 && j < height - 1 && cells[i - 1][j + 1].getNumber() == 0) cells[i][j].reveal();
				if (j < height - 1 && cells[i][j + 1].getNumber() == 0) cells[i][j].reveal();
				if (i < width - 1 && j < height - 1 && cells[i + 1][j + 1]	.getNumber() == 0) cells[i][j].reveal();
			}
		}
     
    
}
        public void refresh()
	{
		board.repaint();
	}
        
        public void select(int x, int y)
	{
		if (cells[x][y].isFlagged()) return;
		cells[x][y].reveal();
		resetMarks();
		refresh();
 
		if (cells[x][y].isMine())
		{
			loose();
		}
		else if (won())
		{
			win();
		}
	}
        private void loose()
	{
		finished = true;
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				if (!cells[i][j].isObsecured()) cells[i][j].unFlag();
				cells[i][j].reveal();
			}
		}
		refresh();
		JOptionPane.showMessageDialog(null, "BOOOOM!");
		reset();
	}
        private void win()
	{
		finished = true;
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				cells[i][j].reveal();
				if (!cells[i][j].isMine()) cells[i][j].unFlag();
			}
		}
 
		refresh();
		JOptionPane.showMessageDialog(null, "Congratulations! You won!");
		reset();
	}

        private boolean won()
	{
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				if (cells[i][j].isObsecured() && !cells[i][j].isMine())
				{
					return false;
				}
			}
		}
 
		return true;
	}


	public void mark(int x, int y)
	{
		if (cells[x][y].isFlagged()) cells[x][y].unFlag();
		else if (cells[x][y].isObsecured()) cells[x][y].flag();
 
		resetMarks();
	}
        

	private void resetMarks()
	{
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				if (!cells[i][j].isObsecured()) cells[i][j].unFlag();
			}
		}
	}
        
        public boolean isFinished()
	{
		return finished;
	}

}



