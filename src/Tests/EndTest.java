package Tests;
import org.junit.jupiter.api.Test;
import command.End;
import static org.junit.jupiter.api.Assertions.*;

public class EndTest {
    End end = new End();
    @org.junit.jupiter.api.Test
    void execute(){
        assertEquals("Exiting the game.", end.execute());
    }

}
