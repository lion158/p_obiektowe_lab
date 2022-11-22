package agh.ics.oop;

public class Grass implements IMapElement{
    private Vector2d grassPosition;

    public Grass(Vector2d grassPosition){
        this.grassPosition = grassPosition;
    }

//    public Vector2d getPosition() {
//        return this.grassPosition;
//    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public Vector2d getPosition() {
        return this.grassPosition;
    }

    @Override
    public boolean isAt(Vector2d position) {
            return this.grassPosition.equals(position);
    }
}
