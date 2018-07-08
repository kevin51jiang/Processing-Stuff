class Camera{
    private PVector pos;
    private final int dispInterval = 5;
    private final int bottomXBound, 
                    bottomYBound;
    public Camera(int bottomXBound, int bottomYBound) {
        pos = new PVector(0, 0);
        this.bottomXBound = bottomXBound;
        this.bottomYBound = bottomYBound;
    }

    public PVector getPos(){
        return pos;
    }

    void update(){
        if (keyPressed) {
            switch(key){
                case 'w':
                    if(pos.y - dispInterval < 0){
                        pos.y = 0;
                    } else {
                        pos.y -= dispInterval;
                    }
                    break;

                case 's':
                    if(pos.y + dispInterval > bottomYBound){
                        pos.y = bottomYBound;
                    } else {
                        pos.y += dispInterval;
                    }
                    break;

                case 'a':
                    if(pos.x - dispInterval < 0) {
                        pos.x = 0;
                    } else {
                        pos.x -= dispInterval;
                    }
                    break;

                case 'd':
                    if(pos.x + dispInterval > bottomXBound){
                        pos.x = bottomXBound;
                    } else {
                        pos.x += dispInterval;
                    }
                    break;
            }
        }
    }


}