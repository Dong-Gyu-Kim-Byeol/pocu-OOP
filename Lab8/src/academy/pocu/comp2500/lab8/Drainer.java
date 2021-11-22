package academy.pocu.comp2500.lab8;

public final class Drainer extends SmartDevice implements IWaterDetectable, IDrainable {
    private static final ESmartDeviceType SMART_DEVICE_TYPE = ESmartDeviceType.DRAINER;
    private static final int DRAIN_WATER_LEVEL_PER_TICK = -7;

    // ---

    private final int maxWaterSize;

    // ---

    public Drainer(final int maxWaterSize) {
        this.maxWaterSize = maxWaterSize;
    }

    // ---

    @Override
    public void onInstall(final Planter planter) {
        planter.registerIWaterDetectable(this);
        planter.registerIDrainable(this);
    }

    @Override
    public void detect(final int waterLevel) {
        this.setIsOn(waterLevel >= this.maxWaterSize);
    }

    @Override
    public void drain(Planter planter) {
        if (isOn()) {
            planter.addWater(DRAIN_WATER_LEVEL_PER_TICK);
        }
    }
}
