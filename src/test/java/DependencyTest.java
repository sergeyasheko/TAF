import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {

    @Test
    public void stepb(){
        System.out.println("stepb...");}
    @Test(dependsOnMethods = "stepb")         // проставляем зависимость от предыдущего теста
    public void stepa(){
        System.out.println("stepa...");
        Assert.assertTrue(false);   //тест УПАЛ, цепочка прервалась
    }
    @Test(dependsOnMethods = "stepa",alwaysRun = true) //даже если предыдущий упал, ПРОДОЛЖИТЬ выполнение
    public void stepd(){
        System.out.println("stepd...");}
    @Test(dependsOnMethods = {"stepd","stepa"})   // будет зависеть от 2-х предыдущих
    public void stepc(){
        System.out.println("stepc...");}
}
