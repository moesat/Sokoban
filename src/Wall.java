public class Wall extends WareHouseObject
{
    public Wall()
    {
        //super("Sokoban Photos\\Wall.jpg",false,new Floor(),true);
        imageLocation="/images/wall.png";
        isMoveable=false;
        under=new Floor();
        isObstacle=true;
        isTarget=false;
    }
}