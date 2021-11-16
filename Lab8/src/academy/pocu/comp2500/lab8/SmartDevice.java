package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    private final ESmartDeviceType smartDeviceType;

    private int tick;
    private int ticksSinceLastUpdate;
    private boolean isOn;

    // ---

    protected SmartDevice(final ESmartDeviceType smartDeviceType) {
        this.smartDeviceType = smartDeviceType;
    }

    // ---

    public final ESmartDeviceType getSmartDeviceType() {
        return smartDeviceType;
    }

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
