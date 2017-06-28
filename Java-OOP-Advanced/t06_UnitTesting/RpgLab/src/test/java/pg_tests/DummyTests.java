package pg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {
    @Test
    public void dummyLosesHealthWhenAttacked(){
        Dummy dummy=new Dummy(10,10);

        dummy.takeAttack(5);

        Assert.assertEquals(5,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked(){
        Dummy dummy=new Dummy(10,10);

        while(dummy.getHealth()>=0){
            dummy.takeAttack(5);
        }
    }

    @Test
    public void deadDummyCanGiveXP(){
        Dummy dummy=new Dummy(10,10);
        Axe axe=new Axe(10,10);

        while(dummy.getHealth()>=0){
            dummy.takeAttack(axe.getAttackPoints());
        }


    }

    @Test
    public void aliveDummyCantGiveXP(){

    }
}
