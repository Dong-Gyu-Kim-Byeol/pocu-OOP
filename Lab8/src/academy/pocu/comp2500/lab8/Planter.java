package academy.pocu.comp2500.lab8;

import java.util.LinkedList;

public final class Planter {
    private static final int EAT_WATER_LEVEL_PER_TICK = -2;

    private int waterAmount;
    private final LinkedList<SmartDevice> smartDevices;

    public Planter(final int waterAmount) {
        this.waterAmount = waterAmount;
        this.smartDevices = new LinkedList<>();
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public void addWater(final int waterLevel) {
        this.waterAmount += waterLevel;
        if (this.waterAmount < 0) {
            this.waterAmount = 0;
        }
    }

    public void installSmartDevice(final SmartDevice smartDevice) {
        this.smartDevices.add(smartDevice);
    }

    public void tick() {
        for (final SmartDevice smartDevice : this.smartDevices) {
            smartDevice.onTick();

            switch (smartDevice.getSmartDeviceType()) {
                case DRAINER:
                    final Drainer drainer = (Drainer) smartDevice;
                    drainer.detect(this.waterAmount);
                    break;
                case SPRINKLER:
                    break;
                default:
                    throw new IllegalArgumentException("unknown type");
            }
        }

        for (final SmartDevice smartDevice : this.smartDevices) {
            switch (smartDevice.getSmartDeviceType()) {
                case DRAINER:
                    final Drainer drainer = (Drainer) smartDevice;
                    drainer.drain(this);
                    break;
                case SPRINKLER:
                    final Sprinkler sprinkler = (Sprinkler) smartDevice;
                    sprinkler.spray(this);
                    break;
                default:
                    throw new IllegalArgumentException("unknown type");
            }
        }

        addWater(EAT_WATER_LEVEL_PER_TICK);
    }
}
