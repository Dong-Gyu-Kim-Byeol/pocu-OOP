package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class SimulationManager {
    private static SimulationManager instance;

    public static SimulationManager getInstance() {
        if (instance == null) {
            instance = new SimulationManager();
        }

        return instance;
    }

    private final ArrayList<Unit> units;
//    private final ArrayList<Unit> thinkablUnits;
//    private final ArrayList<Unit> movableUnits;

    private SimulationManager() {
        this.units = new ArrayList<>();
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void spawn(final Unit unit) {
        if (unit.getHp() == 0) {
            return;
        }

        switch (){
            registerThinkable();
            registerMovable();
        }

        this.units.add(unit);
    }

    public void registerThinkable(Unit thinkable) {

    }

    public void registerMovable(Unit movable) {

    }

    public void registerCollisionEventListener(Unit listener) {

    }

    public void update() {
//      1  각 유닛들이 이번 프레임에서 할 행동(선택지: 공격, 이동, 아무것도 안 함)을 결정
//      2  움직일 수 있는 각 유닛에게 이동할 기회를 줌
//      3  이동 후 충돌 처리
//      4  각 유닛에게 공격할 기회를 줌
//      5  피해를 입어야 하는 각 유닛에게 피해를 입힘
//      6  죽은 유닛들을 모두 게임에서 제거함
    }
}