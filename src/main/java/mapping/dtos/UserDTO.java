package mapping.dtos;

import lombok.Builder;

@Builder
public record UserDTO(
                      String name,
                      String mail,
                      String password,
                      String mobile
                ) {
}
