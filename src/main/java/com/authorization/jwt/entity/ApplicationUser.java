package com.authorization.jwt.entity;

import lombok.*;

import javax.persistence.*;

@DiscriminatorValue("User")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String password;

//    @Column(name = "FIRST_NAME" , nullable = false)
//    private String firstName;
//
//    @Column(name = "LAST_NAME" , nullable = false)
//    private String lastName;
//
//    @Column(name = "EMAIL" , nullable = false,unique = true)
//    private String email;


    public ApplicationUser(ApplicationUser user) {
        this.userName = user.userName;
        this.password = user.password;
//        this.firstName = user.firstName;
//        this.lastName = user.lastName;
//        this.email = user.email;
    }


}
