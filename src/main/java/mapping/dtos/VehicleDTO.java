package mapping.dtos;

import lombok.Builder;
import model.VehicleCategory;
@Builder
public record VehicleDTO(int vehicle_id,
                         VehicleCategory vehicleCategory,
                         String brand,
                         String plate,
                         Double price,
                         String state ) {
}
