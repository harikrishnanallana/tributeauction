package dal;

import DBconnect.DBconnector;
import model.Bids;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BidsDao extends DBconnector {

    public List<Bids> getBids() {
        List<Bids> list = new ArrayList<>();
        String query = "SELECT BidID, AuctionID, UserID, Amount, BidTime FROM Bids;";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Bids bid = new Bids();
                bid.setBidID(rs.getInt("BidID"));
                bid.setAuctionID(rs.getInt("AuctionID"));
                bid.setUserID(rs.getInt("UserID"));
                bid.setAmount(rs.getBigDecimal("Amount"));
                bid.setBidTime(rs.getTimestamp("BidTime").toLocalDateTime());
                list.add(bid);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
        return list;
    }

    public void saveBid(Bids bid) {
        String query = "INSERT INTO Bids (BidID, AuctionID, UserID, Amount, BidTime) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, bid.getBidID());
            pst.setInt(2, bid.getAuctionID());
            pst.setInt(3, bid.getUserID());
            pst.setBigDecimal(4, bid.getAmount());
            pst.setTimestamp(5, java.sql.Timestamp.valueOf(bid.getBidTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
    }

    public void updateBid(Bids bid) {
        String query = "UPDATE Bids SET AuctionID = ?, UserID = ?, Amount = ?, BidTime = ? WHERE BidID = ?;";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, bid.getAuctionID());
            pst.setInt(2, bid.getUserID());
            pst.setBigDecimal(3, bid.getAmount());
            pst.setTimestamp(4, java.sql.Timestamp.valueOf(bid.getBidTime()));
            pst.setInt(5, bid.getBidID());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
    }

    public void deleteBid(int bidID) {
        String query = "DELETE FROM Bids WHERE BidID = ?;";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, bidID);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        BidsDao bidsDao = new BidsDao();
        List<Bids> list = bidsDao.getBids();
        System.out.println(list.get(0).toString());
    }
}
