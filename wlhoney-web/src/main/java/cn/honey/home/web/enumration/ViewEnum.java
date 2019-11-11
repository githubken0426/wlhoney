package cn.honey.home.web.enumration;

public enum ViewEnum {
    ALBUMS("albums"),
    PHOTO_CONVERFLOW("photo-coverflow");

    private ViewEnum(String view) {
        this.view = view;
    }

    private String view;

    public String view() {
        return view;
    }
}
