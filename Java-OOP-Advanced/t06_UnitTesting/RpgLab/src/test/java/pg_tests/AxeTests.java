package pg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {

    @Test
    public void weaponAttacksLosesDurability(){
        //arrange
        Axe axe=new Axe(10,10);
        Dummy dummy=new Dummy(10,10);

        //act
        axe.attack(dummy);

        //assert
        Assert.assertEquals(9,axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCanAttack(){
        Axe axe=new Axe(10,10);
        Dummy dummy=new Dummy(10,10);

        while(axe.getDurabilityPoints()>=0) {
            axe.attack(dummy);
        }
    }

}
