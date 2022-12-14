package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private int grassFieldNumber;

    private List<Grass> grasses;
    protected Map<Vector2d, Animal> animals;
    protected MapBoundary boundary = new MapBoundary();
    public GrassField(int grassFieldNumber){
        this.grassFieldNumber = grassFieldNumber;
        this.grasses = new ArrayList<>();
        this.animals = super.animals;
        randomGrassGenerator();
    }

    private void randomGrassGenerator(){
        int maxValue = (int) Math.sqrt(this.grassFieldNumber * 10);
        Random rand = new Random();
        int xRandom;
        int yRandom;

        for (int i = 0; i < this.grassFieldNumber; i++) {
            while (true) {
                boolean repeat = false;
                xRandom = rand.nextInt(maxValue + 1);
                yRandom = rand.nextInt(maxValue + 1);

                Vector2d newRandomVector = new Vector2d(xRandom, yRandom);

                for (Grass field : this.grasses) {
                    if (field.getPosition().equals(newRandomVector)) {
                        repeat = true;
                    }
                }

                if (!repeat) {
                    Grass newGrass = new Grass(newRandomVector);
                    this.grasses.add(newGrass);
                    /////////////////////////////////////////////////////////////////
                    newGrass.addObserver(boundary);
                    boundary.add(newRandomVector);
                    break;
                }
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return ! super.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (super.place(animal)){
            //////////////////////////////////////////////////////////////
            animal.addObserver(boundary);
            boundary.add(animal.getPosition());
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        boolean bool = super.isOccupied(position);

        if (bool){
            return true;
        }else {
            for (Grass grass: this.grasses){
                if (grass.getPosition().equals(position)){
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object != null){
            return object;
        }
        else {
            for (Grass grass: this.grasses){
                if (grass.getPosition().equals(position)){
                    return grass;
                }
            }
            return null;
        }
    }

    @Override
    public Vector2d getLowerBound() {
//        int minX = this.grasses.get(0).getPosition().x;
//        int minY = this.grasses.get(0).getPosition().y;
//        int currentX;
//        int currentY;
//        for (Map.Entry<Vector2d, Animal> set:
//                animals.entrySet()) {
//            Vector2d key = set.getKey();
//            currentX = animals.get(key).getPosition().x;
//            currentY = animals.get(key).getPosition().y;
//            if (minX > currentX) {
//                minX = currentX;
//            }
//            if (minY > currentY){
//                minY = currentY;
//            }
//        }
//        for(Grass grass: this.grasses) {
//            currentX = grass.getPosition().x;
//            currentY = grass.getPosition().y;
//            if (minX > currentX) {
//                minX = currentX;
//            }
//            if (minY > currentY) {
//                minY = currentY;
//            }
//        }
//        return new Vector2d(minX, minY);
        return boundary.getLowerBound();
    }

    @Override
    public Vector2d getUpperBound() {
//        int maxX = this.grasses.get(0).getPosition().x;
//        int maxY = this.grasses.get(0).getPosition().y;
//        int currentX;
//        int currentY;
//        for (Map.Entry<Vector2d, Animal> set:
//                animals.entrySet()) {
//            Vector2d key = set.getKey();
//            currentX = animals.get(key).getPosition().x;
//            currentY = animals.get(key).getPosition().y;
//            if (maxX < currentX){
//                maxX = currentX;
//            }
//            if (maxY < currentY){
//                maxY = currentY;
//            }
//        }
//        for(Grass grass: this.grasses) {
//            currentX = grass.getPosition().x;
//            currentY = grass.getPosition().y;
//            if (maxX < currentX) {
//                maxX = currentX;
//            }
//            if (maxY < currentY) {
//                maxY = currentY;
//            }
//        }
//        return new Vector2d(maxX,maxY);
        return boundary.getUpperBound();
    }
}
// printowanie listy za pomocą kolekcji (brak możliwości edycji)
// abstrat class (extends)
