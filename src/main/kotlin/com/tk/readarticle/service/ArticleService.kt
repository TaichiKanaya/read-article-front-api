package com.tk.readarticle.service

import com.tk.readarticle.dao.Article
import com.tk.readarticle.mapper.ArticleMapper
import org.springframework.stereotype.Service

@Service
class ArticleService(private val articleMapper: ArticleMapper) {

    companion object {
        const val DISPLAY_PER_PAGE = 10
    }

    fun findArticles(page: Int): List<Article> {
        return articleMapper.find(DISPLAY_PER_PAGE, DISPLAY_PER_PAGE * (page - 1))
    }
}