package net.scub.hubicc.batch.model;

public class HtmlItem {

    private String relation;

    private String object;

    private boolean isLink;

    public HtmlItem(String relation, String object) {
        this.relation = relation;
        this.object = object;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public boolean isLink() {
        if (object.startsWith("http")) {
            isLink = true;
        }
        return isLink;
    }

    public void setLink(boolean link) {
        isLink = link;
    }
}
