package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{

    private final MoveDirection[] moveDirections;
    private final IWorldMap map;
    private final Vector2d[] startPositions;

    private List<Animal> animals;

    public SimulationEngine(MoveDirection[] moveDirections, IWorldMap map, Vector2d[] startPositions){
        this.moveDirections = moveDirections;
        this.map = map;
        this.startPositions = startPositions;
        this.animals = new ArrayList<>();
        this.addAnimalToMap();
    }

    private void addAnimalToMap(){
        for (Vector2d position: this.startPositions){
            Animal animal = new Animal(this.map, position);
            if (map.place(animal)){
                animals.add(animal);
                //////////////////////////////////////////////////////////////////
                animal.addObserver((IPositionChangeObserver) this.map);
            }
            else {
                System.out.println("Animal "+ animal.toString()+" can't be place on the map (this position: "+position.toString() + " is occupied)");
            }
        }
    }


    @Override
    public void run() {
        int moveCounter = 0;
        while (moveCounter < moveDirections.length){
            for (Animal animal: animals){
                animal.move(moveDirections[moveCounter]);
                moveCounter ++;
                if (moveCounter >= moveDirections.length){
                    break;
                }
            }
        }
    }
}
