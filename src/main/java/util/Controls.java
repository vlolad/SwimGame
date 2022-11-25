package util;

public enum Controls {
    W, S, A, D;

    public static Controls parseMove(String move) {
        try {
            return valueOf(move.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
