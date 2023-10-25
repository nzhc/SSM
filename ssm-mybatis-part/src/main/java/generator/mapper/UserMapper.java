package generator.mapper;

import generator.org.example.pojo.User;

/**
* @author 79928
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-10-25 11:24:27
* @Entity generator.org.example.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
