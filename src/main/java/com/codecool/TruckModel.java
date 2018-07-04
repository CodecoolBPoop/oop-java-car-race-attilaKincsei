package com.codecool;

/**
 * Source: https://www.hotcars.com/the-20-fastest-pickups-to-go-0-to-60-mph/ */
enum TruckModel {
    FORD_F_150_TREMOR_2014 (5.8),
    CHEVROLET_1500_HIGH_COUNTRY_2015 (5.7),
    FORD_F_150_3_5_ECOBOOST_2015 (5.6),
    FORD_F_150_RAPTOR_2015 (5.3),
    FORD_F_150_LIGHTNING_2003 (5.2),
    EL_CAMINO_454_SS_1970 (5.0),
    GMC_SYCLONE_1991 (4.6),
    RAM_SRT_10_2006 (4.9),
    HOLDEN_MALOO_VXR_2012 (4.8),
    TOYOTA_TUNDRA_TRD_SUPERCHARGED_2015 (4.4);

    private final double acceleration;

    TruckModel(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getAcceleration() {
        return acceleration;
    }



}
