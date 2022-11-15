package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    private int width;
    private int height;

    private List<Animal> animals;


    RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.animals = new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (position.x >= 0 && position.x <= this.width && position.y >= 0 && position.y <= this.height) && ! isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        ///?????????????
        //umożliwia występowanie więcej niż jednego zwierzęcia na mapie,
        if (isOccupied(animal.getPosition())){
            return false;
        }
        else{
            this.animals.add(animal);
            return true;
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

        for (Animal animal: this.animals){
            if (animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
//        Animal a = new Animal(this, position);
    }

    @Override
    public String toString() {
        MapVisualizer vizualizer = new MapVisualizer(this);
        return vizualizer.draw(new Vector2d(0,0), new Vector2d(this.width, this.height));
    }
}
