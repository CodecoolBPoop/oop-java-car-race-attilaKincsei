package com.codecool;

/**
 * Source: https://themysteriousworld.com/top-10-fastest-bikes-in-the-world/
 * */
enum MotorcycleModel {
    BMW_K_1200S (280),
    APRILIA_RSV_1000R_MILLE (281),
    MV_AGUSTA_F4_1000R (296),
    YAMAHA_YZF_R1 (300),
    HONDA_CBR1100XX_SUPER_BLACKBIRD (306),
    SUZUKI_HAYABUSA (312),
    KAWASAKI_NINJA_ZX_14R (335),
    MTT_TURBINE_SUPERBIKE_Y2K (365),
    KAWASAKI_NINJA_H2R (401),
    DODGE_TOMAHAWK (676);

    private final int topSpeed;

    MotorcycleModel(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getTopSpeed() {
        return topSpeed;
    }
}
