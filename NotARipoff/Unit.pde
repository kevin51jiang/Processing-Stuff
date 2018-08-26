public abstract class Unit {
    private String name;

    private enum State {
        DEAD,
        ALIVE;
    }

    public String setName(){
        return name;
    }

}