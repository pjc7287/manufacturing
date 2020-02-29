package data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table {

    private ArrayList<TableRow> rows;

    public Table(ArrayList<TableRow> rows){
        this.rows = rows;
    }

    public Iterator iterator(){
        return rows.iterator();
    }
}
