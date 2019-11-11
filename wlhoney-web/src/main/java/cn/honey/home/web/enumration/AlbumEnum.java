package cn.honey.home.web.enumration;

public enum AlbumEnum {
    JAN("January", 1),
    FEB("February", 2),
    MAR("March", 3),
    APR("April", 4),
    MAY("May", 5),
    JUN("June", 6),
    JUL("July", 7),
    AUG("August", 8),
    SEPT("September", 9),
    OCT("October", 10),
    NOV("November", 11),
    DEC("December", 12);

    private AlbumEnum(String album, int value) {
        this.album = album;
        this.value = value;
    }

    private String album;
    private int value;

    public String album() {
        return album;
    }

    public int value() {
        return value;
    }
}
