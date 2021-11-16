package academy.pocu.comp2500.lab8;

import java.util.LinkedList;

public final class Sprinkler extends SmartDevice implements ISprayable {
    private static final ESmartDeviceType SMART_DEVICE_TYPE = ESmartDeviceType.SPRINKLER;
    private static final int ADD_WATER_LEVEL_PER_TICK = 15;

    // ---

    private final LinkedList<Schedule> schedules;
    private Schedule nowScheduleOrNull;

    // ---

    public Sprinkler() {
        super(SMART_DEVICE_TYPE);
        this.schedules = new LinkedList<>();
    }

    // ---

    @Override
    public void onTick() {
        super.onTick();

        while (this.schedules.size() != 0 && (nowScheduleOrNull == null || isValidSchedule(nowScheduleOrNull) == false)) {
            if (nowScheduleOrNull != null && nowScheduleOrNull.getStartTick() + nowScheduleOrNull.getWorkTickCount() == getTick()) {
                this.setIsOn(false);

                nowScheduleOrNull = null;
                return;
            }

            nowScheduleOrNull = null;
            if (isValidSchedule(this.schedules.getFirst()) == false) {
                schedules.poll();
                continue;
            }

            if (this.schedules.getFirst().getStartTick() > getTick()) {
                this.setIsOn(false);
                break;
            }

            setIsUseInSchedule(schedules.getFirst());
            nowScheduleOrNull = schedules.poll();
            break;
        }

        if (nowScheduleOrNull == null) {
            this.setIsOn(false);
            return;
        }

        if (isValidSchedule(nowScheduleOrNull)) {
            if (nowScheduleOrNull.isCanUse(getTick())) {
                this.setIsOn(true);
                return;
            } else {
                this.setIsOn(false);
                return;
            }
        }

        {
            this.setIsOn(false);
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

    // ---

    private void setIsUseInSchedule(final Schedule schedule) {
        assert (schedule.getStartTick() <= getTick()); // prevent wrong calls

        if (schedule.getStartTick() >= getTick()) {
            schedule.setIsUse(true);
            return;
        }

        schedule.setIsUse(false);
    }

    private boolean isValidSchedule(final Schedule schedule) {
        return schedule.getStartTick() + schedule.getWorkTickCount() - 1 >= getTick();
    }
}
