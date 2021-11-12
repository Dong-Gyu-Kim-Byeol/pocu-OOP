package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.LinkedList;

public final class SimulationManager {
    // 월드는 16 x 8 크기의 2D 그리드(grid)입니다.
    // 원점은 (0,0)이며 +x는 오른쪽, +y는 아래쪽입니다. 또한 북쪽은 -y, 동쪽은 +x 입니다
    public static final int X_MAP_SIZE = 16;
    public static final int Y_MAP_SIZE = 8;

    private static SimulationManager instance;

    // 시그내처 불변
    public static SimulationManager getInstance() {
        if (instance == null) {
            instance = new SimulationManager();
        }

        return instance;
    }

    private final LinkedList<Unit>[][] map;

    private final LinkedList<IThinkable> thinkableUnits;
    private final LinkedList<IMovable> movableUnits;
    private final LinkedList<ICollision> collisionUnits;

    @SuppressWarnings("unchecked")
    private SimulationManager() {
        this.map = new LinkedList[Y_MAP_SIZE][X_MAP_SIZE];

        for (int y = 0; y < Y_MAP_SIZE; ++y) {
            for (int x = 0; x < X_MAP_SIZE; ++x) {
                this.map[y][x] = new LinkedList<>();
            }
        }

        this.thinkableUnits = new LinkedList<>();
        this.movableUnits = new LinkedList<>();
        this.collisionUnits = new LinkedList<>();
    }

    public LinkedList<Unit>[][] getMap() {
        return map;
    }

    // 시그내처 불변
    public ArrayList<Unit> getUnits() {
        int size = 0;
        for (int y = 0; y < Y_MAP_SIZE; ++y) {
            for (int x = 0; x < X_MAP_SIZE; ++x) {
                size += this.map[y][x].size();
            }
        }

        ArrayList<Unit> out = new ArrayList<>(size);

        for (int y = 0; y < Y_MAP_SIZE; ++y) {
            for (int x = 0; x < X_MAP_SIZE; ++x) {
                for (final Unit unit : this.map[y][x]) {
                    out.add(unit);
                }
            }
        }

        return out;
    }

    // 시그내처 불변
    public void spawn(final Unit unit) {
        unit.onSpawn();
        this.map[unit.getPosition().getY()][unit.getPosition().getX()].add(unit);
    }

    // 시그내처 ?
    public void registerThinkable(final IThinkable thinkable) {
        this.thinkableUnits.add(thinkable);
    }

    // 시그내처 ?
    public void registerMovable(final IMovable movable) {
        this.movableUnits.add(movable);
    }

    // 시그내처 ?
    public void registerCollisionEventListener(final ICollision listener) {
        this.collisionUnits.add(listener);
    }

    // 시그내처 불변
    public void update() {
//      1  각 유닛들이 이번 프레임에서 할 행동(선택지: 공격, 이동, 아무것도 안 함)을 결정
//      2  움직일 수 있는 각 유닛에게 이동할 기회를 줌
//      3  이동 후 충돌 처리
//      4  각 유닛에게 공격할 기회를 줌
//      5  피해를 입어야 하는 각 유닛에게 피해를 입힘
//      6  죽은 유닛들을 모두 게임에서 제거함
    }


    public static boolean isValidPosition(final LinkedList<Unit>[][] map, final int x, final int y) {
        if (x < 0 || map[0].length <= x
                || y < 0 || map.length <= y) {
            return false;
        }

        return true;
    }
}