import com.supermarket.entity.User;
import com.supermarket.mapper.UserMapper;
import com.supermarket.service.DBOperateSerive;
import org.apache.ibatis.session.SqlSession;


public class TestMain {
    public static void main(String[] args) {
        SqlSession session = DBOperateSerive.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("life");
        user.setEmail("534619360@qq.com");
        if (mapper.verifyUser(user) != null)
            System.out.println("yes");
        System.out.println("no");
    }
}