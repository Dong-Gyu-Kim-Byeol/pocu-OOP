package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.HashSet;

public final class Map2DCanSamePosition<T> {
    private final ArrayList<ArrayList<HashSet<T>>> map;
    private int unitCount;

    public Map2DCanSamePosition(final int ySize, final int xSize) {
        map = new ArrayList<ArrayList<HashSet<T>>>(ySize);

        for (int y = 0; y < ySize; ++y) {
            map.add(new ArrayList<HashSet<T>>(xSize));

            for (int x = 0; x < xSize; ++x) {
                this.map.get(y).add(new HashSet<T>());
            }
        }
    }

    public void clear() {
        for (int y = 0; y < map.size(); ++y) {
            for (int x = 0; x < this.map.get(0).size(); ++x) {
                this.map.get(y).get(x).clear();
            }
        }
    }

    public int elementsCount() {
        return unitCount;
    }

    public int ySize() {
        return map.size();
    }

    public int xSize() {
        return map.get(0).size();
    }

    public HashSet<T> getHashSet(final int y, final int x) {
        return map.get(y).get(x);
    }

    public void add(final T data, final int y, final int x) {
        map.get(y).get(x).add(data);
        ++unitCount;
    }

    public void remove(final T data, final int y, final int x) {
        map.get(y).get(x).remove(data);
        --unitCount;
    }

    public void replace(final T data, final int preY, final int preX, final int postY, final int postX) {
        map.get(preY).get(preX).remove(data);
        map.get(postY).get(postX).add(data);
    }
}
