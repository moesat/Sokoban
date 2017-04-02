
public class WareHouseKeeper extends WareHouseObject {
    public WareHouseKeeper()
    {
        //super("Sokoban Photos\\Sokoban.jpg",true,new Floor(),false);
        imageLocation="/images/warehousekeeper.png";
        isMoveable=true;
        under=new Floor();
        isObstacle=false;
        isTarget=false;
    }
}