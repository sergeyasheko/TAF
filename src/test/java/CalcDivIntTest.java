import org.testng.Assert;
import org.testng.annotations.Test;


public class CalcDivIntTest extends BaseTest{
    @Test(priority = 2)
    public void testDivInt(){
        Assert.assertEquals(calculator.div(10,5), 2, "неверное деление...");
    }
    @Test(priority = 3)
    public void testDivInt1(){
        Assert.assertEquals(calculator.div(9,0), 3, "неверное деление...");
    }
    @Test(enabled = false)
    public void testDivInt2(){
        Assert.assertEquals(calculator.div(9,3), 3, "неверное деление...");
    }
    @Test(description = "Что меняется в тесте...", priority = 1)
    public void testDivInt3(){
        Assert.assertEquals(calculator.div(10,2), 5, "неверное деление...");
    }


}
