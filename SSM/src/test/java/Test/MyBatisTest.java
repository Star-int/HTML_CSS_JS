package Test;

import com.mapper.UserMapper;
import com.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //List<User> User = sqlSession.selectList(".selectAll");
        //获取usermapper代理对象

        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        List<User> users=usermapper.selectAll();
        System.out.println(users);
        sqlSession.close();
    }
}
