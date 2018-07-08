class ClickyAnim{
    
    private final int increments;
    private final double duration;
    private final int startTime;
    private final int maxDia;
    private int xPos,
                yPos;


    public ClickyAnim(int maxDia, int duration, int currentTime, int mousePosX, int mousePosY){
        increments = maxDia / duration;
        this.duration = duration;
        this.startTime = currentTime;
        this.maxDia = maxDia;

        this.xPos = mousePosX;
        this.yPos = mousePosY;
    }

    public int getDia(int currentTime) throws FinishedAnimException{
        int timeElapsed = currentTime - startTime;//find timeElapsed ellapsed, in milliseconds

        if(timeElapsed < duration / 2){//if still growing
            return (int) (timeElapsed / (duration / 2) * maxDia) ;

        } else if (timeElapsed == duration / 2){//if at max size
            return maxDia;

        } else if (timeElapsed > duration / 2 && timeElapsed < duration){//if shrinking
            return (int) (1 - (timeElapsed - duration / 2) / (duration / 2)) * maxDia ;

        } else {//done, should be thrown out
            throw new FinishedAnimException("Duration was exceeded. Please remove from queue.");
        }
    }

    public int getXPos(){
        return this.xPos;
    }

    public int getYPos(){
        return this.yPos;
    }
}