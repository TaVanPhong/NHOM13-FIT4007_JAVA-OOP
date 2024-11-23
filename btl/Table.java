class Table {
    private int id;
    private boolean isBooked;

    public Table(int id) {
        this.id = id;
        this.isBooked = false;
    }

    public int getId() {
        return id;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void book() {
        isBooked = true;
    }

    public void free() {
        isBooked = false;
    }

    @Override
    public String toString() {
        return "Table " + id + (isBooked ? " (Booked)" : " (Available)");
    }
}