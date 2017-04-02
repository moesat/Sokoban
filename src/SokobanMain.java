import javax.swing.*;
import sun.applet.Main;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class SokobanMain extends JFrame implements KeyListener,ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private ReadMap readFile;
	private  JPanel myPanel;
    private JLabel[][] lblAry;
    private  WareHouseObject[][] objectAry;
    private JButton restartbutton,exitButton;
    private int  diamondIn=0,level=1,playerRow=0,playerCol=0;
    private boolean move=false;
    
    public SokobanMain()
    {
        super("Sokoban Game Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);       
       
        JToolBar toolbar = new JToolBar("Toolbar", JToolBar.HORIZONTAL);      
        restartbutton = new JButton("Restart Level");
        restartbutton.addActionListener(this);
        restartbutton.setFocusable(false);      
        toolbar.add(restartbutton);
        
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);       
        toolbar.add(exitButton);
        
        add(toolbar,BorderLayout.NORTH);
        
        myPanel=new JPanel(new GridLayout(10,10));    
        lblAry=new JLabel[10][10];
        objectAry=new WareHouseObject[10][10];
       
        loadMap(true);       
      
        add(myPanel);
        setVisible(true);
        pack();
    }
    
    public void loadMap(boolean isfirstTimeLoad)
    {
    	int index;diamondIn=0;    	
    	readFile=new ReadMap(level);
    	String str =readFile.readSKBMapFile();      
        for(int i=0;i<objectAry.length;i++)
        {        	
        	
            for(int j=0;j<objectAry[i].length;j++)
            {            	
                index=i*objectAry[i].length+j;
                if(str.charAt(index)=='f')
                {
                    objectAry[i][j]=new Floor();
                }
                else if(str.charAt(index)=='d')
                {
                    objectAry[i][j]=new FloorWithDiamond();
                    diamondIn++;
                }
                else if(str.charAt(index)=='b')
                {
                    objectAry[i][j]=new Box();
                }
                else if(str.charAt(index)=='w')
                {
                    objectAry[i][j]=new Wall();
                }
                else if(str.charAt(index)=='g')
                {
                    objectAry[i][j]=new BoxWithDiamond();
                  
                }
                else if(str.charAt(index)=='s')
                {
                    objectAry[i][j]=new WareHouseKeeper();                  
                    playerRow=i;playerCol=j;
                }         
                
                if(isfirstTimeLoad){               
	              lblAry[i][j]=new JLabel(new ImageIcon(getImage(i, j)));	             
	              lblAry[i][j].setPreferredSize(new Dimension(49,49));	             
	              myPanel.add(lblAry[i][j]);
                }
                else{                             	
            	  lblAry[i][j].setIcon(new ImageIcon(getImage(i, j)));
                }
            }
        }   
    }
    
    public void Swapping(int row,int col,int row2,int col2)
    {    	
    	
    	 WareHouseObject temp=objectAry[row][col]; 
    	 if(!temp.getObstacle()&&!temp.getMoveable())            
	     { 		
    		 move=true;
         }    	
	     else if(temp.getMoveable())
         {      	    	
            if(!objectAry[row2][col2].getObstacle())
            {  
              	if(objectAry[row2][col2].getTarget()){
            		objectAry[row2][col2]=new BoxWithDiamond();     
            		diamondIn--;
            		
            		if(objectAry[row2][col2].getUnder().getTarget()&&temp.getUnder().getTarget())
            			diamondIn++;
        		}
            	else
            	{	
        			if(temp.getUnder().getTarget())diamondIn++;
        		 	objectAry[row2][col2]=new Box();
        		}         
            	temp=objectAry[row][col].getUnder();  
            	lblAry[row2][col2].setIcon(new ImageIcon(getImage(row2,col2)));
   		      	move=true;
            }           
         }
	     if(!move) return;	     
	     
		 objectAry[row][col]=objectAry[playerRow][playerCol];
		 objectAry[playerRow][playerCol]=objectAry[playerRow][playerCol].getUnder();
		 objectAry[row][col].setUnder(temp);
		 lblAry[row][col].setIcon(new ImageIcon(getImage(row,col)));
		 lblAry[playerRow][playerCol].setIcon(new ImageIcon(getImage(playerRow,playerCol)));
    }	
    
    @Override
   public void keyPressed(KeyEvent e)
    {	        
    	move=false;int ch=e.getKeyCode();    
    	if(ch==KeyEvent.VK_RIGHT)
    	{
    		Swapping(playerRow, playerCol+1, playerRow, playerCol+2);
    		if(move) playerCol+=1;    		
    	}
    	else if(ch==KeyEvent.VK_LEFT)
    	{
    		Swapping(playerRow, playerCol-1, playerRow, playerCol-2);
    		if(move) playerCol-=1;
    	}
    	else if(ch==KeyEvent.VK_DOWN)
    	{
    		Swapping(playerRow+1, playerCol, playerRow+2, playerCol);
    		if(move) playerRow+=1;
    	}
    	else if(ch==KeyEvent.VK_UP)
    	{
    		Swapping(playerRow-1, playerCol, playerRow-2, playerCol);
    		if(move) playerRow-=1;
    	}
    	if(diamondIn==0) {checkLevel();}
    }  
    
   private  void checkLevel(){
	 if(level==5){
		JOptionPane.showMessageDialog(null, "Bravo!! Man you are finish all levels");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	 else
	 {
		JOptionPane.showMessageDialog(null, "Bravo!! Man you are finish this level");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        level++;
        loadMap(false);           
	 }     
   }    
   private Image getImage(int row,int col){
      URL loc = Main.class.getResource(objectAry[row][col].getImageLocation());
      ImageIcon iia = new ImageIcon(loc);
      Image image = iia.getImage();
      return image;
   }  
   public void actionPerformed(ActionEvent event) {
	   if (event.getSource() == exitButton) {
		   System.exit(0);
		   //Application exit
	   } 
	   else if(event.getSource() == restartbutton) {
		  loadMap(false);
	  }
   }
   
   public void keyReleased(KeyEvent e)
   {
   }
   public void keyTyped(KeyEvent e)
   {
   }
   public static void main(String[]args)
   {
      new SokobanMain();
   }
}