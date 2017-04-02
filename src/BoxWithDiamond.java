
public class BoxWithDiamond extends WareHouseObject{
    public BoxWithDiamond()
    {
        //super("Sokoban Photos\\Box2.jpg",true,new FloorWithDiamond(),true);
        imageLocation="/images/goal1.png";
        isMoveable=true;
        under=new FloorWithDiamond();
        isObstacle=true;
        isTarget=false;
    }

}
