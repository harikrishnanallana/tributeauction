package dal;

import DBconnect.DBconnector;
import model.Items;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDao extends DBconnector {

    public ArrayList<Items> getItems() {
        ArrayList<Items> list = new ArrayList<>();
        String query = "SELECT * FROM Items;";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Items item = new Items();
                item.setItemID(rs.getInt("ItemID"));
                item.setAuctionID(rs.getInt("AuctionID"));
                item.setItemName(rs.getString("ItemName"));
                item.setDescription(rs.getString("Description"));
                item.setCurrentBid(rs.getBigDecimal("CurrentBid"));
                item.setItemType(rs.getString("ItemType"));
                list.add(item);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
        return list;
    }

    public void saveItem(Items item) {
        String query = "INSERT INTO Items (AuctionID, ItemName, Description, CurrentBid, ItemType) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, item.getAuctionID());
            pst.setString(2, item.getItemName());
            pst.setString(3, item.getDescription());
            pst.setBigDecimal(4, item.getCurrentBid());
            pst.setString(5, item.getItemType());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
    }

    public boolean checkItemExists(int itemID) {
        String query = "SELECT COUNT(*) FROM Items WHERE ItemID = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, itemID);
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

    public Items getItemByID(int itemID) {
        String query = "SELECT * FROM Items WHERE ItemID = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, itemID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Items item = new Items();
                item.setItemID(rs.getInt("ItemID"));
                item.setAuctionID(rs.getInt("AuctionID"));
                item.setItemName(rs.getString("ItemName"));
                item.setDescription(rs.getString("Description"));
                item.setCurrentBid(rs.getBigDecimal("CurrentBid"));
                item.setItemType(rs.getString("ItemType"));
                return item;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
        return null;
    }

    public void updateItem(Items item) {
        String query = "UPDATE Items SET AuctionID = ?, ItemName = ?, Description = ?, CurrentBid = ?, ItemType = ? WHERE ItemID = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, item.getAuctionID());
            pst.setString(2, item.getItemName());
            pst.setString(3, item.getDescription());
            pst.setBigDecimal(4, item.getCurrentBid());
            pst.setString(5, item.getItemType());
            pst.setInt(6, item.getItemID());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
    }

    public void deleteItem(int itemID) {
        String query = "DELETE FROM Items WHERE ItemID = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, itemID);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException occurred: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ItemDao itemDao = new ItemDao();
        ArrayList<Items> list = itemDao.getItems();
        System.out.println(list.get(0).toString());
    }
}
