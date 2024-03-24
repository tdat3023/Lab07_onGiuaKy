package com.tiendat.auth.Entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserVO {
    private String id;
    private String email;
    private String password;
    private String role;


    public Object getId() {
    }

    public Object getRole() {
    }

    public String getEmail() {
    }
}
