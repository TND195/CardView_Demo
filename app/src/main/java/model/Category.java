package model;

public class Category {
    private int img;
    private String id;
    private String name;

    public Category(int img, String id, String name) {
        this.img = img;
        this.id = id;
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
