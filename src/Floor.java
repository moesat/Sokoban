
public class Floor extends WareHouseObject{
    public Floor()
    {
    	
        imageLocation="/images/floor.png";
        isMoveable=false;
        under=this;
        isObstacle=false;
        isTarget=false;
    }
}