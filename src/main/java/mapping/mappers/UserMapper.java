package mapping.mappers;

import mapping.dtos.UserDTO;
import model.User;

public class UserMapper {
    public static User mapFrom(UserDTO userDTO){
        return User.builder()
                .id(userDTO.id())
                .name(userDTO.name())
                .mail(userDTO.mail())
                .password(userDTO.password())
                .role(userDTO.role())
                .state(userDTO.state())
                .build();
    }
    public static UserDTO mapFrom(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .mail(user.getMail())
                .password(user.getPassword())
                .role(user.getRole())
                .state(user.getState())
                .build();
    }
}
