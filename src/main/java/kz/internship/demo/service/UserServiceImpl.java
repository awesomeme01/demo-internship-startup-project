package kz.internship.demo.service;

import jakarta.persistence.EntityNotFoundException;
import kz.internship.demo.dto.UserDto;
import kz.internship.demo.model.User;
import kz.internship.demo.repository.UserRepository;
import kz.internship.demo.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * User Service Implementation.
 *
 * @author shabdan
 * Date: 6/9/2022
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<UserDto> getAllUsers(Pageable pageable) {
        return this.userRepository.findAll(pageable)
                .map(this.userMapper::toDto);
    }

    @Override
    public UserDto getUser(Long id) {
        final User user = this.userRepository.findById(id)
                                               .orElseThrow(() -> new EntityNotFoundException("Entity(User) with the given id " + id + " was not found!"));
        final UserDto userDto = this.userMapper.toDto(user);
        return userDto;
    }

    @Override
    public UserDto saveUser(UserDto dto) {
        var user = this.userMapper.toEntity(dto, false);
        return this.userMapper.toDto(this.userRepository.save(user));
    }

    @Override
    public void deleteUser(UserDto dto) {
        var maybeUser = this.userRepository.findById(dto.getId());
        if (maybeUser.isPresent()) {
            this.userRepository.delete(maybeUser.get());
        } else {
            throw new EntityNotFoundException("Entity(User) with the given id " + dto.getId() + " was not found!");
        }
    }
}
