package agh.ics.oop;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;

    private Vector2d position = new Vector2d(2,2);

    private IWorldMap map;
    private Vector2d initialPosition = new Vector2d(2, 2) ;

//    public Animal(){
//        this(new RectangularMap(4, 4));
//    }
    public Animal(IWorldMap map){
        //this(map, new Vector2d(22))
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.initialPosition = initialPosition;
        this.position = this.initialPosition;
    }

    @Override
    public String toString() {
        return switch (direction){
            case NORTH -> "N";
            case EAST -> "E";
            case WEST -> "W";
            case SOUTH -> "S";
        };
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getDirection() {
        return direction;
    }

    public boolean isAt(Vector2d position){
        //return Object.equls
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){

        Vector2d passingDirection = this.position;


        switch (direction){
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD -> passingDirection = this.position.add(this.direction.toUnitVector());
            case BACKWARD -> passingDirection = this.position.subtract(this.direction.toUnitVector());
        }

        if (this.map.canMoveTo(passingDirection)){
            this.position = passingDirection;
        }
    }
    /* Jak zaimplementować mechanizm, który wyklucza pojawienie się dwóch zwierząt w tym samym miejscu?

    Odp: Metoda move() po ustaleniu nowego wektora na któym miałby się znaleźć obiekt mogłaby wykożystać
    metodę isAt() która zostałaby użyta na każdym obiekcie w tablicy ze wszystkimi istniejącymi obiektami
    w celu sprawdzenia czy dana pozycja jest w danym momencie pusta i wtedy dokonać
    ewentualnego przemieszczenia. Dodatkowo aby uniknąć sytacji w której obiekty w tym samym czasie
    wykonują swoje operacje, co mogłoby doprowadzić do kolizji, koniecznym byłoby dodanie systemu
    kolejkowania.
    Innym sposobem mogłoby być stworzenie dwuwymiarowej tablicy w której każda komórka odpowiadałaby
    polu na mapie (x,y) i przechowywała wartość true (pole wolne), lub false (pole zajęte). W tedy przy
    każdym ruchu obiekt zmieniałby wartość komórki zarówno tej którą opuszcza jak i nowej na którą
    przechodzi odpowiednio na true lub false. Sposób ten zmniejszyłby ilość koniecznych porównań do jednego
    przypadku zamiast długości listy istniejących obiektów.
     */
}
