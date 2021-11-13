package academy.pocu.comp2500.assignment3;

import java.util.HashSet;
import java.util.LinkedList;

// 공격 의도
public final class AttackIntent {
    private final Unit attackUnit;
    private final ImmutableIntVector2D attackCenterPosition;

    public AttackIntent(final Unit attackUnit, final ImmutableIntVector2D attackPosition) {
        this.attackUnit = attackUnit;
        this.attackCenterPosition = attackPosition;
    }

    public void execute(final HashSet<Unit> outAttackedUnits) {
        final Map2DCanSamePosition<Unit> map = SimulationManager.getInstance().getMap();

        if (!isValid()) {
            return;
        }

        final int minY = attackCenterPosition.y() - attackUnit.getAttackAreaOfEffect();
        final int minX = attackCenterPosition.x() - attackUnit.getAttackAreaOfEffect();

        final int maxY = attackCenterPosition.y() + attackUnit.getAttackAreaOfEffect();
        final int maxX = attackCenterPosition.x() + attackUnit.getAttackAreaOfEffect();

        for (int y = minY; y <= maxY; ++y) {
            for (int x = minX; x <= maxX; ++x) {
                if (!SimulationManager.getInstance().isValidPosition(x, y)) {
                    continue;
                }

                if (map.getHashSet(y, x).size() == 0) {
                    continue;
                }

                for (final Unit unit : map.getHashSet(y, x)) {
                    if (unit == attackUnit) {
                        continue;
                    }

                    for (final EUnitType unitType : attackUnit.getCanAttackUnitTypes()) {
                        if (unit.getUnitType() == unitType) {
                            unit.onAttacked(calculateDamage(attackUnit, attackCenterPosition, x, y));
                            outAttackedUnits.add(unit);
                        }
                    }
                }
            }
        }
    }

    public boolean isValid() {
        return SimulationManager.getInstance().isValidPosition(attackCenterPosition.x(), attackCenterPosition.y());
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
    public static int calculateDamage(final Unit attackUnit, final ImmutableIntVector2D attackCenterPosition, final int attackedPositionX, final int attackedPositionY) {
        final double distance = Math.max(Math.abs(attackCenterPosition.x() - attackedPositionX), Math.abs(attackCenterPosition.y() - attackedPositionY));
        final double aoe = attackUnit.getAttackAreaOfEffect();
        final double ap = attackUnit.getAttackPoint();

        assert (distance <= aoe);

        final int damage = (int) (ap * (1.0 - distance / (aoe + 1.0)));

        assert (damage >= 0);

        return damage;
    }
}