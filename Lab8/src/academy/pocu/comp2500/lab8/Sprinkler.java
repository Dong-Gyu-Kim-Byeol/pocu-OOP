package academy.pocu.comp2500.lab8;

import java.util.LinkedList;

public final class Sprinkler extends SmartDevice implements ISprayable {
    private static final int ADD_WATER_LEVEL_PER_TICK = 15;

    private final LinkedList<Schedule> schedules;
    private Schedule nowSchedule;

    public Sprinkler() {
        super(ESmartDeviceType.SPRINKLER);
        this.schedules = new LinkedList<>();
    }

    private boolean isSetUseSchedule(Schedule schedule) {
        if (schedule.getStartTick() >= tick) {
            schedule.setUse(true);
            return true;
        }

        return false;
    }

    private boolean isValidSchedule(Schedule schedule) {
        if (schedule.getStartTick() + schedule.getWorkTickCount() - 1 >= tick) {
            return true;
        } else {
            return false;
        }
    }

    public void onTick() {
        this.tick++;

        while (this.schedules.size() != 0 && (nowSchedule == null || isValidSchedule(nowSchedule) == false)) {
            if (nowSchedule != null && nowSchedule.getStartTick() + nowSchedule.getWorkTickCount() == tick) {
                if (this.isOn != false) {
                    this.ticksSinceLastUpdate = this.tick;
                }

                this.isOn = false;
                return;
            }

            nowSchedule = null;
            if (isValidSchedule(this.schedules.getFirst()) == false) {
                schedules.poll();
                continue;
            }

            isSetUseSchedule(schedules.getFirst());
            nowSchedule = schedules.poll();
            break;
        }

        if (nowSchedule == null) {
            if (this.isOn != false) {
                this.ticksSinceLastUpdate = this.tick;
            }

            this.isOn = false;
            return;
        }

        if (isValidSchedule(nowSchedule)) {
            if (nowSchedule.isUse(tick)) {
                if (this.isOn != true) {
                    this.ticksSinceLastUpdate = this.tick;
                }

                this.isOn = true;
                return;
            } else {
                if (this.isOn != false) {
                    this.ticksSinceLastUpdate = this.tick;
                }

                this.isOn = false;
                return;
            }
        }

        {
            if (this.isOn != false) {
                this.ticksSinceLastUpdate = this.tick;
            }
            this.isOn = false;
        }
    }

    public void addSchedule(final Schedule schedule) {
        if (schedule.getStartTick() == 0) {
            return;
        }

        this.schedules.add(schedule);
    }

    public void spray(Planter planter) {
        if (isOn()) {
            planter.addWater(ADD_WATER_LEVEL_PER_TICK);
        }
    }
}
