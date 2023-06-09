package kz.internship.demo.util;

import kz.internship.demo.dto.UserDto;
import kz.internship.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Utility bean to map from User to UserDto
 *
 * @author shabdan
 * Date: 6/9/2022
 */
@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User toEntity(UserDto dto, boolean setIdField) {
        final User user = new User();
        user.setActive(dto.getIsActive());
        user.setPassword(this.passwordEncoder.encode(dto.getRawPassword()));
        user.setActive(dto.getIsActive());

        if (setIdField) {
            user.setId(dto.getId());
        }

        return user;
    }

    public UserDto toDto(User entity) {
        final UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setIsActive(entity.getActive());
        dto.setUsername(entity.getUsername());
        return dto;
    }
}
