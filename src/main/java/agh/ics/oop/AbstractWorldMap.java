package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animals;

    public AbstractWorldMap(){
        this.animals = new HashMap<>();
    }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition())){
//            return false;
            throw new IllegalArgumentException("Position: " + animal.getPosition() + " is occupied");
        }
        else{
            this.animals.put(animal.getPosition(), animal);
            //można dodać tutaj
            //animal.addObserver(this)
            return true;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position){
        //objectAt != null
//        Animal animal = animals.get(position);
//        return animal.getPosition().equals(position);
    ////////////////////////////////////////////////////////////////////////////////////////////
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);

//        Animal animal = animals.get(position);
//        if (animal.getPosition().equals(position)){
//            return animal;
//        }
//        else {
//            return null;
//        }

    }


//    public String toString(Vector2d loverLeft, Vector2d upperRight) {
//        MapVisualizer visualizer = new MapVisualizer(this);
//        return visualizer.draw(loverLeft, upperRight);
//    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(getLowerBound(), getUpperBound());
    }

    public abstract Vector2d getLowerBound();

    public abstract Vector2d getUpperBound();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }
}
// iteroewanie po hash mapie keyset
//entryset
//zwierze publisher
//        mapa subskrybent