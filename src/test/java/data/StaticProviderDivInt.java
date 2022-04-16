package data;

import org.testng.annotations.DataProvider;

public class StaticProviderDivInt {
    @DataProvider(name= "dataForDivInt")
    public static Object[][]dataForDivInt(){
        return new Object[][]{
                {10,2,5},
                {4,2,2},
                {15,5,3}
        };
    }
}
