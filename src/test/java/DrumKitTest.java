import enums.DrumkitType;
import enums.InstrumentType;
import instruments.Drumkit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrumKitTest {

    Drumkit drumkit;

    @Before
    public void setup(){
        drumkit = new Drumkit("Black", InstrumentType.PERCUSSION, 250, 500, DrumkitType.ACOUSTIC);
    }

    @Test
    public void drumkitHasIsBlack(){
        assertEquals("Black", drumkit.getColour());
    }

    @Test
    public void drumkitIsAPercussionInstrument(){
        assertEquals("Percussion", drumkit.getInstrumentType().getType());
    }

    @Test
    public void drumKitCosts250(){
        assertEquals(250, drumkit.getBuyPrice());
    }

    @Test
    public void drumKitSellsAt500(){
        assertEquals(500, drumkit.getSellPrice());
    }

    @Test
    public void drumkitIsAcoustic(){
        assertEquals("Acoustic", drumkit.getDrumkitType().getvalue());
    }
}
