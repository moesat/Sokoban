public class WareHouseObject {
        protected boolean isMoveable;
        protected String imageLocation;
        protected WareHouseObject under;
        protected boolean isObstacle;
        protected boolean isTarget;
        
        /*public WareHouseObject(String imageLocation,boolean isMoveable,WareHouseObject under,boolean isObstacle)
        {
            this.imageLocation=imageLocation;
            this.isMoveable=isMoveable;
            this.under=under;
            this.isObstacle=isObstacle;
        }*/
        public void setMoveable(boolean isMoveable)
        {
            this.isMoveable=isMoveable;
        }
        public void setImageLocation(String imageLocation)
        {
            this.imageLocation=imageLocation;
        }
        public void setObstacle(boolean isObstacle)
        {
            this.isObstacle=isObstacle;
        }
        public void setUnder(WareHouseObject obj)
        {
            this.under=obj;
        }
        public boolean getMoveable()
        {
            return isMoveable;
        }
        public String getImageLocation()
        {
            return imageLocation;
        }
        public boolean getObstacle()
        {
            return isObstacle;
        }
        public WareHouseObject getUnder()
        {
            return under;
        }
        public void setTarget(boolean obj)
        {
            this.isTarget=obj;
        }
        public boolean getTarget()
        {
            return isTarget;
        }
    }