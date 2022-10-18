package agh.ics.oop;

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
        if(y <= other.y && x <= other.x){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean follows(Vector2d other){
        if(x >= other.x && y >= other.y){
            return true;
        }
        else {
            return false;
        }
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(x + other.x, y+other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(x - other.x, y - other.y);
    }

    public Vector2d upperRight(Vector2d other){
        int greaterX = x > other.x ? x: other.x;
        int greaterY = y > other.y ? y: other.y;

        return new Vector2d(greaterX, greaterY);
    }

    public Vector2d lowerLeft(Vector2d other){
        int lowerX = x < other.x ? x: other.x;
        int lowerY = y < other.y ? y: other.y;

        return new Vector2d(lowerX, lowerY);
    }

    public Vector2d opposite(){
        return new Vector2d(-x,-y);
    }

    @Override
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;

        // ?????????
        Vector2d that = (Vector2d) other;
        return x == that.x && y == that.y;
    }
}
