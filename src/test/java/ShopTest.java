import accessories.DrumStick;
import enums.AccessoryType;
import enums.DrumkitType;
import enums.GuitarType;
import enums.InstrumentType;
import instruments.Drumkit;
import instruments.Guitar;
import instruments.Instrument;
import org.junit.Before;
import org.junit.Test;
import shop.Shop;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShopTest {

    Shop shop;
    Guitar guitar;
    DrumStick drumsticks;
    Drumkit drumkit;

    @Before
    public void setup(){
        shop = new Shop("Guitar Guitar", 2000);
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

    @Test
    public void shopStartsWith2000Pounds(){
        assertEquals(2000, shop.getMoney());
    }

    @Test
    public void shopCanIncreaseProfit(){
        shop.increaseProfit(100);
        assertEquals(2100, shop.getMoney());
    }

    @Test
    public void shopMustHaveFundsToAddItemsToStock(){
        assertEquals(true, shop.canAffordInstrument(drumkit));
    }

    @Test
    public void shopMustUseMoneyToAddItemsToStock(){
        shop.addInstrumentToStock(drumkit);
        assertEquals(1750, shop.getMoney());
    }

    @Test
    public void shopUsesMoneyToAddAccessoriesToStock(){
        shop.addAccessoryToStock(drumsticks);
        assertEquals(1995, shop.getMoney());
    }

    @Test
    public void canCheckIfItemIsInStock(){
        shop.addInstrumentToStock(drumkit);
        shop.addAccessoryToStock(drumsticks);
        assertTrue(shop.isInstrumentInStock("Percussion"));
    }

    @Test
    public void canCheckIfItemIsNotInStock(){
        shop.addAccessoryToStock(drumsticks);
        assertFalse(shop.isInstrumentInStock("Percussion"));
    }

    @Test
    public void canCheckIfAccessoryIsInStock(){
        shop.addAccessoryToStock(drumsticks);
        assertTrue(shop.isAccessoryInStock("Drum Sticks"));
    }

    @Test
    public void canCheckIfAccessoryIsNotInStock(){
        shop.addInstrumentToStock(drumkit);
        assertFalse(shop.isAccessoryInStock("Drum Sticks"));
    }

    @Test
    public void canReturnListOfAvailableInstruments(){
        shop.addToStock(drumkit);
        Drumkit newKit = new Drumkit("White", InstrumentType.PERCUSSION, 100, 400, DrumkitType.ACOUSTIC);
        shop.addToStock(newKit);
        assertEquals(2, shop.getAvailableInstruments(InstrumentType.PERCUSSION).size());
    }

    @Test
    public void canReturnListOfAvailableAccessories(){
        shop.addToStock(drumsticks);
        assertEquals(1, shop.getAvailableAccessories(AccessoryType.DRUMSTICKS).size());
    }

//    @Test
//    public void displayListOfAvailableInstrumentsToCustomer(){
//        shop.addToStock(drumkit);
//        ArrayList<Instrument> available = shop.getAvailableInstruments(InstrumentType.PERCUSSION);
//        assertEquals("test", shop.displayListOfItems(available));
//    }
}
