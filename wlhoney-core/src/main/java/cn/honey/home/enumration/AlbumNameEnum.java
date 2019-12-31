package cn.honey.home.enumration;

public enum AlbumNameEnum {
    JANUARY("January", "一月", ViewEnum.PHOTO_CONVERFLOW),
    FEBRUARY("February", "二月", ViewEnum.PHOTO_CONVERFLOW),
    MARCH("March", "三月", ViewEnum.PHOTO_CONVERFLOW),
    APRIL("April", "四月", ViewEnum.PHOTO_CONVERFLOW),
    MAY("May", "五月", ViewEnum.PHOTO_CONVERFLOW),
    JUNE("June", "六月", ViewEnum.PHOTO_CONVERFLOW),
    JULY("July", "七月", ViewEnum.PHOTO_CONVERFLOW),
    AUGUST("August", "八月", ViewEnum.PHOTO_CONVERFLOW),
    SEPTEMBER("September", "久月", ViewEnum.PHOTO_CONVERFLOW),
    OCTOBER("October", "十月", ViewEnum.PHOTO_CONVERFLOW),
    NOVEMBER("November", "十一月", ViewEnum.PHOTO_CONVERFLOW),
    DECEMBER("December", "十二月", ViewEnum.PHOTO_CONVERFLOW);

    private AlbumNameEnum(String album, String value, ViewEnum viewEnum) {
        this.album = album;
        this.value = value;
        this.viewEnum = viewEnum;
    }

    private String album;
    private String value;
    private ViewEnum viewEnum;

    public String album() {
        return album;
    }

    public String value() {
        return value;
    }

    public ViewEnum viewEnum() {
        return viewEnum;
    }
}
