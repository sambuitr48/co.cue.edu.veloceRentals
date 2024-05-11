package mapping.dtos;

import lombok.Builder;

@Builder
public record UserDTO(int id,
                      String name,
                      String mail,
                      String password,
                      String mobile
                ) {
}
