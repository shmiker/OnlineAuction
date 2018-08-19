package com.onlineauction.OnlineAuction;

import com.onlineauction.domain.Auction;
import com.onlineauction.domain.Bidder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineAuctionApplicationTests {

    @Autowired
    private Auction auction;

    @Test
    public void testRecordPlayer() {
        Bidder linda = new Bidder("Linda",170.00, 240.00, 3.0);
        Bidder dave = new Bidder("Dave",160.0, 243.00, 7.0);
        Bidder eric = new Bidder("Eric",190.00, 240.00, 4.00);

        auction.addBidder(linda);
        auction.addBidder(dave);
        auction.addBidder(eric);

        auction.startAuction();
    }

    @Test
    public void testSnowShoes() {
        Bidder linda = new Bidder("Linda",30.00, 70.00, 4.0);
        Bidder dave = new Bidder("Dave",30.00, 70.00, 3.00);
        Bidder eric = new Bidder("Eric",40.00, 90.00, 2.00);

        auction.addBidder(linda);
        auction.addBidder(dave);
        auction.addBidder(eric);

        auction.startAuction();
    }

    @Test
    public void testPiano() {
        Bidder linda = new Bidder("Linda",20000.00, 65000.00, 2000.0);
        Bidder dave = new Bidder("Dave",10000.0, 70000.00, 15000.0);
        Bidder eric = new Bidder("Eric",22000.00, 70000.00, 8000.00);

        auction.addBidder(linda);
        auction.addBidder(dave);
        auction.addBidder(eric);

        auction.startAuction();
    }
}
