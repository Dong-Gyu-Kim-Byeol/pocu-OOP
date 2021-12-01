package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.LinkedList;

public final class OverdrawAnalyzer extends Canvas {
    private final ArrayList<LinkedList<Character>> historyArray;

    // ---

    public OverdrawAnalyzer(final int width, final int height) {
        super(width, height);

        this.historyArray = new ArrayList<>(width * height);
        for (int h = 0; h < height; ++h) {
            for (int w = 0; w < width; ++w) {
                this.historyArray.add(new LinkedList<>());
            }
        }
    }

    // ---

    @Override
    public void drawPixel(final int x, final int y, final char character) {
        if (super.getPixel(x, y) == character) {
            return;
        }

        final LinkedList<Character> history = getPixelHistory(x, y);
        history.addLast(character);

        super.drawPixel(x, y, character);
    }

    public final LinkedList<Character> getPixelHistory(final int x, final int y) {
        return this.historyArray.get(getHistoryIndex(x, y));
    }

    public final int getOverdrawCount() {
        int sum = 0;
        for (int y = 0; y < getHeight(); ++y) {
            for (int x = 0; x < getWidth(); ++x) {
                sum += getOverdrawCount(x, y);
            }
        }

        return sum;
    }

    public final int getOverdrawCount(final int x, final int y) {
        return getPixelHistory(x, y).size();
    }

    // ---

    private int getHistoryIndex(final int x, final int y) {
        return y * getWidth() + x;
    }

}
