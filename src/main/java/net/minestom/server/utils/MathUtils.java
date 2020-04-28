package net.minestom.server.utils;

public class MathUtils {

    public static int square(int num) {
        return num * num;
    }

    public static float square(float num) {
        return num * num;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static float round(float value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (float) tmp / factor;
    }

    public static Direction getHorizontalDirection(float yawInDegrees) {
        // +45f gives a 90° angle for the direction (-1° and 1° are towards the same direction)
        int directionIndex = (int) ((yawInDegrees+45f) / 90f);
        if(directionIndex < 0) {
            directionIndex = Direction.HORIZONTAL.length-directionIndex;
        }
        directionIndex %= Direction.HORIZONTAL.length;
        return Direction.HORIZONTAL[directionIndex];
    }

}