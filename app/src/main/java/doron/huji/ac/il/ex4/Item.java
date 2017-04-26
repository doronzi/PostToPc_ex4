package doron.huji.ac.il.ex4;

import java.util.Date;

public class Item {

    private String task;
    private Date dueDate;
    private int id;

    public Item(String task, int ID, Date date)
    {
        this.task = task;
        this.dueDate = date;
        this.id = ID;
    }

    public Date getDueDate()
    {
        return this.dueDate;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "#" + this.task;
    }
}
