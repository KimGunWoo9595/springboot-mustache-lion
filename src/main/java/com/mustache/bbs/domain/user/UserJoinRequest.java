package com.mustache.bbs.domain.user;
import com.mustache.bbs.domain.entity.User;
import com.mustache.bbs.domain.entity.UserRole;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @ToString
public class UserJoinRequest {
    private String userName;
    private String password;
    private String emailAddress;


    //dto -> entity
    public User toEntity(String password) { // 매개변수로 넘어오는 password는 암호화된 password
        return User.builder()
                .username(this.userName)
                .password(password)
                .emailAddress(this.emailAddress)
                .role(UserRole.USER)
                .build();
    }
}