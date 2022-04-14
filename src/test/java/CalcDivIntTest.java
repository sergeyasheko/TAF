import org.testng.Assert;
import org.testng.annotations.Test;


public class CalcDivIntTest extends BaseTest{
    @Test(priority = 2)
    public void testDivInt(){
        Assert.assertEquals(calculator.div(10,5), 2, "неверное деление...");
    }
    @Test(dependsOnMethods = "testDivInt")
    public void testDivInt1(){
        Assert.assertEquals(calculator.div(12,4), 3, "неверное деление...");
    }
    @Test(priority = 1, testName = "Деление на 0")
    public void testDivInt2(){
        Assert.assertEquals(calculator.div(9,0), 3, "неверное деление...");
    }
    @Test(enabled = false)
    public void testDivInt3(){
        Assert.assertEquals(calculator.div(9,3), 3, "неверное деление...");
    }
    @Test(description = "Что меняется в тесте...")
    public void testDivInt4(){
        Assert.assertEquals(calculator.div(10,2), 5, "неверное деление...");
    }
    @Test(dependsOnMethods = "testDivInt1")
    public void testDivInt5(){
        Assert.assertEquals(calculator.div(10,2), 4, "неверное деление...");
    }
    @Test(dependsOnMethods = "testDivInt5",alwaysRun = true)
    public void testDivInt6(){
        Assert.assertEquals(calculator.div(25,5), 5, "неверное деление...");
    }
    @Test(timeOut = 1000)
    public void testDivInt7() throws InterruptedException {
        Assert.assertEquals(calculator.div(10,5), 2, "неверное деление...");
        Thread.sleep(900);
    }
    @Test(invocationCount = 6,invocationTimeOut = 400, threadPoolSize = 2)
    public void testDivInt8()throws InterruptedException{
        Assert.assertEquals(calculator.div(34,2), 17, "неверное деление...");
        Thread.sleep(115);
    }

}
