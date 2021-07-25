import accessories.DrumStick;
import customers.Customer;
import enums.DrumkitType;
import enums.InstrumentType;
import instruments.Drumkit;
import interfaces.ISell;
import org.junit.Before;
import org.junit.Test;
import shop.Shop;

import static org.junit.Assert.*;

public class CustomerTest {

    Customer customer;
    Drumkit drumkit;
    DrumStick drumStick;
    Shop shop;

    @Before
    public void setup(){
        customer = new Customer("David", 1000);
        drumkit = new Drumkit("White", InstrumentType.PERCUSSION, 200, 400, DrumkitType.ACOUSTIC);
        shop = new Shop("Instrument Shop", 2000);
        drumStick = new DrumStick("Basic Drumstick", 5, 10, "White");
        shop.addToStock(drumkit);
        shop.addToStock(drumStick);
    }

    @Test
    public void customerIsCalledDavid(){
        assertEquals("David", customer.getName());
    }

    @Test
    public void customerHas1000Pounds(){
        assertEquals(1000, customer.getCash());
    }

    @Test
    public void customerStartsWithNoPurchases(){
        assertEquals(0, customer.getNumberOfPurchases());
    }

    @Test
    public void customerCanAffordDrumkit(){
        assertTrue(customer.canAfford(drumkit));
    }

    @Test
    public void customerHasEmptyBasket(){
        assertEquals(0, customer.getNumberOfItemsInBasket());
    }

    @Test
    public void customerCanAddItemToBasket(){
        customer.addItemToBasket(drumkit);
        assertEquals(1, customer.getNumberOfItemsInBasket());
    }

    @Test
    public void customerCanRemoveItemFromBasket(){
        customer.addItemToBasket(drumkit);
        customer.removeItemFromBasket(drumkit);
        assertEquals(0, customer.getNumberOfItemsInBasket());
    }

    @Test
    public void customerCanAddInstrumentAndAccessoryToBasket(){
        customer.addItemToBasket(drumkit);
        customer.addItemToBasket(drumStick);
        assertEquals(2, customer.getNumberOfItemsInBasket());
    }

    @Test
    public void customerCanCheckTotalPriceOfBasket(){
        customer.addItemToBasket(drumkit);
        customer.addItemToBasket(drumStick);
        assertEquals(410, customer.getBasketPrice());
    }

    @Test
    public void customerCanCheckIfTheyCanAffordBasket(){
        customer.addItemToBasket(drumkit);
        customer.addItemToBasket(drumStick);
        assertTrue(customer.canAffordBasket());
    }

    @Test
    public void customerCantAffordBasket(){
        Customer lowMoney = new Customer("Test", 200);
        lowMoney.addItemToBasket(drumkit);
        lowMoney.addItemToBasket(drumStick);
        assertFalse(lowMoney.canAffordBasket());
    }

    @Test
    public void customerCanBuyAllItemsInBasket(){
        customer.addItemToBasket(drumkit);
        customer.addItemToBasket(drumStick);
        assertEquals(0, customer.getNumberOfPurchases());
        customer.buyBasket();
        assertEquals(2, customer.getNumberOfPurchases());
    }


}
