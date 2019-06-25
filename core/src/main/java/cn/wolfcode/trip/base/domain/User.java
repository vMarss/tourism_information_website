package cn.wolfcode.trip.base.domain;

import lombok.*;

@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Long id;

    private String email;

    private String nickName;

    private String password;

    private String place;

    private String headImgUrl;

    private Integer gender = -1;

    private String coverImgUrl;

    private String sign;

    public String getGenderName() {
        if (gender == 0) {
            return "女";
        } else if (gender == 1) {
            return "男";
        } else {
            return "未知";
        }
    }
}