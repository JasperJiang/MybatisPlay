import com.demo.mybatisplay.dao.NameMapper;
import com.demo.mybatisplay.pojo.Name;
import com.demo.mybatisplay.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest1 {


    @Test
    public void test1(){

        //获得sqlSession对象
        try (SqlSession sqlSession = MybatisUtils.getSqlSession();){

            //第一种
            NameMapper nameMapper = sqlSession.getMapper(NameMapper.class);
            List<Name> nameList = nameMapper.getNameList();
            System.out.println(Arrays.toString(nameList.toArray()));

            //第二种 一般不用
            nameList = sqlSession.selectList("com.demo.mybatisplay.dao.NameMapper.getNameList");
            System.out.println(Arrays.toString(nameList.toArray()));

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void test2(){

        //获得sqlSession对象
        try (SqlSession sqlSession = MybatisUtils.getSqlSession();){

            NameMapper nameMapper = sqlSession.getMapper(NameMapper.class);

            //第一种
            Name name = nameMapper.getNameById(1);

            System.out.println(name);

        } catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void addName(){

        //获得sqlSession对象
        try (SqlSession sqlSession = MybatisUtils.getSqlSession();){

            NameMapper nameMapper = sqlSession.getMapper(NameMapper.class);

            Name name = new Name();

            name.setId(3);

            name.setName("hahaha");

            int nameId = nameMapper.addName(name);

            sqlSession.commit();

            System.out.println(nameId);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void updateUser(){

        //获得sqlSession对象
        try (SqlSession sqlSession = MybatisUtils.getSqlSession();){

            NameMapper nameMapper = sqlSession.getMapper(NameMapper.class);

            Name name = new Name();

            name.setId(3);

            name.setName("user3");

            int nameId = nameMapper.updateName(name);

            sqlSession.commit();

            System.out.println(nameId);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void deleteUser(){

        //获得sqlSession对象
        try (SqlSession sqlSession = MybatisUtils.getSqlSession();){

            NameMapper nameMapper = sqlSession.getMapper(NameMapper.class);

            int nameId = nameMapper.deleteNameById(3);

            sqlSession.commit();

            System.out.println(nameId);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void addName2(){

        //获得sqlSession对象
        try (SqlSession sqlSession = MybatisUtils.getSqlSession();){

            NameMapper nameMapper = sqlSession.getMapper(NameMapper.class);

            Map<String, Object> map = new HashMap<>();
            map.put("userId", 3);
            map.put("userName", "hahaha");

            int nameId = nameMapper.addName2(map);

            sqlSession.commit();

            System.out.println(nameId);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void getNameLike(){

        //获得sqlSession对象
        try (SqlSession sqlSession = MybatisUtils.getSqlSession();){

            NameMapper nameMapper = sqlSession.getMapper(NameMapper.class);

            List<Name> nameList = nameMapper.getNameLike("user");

            System.out.println(Arrays.toString(nameList.toArray()));

        } catch (Exception e){
            e.printStackTrace();
        }

    }


}

