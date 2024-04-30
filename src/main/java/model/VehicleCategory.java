package model;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class VehicleCategory {
    private int category_id;
    private String category_name;
    private String category_description;
    private String state;
}
