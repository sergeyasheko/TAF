import org.testng.Assert;
import org.testng.annotations.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static jdk.nashorn.internal.objects.Global.NaN;

public class CalcDivDouble extends BaseTest{

    @Test (enabled = false)
    public void testDivDouble(){
        Assert.assertEquals(calculator.divDouble(5.5,1.1), 5, "Неверное деление...");
    }
    @Test(priority = 3)
    public void testDivDouble1(){
        Assert.assertEquals(calculator.divDouble(5.5,0), Double.POSITIVE_INFINITY, "Неверное деление...");
    }
    @Test(priority = 4)
    public void testDivDouble2(){
        Assert.assertEquals(calculator.divDouble(0,0), NaN, "Неверное деление...");
    }
    @Test(priority = 5)
    public void testDivDouble3(){
        Assert.assertEquals(calculator.divDouble(-12.3,0.0),Double.NEGATIVE_INFINITY, "Неверное деление...");
    }
    @Test(priority = 5)
    public void testDivDouble4(){
        Assert.assertEquals(calculator.divDouble(4.5,-0.00), Double.NEGATIVE_INFINITY, "Неверное деление...");
    }
    @Test(priority = 2)
    public void testDivDouble5(){
        Assert.assertEquals(calculator.divDouble(7.3,1.4),5.214285714285714, "Неверное деление...");
    }
    @Test(description = "Тест с описанием, что поменялось...", priority = 1)
    public void testDivDouble6(){
        Assert.assertEquals(calculator.divDouble(7.3,1.4),5.214285714285714, "Неверное деление...");
    }
}
