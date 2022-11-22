package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals;
    protected List<Grass> grasses;

    AbstractWorldMap(){
        this.animals = new ArrayList<>();
        this.grasses = new ArrayList<>();
    }
    @Override
    abstract public boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition())){
            return false;
        }
        else{
            this.animals.add(animal);
            return true;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position){
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
    }


    public String toString(Vector2d loverLeft, Vector2d upperRight) {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(loverLeft, upperRight);
    }
}
