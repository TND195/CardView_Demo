package model;

public class Content {
    private String id;
    private String content;
    private int liked;
    private int saved;

    public Content(String id, String content, int liked, int saved) {
        this.id = id;
        this.content = content;
        this.liked = liked;
        this.saved = saved;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public int getSaved() {
        return saved;
    }

    public void setSaved(int saved) {
        this.saved = saved;
    }
}
