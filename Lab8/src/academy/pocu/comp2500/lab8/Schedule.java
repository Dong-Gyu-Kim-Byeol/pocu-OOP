package academy.pocu.comp2500.lab8;

public final class Schedule {
    private final int startTick;
    private final int workTickCount;
    private boolean isUse;

    public Schedule(final int startTick, final int workTickCount) {
        assert (startTick >= 0);
        assert (workTickCount > 0);

        this.startTick = startTick;
        this.workTickCount = workTickCount;
    }

    public void setIsUse(boolean isUse) {
        this.isUse = isUse;
    }

    public boolean isUse(final int tick) {
        return isUse && tick >= startTick;
    }

    public int getStartTick() {
        return startTick;
    }

    public int getWorkTickCount() {
        return workTickCount;
    }
}

