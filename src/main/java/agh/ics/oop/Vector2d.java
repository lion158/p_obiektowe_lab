package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    final public int x;
    final public int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "(%d, %d)".formatted(x,y);
    }

    public boolean precedes(Vector2d other){
        return y <= other.y && x <= other.x;
    }

    public boolean follows(Vector2d other){
        return x >= other.x && y >= other.y;
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(x + other.x, y+other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(x - other.x, y - other.y);
    }

    public Vector2d upperRight(Vector2d other){
        int greaterX = Math.max(x, other.x);
        int greaterY = Math.max(y, other.y);

        return new Vector2d(greaterX, greaterY);
    }

    public Vector2d lowerLeft(Vector2d other){
        int lowerX = Math.min(x, other.x);
        int lowerY = Math.min(y, other.y);

        return new Vector2d(lowerX, lowerY);
    }

    public Vector2d opposite(){
        return new Vector2d(-x,-y);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
