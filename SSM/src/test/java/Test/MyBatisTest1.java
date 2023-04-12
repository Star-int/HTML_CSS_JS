package Test;

import com.mapper.BrandMapper;
import com.mapper.UserMapper;
import com.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyBatisTest1 {
    public static void main(String[] args) throws IOException {

//        testSelectAll();
//        testSelectById();
        testSelectByCondition();

    }

    public static void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //List<User> User = sqlSession.selectList(".selectAll");
        //获取usermapper代理对象

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> Brand=brandmapper.selectAll();
        System.out.println(Brand);
        sqlSession.close();
    }

    public static void testSelectById() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //List<User> User = sqlSession.selectList(".selectAll");
        //获取usermapper代理对象

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println("请输入你要查询的公司ID");
        Scanner scanner =new Scanner(System.in);
        int id = scanner.nextInt();


        List<Brand> Brand=brandmapper.selectById(id);
        System.out.println(Brand);
        sqlSession.close();
    }

    public static void testSelectByCondition() throws IOException {

//        int status=1;
//        String companyName="华为";
//        String brandName="华为";
        int status;
        String companyName ;
        String brandName;


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //List<User> User = sqlSession.selectList(".selectAll");
        //获取usermapper代理对象

        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println("请输入你要查询的公司的status，公司名和品牌");
        System.out.println("1、status");
        Scanner scanner =new Scanner(System.in);
        status = scanner.nextInt();
        System.out.println("2、公司名");
        companyName=scanner.next();
        System.out.println("3、品牌");
        brandName=scanner.next();
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";


        Map map =new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        //List<Brand> Brand=brandmapper.selectByCondition(status,companyName,brandName);
//        List<Brand> Brand=brandmapper.selectByCondition(brand);
        List<Brand> Brand=brandmapper.selectByCondition(map);
        System.out.println(Brand);
        sqlSession.close();
        System.out.println(companyName);
        System.out.println(brandName);
    }

}
