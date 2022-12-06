package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{

    private TreeSet<Vector2d> oX = new TreeSet<>(Comparator.comparing(Vector2d -> Vector2d.x));
    private TreeSet<Vector2d> oY = new TreeSet<>(Comparator.comparing(Vector2d -> Vector2d.y));

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        remove(oldPosition);
        add(newPosition);
    }
    public void add(Vector2d vector){
        this.oX.add(vector);
        this.oY.add(vector);
    }
    public void remove(Vector2d vector){
        this.oX.remove(vector);
        this.oY.remove(vector);
    }

    public Vector2d getLowerBound(){
        return new Vector2d(oX.first().x, oY.first().y);
    }
    public Vector2d getUpperBound(){
        return new Vector2d(oX.last().x, oY.last().y);
    }

}
