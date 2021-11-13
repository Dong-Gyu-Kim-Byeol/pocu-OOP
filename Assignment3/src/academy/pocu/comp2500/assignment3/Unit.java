package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public abstract class Unit {
    // 유닛이 할 수 있는 행동은 이동, 공격, '아무것도 안 함' 중 하나입니다.
    // 유닛은 현재 위치에 바로 인접한 타일로만 이동할 수 있습니다. 즉, 동서남북 중 한 방향으로만 이동할 수 있으며 대각선 이동은 허용하지 않습니다.
    // 유닛은 공격 구역에 있는 적을 발견하면 반드시 그 타일을 공격해야 합니다.
    // 이동 가능한 유닛은 공격 구역에 있는 적을 발견하지 못한 경우에만 이동할 수 있습니다.
    // 유닛은 자기 자신에게 피해를 입힐 수 없습니다.

    private final EUnitType unitType;
    private final IntVector2D position;
    private int hp;
    private EAction action;

    protected Unit(final EUnitType unitType, final int hp, final IntVector2D startPosition) {
        this.unitType = unitType;
        this.hp = hp;
        this.position = startPosition;
        this.action = EAction.DO_NOTHING;
    }


    public EUnitType getUnitType() {
        return unitType;
    }

    // 시그내처 불변
    public final IntVector2D getPosition() {
        return position;
    }

    // 시그내처 불변
    public final int getHp() {
        return hp;
    }

    protected final void subHp(final int damage) {
        assert (damage >= 0);

        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    protected final void setHpZero() {
        this.hp = 0;
    }

    protected EAction getAction() {
        return action;
    }

    protected void setAction(EAction action) {
        this.action = action;
    }


    // 시그내처 불변
    public abstract AttackIntent attack();

    // 시그내처 불변
    public abstract void onAttacked(final int damage);

    // 시그내처 불변
    public abstract void onSpawn();

    // 시그내처 불변
    public abstract char getSymbol();

    public abstract int getAttackPoint();

    public abstract int getAttackAreaOfEffect();

    public abstract EUnitType[] getCanAttackUnitTypes();

    public abstract boolean isIThinkable();

    public abstract boolean isIMovable();

    public abstract boolean isICollision();

    protected static ImmutableIntVector2D[] createClockwiseManhattanDistanceOrderOffsetStartingAt12oClock(final int maxDistanceFromCenter) {

        //   시야: 1   ( == vision)
        //   o o o
        //   o * o
        //   o o o
        //
        //   시야: 2   ( == vision)
        //   o o o o o
        //   o o o o o
        //   o o * o o
        //   o o o o o
        //   o o o o o
        //
        //   시야: 3   ( == vision)
        //   o o o o o o o
        //   o o o o o o o
        //   o o o o o o o
        //   o o o * o o o
        //   o o o o o o o
        //   o o o o o o o
        //   o o o o o o o
        //
        // Create a clockwise offset starting at 12 o'clock

        ArrayList<ImmutableIntVector2D> arrayList = new ArrayList<>();

        {
            assert (maxDistanceFromCenter > 0);

            // vision == distance from center
            for (int distanceFromCenter = 1; distanceFromCenter <= maxDistanceFromCenter * 2; ++distanceFromCenter) {

                // -y : up, +y : down
                // -x : left, +x : right
                // Add corner points clockwise starting at 12 o'clock
                // 12시 방향을 시작으로 시계방향으로 모서리 점 추가

                final int maxX = maxDistanceFromCenter;


                // 1 / 4
                for (int y = -distanceFromCenter; y < 0; ++y) {
                    final ImmutableIntVector2D pos = new ImmutableIntVector2D(distanceFromCenter + y, y);

                    if (-maxDistanceFromCenter > pos.x() || pos.x() > maxDistanceFromCenter || -maxDistanceFromCenter > pos.y() || pos.y() > maxDistanceFromCenter) {
                        continue;
                    }

                    arrayList.add(pos);
                }

                // 2 / 4
                for (int y = 0; y < distanceFromCenter; ++y) {
                    final ImmutableIntVector2D pos = new ImmutableIntVector2D(distanceFromCenter - y, y);

                    if (-maxDistanceFromCenter > pos.x() || pos.x() > maxDistanceFromCenter || -maxDistanceFromCenter > pos.y() || pos.y() > maxDistanceFromCenter) {
                        continue;
                    }

                    arrayList.add(pos);
                }

                // 3 / 4
                for (int y = distanceFromCenter; 0 < y; --y) {
                    final ImmutableIntVector2D pos = new ImmutableIntVector2D(-distanceFromCenter + y, y);

                    if (-maxDistanceFromCenter > pos.x() || pos.x() > maxDistanceFromCenter || -maxDistanceFromCenter > pos.y() || pos.y() > maxDistanceFromCenter) {
                        continue;
                    }

                    arrayList.add(pos);
                }

                // 4 / 4
                for (int y = 0; -distanceFromCenter < y; --y) {
                    final ImmutableIntVector2D pos = new ImmutableIntVector2D(-distanceFromCenter - y, y);

                    if (-maxDistanceFromCenter > pos.x() || pos.x() > maxDistanceFromCenter || -maxDistanceFromCenter > pos.y() || pos.y() > maxDistanceFromCenter) {
                        continue;
                    }

                    arrayList.add(pos);
                }
            }
        }

        return arrayList.toArray(new ImmutableIntVector2D[0]);
    }
}