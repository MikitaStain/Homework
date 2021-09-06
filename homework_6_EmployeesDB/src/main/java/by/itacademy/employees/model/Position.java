package by.itacademy.employees.model;

public class Position {

    private long id;
    private String position;

    public Position(String position,long id) {
        this.position = position;
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
