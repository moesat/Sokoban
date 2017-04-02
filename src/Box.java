

	public class Box extends WareHouseObject {
	    public Box()
	    {
	        //super("Sokoban Photos\\Box1.jpg",true,new Floor(),true);
	    	
	        imageLocation="/images/box.png";
	        isMoveable=true;
	        under=new Floor();
	        isObstacle=true;
	        isTarget=false;
	    }
	}

