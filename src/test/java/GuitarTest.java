import enums.GuitarType;
import enums.InstrumentType;
import instruments.Guitar;
import instruments.Instrument;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuitarTest {

    Guitar guitar;

    @Before
    public void setup(){
        guitar = new Guitar("Red", InstrumentType.GUITAR, 100, 150, GuitarType.ELECTRIC);
    }

    @Test
    public void guitarHasColour(){
        assertEquals("Red", guitar.getColour());
    }

    @Test
    public void guitarIsAStringInstrument(){
        assertEquals(InstrumentType.GUITAR, guitar.getInstrumentType());
    }

    @Test
    public void guitarCostsShop100(){
        assertEquals(100, guitar.getBuyPrice());
    }

    @Test
    public void guitarSellsFor150(){
        assertEquals(150, guitar.getSellPrice());
    }

    @Test
    public void guitarTypeIsElectric(){
        assertEquals("Electric", guitar.getGuitarType().getGuitarType());
    }

    @Test
    public void guitarHasSixStrings(){
        assertEquals(6, guitar.getGuitarType().getNumOfStrings());
    }

    @Test
    public void guitarCanPlayAChord(){
        assertEquals("Guitar plays a chord", guitar.play());
    }

    @Test
    public void guitarMarkupIs50Pounds(){
        assertEquals(50, guitar.calculateMarkup());
    }
}
