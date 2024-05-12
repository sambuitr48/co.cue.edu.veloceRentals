    package service.impl;

    import mapping.dtos.UserDTO;
    import mapping.mappers.UserMapper;
    import model.User;
    import repository.impl.user.UserRepositoryJdbcImpl;
    import service.Service;

    import java.util.List;

    public class UserServiceImpl implements Service {

        private final UserRepositoryJdbcImpl repo;

        public UserServiceImpl(UserRepositoryJdbcImpl repo) {
            this.repo = repo;
        }

        @Override
        public List<User> list() {
            return repo.list();
        }

        @Override
        public User byId(Integer id) {
            return repo.byId(id);
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
