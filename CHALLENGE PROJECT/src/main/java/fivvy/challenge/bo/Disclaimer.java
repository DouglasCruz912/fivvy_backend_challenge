package fivvy.challenge.bo;


import fivvy.challenge.entity.DisclaimerEntity;

public class Disclaimer {
    private Long id;
    private String name;
    private String text;
    private String version;
    private String createAt;
    private String updateAt;

    public Disclaimer() {

    }

    public Disclaimer(Long id, String name, String text, String version, String createAt, String updateAt) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.version = version;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Disclaimer(DisclaimerEntity disclaimerEntity) {
        this.id = disclaimerEntity.getId();
        this.name = disclaimerEntity.getName();
        this.text = disclaimerEntity.getText();
        this.version = disclaimerEntity.getVersion();
        this.createAt = disclaimerEntity.getCreateAt();
        this.updateAt = disclaimerEntity.getUpdateAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Disclaimer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", version='" + version + '\'' +
                ", createAt='" + createAt + '\'' +
                ", updateAt='" + updateAt + '\'' +
                '}';
    }
}
