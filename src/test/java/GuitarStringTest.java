import accessories.GuitarString;
import enums.GuitarStringType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuitarStringTest {

    GuitarString string;

    @Before
    public void setup(){
        string = new GuitarString("Basic Strings", 1, 5, GuitarStringType.STEEL);
    }

    @Test
    public void guitarHasSteelStrings(){
        assertEquals("Steel", string.getStringType().getValue());
    }
}
