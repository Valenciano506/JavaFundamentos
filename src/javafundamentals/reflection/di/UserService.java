package javafundamentals.reflection.di;

public class UserService {

    @Inject
    private UserRepository repository;

    public void registerUser(String name) {
        repository.saveUser(name);
    }
}