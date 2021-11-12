package academy.pocu.comp2500.lab8;

import java.util.LinkedList;

public final class Sprinkler extends SmartDevice implements ISprayable {
    private static final int ADD_WATER_LEVEL_PER_TICK = 15;

    private final LinkedList<Schedule> schedules;
    private Schedule nowScheduleOrNull;

    public Sprinkler() {
        super(ESmartDeviceType.SPRINKLER);
        this.schedules = new LinkedList<>();
    }

    public void onTick() {
        this.tick++;

        while (this.schedules.size() != 0 && (nowScheduleOrNull == null || isValidSchedule(nowScheduleOrNull) == false)) {
            if (nowScheduleOrNull != null && nowScheduleOrNull.getStartTick() + nowScheduleOrNull.getWorkTickCount() == tick) {
                if (this.isOn != false) {
                    this.ticksSinceLastUpdate = this.tick;
                }
                this.isOn = false;

                nowScheduleOrNull = null;
                return;
            }

            nowScheduleOrNull = null;
            if (isValidSchedule(this.schedules.getFirst()) == false) {
                schedules.poll();
                continue;
            }

            if (this.schedules.getFirst().getStartTick() > tick) {
                if (this.isOn != false) {
                    this.ticksSinceLastUpdate = this.tick;
                }
                this.isOn = false;
                break;
            }

            setIsUseInSchedule(schedules.getFirst());
            nowScheduleOrNull = schedules.poll();
            break;
        }

        if (nowScheduleOrNull == null) {
            if (this.isOn != false) {
                this.ticksSinceLastUpdate = this.tick;
            }
            this.isOn = false;
            return;
        }

        if (isValidSchedule(nowScheduleOrNull)) {
            if (nowScheduleOrNull.isUse(tick)) {
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
            return;
        }
    }

    public void addSchedule(final Schedule schedule) {
        if (schedule.getStartTick() == 0) {
            return;
        }

        this.schedules.add(schedule);
    }

    public void spray(final Planter planter) {
        if (isOn()) {
            planter.addWater(ADD_WATER_LEVEL_PER_TICK);
        }
    }

    private void setIsUseInSchedule(final Schedule schedule) {
        assert (schedule.getStartTick() <= tick);

        if (schedule.getStartTick() >= tick) {
            schedule.setIsUse(true);
            return;
        }

        schedule.setIsUse(false);
    }

    private boolean isValidSchedule(final Schedule schedule) {
        return schedule.getStartTick() + schedule.getWorkTickCount() - 1 >= tick;
    }
}
