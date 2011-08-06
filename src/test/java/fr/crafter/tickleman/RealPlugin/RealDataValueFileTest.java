package fr.crafter.tickleman.RealPlugin;

import fr.crafter.tickleman.RealShop.RealShopPlugin;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author synopia
 */
public class RealDataValueFileTest  {

    private RealDataValuesFile sut;


    @Before
    public void setup() {
/*
        sut = new RealDataValuesFile(new RealShopPlugin(), "dataValues");
        sut.load();
*/
    }
    @Test
    public void testNameToId() {
/*
        Assert.assertEquals("1", sut.getId( sut.getName("1") ) );
        Assert.assertEquals("2", sut.getId( sut.getName("2") ) );
        Assert.assertEquals("2", sut.getId( "grass" ) );
        Assert.assertEquals("21", sut.getId( "Lapis Lazuli Ore" ) );
        Assert.assertEquals("21", sut.getId( "Lapis_Lazuli_Ore" ) );
        Assert.assertEquals("21", sut.getId( "21" ) );
*/
    }

}
