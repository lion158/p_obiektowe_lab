package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{
    private int width;
    private int height;

    private final Vector2d lowerBound;

    private final Vector2d upperBound;

    protected Map<Vector2d, Animal> animals;

    RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.animals = super.animals;
        this.lowerBound = new Vector2d(0,0);
        this.upperBound = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (position.x >= 0 && position.x <= this.width && position.y >= 0 && position.y <= this.height) && ! isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        int positonX = animal.getPosition().x;
        int positonY = animal.getPosition().y;

        if (positonX < 0 || positonX > this.width || positonY < 0 || positonY > this.height){
//            return false;
            throw new  IllegalArgumentException("Position: " + animal.getPosition() + " is not legal (outside the map)");
        }else {
            return super.place(animal);
        }
    }


    @Override
    public Object objectAt(Vector2d position) {
        return super.objectAt(position);
    }

//    @Override
//    public String toString(){
//        return super.toString(new Vector2d(0,0), new Vector2d(this.width, this.height));
//    }
    @Override
    public Vector2d getLowerBound() {
        return this.lowerBound;
    }

    @Override
    public Vector2d getUpperBound() {
        return this.upperBound;
    }
}
