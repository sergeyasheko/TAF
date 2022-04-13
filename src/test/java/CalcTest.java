import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalcTest extends BaseTest{

    @Test
    public void testSum(){
        Assert.assertEquals(calculator.sum(2,4), 6,"неверная сумма..."); // исходные данные, ожидаемый результат, комментарий
    }
    @Test (enabled = false)
    public void testSum1(){
        Assert.assertEquals(calculator.sum(2,3), 5,"неверная сумма..."); // исходные данные, ожидаемый результат, комментарий
    }
    @Test (description = "Тест с описанием")              // описывает что меняется в тесте
    public void testSum2(){
        Assert.assertEquals(calculator.sum(2,3), 5,"неверная сумма..."); // исходные данные, ожидаемый результат, комментарий
    }
    @Test (testName = "Test with name")                  // меняет название теста
    public void testSum3(){
        Assert.assertEquals(calculator.sum(2,3), 5,"неверная сумма..."); // исходные данные, ожидаемый результат, комментарий
    }


// параметр invocationCount запустить количество раз
    @Test(invocationCount = 3)
    public void invocationCountTest(){
        Assert.assertEquals(calculator.sum(2,3), 5,"неверная сумма..."); // исходные данные, ожидаемый результат, комментарий
    }


    // параметр timeOut количество времени для прогона
    @Test(timeOut = 1000)            //тысяча милисекунд, к timeOut
    public void waitLongTimeTest() throws InterruptedException {
       Thread.sleep(1100);     //спит 1000 милисекунд
    }


    // параметр dataProvider количество времени для прогона
    @Test(dataProvider = "dataForSum",dataProviderClass = StaticProvider.class, threadPoolSize = 3) //threadPoolSize чтобы 3 теста шли параллельно, для ускорения прохода
    public void testDataProvider(int a, int b, int expectedResult){
        Assert.assertEquals(calculator.sum(a,b), expectedResult,"неверная сумма...");
    }
    // параметр expectedExceptions
    @Test (expectedExceptions = NullPointerException.class)
    public void testExceptions(){
       List list = null;
       int size = list.size();
    }

}
