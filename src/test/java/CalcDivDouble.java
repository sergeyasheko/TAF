import data.StaticProviderDivDouble;
import org.testng.Assert;
import org.testng.annotations.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static jdk.nashorn.internal.objects.Global.NaN;

public class CalcDivDouble extends BaseTest{

    @Test (enabled = false)
    public void testDivDouble(){
        Assert.assertEquals(calculator.divDouble(5.5,1.1), 5, "Неверное деление...");
    }
    @Test(invocationCount = 4,invocationTimeOut = 400, threadPoolSize = 2)
    public void testDivDouble1() throws InterruptedException{
        Assert.assertEquals(calculator.divDouble(5.5,0), Double.POSITIVE_INFINITY, "Неверное деление...");
        Thread.sleep(200);
    }
    @Test(testName = "Деление 0 на 0")
    public void testDivDouble2(){
        Assert.assertEquals(calculator.divDouble(0,0), NaN, "Неверное деление...");
    }
    @Test()
    public void testDivDouble3 (){
        Assert.assertEquals(calculator.divDouble(-12.3,0.0),Double.NEGATIVE_INFINITY, "Неверное деление...");
    }
    @Test(priority = 2)
    public void testDivDouble4(){
        Assert.assertEquals(calculator.divDouble(4.5,-0.00), Double.NEGATIVE_INFINITY, "Неверное деление...");
    }
    @Test(priority = 1)
    public void testDivDouble5(){
        Assert.assertEquals(calculator.divDouble(7.3,1.4),5.214285714285714, "Неверное деление...");
    }
    @Test(description = "Тест с описанием, что поменялось...", timeOut = 900, groups = "smoke")
    public void testDivDouble6() throws InterruptedException {
        Assert.assertEquals(calculator.divDouble(7.3,1.4),5.214285714285714, "Неверное деление...");
        Thread.sleep(800);
    }
    @Test(dependsOnMethods = "testDivDouble5" )
    public void testDivDouble7(){
        Assert.assertEquals(calculator.divDouble(3.4,1.2),2.833333333333333, "Неверное деление...");
}
@Test(dependsOnMethods = "testDivDouble7",alwaysRun = true )
    public void testDivDouble8(){
        Assert.assertEquals(calculator.divDouble(12.4,1.2),10.333333333333334, "Неверное деление...");
}
    @Test(dataProvider = "dataForDivDouble",dataProviderClass = StaticProviderDivDouble.class)
    public void testDivDouble9(double a, double b, double expectedResult){
        Assert.assertEquals(calculator.divDouble(a,b),expectedResult, "Неверное деление...");
    }
}
