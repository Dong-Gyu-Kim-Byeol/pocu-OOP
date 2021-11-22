package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    private int tick;
    private int ticksSinceLastUpdate;
    private boolean isOn;

    // ---

    protected SmartDevice() {
    }

    // ---

    public final boolean isOn() {
        return isOn;
    }

    public final int getTicksSinceLastUpdate() {
        return this.tick - this.ticksSinceLastUpdate;
    }

    // ---

    public void onTick() {
        this.tick++;
    }

    // ---

    public abstract void onInstall(final Planter planter);

    // ---

    protected final int getTick() {
        return tick;
    }

    protected final void setIsOn(final boolean on) {
        if (this.isOn() != on) {
            this.ticksSinceLastUpdate = this.tick;
        }

        this.isOn = on;
    }
}
