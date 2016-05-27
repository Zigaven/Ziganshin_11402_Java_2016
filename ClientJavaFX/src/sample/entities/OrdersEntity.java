package sample.entities;

/**
 * Created by ruslanzigansin on 10.05.16.
 */
public class OrdersEntity {

    private Long id;

    private GeneralEntity staffEntity;

    private GeneralEntity clientEntity;

    private ComicsEntity comicsEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GeneralEntity getStaffEntity() {
        return staffEntity;
    }

    public void setStaffEntity(GeneralEntity staffEntity) {
        this.staffEntity = staffEntity;
    }

    public GeneralEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(GeneralEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public ComicsEntity getComicsEntity() {
        return comicsEntity;
    }

    public void setComicsEntity(ComicsEntity comicsEntity) {
        this.comicsEntity = comicsEntity;
    }
}
