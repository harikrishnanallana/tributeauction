package model;

public class Auctions {
    private String auctionID;
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private String userID;
    private Status status;

    public enum Status {
        ONGOING,
        UPCOMING,
        COMPLETED
    }

    public Auctions() {
        status = Status.ONGOING; // Gán giá trị mặc định cho status là ONGOING
    }

    public Auctions(String auctionID, String title, String description, String startDate, String endDate, String userID, Status status) {
        this.auctionID = auctionID;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userID = userID;
        this.status = status;
    }

    public String getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(String auctionID) {
        this.auctionID = auctionID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Auctions{" +
                "auctionID='" + auctionID + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", userID='" + userID + '\'' +
                ", status=" + status +
                '}';
    }
}
