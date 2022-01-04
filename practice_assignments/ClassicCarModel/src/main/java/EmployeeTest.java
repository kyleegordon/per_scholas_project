import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {

    @Test
    public void testEmployee() {
        EmployeeEntity a = new EmployeeEntity();
        a.setEmail("email@email.com");

        EmployeeEntity b = new EmployeeEntity();
        b.setEmail("email@email.com");

        Assert.assertEquals(a, b);
    }
}
