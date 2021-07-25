import accessories.DrumStick;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrumStickTest {

    DrumStick drumStick;

    @Before
    public void setup(){
        drumStick = new DrumStick("Zildjian DrumSticks", 2, 7, "Black");
    }

    @Test
    public void drumsticksHaveAName(){
        assertEquals("Zildjian DrumSticks", drumStick.getName());
    }

    @Test
    public void drumstickHasBuyPrice(){
        assertEquals(2, drumStick.getBuyPrice());
    }

    @Test
    public void drumStickHasSellPrice(){
        assertEquals(7, drumStick.getSellPrice());
    }

    @Test
    public void drumStickHasColour(){
        assertEquals("Black", drumStick.getColour());
    }

    @Test
    public void drumStickHas5Markup(){
        assertEquals(5, drumStick.calculateMarkup());
    }
}
