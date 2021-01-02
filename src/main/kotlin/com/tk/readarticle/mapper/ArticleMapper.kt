package com.tk.readarticle.mapper

import com.tk.readarticle.dao.Article
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface ArticleMapper {

    @Select("SELECT id, title, subtitle, body, image_url FROM article ORDER BY id LIMIT #{limit} OFFSET #{offset}")
    fun find(limit:Int, offset:Int): List<Article>

    @Select("SELECT count(1) FROM article")
    fun getTotal(): Int

    @Select("SELECT id, title, subtitle, body, image_url FROM article WHERE id = #{id}")
    fun findById(id:Int): Article
}