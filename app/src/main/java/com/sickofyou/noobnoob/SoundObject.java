package com.sickofyou.noobnoob;

class SoundObject {
    private String itemName;
    private Integer itemId;

    SoundObject(String itemName, Integer itemId) {
        this.itemName = itemName;
        this.itemId = itemId;

    }

    String getItemName() {
        return itemName;
    }

    Integer getItemId() {
        return itemId;
    }
}
