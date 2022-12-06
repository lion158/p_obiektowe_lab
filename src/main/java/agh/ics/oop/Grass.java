package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Grass implements IMapElement{
    private Vector2d grassPosition;
    protected List<IPositionChangeObserver> observers = new ArrayList<>();

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

    /////////////////////////////można dodać klasę abstrakcyjną (powtarza się kod w animal i tutaj)
    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
    public void positionChanged(Vector2d oldPosition){
        for (IPositionChangeObserver observer: observers){
            observer.positionChanged(oldPosition,this.grassPosition);
        }
    }
}

