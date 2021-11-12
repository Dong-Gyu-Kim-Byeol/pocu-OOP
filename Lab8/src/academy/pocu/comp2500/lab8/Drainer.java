package academy.pocu.comp2500.lab8;

public final class Drainer extends SmartDevice implements IWaterDetectable, IDrainable {
    private static final int DRAIN_WATER_LEVEL_PER_TICK = -7;

    private final int maxWaterSize;

    public Drainer(final int maxWaterSize) {
        super(ESmartDeviceType.DRAINER);
        this.maxWaterSize = maxWaterSize;
    }

    public void drain(Planter planter) {
        if (isOn()) {
//            if (planter.getWaterAmount() >= maxWaterSize) {
                planter.addWater(DRAIN_WATER_LEVEL_PER_TICK);
//            }
        }
    }

    public void detect(final int waterLevel) {
        if (waterLevel >= this.maxWaterSize) {
            if (this.isOn != true) {
                this.ticksSinceLastUpdate = this.tick;
            }
            this.isOn = true;
        } else {
            if (this.isOn != false) {
                this.ticksSinceLastUpdate = this.tick;
            }
            this.isOn = false;
        }
    }
}
