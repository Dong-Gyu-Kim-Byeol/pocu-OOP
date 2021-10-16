package academy.pocu.comp2500;

import academy.pocu.comp2500.assignment2.Color;

public enum ECalendarColor {
    WHITE;

    // public method
    public Color getColor() {
        final Color color;
        switch (this) {
            case WHITE:
                color = Color.WHITE;
                break;
            default:
                throw new IllegalArgumentException("unknown type");
        }

        return color;
    }
}
