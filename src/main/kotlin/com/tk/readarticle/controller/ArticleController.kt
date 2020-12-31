package com.tk.readarticle.controller

import com.tk.readarticle.dao.Article
import com.tk.readarticle.form.ArticleForm
import com.tk.readarticle.response.JsonArticle
import com.tk.readarticle.service.ArticleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleController(
        private val articleService: ArticleService
) {

    @GetMapping("/articles")
    fun getArticles(@ModelAttribute form: ArticleForm): List<JsonArticle> {
        var articles: List<Article> = articleService.findArticles(form.page)
        val jsonArticles = mutableListOf<JsonArticle>()
        for (article: Article in articles) {
            jsonArticles.add(JsonArticle(
                    id = article.id,
                    title = article.title,
                    subtitle = article.subtitle,
                    body = article.body,
                    imageUrl = article.imageUrl
            ))
        }
        return jsonArticles
    }

}