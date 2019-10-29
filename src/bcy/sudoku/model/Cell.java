package bcy.sudoku.model;

public class Cell {
    private Integer value;
    private Set<Integer> possibilities = new HashSet<Integer>(
        Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9 ) );
    private Set<Integer> impossibilities = new HashSet<Integer>(
        Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9 ) );

    public void setValue( Integer value ) {
        this.value = value;
        for ( Integer i : possibilities ) {
            if ( i != value ) {
                possibilities.remove( i );
            }
        }
    }
    public Integer getValue() {
        return value;
    }
    public Set<Integer> getPossibilities() {
        return possibilities;
    }
}
