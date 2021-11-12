package academy.pocu.comp2500.assignment3;

import java.util.LinkedList;

// 공격 의도
public class AttackIntent {
    private final Unit attackUnit;
    private final ImmutableIntVector2D attackCenterPosition;

    public AttackIntent(final Unit attackUnit, final ImmutableIntVector2D attackPosition) {
        this.attackUnit = attackUnit;
        this.attackCenterPosition = attackPosition;
    }

    public Unit getAttackUnit() {
        return attackUnit;
    }

    public int getAttackPoint(final ImmutableIntVector2D attackedPosition) {
        if (isAttacked(attackedPosition) == false) {
            assert (false);
            return 0;
        }

        return calculateDamage(attackUnit, attackCenterPosition, attackedPosition);
    }

    public boolean isAttacked(final ImmutableIntVector2D attackedPosition) {
        final LinkedList<Unit>[][] map = SimulationManager.getInstance().getMap();
        final int aoe = attackUnit.getAttackAreaOfEffect();

        for (int y = attackCenterPosition.y() - aoe; y <= attackCenterPosition.y() + aoe; ++y) {
            for (int x = attackCenterPosition.x() - aoe; x <= attackCenterPosition.x() + aoe; ++x) {
                if (!SimulationManager.isValidPosition(map, x, y)) {
                    continue;
                }

                if (map[y][x].size() == 0) {
                    continue;
                }

                for (final Unit unit : map[y][x]) {
                    for (final EUnitType unitType : attackUnit.getCanAttackUnitTypes()) {
                        if (unit.getUnitType() == unitType) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public ImmutableIntVector2D getAttackCenterPosition() {
        return attackCenterPosition;
    }


    // 피해치(x, y) = (공격 지점에서의 피해치) * (1 - 공격 지점으로부터의 거리 / (공격의 AoE 값 + 1))

    //    거리는 다음과 같이 정의합니다. 다음 그림에서 숫자는 공격 지점으로부터의 거리값을 나타냅니다.
    //        3 3 3 3 3 3 3
    //        3 2 2 2 2 2 3
    //        3 2 1 1 1 2 3
    //        3 2 1 * 1 2 3
    //        3 2 1 1 1 2 3
    //        3 2 2 2 2 2 3
    //        3 3 3 3 3 3 3
    // 계산 중에는 double 형을 사용하고 최종 계산 뒤에는 소수점 이하는 버리세요.
    public static int calculateDamage(final Unit attackUnit, final ImmutableIntVector2D attackCenterPosition, final ImmutableIntVector2D attackedPosition) {
        final double distance = Math.max(Math.abs(attackCenterPosition.x() - attackedPosition.x()), Math.abs(attackCenterPosition.y() - attackedPosition.y()));
        final double aoe = attackUnit.getAttackAreaOfEffect();
        final double ap = attackUnit.getAttackPoint();

        assert (distance <= aoe);

        return (int) (ap * (1.0 - distance / (aoe + 1.0)));
    }
}