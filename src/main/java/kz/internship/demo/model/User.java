package kz.internship.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User Entity class.
 *
 * @author shabdan
 * Date: 6/9/2022
 */
@Entity
@Table(name = "c_user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;

}
