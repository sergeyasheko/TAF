import org.testng.annotations.*;

@Listeners(Listener.class) // связь с Listener
public class BaseTest {
    protected Calculator calculator = new Calculator("тестовый калькулятор");
    @BeforeSuite
    public void beforeSuite(){ System.out.println("BeforeSuite...");}
    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest...");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass...");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod...");
    }
    @BeforeGroups
    public void beforeGroup(){
        System.out.println("BeforeGroup...");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite...");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest...");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass...");
    }
    @AfterMethod
    public void afterMethod(){   System.out.println("AfterMethod...");}
    @AfterGroups
    public void afterGroup(){
        System.out.println("AfterGroup...");
    }
}
