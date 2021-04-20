package team.dna2.serviceDesk_client.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Ticket {
    public SimpleIntegerProperty id;
    public SimpleStringProperty title;
    public SimpleStringProperty creator;
    public SimpleIntegerProperty creatorId;
    public SimpleStringProperty status;
    public SimpleStringProperty category;
    public SimpleObjectProperty<Date> creationDate;
    public SimpleObjectProperty<Date> changeDate;
    public SimpleStringProperty software;
    public SimpleStringProperty helper;


    public Ticket(Integer id,
                  String title,
                  String creator,
                  Integer creatorId,
                  String status,
                  String category,
                  Date creationDate,
                  Date changeDate,
                  String software,
                  String helper) {
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.creator = new SimpleStringProperty(creator);
        this.creatorId = new SimpleIntegerProperty(creatorId);
        this.status = new SimpleStringProperty(status);
        this.category = new SimpleStringProperty(category);
        this.creationDate = new SimpleObjectProperty<Date>(creationDate);
        this.changeDate = new SimpleObjectProperty<Date>(changeDate);
        this.software = new SimpleStringProperty(software);
        this.helper = new SimpleStringProperty(helper);
    }

    public int getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getCreator() {
        return creator.get();
    }

    public void setCreator(String creator) {
        this.creator.set(creator);
    }

    public int getCreatorId() {
        return creatorId.get();
    }

    public void setCreatorId(int creatorId) {
        this.creatorId.set(creatorId);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public Date getCreationDate() {
        return creationDate.get();
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate.set(creationDate);
    }

    public Date getChangeDate() {
        return changeDate.get();
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate.set(changeDate);
    }

    public String getSoftware() {
        return software.get();
    }

    public void setSoftware(String software) {
        this.software.set(software);
    }

    public String getHelper() {
        return helper.get();
    }

    public void setHelper(String helper) {
        this.helper.set(helper);
    }
}
