package util;

import java.util.Objects;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(Coordinates cord) {
        this.x = cord.x();
        this.y = cord.y();
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void set(int x, int y) {
        if (x >= 0 && x <= 9) this.x = x;
        if (y >= 0 && y <= 9) this.y = y;
    }

    public void set(Coordinates cord) {
        this.x = cord.x();
        this.y = cord.y();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
