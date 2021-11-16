package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public abstract class Unit {
    // 유닛이 할 수 있는 행동은 이동, 공격, '아무것도 안 함' 중 하나입니다.
    // 유닛은 현재 위치에 바로 인접한 타일로만 이동할 수 있습니다. 즉, 동서남북 중 한 방향으로만 이동할 수 있으며 대각선 이동은 허용하지 않습니다.
    // 유닛은 공격 구역에 있는 적을 발견하면 반드시 그 타일을 공격해야 합니다.
    // 이동 가능한 유닛은 공격 구역에 있는 적을 발견하지 못한 경우에만 이동할 수 있습니다.
    // 유닛은 자기 자신에게 피해를 입힐 수 없습니다.

    private final char symbol;
    private final EUnitType unitType;
    private final int attackAreaOfEffect;
    private final int attackPoint;
    private final EUnitType[] canAttackUnitTypes;

    private final IntVector2D position;
    private int hp;
    private EAction action;

    // ---

    protected Unit(final char symbol,
                   final EUnitType unitType,
                   final int attackPoint,
                   final int attackAreaOfEffect,
                   final EUnitType[] canAttackUnitTypes,

                   final int hp,
                   final IntVector2D position) {
        this.symbol = symbol;
        this.unitType = unitType;
        this.attackPoint = attackPoint;
        this.attackAreaOfEffect = attackAreaOfEffect;
        this.canAttackUnitTypes = canAttackUnitTypes;

        this.position = position;
        this.hp = hp;
        this.action = EAction.DO_NOTHING;
    }

    // ---

    // 시그내처 불변
    public final IntVector2D getPosition() {
        return position;
    }

    // 시그내처 불변
    public final int getHp() {
        return hp;
    }

    public final EUnitType getUnitType() {
        return unitType;
    }

    // 시그내처 불변
    public final char getSymbol() {
        return symbol;
    }

    public final int getAttackPoint() {
        return attackPoint;
    }

    public final int getAttackAreaOfEffect() {
        return attackAreaOfEffect;
    }

    public final EUnitType[] getCanAttackUnitTypes() {
        return canAttackUnitTypes;
    }

    // ---

    // 시그내처 불변
    public abstract void onAttacked(final int damage);

    // 시그내처 불변
    public abstract void onSpawn();

    public abstract void onDestroy();

    // 시그내처 불변
    public abstract AttackIntent attack();

    // ---

    protected static ImmutableIntVector2D[] createClockwiseManhattanDistanceOrderOffsetStartingAt12oClock(final int vision) {

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
            assert (vision > 0);

            // vision == distance from center
            for (int distanceFromCenter = 1; distanceFromCenter <= vision * 2; ++distanceFromCenter) {

                // -y : up, +y : down
                // -x : left, +x : right
                // Add corner points clockwise starting at 12 o'clock
                // 12시 방향을 시작으로 시계방향으로 모서리 점 추가

                // 1 / 4
                for (int y = -distanceFromCenter; y < 0; ++y) {
                    final ImmutableIntVector2D pos = new ImmutableIntVector2D(distanceFromCenter + y, y);

                    if (-vision > pos.x() || pos.x() > vision || -vision > pos.y() || pos.y() > vision) {
                        continue;
                    }

                    arrayList.add(pos);
                }

                // 2 / 4
                for (int y = 0; y < distanceFromCenter; ++y) {
                    final ImmutableIntVector2D pos = new ImmutableIntVector2D(distanceFromCenter - y, y);

                    if (-vision > pos.x() || pos.x() > vision || -vision > pos.y() || pos.y() > vision) {
                        continue;
                    }

                    arrayList.add(pos);
                }

                // 3 / 4
                for (int y = distanceFromCenter; 0 < y; --y) {
                    final ImmutableIntVector2D pos = new ImmutableIntVector2D(-distanceFromCenter + y, y);

                    if (-vision > pos.x() || pos.x() > vision || -vision > pos.y() || pos.y() > vision) {
                        continue;
                    }

                    arrayList.add(pos);
                }

                // 4 / 4
                for (int y = 0; -distanceFromCenter < y; --y) {
                    final ImmutableIntVector2D pos = new ImmutableIntVector2D(-distanceFromCenter - y, y);

                    if (-vision > pos.x() || pos.x() > vision || -vision > pos.y() || pos.y() > vision) {
                        continue;
                    }

                    arrayList.add(pos);
                }
            }
        }

        return arrayList.toArray(new ImmutableIntVector2D[0]);
    }

    // ---

    protected final void subHp(final int damage) {
        assert (damage >= 0);

        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    protected final EAction getAction() {
        return action;
    }

    protected final void setAction(EAction action) {
        this.action = action;
    }
}