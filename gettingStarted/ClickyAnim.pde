class ClickyAnim{
    
    private final int increments;
    private final double duration;
    private final int startTime;
    private final int maxSize;


    public ClickyAnim(int maxSize, int duration, int currentTime){
        increments = maxSize / duration;
        this.duration = duration;
        this.startTime = currentTime;
        this.maxSize = maxSize;
    }

    public int getSize(int currentTime){
        int time = currentTime - startTime;

        if(time > duration / 2) {
            return (int) Math.round(maxSize - ((duration - time) * increments));
        } else if (time == duration / 2){
            return maxSize;
        } else { //teim < duration/2
            return (int) Math.round((duration - time) * increments);
        }
    }



}