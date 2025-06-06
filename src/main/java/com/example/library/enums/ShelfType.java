package com.example.library.enums;

import lombok.Getter;

@Getter
public enum ShelfType {
    LITERATURE("Literature Shelf"),
    SCIENCE("Science Shelf"),
    HISTORY("History Shelf"),
    FICTION("Fiction Shelf"),
    COOKING("Cooking Shelf"),
    TRAVEL("Travel Shelf"),
    ART("Art Shelf"),
    PHILOSOPHY("Philosophy Shelf"),
    SCI_FI("Sci-Fi Shelf"),
    BIOGRAPHY("Biography Shelf"),
    TECHNOLOGY("Technology Shelf"),
    KIDS("Kid's Books Shelf");

    // Method to get the name of the shelf
    private final String shelfName;

    // Constructor to assign the name to each enum constant
    ShelfType(String shelfName) {
        this.shelfName = shelfName;
    }

}
