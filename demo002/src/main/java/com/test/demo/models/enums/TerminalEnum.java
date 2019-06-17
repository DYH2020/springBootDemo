package com.test.demo.models.enums;


/**
 * 终端类型
 */
public enum TerminalEnum {
    UNKNOWN("未知", 0),
    PatientWxApp("微信小程序患者版", 1),
    PatientWxOfficial("微信公众号患者版", 2),
    DoctorAndroid("安卓医生版", 3),
    DoctorIOS("苹果医生版", 4),
    PatientAndroid("安卓患者版", 5),
    PatientIOS("苹果患者版", 6),
    DoctorWxOfficial("微信公众号医生版", 7),
    TaiheWxOfficial("太和医院公众号", 8),
    NfHealth("南方大健康", 9),
    TAI_HE_OFFICIAL("太和医院官网", 10),
    TAI_HE_INTERNET_HOSPITAL_PATIENT_MINI_PROGRAM("太和互联网医院患者端小程序版", 11),
    TAI_HE_INTERNET_HOSPITAL_PATIENT_WX_OFFICIAL("太和互联网医院患者端公众号版", 12),
    TAI_HE_INTERNET_HOSPITAL_DOCTOR_WX_OFFICIAL("太和互联网医院医生端公众号版", 13),
    GD_YWT_WX_OFFICIAL("广东医务通公众号", 14),
    PRESCRIPTION_SYSTEM_PC("处方系统PC端", 15),
    DOCTOR_MINI_PROGRAM("医生端小程序", 16);

    private final String displayName;

    private final int value;

    TerminalEnum(String displayName, int value) {
        this.displayName = displayName;
        this.value = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getValue() {
        return value;
    }


    public static TerminalEnum valueOf(int value) {
        for (TerminalEnum terminalEnum : TerminalEnum.values()) {
            if (terminalEnum.getValue() == value) {
                return terminalEnum;
            }
        }
        return UNKNOWN;
    }

    public static boolean isDoctorTerminal(int terminal) {
        for (TerminalEnum terminalEnum : getDoctorTerminal()) {
            if (terminalEnum.getValue() == terminal) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断终端是否是患者版
     *
     * @param terminal 终端
     * @return ture or fasle
     */
    public static boolean isPatientTerminal(int terminal) {
        for (TerminalEnum terminalEnum : getPatientTerminals()) {
            if (terminalEnum.getValue() == terminal) {
                return true;
            }
        }
        return false;
    }

    /**
     * 患者版终端
     */
    public static TerminalEnum[] getPatientTerminals() {
        return new TerminalEnum[]{
                PatientAndroid,
                PatientIOS,
                PatientWxApp,
                PatientWxOfficial,
                TAI_HE_INTERNET_HOSPITAL_PATIENT_MINI_PROGRAM,
                TAI_HE_INTERNET_HOSPITAL_PATIENT_WX_OFFICIAL
        };
    }

    /**
     * 医生终端
     *
     * @return
     */
    public static TerminalEnum[] getDoctorTerminal() {
        return new TerminalEnum[]{
                DoctorAndroid,
                DoctorIOS,
                DoctorWxOfficial,
                TAI_HE_INTERNET_HOSPITAL_DOCTOR_WX_OFFICIAL,
                PRESCRIPTION_SYSTEM_PC,
                DOCTOR_MINI_PROGRAM
        };
    }

    public static TerminalEnum getTerminalEnum(int type) {
        for(TerminalEnum terminalEnum : TerminalEnum.values()){
            if(terminalEnum.value == type){
                return terminalEnum;
            }
        }
        return UNKNOWN;
    }
}
