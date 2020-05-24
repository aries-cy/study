package com.cy.study.elasticsearch.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * user实体类
 *
 * @author cy
 */
@Data
@Document(indexName = "cy",type = "user")
public class User {

    @Id
    String id;

    private String username;
    private String password;
    private Integer age;
    private String sex;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
