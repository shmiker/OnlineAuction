package com.onlineauction.domain;


public class Bidder implements BidderIntefrace {
    private String name;
    private double startingBid;
    private double maxBid;
    private double autoIncrementAmount;
    private double currentBid;

    public Bidder(String name, double startingBid, double maxBid, double autoIncrementAmount) {
        this.startingBid = startingBid;
        this.maxBid = maxBid;
        this.autoIncrementAmount = autoIncrementAmount;
        this.name = name;
    }

    public double getStartingBid() {
        return startingBid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public String getName() {
        return name;
    }

    /**
     * Method updates the current bid according to the current winning bid of auction
     * @param currentAuctionBid current winning bid
     */
    @Override
    public void updateBid(double currentAuctionBid) {
        currentBid = startingBid;
        while (currentBid < currentAuctionBid) {
            if (!(currentBid + autoIncrementAmount > maxBid)) {
                currentBid += autoIncrementAmount;
            } else {
                return;
            }
        }

    }
}
