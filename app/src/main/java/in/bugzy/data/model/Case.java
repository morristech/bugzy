package in.bugzy.data.model;

import com.google.gson.annotations.SerializedName;

import android.arch.persistence.room.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity(primaryKeys = "ixBug")
public class Case implements Serializable {
    int ixBug;

    @SerializedName( "operations")
    List<String> operations;

    @SerializedName("requiredxmergexin")
    private String requiredMergeIn;

    @SerializedName("productxversion")
    private String foundIn;

    @SerializedName("verifiedxin")
    private String verifiedIn;

    @SerializedName("fixedxin")
    private String fixedIn;

    @SerializedName("sTitle")
    String title;

    @SerializedName( "ixPriority")
    int priority;

    @SerializedName( "ixFixFor")
    int fixForId;

    @SerializedName( "sFixFor")
    String fixFor;

    @SerializedName( "sProject")
    String projectName;

    @SerializedName( "ixProject")
    int projectId;

    @SerializedName( "sArea")
    String projectArea;

    @SerializedName( "ixArea")
    int projectAreaId;

    @SerializedName( "sStatus")
    String status;

    @SerializedName( "ixStatus")
    int statusId;

    @SerializedName( "sPersonAssignedTo")
    String personAssignedTo;

    @SerializedName( "ixPersonAssignedTo")
    int personAssignedToId;

    @SerializedName( "sPersonOpenedBy")
    String personOpenedBy;

    @SerializedName( "ixPersonOpenedBy")
    int personOpenedById;

    @SerializedName( "events")
    List<CaseEvent> caseevents;

    @SerializedName("sFavorite")
    boolean favorite;

    @SerializedName( "sCategory")
    String categoryName;

    @SerializedName( "ixCategory")
    int categoryId;

    @SerializedName("tags")
    List<String> tags;

    @SerializedName("dtLastUpdated")
    Date lastUpdatedAt;

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public int getIxBug() {
        return ixBug;
    }

    public void setIxBug(int ixBug) {
        this.ixBug = ixBug;
    }

    public List<String> getOperations() {
        return operations;
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getFixFor() {
        return fixFor;
    }

    public void setFixFor(String fixFor) {
        this.fixFor = fixFor;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectArea() {
        return projectArea;
    }

    public void setProjectArea(String projectArea) {
        this.projectArea = projectArea;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPersonAssignedTo() {
        return personAssignedTo;
    }

    public void setPersonAssignedTo(String personAssignedTo) {
        this.personAssignedTo = personAssignedTo;
    }

    public String getPersonOpenedBy() {
        return personOpenedBy;
    }

    public void setPersonOpenedBy(String personOpenedBy) {
        this.personOpenedBy = personOpenedBy;
    }

    public List<CaseEvent> getCaseevents() {
        return caseevents;
    }

    public void setCaseevents(List<CaseEvent> caseevents) {
        this.caseevents = caseevents;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getRequiredMergeIn() {
        return requiredMergeIn;
    }

    public void setRequiredMergeIn(String requiredMergeIn) {
        this.requiredMergeIn = requiredMergeIn;
    }

    public String getFoundIn() {
        return foundIn;
    }

    public void setFoundIn(String foundIn) {
        this.foundIn = foundIn;
    }

    public String getVerifiedIn() {
        return verifiedIn;
    }

    public void setVerifiedIn(String verifiedIn) {
        this.verifiedIn = verifiedIn;
    }

    public String getFixedIn() {
        return fixedIn;
    }

    public void setFixedIn(String fixedIn) {
        this.fixedIn = fixedIn;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getFixForId() {
        return fixForId;
    }

    public void setFixForId(int fixForId) {
        this.fixForId = fixForId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectAreaId() {
        return projectAreaId;
    }

    public void setProjectAreaId(int projectAreaId) {
        this.projectAreaId = projectAreaId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPersonAssignedToId() {
        return personAssignedToId;
    }

    public void setPersonAssignedToId(int personAssignedToId) {
        this.personAssignedToId = personAssignedToId;
    }

    public int getPersonOpenedById() {
        return personOpenedById;
    }

    public void setPersonOpenedById(int personOpenedById) {
        this.personOpenedById = personOpenedById;
    }
}
