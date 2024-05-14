    package service.impl.user;

    import mapping.dtos.UserDTO;
    import mapping.mappers.UserMapper;
    import model.User;
    import repository.impl.user.UserUserRepositoryJdbcImpl;
    import service.UserService;

    import java.util.List;

    public class UserUserServiceImpl implements UserService {

        private final UserUserRepositoryJdbcImpl repo;

        public UserUserServiceImpl(UserUserRepositoryJdbcImpl repo) {
            this.repo = repo;
        }

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
