package com.test.demo.models.enums;

public enum PaymentStatusEnum {
    Pending("待支付", 0),
    Processing("支付处理中", 1),
    Success("支付成功", 2),
    Failed("支付失败", 3);

    private final String displayName;

    private final int value;

    PaymentStatusEnum(String displayName, int value) {
        this.displayName = displayName;
        this.value = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getValue() {
        return value;
    }
}
