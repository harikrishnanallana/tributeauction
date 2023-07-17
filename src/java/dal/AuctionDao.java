package dal;

import DBconnect.DBconnector;
import model.Auctions;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AuctionDao extends DBconnector {

    public ArrayList<Auctions> getAuctions() {
        ArrayList<Auctions> list = new ArrayList<>();
        String query = "SELECT * FROM Auctions;";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Auctions auction = new Auctions();
                auction.setAuctionID(rs.getString("AuctionID"));
                auction.setTitle(rs.getString("Title"));
                auction.setDescription(rs.getString("Description"));
                auction.setStartDate(rs.getString("StartDate"));
                auction.setEndDate(rs.getString("EndDate"));
                auction.setUserID(rs.getString("UserID"));
                auction.setStatus(Auctions.Status.valueOf(rs.getString("Status")));
                list.add(auction);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
        return list;
    }

    public void saveAuction(Auctions auction) {
        String query = "INSERT INTO Auctions (Title, Description, StartDate, EndDate, UserID, Status) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(2, auction.getTitle());
            pst.setString(3, auction.getDescription());
            pst.setString(4, auction.getStartDate());
            pst.setString(5, auction.getEndDate());
            pst.setString(6, auction.getUserID());
            pst.setString(7, auction.getStatus().name());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
    }

    public boolean checkAuctionExists(String auctionID) {
        String query = "SELECT COUNT(*) FROM Auctions WHERE AuctionID = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, auctionID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
        return false;
    }

    public Auctions getAuctionByID(String auctionID) {
        String query = "SELECT * FROM Auctions WHERE AuctionID = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, auctionID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Auctions auction = new Auctions();
                auction.setAuctionID(rs.getString("AuctionID"));
                auction.setTitle(rs.getString("Title"));
                auction.setDescription(rs.getString("Description"));
                auction.setStartDate(rs.getString("StartDate"));
                auction.setEndDate(rs.getString("EndDate"));
                auction.setUserID(rs.getString("UserID"));
                auction.setStatus(Auctions.Status.valueOf(rs.getString("Status")));
                return auction;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
        return null;
    }

    public void updateAuction(Auctions auction) {
        String query = "UPDATE Auctions SET Title = ?, Description = ?, StartDate = ?, EndDate = ?, UserID = ?, Status = ? WHERE AuctionID = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, auction.getTitle());
            pst.setString(2, auction.getDescription());
            pst.setString(3, auction.getStartDate());
            pst.setString(4, auction.getEndDate());
            pst.setString(5, auction.getUserID());
            pst.setString(6, auction.getStatus().name());
            pst.setString(7, auction.getAuctionID());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
    }

    public void deleteAuction(String auctionID) {
        String query = "DELETE FROM Auctions WHERE AuctionID = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, auctionID);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        AuctionDao auctionDao = new AuctionDao();
        ArrayList<Auctions> list = auctionDao.getAuctions();
        System.out.println(list.get(0).toString());
    }
}
