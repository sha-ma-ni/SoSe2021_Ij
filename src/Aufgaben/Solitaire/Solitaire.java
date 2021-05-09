package Aufgaben.Solitaire;

public class Solitaire {

    private Moves game;  //ein Zug
    private State[][] field;

    //Konstruktor
    public Solitaire() {
        this.game = new Moves();
        this.field = new State[7][7];
        for (int row = 0; row < this.field.length; row++) {
            for (int col = 0; col < this.field[row].length; col++) {
                if ((row < 2 || row > 4) && (col < 2 || col > 4)) {
                    this.field[row][col] = State.NOT;
                }
                else {
                    this.field[row][col] = State.USED;
                }
            }
        }
        this.field[3][3] = State.FREE;
    }
    public void print()
    {
        for(int row = 0; row < this.field.length; row++)
        {
            for(int col = 0; col < this.field[row].length; col++)
            {
                if(this.field[row][col] == State.USED) System.out.print("o ");
                else if(this.field[row][col] == State.NOT) System.out.print("  ");
                else System.out.print("- ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
     * diese Methode gibt ein true zurueck, wenn von der
     * uebergebenen Position (row,col) ein Zug moeglich ist
     * d.h.
     * 1. auf der angegebenen Position muss ein Stein sein
     * 2. zwei Steine weiter (oben, unten, rechts oder links)
     *      darf kein Stein sein
     * 3. dazwischen muss ein Stein sein
     */
    public boolean possibleFrom(int row, int col) {

        // Wenn die oben gennanten Voraussetzung erfüllt ist
        if (row >= 0 && row < 7 && col >= 0 && col < 7 && this.field[row][col] == State.USED)
            if (row < 5 && this.field[row + 2][col] == State.FREE && this.field[row + 1][col] == State.USED ||
                    col < 5 && this.field[row][col + 2] == State.FREE && this.field[row][col + 1] == State.USED ||
                    row > 1 && this.field[row - 2][col] == State.FREE && this.field[row - 1][col] == State.USED ||
                    col > 1 && this.field[row][col - 2] == State.FREE && this.field[row][col - 1] == State.USED) {
                return true;
            }
        return false;
    }


    /*
     * diese Methode gibt alle Positionen (Point) zurueck,
     * AUF die von (fromRow,fromCol) aus gesprungen werden
     * kann
     */
    public Point[] possibleTo(int fromRow, int fromCol) {
        int numberOfPossibleTo = 0;

        if (!possibleFrom(fromRow, fromCol)) return new Point[numberOfPossibleTo];
        boolean up = fromRow > 1 && this.field[fromRow - 1][fromCol] == State.USED && this.field[fromRow - 2][fromCol] == State.FREE;
        boolean down = fromRow < 5 && this.field[fromRow + 1][fromCol] == State.USED && this.field[fromRow + 2][fromCol] == State.FREE;
        boolean right = fromCol < 5 && this.field[fromRow][fromCol + 1] == State.USED && this.field[fromRow][fromCol + 2] == State.FREE;
        boolean left = fromCol > 1 && this.field[fromRow][fromCol - 1] == State.USED && this.field[fromRow][fromCol - 2] == State.FREE;

        if (up) numberOfPossibleTo++;
        if (down) numberOfPossibleTo++;
        if (left) numberOfPossibleTo++;
        if (right) numberOfPossibleTo++;

        Point[] point = new Point[numberOfPossibleTo];
        int index = 0;
        if (up) point[index++] = new Point(fromRow - 2, fromCol);
        if (down) point[index++] = new Point(fromRow + 2, fromCol);
        if (right) point[index++] = new Point(fromRow, fromCol + 2);
        if (left) point[index] = new Point(fromRow, fromCol - 2);
        return point;
    }

    /*
     * diese Methode erzeugt ein Moves-Objekt
     * in dieses Moves-Objekt werden mithilfe der
     * Objektmethode addMove() (aus Moves) alle
     * moeglichen Zuege hinzugefuegt
     * (moeglich im aktuellen Zustand von field[][])
     */
    public Moves possibleMoves()
    {
        Moves possibleMoves = new Moves();
        for (int row = 0; row < this.field.length; row++)
            for (int col = 0; col < this.field[row].length; col++)
            {
                if (possibleFrom(row, col))
                {
                    Point from = new Point(row, col);
                    Point[] to = this.possibleTo(row, col);
                    for (int index = 0; index < to.length; index++)
                    {
                        Move move = new Move(from, to[index]);
                        possibleMoves.addMove(move);
                    }
                }
            }
        return possibleMoves;
    }

    /*
     * gibt ein true zurueck, wenn im aktuellen Zustand
     * von field[][] ueberhaupt noch ein Zug moeglich ist
     * sonst false
     */
    public boolean movePossible() {

        for (int row = 0; row < this.field.length; row++) {
            for (int col = 0; col < this.field[row].length; col++) {
                if (possibleFrom(row, col)) return true;
            }
        }
        return false;
    }

    /*
     * ruft die Methode move(Move move) auf,
     * wenn ein Zug moeglich ist (dann true zurueck)
     * sonst false
     */
    public boolean moveFirstPossible()
    {
        if(!movePossible()) return false;
        else {
            Moves possibleMoves = this.possibleMoves();
            possibleMoves.printMoves();
            Move move = possibleMoves.getMoveAtIndex(0);
            this.move(move);
            return true;
        }
    }

    /*
     * hier wird der Zug Move move ausgefuehrt
     * nach dem Zug ist
     * 1. die from-Position leer
     * 2. die to-Position mit einem Stein besetzt
     * 3. dazwischen leer (Stein wird "entfernt")
     * falls Zug nicht moeglich, wird eine
     * IllegalArgumentException geworfen
     */
    public void move(Move move) throws IllegalArgumentException {
        int mittelRow = (move.getFrom().getRow() + move.getTo().getRow()) / 2;
        int mittelCol = (move.getFrom().getCol() + move.getTo().getCol()) / 2;
        try {
            this.field[move.getFrom().getRow()][move.getFrom().getCol()] = State.FREE;
            this.field[mittelRow][mittelCol] = State.FREE;
            this.field[move.getTo().getRow()][move.getTo().getCol()] = State.USED;
        } catch (ArrayIndexOutOfBoundsException e) {

            throw new IllegalArgumentException("Move ist nicht möglich (" + move.getFrom().getRow() + ", " + move.getFrom().getCol() + ") --> "
                    + "( " + move.getTo().getRow() + ", " + move.getTo().getCol() + ") ");
        }
    }

}
