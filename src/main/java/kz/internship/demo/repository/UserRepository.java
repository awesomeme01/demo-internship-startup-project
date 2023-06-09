package kz.internship.demo.repository;

import kz.internship.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User Jpa Repository.
 *
 * @author shabdan
 * Date: 6/9/2022
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
