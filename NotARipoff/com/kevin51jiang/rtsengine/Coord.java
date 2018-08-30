
package com.kevin51jiang.rtsengine;


public class Coord {
    
    private float x;

    private float y;

    /**
     * * Adds a deltaY to current X-val
     * @param deltaX  Difference in X to be added
     */
    public void changeX(float deltaX){
        this.x += deltaX;
    }
    
    /**
     * Adds a deltaY to current Y-val
     * @param deltaY Difference in Y to be added
     */
    public void changeY(float deltaY) {
        this.y += deltaY;
    }
    
    /**
     * Sets this coord to the params of given coord
     * @param newCoord Coord to be set to 
     */
    public void setCoord(Coord newCoord){
        this.x = newCoord.getX();
        this.y = newCoord.getY();
        
    }
    
    /**
     * Get the value of y
     *
     * @return the value of y
     */
    public float getY() {
        return y;
    }

    /**
     * Set the value of y
     *
     * @param y new value of y
     */
    public void setY(float y) {
        this.y = y;
    }

    
    /**
     * Get the value of x
     *
     * @return the value of x
     */
    public float getX() {
        return x;
    }

    /**
     * Set the value of x
     *
     * @param x new value of x
     */
    public void setX(float x) {
        this.x = x;
    }

}
