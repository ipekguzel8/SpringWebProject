package com.avansas.springwebproject.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "XUser")
public class XUser extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Enumerated
    @NotNull
    @Column(name = "Role")
    private Role role;

    @Column(name = "Password")
    @NotEmpty
    @Size(max = 8,min = 8,message = "User password must be 8 characters.")
    private String password;

    @Column(name = "Name")
    @NotEmpty
    private String name;

    @NotEmpty
    @Column(name = "Surname")
    private String surname;

    @NotNull
    @Column(name = "BirthDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotEmpty
    @Column(name = "TelNo")
    private String telno;

    @NotEmpty
    @Column(name="MailAddr")
    @Size(min = 6, max = 50)
    private String mail;

    @Override
    public String toString() {
        return "XUser{" +
                "id=" + id +
                ", role=" + role +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date=" + date +
                ", telno='" + telno + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
