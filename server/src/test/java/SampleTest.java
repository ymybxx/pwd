import com.yyx.pwd.Application;
import com.yyx.pwd.entity.User;
import com.yyx.pwd.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        ArrayList<Long> objects = new ArrayList<>();
        objects.add(1L);
        List<User> users = userMapper.findByIds(objects);
        Assert.assertEquals(users.size(), 1);
        System.out.println(users.get(0).getName());
    }

}

