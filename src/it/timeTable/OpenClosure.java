package it.timeTable;

public enum OpenClosure {
    OPEN,
    CLOSURE;

    String name;

    OpenClosure () {
        this.name = this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }

    public String getName() {
        return name;
    }
}
