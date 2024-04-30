package mapping.dtos;

import lombok.Builder;
import model.Role;
@Builder
public record UserDTO(int id,
                      String name,
                      String mail,
                      String password,
                      Role role,
                      String state) {
}
