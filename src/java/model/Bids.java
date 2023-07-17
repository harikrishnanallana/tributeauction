/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author nkhan
 */
public class Bids {
    public int BidID;
    public int AuctionID;
    public int UserID;
    public LocalDateTime  BidTime;
    public BigDecimal Amount;

    @Override
    public String toString() {
        return "Bids{" + "BidID=" + BidID + ", AuctionID=" + AuctionID + ", UserID=" + UserID + ", BidTime=" + BidTime + ", Amount=" + Amount + '}';
    }

    public int getBidID() {
        return BidID;
    }

    public void setBidID(int BidID) {
        this.BidID = BidID;
    }

    public int getAuctionID() {
        return AuctionID;
    }

    public void setAuctionID(int AuctionID) {
        this.AuctionID = AuctionID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public LocalDateTime getBidTime() {
        return BidTime;
    }

    public void setBidTime(LocalDateTime BidTime) {
        this.BidTime = BidTime;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal Amount) {
        this.Amount = Amount;
    }

    public Bids() {
    }

    public Bids(int BidID, int AuctionID, int UserID, LocalDateTime BidTime, BigDecimal Amount) {
        this.BidID = BidID;
        this.AuctionID = AuctionID;
        this.UserID = UserID;
        this.BidTime = BidTime;
        this.Amount = Amount;
    }
}
