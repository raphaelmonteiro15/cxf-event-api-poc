import java.util.function.Supplier;

/**
 * Created by raphaelmonteiro on 5/21/15.
 */
public class SupplierTest {

    public static void sum(Supplier<Integer> supplier){
        System.out.println(supplier.get());
    }


    public static void main(String[]args){
        sum(() -> 1 + 2);
        sum(() -> 2 + 2);

    }
}
