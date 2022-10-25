package agh.ics.oop;

public class OptionsParser {

    public MoveDirection[] parse(String[] strings){
        MoveDirection[] directions = new MoveDirection[strings.length];

        int counter = 0;
        for(String string : strings){
            switch (string){
                case "f", "forward" ->  directions[counter] = MoveDirection.FORWARD;
                case "b", "backward" -> directions[counter] = MoveDirection.BACKWARD;
                case "l", "left" -> directions[counter] = MoveDirection.LEFT;
                case "r", "right" -> directions[counter] = MoveDirection.RIGHT;
            }
            counter ++;
        }
        return directions;
    }
}
