package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;
import java.util.HashSet;
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
    private int unitCount;

    private final HashSet<IThinkable> thinkableUnits;
    private final HashSet<IMovable> movableUnits;
    private final HashSet<ICollision> collisionUnits;

    private final ArrayList<AttackIntent> attackIntents;
    private final HashSet<Unit> attackedUnits;

    @SuppressWarnings("unchecked")
    private SimulationManager() {
        this.map = new LinkedList[Y_MAP_SIZE][X_MAP_SIZE];

        for (int y = 0; y < Y_MAP_SIZE; ++y) {
            for (int x = 0; x < X_MAP_SIZE; ++x) {
                this.map[y][x] = new LinkedList<>();
            }
        }

        this.thinkableUnits = new HashSet<>();
        this.movableUnits = new HashSet<>();
        this.collisionUnits = new HashSet<>();

        this.attackIntents = new ArrayList<>();
        this.attackedUnits = new HashSet<>();
    }

    public void clear() {
        for (int y = 0; y < Y_MAP_SIZE; ++y) {
            for (int x = 0; x < X_MAP_SIZE; ++x) {
                this.map[y][x].clear();
            }
        }

        unitCount = 0;

        this.thinkableUnits.clear();
        this.movableUnits.clear();
        this.collisionUnits.clear();

        this.attackIntents.clear();
        this.attackedUnits.clear();
    }


    public LinkedList<Unit>[][] getMap() {
        return map;
    }

    // 시그내처 불변
    public ArrayList<Unit> getUnits() {
        ArrayList<Unit> out = new ArrayList<>(unitCount);

        for (int y = 0; y < Y_MAP_SIZE; ++y) {
            for (int x = 0; x < X_MAP_SIZE; ++x) {
                for (final Unit unit : this.map[y][x]) {
                    out.add(unit);
                }
            }
        }

        assert (out.size() == unitCount);

        return out;
    }

    // 시그내처 불변
    public void spawn(final Unit unit) {
        unit.onSpawn();

        ++this.unitCount;
        this.map[unit.getPosition().getY()][unit.getPosition().getX()].add(unit);
    }

    public boolean isValidPosition(final int x, final int y) {
        return 0 <= x && x < map[0].length && 0 <= y && y < map.length;
    }

    public void replacePosition(final Unit unit, final int preX, final int preY) {
        map[preY][preX].remove(unit);
        map[unit.getPosition().getY()][unit.getPosition().getX()].add(unit);
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
        // 1  각 유닛들이 이번 프레임에서 할 행동(선택지: 공격, 이동, 아무것도 안 함)을 결정
        for (final IThinkable thinkable : thinkableUnits) {
            thinkable.think();
        }

        // 2  움직일 수 있는 각 유닛에게 이동할 기회를 줌
        for (final IMovable movable : movableUnits) {
            movable.move();
        }

        // 3  이동 후 충돌 처리
        for (final ICollision collision : collisionUnits) {
            final int y = collision.getCollisionPosition().y();
            final int x = collision.getCollisionPosition().x();

            for (final Unit unit : map[y][x]) {
                collision.checkCollision(unit);
            }
        }

        // 4  각 유닛에게 공격할 기회를 줌
        for (int y = 0; y < Y_MAP_SIZE; ++y) {
            for (int x = 0; x < X_MAP_SIZE; ++x) {
                for (final Unit unit : this.map[y][x]) {
                    final AttackIntent attackIntent = unit.attack();
                    if (attackIntent.isValid()) {
                        attackIntents.add(attackIntent);
                    }
                }
            }
        }

        // 5  피해를 입어야 하는 각 유닛에게 피해를 입힘
        for (final AttackIntent attackIntent : attackIntents) {
            attackIntent.execute(attackedUnits);
        }
        attackIntents.clear();

        // 6  죽은 유닛들을 모두 게임에서 제거함
        for (final Unit unit : attackedUnits) {
            if (unit.getHp() <= 0) {
                map[unit.getPosition().getY()][unit.getPosition().getX()].remove(unit);
                thinkableUnits.remove(unit);
                movableUnits.remove(unit);
                collisionUnits.remove(unit);
                --unitCount;
            }
        }
        attackedUnits.clear();
    }
}