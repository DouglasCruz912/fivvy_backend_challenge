package fivvy.challenge.bo;


import fivvy.challenge.entity.AcceptanceEntity;


public class Acceptance {
    private Long id;
    private Long userId;
    private String createAt;

    public Acceptance() {
    }

    public Acceptance(Long id, Long userId, String createId) {
        this.id = id;
        this.userId = userId;
        this.createAt = createId;
    }

    public Acceptance(AcceptanceEntity acceptanceEntity) {
        this.id = acceptanceEntity.getId();
        this.userId = acceptanceEntity.getUserId();
        this.createAt = acceptanceEntity.getCreateAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Acceptance{" +
                "id=" + id +
                ", userId=" + userId +
                ", createId=" + createAt +
                '}';
    }
}
