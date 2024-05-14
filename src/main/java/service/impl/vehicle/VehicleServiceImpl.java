    package service.impl.vehicle;

    import jakarta.enterprise.context.ApplicationScoped;
    import jakarta.inject.Inject;
    import mapping.dtos.VehicleDTO;
    import mapping.mappers.VehicleMapper;
    import model.Vehicle;
    import repository.impl.vehicle.VehicleRepositoryJdbcImpl;
    import service.VehicleService;

    import java.util.List;
    @ApplicationScoped
    public class VehicleServiceImpl implements VehicleService {
        public VehicleServiceImpl() {
        }
        @Inject
        private VehicleRepositoryJdbcImpl repo;


        @Override
        public List<Vehicle> list() {
            return repo.list();
        }

        @Override
        public Vehicle verifyExist(int id) {
            return repo.verifyExist(id);
        }

        @Override
        public int save(VehicleDTO vehicleDTO) {
            repo.save(VehicleMapper.mapFrom(vehicleDTO));
            return 0;
        }


        @Override
        public void delete(int id) {
            repo.delete(id);
        }
    }
