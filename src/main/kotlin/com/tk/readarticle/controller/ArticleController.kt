package com.tk.readarticle.controller

import com.tk.readarticle.dao.Article
import com.tk.readarticle.form.ArticleForm
import com.tk.readarticle.response.JsonArticle
import com.tk.readarticle.service.ArticleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleController(
        private val articleService: ArticleService
) {

    @GetMapping("/articles")
    fun find(@ModelAttribute form: ArticleForm): JsonArticle {
        var articles: List<Article> = articleService.find(form.page, form.limit)
        val responseArticles = mutableListOf<JsonArticle.ResponseArticle>()
        for (article: Article in articles) {
            responseArticles.add(JsonArticle.ResponseArticle(
                    id = article.id,
                    title = article.title,
                    subtitle = article.subtitle,
                    body = article.body,
                    imageUrl = article.imageUrl
            ))
        }
        return JsonArticle(
                total = articleService.getTotal(),
                articles = responseArticles
        )
    }

    @GetMapping("/articles/{id}")
    fun findById(@PathVariable id: Int): JsonArticle.ResponseArticle? {
        var article: Article = articleService.findById(id)
        return if (article != null) JsonArticle.ResponseArticle(
                id = article.id,
                title = article.title,
                subtitle = article.subtitle,
                body = article.body,
                imageUrl = article.imageUrl
        ) else null
    }

}
