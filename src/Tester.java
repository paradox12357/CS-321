
import static org.junit.Assert.*;
import org.junit.Test;

public class Tester 
{
    @Test
    private static void test1()
    {
        try 
        {
            assertEquals("hel3lo", "hello");
            System.out.println("It Works!");
        }
        catch(AssertionError e)
        {
            System.out.println("Error!!");
        }
    }

    public static void main(String[] args)
    {
        test1();
    }
}

