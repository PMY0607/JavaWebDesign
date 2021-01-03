import org.junit.Test;

import java.io.InputStream;

public class TestDButil {
    @Test
    public  void ff() throws Exception {

        //DBUtils.getConnection();
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/db.properties");
        System.out.println(in);
    }
}