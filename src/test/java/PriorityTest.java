import org.testng.annotations.Test;

public class PriorityTest {

    @Test(priority = 1)         //устанавливаем приоритеты выполнения тестов, если изменилось время прогона, запускаем самые приоритетные
    public void stepb(){
        System.out.println("stepb...");}  //атоматически иерархия выполнения выстраивается  по принципу как в СЛОВАРЕ
    @Test(priority = 2)
    public void stepa2(){
        System.out.println("stepa2...");}
    @Test(priority = 3)
    public void stepa11(){
        System.out.println("stepa11...");}
    @Test(priority = 4)
    public void stepd(){
        System.out.println("stepd...");}
    @Test(priority = 5)
    public void stepc(){
        System.out.println("stepc...");}
}
