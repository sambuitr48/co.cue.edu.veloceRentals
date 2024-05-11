package model;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
    private int id;
    private String name;
    private String mail;
    private String password;
}
