    package service.impl.user;

    import jakarta.enterprise.context.ApplicationScoped;
    import jakarta.inject.Inject;
    import mapping.dtos.UserDTO;
    import mapping.mappers.UserMapper;
    import model.User;
    import repository.impl.user.UserUserRepositoryJdbcImpl;
    import service.UserService;

    import java.util.List;
@ApplicationScoped
    public class UserUserServiceImpl implements UserService {

    @Inject
    private UserUserRepositoryJdbcImpl repo;
        @Override
        public List<User> list() {
            return repo.list();
        }

        @Override
        public User verifyExist(String mail, String password) {
            return repo.verifyExist(mail, password);
        }

        @Override
        public int save(UserDTO userdto) {
             repo.save(UserMapper.mapFrom(userdto));
            return 0;
        }

        @Override
        public void delete(int id) {
            repo.delete(id);
        }
    }
