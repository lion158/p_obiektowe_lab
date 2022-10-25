package agh.ics.oop;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;

    private Vector2d position = new Vector2d(2,2);

    @Override
    public String toString() {
        return "(" + direction + ", " + position + ")";
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getDirection() {
        return direction;
    }

    public boolean isAt(Vector2d position){

        return this.position.equals(position);
        //return position.equals(this.position);
    }

    public void move(MoveDirection direction){

        Vector2d passingDirection = this.position;

        switch (direction){
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD -> this.position = this.position.add(this.direction.toUnitVector());
            case BACKWARD -> this.position = this.position.subtract(this.direction.toUnitVector());
        }
        if (this.position.x < 0 || this.position.x > 4 || this.position.y < 0 || this.position.y > 4){
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
