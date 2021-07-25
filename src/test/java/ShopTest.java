import accessories.DrumStick;
import enums.DrumkitType;
import enums.GuitarType;
import enums.InstrumentType;
import instruments.Drumkit;
import instruments.Guitar;
import org.junit.Before;
import org.junit.Test;
import shop.Shop;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    Shop shop;
    Guitar guitar;
    DrumStick drumsticks;
    Drumkit drumkit;

    @Before
    public void setup(){
        shop = new Shop("Guitar Guitar");
        guitar = new Guitar("Black", InstrumentType.GUITAR, 100, 250, GuitarType.ACOUSTIC);
        drumsticks = new DrumStick("Steve Gadd Brushes", 5, 10, "White");
        drumkit = new Drumkit("Black", InstrumentType.PERCUSSION, 250, 500, DrumkitType.ACOUSTIC);
    }

    @Test
    public void shopIsCalledGuitarGuitar(){
        assertEquals("Guitar Guitar", shop.getName());
    }

    @Test
    public void shopStartsWithEmptyStock(){
        assertEquals(0, shop.numberOfItemsInStock());
    }

    @Test
    public void canAddInstrumentToStock(){
        shop.addToStock(guitar);
        assertEquals(1, shop.numberOfItemsInStock());
    }

    @Test
    public void canAddAccessoryToStock(){
        shop.addToStock(drumsticks);
        assertEquals(1, shop.numberOfItemsInStock());
    }

    @Test
    public void canAddInstrumentAndAccessoryToStock(){
        shop.addToStock(guitar);
        shop.addToStock(drumsticks);
        assertEquals(2, shop.numberOfItemsInStock());
    }

    @Test
    public void canRemoveItemFromStock(){
        shop.addToStock(guitar);
        shop.addToStock(drumsticks);
        shop.removeFromStock(guitar);
        assertEquals(1, shop.numberOfItemsInStock());
    }

    @Test
    public void canCalculatePotentialProfitOfStock(){
        shop.addToStock(guitar);
        shop.addToStock(drumsticks);
        assertEquals(155, shop.calculatePotentialProfit());
    }
}
