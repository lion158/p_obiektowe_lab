package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {

    public MoveDirection[] parse(String[] strings){
        MoveDirection[] directions = new MoveDirection[strings.length];

        ////////////////////////// stream.of(input) map (casy) filter (null) to array(MoveDirection[]::new)
        int counter = 0;
        for(String string : strings){
            switch (string){
                case "f", "forward" ->  directions[counter] = MoveDirection.FORWARD;
                case "b", "backward" -> directions[counter] = MoveDirection.BACKWARD;
                case "l", "left" -> directions[counter] = MoveDirection.LEFT;
                case "r", "right" -> directions[counter] = MoveDirection.RIGHT;
                default -> {
                    continue;
                }
            }
            counter ++;
        }
        MoveDirection[] endDirections = Arrays.copyOfRange(directions, 0, counter);

        return endDirections;
    }
}
