package com.mustache.bbs.domain.dto.articleAdd;

import com.mustache.bbs.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@Builder
@AllArgsConstructor
public class ArticleAddResponseDto {

    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(this.id, this.title, this.content);
    }
}
