package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected final ESmartDeviceType smartDeviceType;
    protected int tick;
    protected int ticksSinceLastUpdate;
    protected boolean isOn;

    protected SmartDevice(final ESmartDeviceType smartDeviceType) {
        this.smartDeviceType = smartDeviceType;
    }

    public ESmartDeviceType getSmartDeviceType() {
        return smartDeviceType;
    }

    public final boolean isOn() {
        return isOn;
    }

    public void onTick() {
        this.tick++;
    }

    public final int getTicksSinceLastUpdate() {
        return this.tick - this.ticksSinceLastUpdate;
    }
}
