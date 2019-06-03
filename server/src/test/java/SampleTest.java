import com.yyx.pwd.Application;
import com.yyx.pwd.entity.User;
import com.yyx.pwd.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleTest {
    @Autowired
    private UserMapper userMapper;

    @Before

    public void setUp(){

    }

    @Test
    public void testSelect() {

    }

    @Test
    public void testFindByName() {
        User user = userMapper.findByName("yyx");
        assertEquals(user.getName(), "yyx");
    }

}

