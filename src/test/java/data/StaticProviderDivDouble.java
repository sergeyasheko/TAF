package data;

import org.testng.annotations.DataProvider;

public class StaticProviderDivDouble {
    @DataProvider(name= "dataForDivDouble")
    public static Object[][]dataForDivDouble(){
        return new Object[][]{
                {7.6,2.4,3.1666666666666665},
                {5.5,1.1,5},
                {15.3,2.6,5.884615384615385}
        };
    }
}
