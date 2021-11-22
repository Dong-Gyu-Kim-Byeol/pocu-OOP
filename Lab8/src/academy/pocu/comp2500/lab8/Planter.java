package academy.pocu.comp2500.lab8;

import java.util.LinkedList;

public final class Planter {
    private static final int EAT_WATER_LEVEL_PER_TICK = -2;

    // ---

    private int waterAmount;

    private final LinkedList<SmartDevice> smartDevices;
    private final LinkedList<IWaterDetectable> waterDetectables;
    private final LinkedList<ISprayable> sprayables;
    private final LinkedList<IDrainable> drainables;

    // ---

    public Planter(final int waterAmount) {
        this.waterAmount = waterAmount;

        this.smartDevices = new LinkedList<>();
        this.waterDetectables = new LinkedList<>();
        this.sprayables = new LinkedList<>();
        this.drainables = new LinkedList<>();
    }

    // ---

    public final int getWaterAmount() {
        return waterAmount;
    }

    public final void addWater(final int waterLevel) {
        this.waterAmount += waterLevel;
        if (this.waterAmount < 0) {
            this.waterAmount = 0;
        }
    }

    public final void installSmartDevice(final SmartDevice smartDevice) {
        this.smartDevices.add(smartDevice);
        smartDevice.onInstall(this);
    }

    public final void registerIWaterDetectable(final IWaterDetectable iWaterDetectable) {
        this.waterDetectables.add(iWaterDetectable);
    }

    public final void registerISprayable(final ISprayable iSprayable) {
        this.sprayables.add(iSprayable);
    }

    public final void registerIDrainable(final IDrainable iDrainable) {
        this.drainables.add(iDrainable);
    }

    // ---

    public void tick() {
        for (final SmartDevice smartDevice : this.smartDevices) {
            smartDevice.onTick();
        }

        for (final IWaterDetectable iWaterDetectable : this.waterDetectables) {
            iWaterDetectable.detect(this.waterAmount);
        }

        for (final ISprayable iSprayable : this.sprayables) {
            iSprayable.spray(this);
        }

        for (final IDrainable iDrainable : this.drainables) {
            iDrainable.drain(this);
        }

        addWater(EAT_WATER_LEVEL_PER_TICK);
    }
}
