package com.tk.readarticle.response

data class JsonArticle(
        val total: Int,
        val articles: List<ResponseArticle>
) {
    data class ResponseArticle(val id: Int, val title: String, val subtitle: String, val body: String, val imageUrl: String)
}
