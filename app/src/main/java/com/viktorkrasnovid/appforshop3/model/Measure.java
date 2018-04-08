package com.viktorkrasnovid.appforshop3.model;

public enum Measure {

    PIECES("шт.", 0),
    PACKAGE("пакет", 1),
    KG("кг.", 2),
    LITRES("л.", 3),
    GRAMMS("гр.", 4),
    BOTTLES("бут.", 5),
    CONTAINER("уп.", 6),
    PACK("пачка", 7),
    BLOCK("блок", 8),
    TEN("дес.", 9),;

    private final int id;
    private String name;

    Measure(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static Measure get(int id) {
        for (Measure measure : values()) {
            if (measure.getId() == id) {
                return measure;
            }
        }
        return PIECES;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
