package com.codecool;

/**
 * Source: https://speedvegas.com/en/world-of-speed/exotics/fastest-cars-in-the-world-2018/428
 * */
enum CarModel {
    HENNESSEY_VENOM_F5 (484), // km/h
    KOENIGSEGG_AGERA_RS (447),
    HENNESSEY_VENOM_GT (434),
    BUGATTI_VEYRON_SUPER_SPORT (431),
    BUGATTI_CHIRON (420),
    SCC_ULTIMATE_AERO (412),
    TESLA_ROADSTER (402),
    SALEEN_S7_TWIN_TURBO (399),
    KOENIGSEGG_CCR (389),
    MCLAREN_F1 (386);

    private final int topSpeed;

    CarModel(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    int getTopSpeed() {
        return this.topSpeed;
    }

    // TODO: HOW TO GET ENUM CONSTANTS BY ID?
}
