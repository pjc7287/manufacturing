package data;

import java.util.ArrayList;
import java.util.Iterator;

public class TableRow {

    private ArrayList<Cell> cells;

    public TableRow(ArrayList<Cell> cells){
        this.cells = cells;
    }

    public Iterator iterator(){
        return cells.iterator();
    }
}
