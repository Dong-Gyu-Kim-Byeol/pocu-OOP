package academy.pocu.comp2500.assignment3;

import java.util.HashSet;

// 공격 의도
public final class AttackIntent {
    private final Unit attackUnit;
    private final int attackPoint;
    private final int attackAreaOfEffect;
    private final EUnitType[] canAttackUnitTypes;
    private final boolean isCanSelfAttack;
    private final ImmutableIntVector2D attackCenterPosition;

    // ---

    public AttackIntent(final Unit attackUnit, final boolean isCanSelfAttack, final ImmutableIntVector2D attackPosition, final int attackPoint, final int attackAreaOfEffect, final EUnitType[] canAttackUnitTypes) {
        this.attackUnit = attackUnit;
        this.isCanSelfAttack = isCanSelfAttack;
        this.attackCenterPosition = attackPosition;
        this.attackPoint = attackPoint;
        this.attackAreaOfEffect = attackAreaOfEffect;
        this.canAttackUnitTypes = canAttackUnitTypes;
    }

    // ---

    public void execute(final HashSet<Unit> outAttackedUnits) {
        final Map2DCanSamePosition<Unit> map = SimulationManager.getInstance().getMap();

        if (!isValid()) {
            return;
        }

        final int minY = this.attackCenterPosition.y() - this.attackAreaOfEffect;
        final int minX = this.attackCenterPosition.x() - this.attackAreaOfEffect;

        final int maxY = this.attackCenterPosition.y() + this.attackAreaOfEffect;
        final int maxX = this.attackCenterPosition.x() + this.attackAreaOfEffect;

        for (int y = minY; y <= maxY; ++y) {
            for (int x = minX; x <= maxX; ++x) {
                if (!SimulationManager.getInstance().isValidPosition(x, y)) {
                    continue;
                }

                if (map.getHashSet(y, x).size() == 0) {
                    continue;
                }

                for (final Unit unit : map.getHashSet(y, x)) {
                    if (unit == this.attackUnit && this.isCanSelfAttack == false) {
                        continue;
                    }

                    for (final EUnitType canAttackUnitType : this.canAttackUnitTypes) {
                        if (unit.getUnitType() == canAttackUnitType) {
                            unit.onAttacked(calculateDamage(x, y));
                            outAttackedUnits.add(unit);
                            break;
                        }
                    }
                }
            }
        }
    }

    public boolean isValid() {
        return SimulationManager.getInstance().isValidPosition(this.attackCenterPosition.x(), this.attackCenterPosition.y());
    }

    public int calculateDamage(final int attackedPositionX, final int attackedPositionY) {
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

        final double distance = Math.max(Math.abs(this.attackCenterPosition.x() - attackedPositionX), Math.abs(this.attackCenterPosition.y() - attackedPositionY));

        assert (distance <= (double) this.attackAreaOfEffect);

        final int damage = (int) ((double) this.attackPoint * (1.0 - distance / ((double) this.attackAreaOfEffect + 1.0)));

        assert (damage >= 0);

        return damage;
    }
}