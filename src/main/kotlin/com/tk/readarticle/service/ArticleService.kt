package com.tk.readarticle.service

import com.tk.readarticle.dao.Article
import com.tk.readarticle.mapper.ArticleMapper
import org.springframework.stereotype.Service

@Service
class ArticleService(private val articleMapper: ArticleMapper) {

    fun find(page: Int, limit: Int): List<Article> {
        return articleMapper.find(limit, limit * (page - 1))
    }

    fun getTotal(): Int {
        return articleMapper.getTotal()
    }

    fun findById(id: Int): Article {
        return articleMapper.findById(id)
    }
}