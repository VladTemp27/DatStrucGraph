package Backend;

public class EdgeLEC {
    private final VertexLEC start;
    private final VertexLEC end;
    private final double weight;
    private final int id;

    public EdgeLEC(VertexLEC start, VertexLEC end, double weight, int id) {
        this.start = start;
        this.end = end;
        this.weight = weight;
        this.id = id;
    } // end of constructor

    public VertexLEC getStart() {
        return start;
    } // end of getStart

    public VertexLEC getEnd() {
        return end;
    } // end of getEnd

    public double getWeight() {
        return weight;
    } // end of getWeight

    public int getId() {
        return id;
    } // end of getId

    @Override
    public String toString() {
        return "(" + start + "," + end + ")";
    } // end of toString

    @Override
    public boolean equals(Object object) {
        if (object instanceof EdgeLEC otherEdge) {
            return otherEdge.getStart().getId() == getStart().getId() && otherEdge.getEnd().getId() == getEnd().getId();
        }
        return false;
    } // end of equals
} // end of EdgeLEC
