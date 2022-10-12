package agh.ics.oop;

public class World {

    public static void run(Direction[] directions){
        for(int i=0; i< directions.length-1;i++){
            System.out.print(directions[i] + ", ");


        }
        System.out.println(directions[directions.length-1]);

        // alternatywna opcja:

//        String joinedDirections = String.join( ", ", directions);
//        System.out.println(joinedDirections);





        for(Direction direction: directions){
            switch (direction){
                case f -> System.out.println("Zwierzak idzie do przodu");
                case b -> System.out.println("Zwierzak idzie do tyłu");
                case r -> System.out.println("Zwierzak skręca w prawo");
                case l -> System.out.println("Zwierzak skręca w lewo");
            }
        }


    }
    public static void main(String[] args){
        System.out.println("System wystartował");

        Direction qwerty = Direction.l;

        Direction[] directions;

        for(int i = 0; i < args.length; i++){
            directions[i] = Direction.valueOf(args[i]);
        }

        //run(args);
        run(directions);
        System.out.println("System zakończył działanie");
    }
}
