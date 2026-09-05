package com.gca.overwrite_contents.config;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class GCAConfig {

    private static Configuration config;

    // HIMARS
    public static double himarsDetectorRange;

    // ARTILLERY
    public static double artyDetectorRange;


    public static void init(File configFile) {
        config = new Configuration(configFile);
        load();
    }

    public static void load() {
        config.load();

        himarsDetectorRange = config.getFloat(
                "detectorRange", "Artillery", 15000.0F, 100F, 1_000_000F,
                "Detection/targeting range for the HIMARS turret, in blocks.");

        artyDetectorRange = config.getFloat(
                "detectorRange", "Artillery", 10000.0F, 100F, 1_000_000F,
                "Detection/targeting range for the Artillery turret, in blocks.");

        if (config.hasChanged()) {
            config.save();
        }
    }
}