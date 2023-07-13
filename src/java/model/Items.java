/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author nkhan
 */
public class Items {

    public int ItemID;
    public int AuctionID;
    public String ItemName;
    public String Description;
    public BigDecimal CurrentBid;
    public String ItemType;

    public Items() {
    }

    public Items(int ItemID, int AuctionID, String ItemName, String Description, BigDecimal CurrentBid, String ItemType) {
        this.ItemID = ItemID;
        this.AuctionID = AuctionID;
        this.ItemName = ItemName;
        this.Description = Description;
        this.CurrentBid = CurrentBid;
        this.ItemType = ItemType;
    }

    @Override
    public String toString() {
        return "Items{" + "ItemID=" + ItemID + ", AuctionID=" + AuctionID + ", ItemName=" + ItemName + ", Description=" + Description + ", CurrentBid=" + CurrentBid + ", ItemType=" + ItemType + '}';
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int ItemID) {
        this.ItemID = ItemID;
    }

    public int getAuctionID() {
        return AuctionID;
    }

    public void setAuctionID(int AuctionID) {
        this.AuctionID = AuctionID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public BigDecimal getCurrentBid() {
        return CurrentBid;
    }

    public void setCurrentBid(BigDecimal CurrentBid) {
        this.CurrentBid = CurrentBid;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String ItemType) {
        this.ItemType = ItemType;
    }

}
