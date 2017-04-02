public class FloorWithDiamond extends WareHouseObject{
    public FloorWithDiamond()
    {
        //super("Sokoban Photos\\Floor2.jpg",false,new Floor(),false);
        imageLocation="/images/diamond.png";
        isMoveable=false;
        under=new Floor();
        isObstacle=false;
        isTarget=true;
    }

}
