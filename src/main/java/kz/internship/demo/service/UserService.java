package kz.internship.demo.service;

import kz.internship.demo.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * User Service.
 *
 * @author shabdan
 * Date: 6/9/2022
 */
public interface UserService {
    Page<UserDto> getAllUsers(Pageable pageable);

    UserDto getUser(Long id);

    @Transactional
    UserDto saveUser(UserDto user);

    @Transactional
    void deleteUser(UserDto user);
}
