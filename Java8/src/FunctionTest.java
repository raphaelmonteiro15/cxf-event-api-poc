import java.util.function.Function;

/**
 * Created by raphaelmonteiro on 5/21/15.
 */
public class FunctionTest {

    public static void executeFunctionWithOneParameter(Function<Integer, String> doubleToInt, Integer value){
        System.out.println(doubleToInt.apply(value));
    }

    public static void main(String[]args){
        executeFunctionWithOneParameter(x -> x.toString());
    }

}
