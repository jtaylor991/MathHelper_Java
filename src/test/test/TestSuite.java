package test;

import main.BasicAlgebraProblem;
import static org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;
import static org.junit.*;


public class TestSuite
{

    @Test
    public void testBasicAlgebraProblem()
    {
        BasicAlgebraProblem testProblem = new BasicAlgebraProblem(1);

        assertThat(5, is(equalTo(4+1)));
        assertEquals();



    }
}
