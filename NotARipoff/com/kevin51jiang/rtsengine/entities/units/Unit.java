package com.kevin51jiang.rtsengine.entities.units;

import com.kevin51jiang.rtsengine.Coord;
import com.kevin51jiang.rtsengine.entities.Entity;


public abstract class Unit extends Entity{
    
    private int health;
    private int attack;
    private int armor;
    private int speed;//tiles/tick
    private String name;
    private int kills;
    private Coord pos;
    private Coord dest;
    private int nextMove;

    public Unit(int health, int attack, int armor, int speed, String name, int kills, Coord pos, Coord dest, int nextMove, Coord startPos, HealthType healthType) {
        super(startPos, healthType);
        this.health = health;
        this.attack = attack;
        this.armor = armor;
        this.speed = speed;
        this.name = name;
        this.kills = kills;
        this.pos = pos;
        this.dest = dest;
        this.nextMove = nextMove;
    }
    
    
    
    public static void move(int direction){
        
    }
    
    public boolean isDead(){
        if(health == 0) {
            return true;
        } 
        return false;
    }
    
    /**
     * This unit takes damage
     * @param damage Amount
     */
    public void takeDamage(int damage){
        this.health -= (damage - armor);
        
        if (health < 0) health = 0;
    }
    
    public void changeArmor(int deltaArmor){
        this.armor += deltaArmor;
    }
    
    public void changeAttack(int deltaAttack){
        this.attack += deltaAttack;
    }
    
    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getMovementRange() {
        return speed;
    }

    public void setMovementRange(int movementRange) {
        this.speed = movementRange;
    }

    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 
     * @return The amount of kills the current unit has
     */
    public int getKills() {
        return kills;
    }
    
    /**
     * Adds one kill to the current unit
     */
    public void addKill() {
        kills++;
    }
    
    /**
     * 
     * @param kills 
     */
    public void setKills(int kills) {
        this.kills = kills;
    }
    

    /**
     * Get the value of health
     *
     * @return the value of health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set the value of health
     *
     * @param health new value of health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    
    /**
     * Get the value of offensiveAttack
     *
     * @return the value of offensiveAttack
     */
    public int getOffensiveAttack() {
        return attack;
    }

    /**
     * Set the value of offensiveAttack
     *
     * @param offensiveAttack new value of offensiveAttack
     */
    public void setOffensiveAttack(int offensiveAttack) {
        this.attack = offensiveAttack;
    }
    
    

}
