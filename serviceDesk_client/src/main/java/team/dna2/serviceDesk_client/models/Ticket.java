package team.dna2.serviceDesk_client.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Ticket {
    public SimpleIntegerProperty id;
    public SimpleStringProperty title;
    public SimpleStringProperty creator;
    public SimpleStringProperty status;
    public SimpleStringProperty category;
    public SimpleStringProperty creationDate;
    public SimpleStringProperty changeDate;
    public SimpleStringProperty software;
    public SimpleStringProperty helper;

    public Ticket(Integer id,
                  String title,
                  String creator,
                  String status,
                  String category,
                  String creationDate,
                  String changeDate,
                  String software,
                  String helper) {
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.creator = new SimpleStringProperty(creator);
        this.status = new SimpleStringProperty(status);
        this.category = new SimpleStringProperty(category);
        this.creationDate = new SimpleStringProperty(creationDate);
        this.changeDate = new SimpleStringProperty(changeDate);
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

    public String getCreationDate() {
        return creationDate.get();
    }

    public void setCreationDate(String creationDate) {
        this.creationDate.set(creationDate);
    }

    public String getChangeDate() {
        return changeDate.get();
    }

    public void setChangeDate(String changeDate) {
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
