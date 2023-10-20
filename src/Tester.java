
import static org.junit.Assert.*;
import org.junit.Test;

public class Tester 
{
    private static final String WHITE = "\u001B[37m", GREEN = "\u001B[32m", RED = "\u001B[31m", BOLD = "\033[0;1m", PLAIN = "\033[0m";

    @Test
    private static void testAddRequest()
    {
        try 
        {
            // DocumentRequest test = new DocumentRequest();
            DocumentRequest test = null;
            
            assertNotNull(test);
            System.out.println("ADD REQUEST\t\t" + GREEN + "TEST PASSED" + WHITE);
        }
        catch(AssertionError e)
        {
            System.out.println("ADD REQUEST\t\t" + RED + "TEST FAILED" + WHITE);
        }
    }

    @Test
    private static void testUpdateRequest()
    {
        try 
        {
            DocumentRequest test = new DocumentRequest();
            String update = "update";
            // test.update(update);

            assertEquals(update, test.getField());
            System.out.println("UPDATE REQUEST\t\t" + GREEN + "TEST PASSED" + WHITE);
        }
        catch(AssertionError e)
        {
            System.out.println("UPDATE REQUEST\t\t" + RED + "TEST FAILED" + WHITE);
        }
    }

    @Test
    private static void testFormRequest()
    {
        try 
        {
            // DocumentRequest test = new DocumentRequest();
            // Form input = test.getForm();
            Object input = null;

            if(!(input instanceof Form)) fail();
            System.out.println("FORM REQUEST\t\t" + GREEN + "TEST PASSED" + WHITE);
        }
        catch(AssertionError e)
        {
            System.out.println("FORM REQUEST\t\t" + RED + "TEST FAILED" + WHITE);
        }
    }

    @Test
    private static void testSaveWorkflow()
    {
        try 
        {
            Workflow test = new Workflow();
            String update = "update";
            // test.save(update);

            assertEquals(update, test.getState());
            System.out.println("SAVE WORKFLOW\t\t" + GREEN + "TEST PASSED" + WHITE);
        }
        catch(AssertionError e)
        {
            System.out.println("SAVE WORKFLOW\t\t" + RED + "TEST FAILED" + WHITE);
        }
    }

    @Test
    private static void testRemoveEntry()
    {
        try 
        {
            DocumentRequest testObj = new DocumentRequest();
            Workflow test = new Workflow();
            test.addEntry(testObj.getForm());
            // test.rmEntry();

            assertEquals(null, test.getEntry());
            System.out.println("REMOVE ENTRY\t\t" + GREEN + "TEST PASSED" + WHITE);
        }
        catch(AssertionError e)
        {
            System.out.println("REMOVE ENTRY\t\t" + RED + "TEST FAILED" + WHITE);
        }
    }

    public static void main(String[] args)
    {
        System.out.println(BOLD + "TEST NAME\t\tTEST RESULT" + PLAIN);
        testAddRequest();
        testUpdateRequest();
        testFormRequest();
        testSaveWorkflow();
        testRemoveEntry();
    }
}

