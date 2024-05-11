package model;

public enum VehicleCategory {
    MOTORCYCLE (0),
    CAR(1);
    private final int value;

    VehicleCategory(int value) {
        this.value = value;
    }
}
