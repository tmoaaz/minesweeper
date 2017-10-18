
package minesweeper;

public class Cell {
    
    private boolean isMine,isFlagged,isObsecured; // the status of Cell we can use enum here .
    private int number; //number we use to know status of cell
    
    /* Make constructor of Class Cell and initialized values */
    
    public Cell()
    {
        isMine=false;
        isFlagged=false;
        isObsecured=true;
        number=0;
    }
    
    /* function to set Mine because i use encapsulation*/
    
    public void setMine()
    {
        isMine=true;
    }
    
    /* to the flag status of the Cell I will use two functions to know that*/
    
    public void flag()
    {
        isFlagged=true;
    }
    
    public void unFlag()
    {
        isFlagged=false;
    }
    
    /**function to know about reveal status of cell and know if it covered or
    * know that will set it false because its opened */
    
    public void reveal()
    {
        isObsecured=false;
    }
    
    /** to have access of private variable number i use function of number
     * that will take parameter i */
    public void setNumber(int i)
    {
        number=i;
    }
    
    /*we have access to set values of variables that refer to 
    * Cell status know i will create functions get data from variables */
    
    // function to return cell if mine or not 
    public boolean isMine()
    {
        return isMine;
    }
    
    // that will return Flagged status 
    public boolean isFlagged()
    {
        return isFlagged;
    }
    
    // return vale of variable obsecured of Cell if it reveal or obsecured
    public boolean isObsecured()
    {
        return isObsecured;
    }
    
    // this function return number of reveal cell 
    public int getNumber()
    {
        return number;
   
    } 
    
}
