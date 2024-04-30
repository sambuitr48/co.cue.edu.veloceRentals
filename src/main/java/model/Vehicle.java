package model;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Vehicle {
    private int vehicle_id;
    private VehicleCategory vehicleCategory;
    private String brand;
    private String plate;
    private Double price;
    private String state;
}
