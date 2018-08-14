package com.dharma.java8.optional;

import java.util.Optional;

class NextDisplayFeatures {

    private String size; // In inches
    private Optional<ScreenResolution> resolution;

    public NextDisplayFeatures(String size, Optional<ScreenResolution> resolution) {
        this.size = size;
        this.resolution = resolution;
    }

    public String getSize() {
        return size;
    }

    public Optional<ScreenResolution> getResolution() {
        return resolution;
    }
}

class NextMobile {

    private long id;
    private String brand;
    private String name;
    private Optional<NextDisplayFeatures> displayFeatures;
    // Like wise we can see MemoryFeatures, CameraFeatures etc.
    // For simplicity, using only one Features

    public NextMobile(long id, String brand, String name, Optional<NextDisplayFeatures> displayFeatures) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.displayFeatures = displayFeatures;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public Optional<NextDisplayFeatures> getDisplayFeatures() {
        return displayFeatures;
    }

}

class NextMobileService {

    public Integer getMobileScreenWidth(Optional<NextMobile> mobile) {
        return mobile.flatMap(NextMobile::getDisplayFeatures)
                .flatMap(NextDisplayFeatures::getResolution)
                .map(ScreenResolution::getWidth)
                .orElse(0);

    }

}

public class WithOptional {
    public static void main(String[] args) {
        ScreenResolution resolution = new ScreenResolution(750, 1334);
        NextDisplayFeatures dfeatures = new NextDisplayFeatures("4.7", Optional.of(resolution));
        NextMobile mobile = new NextMobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures));

        NextMobileService mService = new NextMobileService();

        int width = mService.getMobileScreenWidth(Optional.of(mobile));
        System.out.println("Apple iPhone 6s Screen Width = " + width);

        NextMobile mobile2 = new NextMobile(2015001, "Apple", "iPhone 6s", Optional.empty());
        int width2 = mService.getMobileScreenWidth(Optional.of(mobile2));
        System.out.println("Apple iPhone 16s Screen Width = " + width2);
    }
}
