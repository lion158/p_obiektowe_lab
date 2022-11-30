package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    private int width;
    private int height;

    private List<Animal> animals;


    RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.animals = super.animals;
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
            return false;
        }else {
            return super.place(animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal: this.animals){
            if (animal.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return super.objectAt(position);
    }

    @Override
    public String toString(){
        return super.toString(new Vector2d(0,0), new Vector2d(this.width, this.height));
    }
}
