package com.ll.sbb.Article;

import com.ll.sbb.Answer.Answer;
import com.ll.sbb.User.SiteUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 50)
    private String subject;

    @Column(columnDefinition = "text")
    private String content;

    private int price;

    @OneToMany
    private Set<SiteUser> voter;

    private int starScore;

    private int viewCount;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

//    private String original_file_name;
//
//    private String stored_file_name;
//
//    private long file_size;

    //        private String photo; 강사님께 문의
    @OneToMany(mappedBy = "article", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

}
