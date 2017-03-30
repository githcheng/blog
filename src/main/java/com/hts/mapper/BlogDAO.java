package com.hts.mapper;

import com.hts.entity.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * Created by jam on 2017/3/26.
 */
@Mapper
public interface BlogDAO {
    @Insert("INSERT INTO blog(title,uniq,markdown,html, create_time,update_time) " +
            "VALUES(#{item.title},#{item.uniq},#{item.markdown},#{item.html},#{item.createTime}, #{item.updateTime})")
    int insert(
            @Param("item") Blog blog
    );

    @Select("SELECT id,uniq,title,markdown,html," +
            " create_time as createTime,update_time as updateTime " +
            " FROM blog WHERE id = #{id}")
    Blog getBlogById(@Param("id") String id);

    @Insert("replace into blog(id,title,uniq,markdown,html, create_time,update_time) " +
            "VALUES(#{item.id},#{item.title},#{item.uniq},#{item.markdown},#{item.html},#{item.createTime}, #{item.updateTime})")
    int update(@Param("item")Blog blog);

    @Select("SELECT id,uniq,title," +
            " create_time as createTime,update_time as updateTime " +
            " FROM blog order by id desc limit #{offset}, #{limit}")
    List<Blog> getBlogList(@Param("offset")long offset,
                           @Param("limit")long limit,
                           @Param("sort") String sort);
}
