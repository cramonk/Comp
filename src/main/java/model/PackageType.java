package model;

import javax.swing.*;

public enum PackageType {
    CAPACITOR_CHIP("C:\\Users\\cramo\\Documents\\RABOTA\\Components\\Components\\src\\main\\resources\\capacitor{}.png"),
    RESISTOR_CHIP("C:\\Users\\cramo\\Documents\\RABOTA\\Components\\Components\\src\\main\\resources\\resistor{}.png"),
    TANTAL(""),
    SO8(""),
    SO14(""),
    SO16(""),
    SO20(""),
    SO4(""),
    SOT23(""),
    SOT23_5(""),
    SOT23_6(""),
    SOT223(""),
    SOT89(""),
    SOD123(""),
    SOD80(""),
    OTHER("");

    private final String packageIconPath;
    PackageType(String path) {
        this.packageIconPath = path;
    }

    public ImageIcon getPackageIcon(int angle) {
        return new ImageIcon(this.packageIconPath.replace("{}", String.valueOf(angle)));
    }
}
