package bo.edu.ucb.sis.WalikiBackend.bl;

import org.springframework.beans.factory.annotation.Autowired;

import bo.edu.ucb.sis.WalikiBackend.dao.*;
import bo.edu.ucb.sis.WalikiBackend.dto.*;
import org.springframework.stereotype.Service;

@Service
public class UserBl {
    @Autowired
    UserDao userDao;
    //Crear un nuevo usuario
    public UserSignUpDto addUsuario(UserSignUpDto userSignUpDto) {
        return userDao.signUp(userSignUpDto);
    }

    public Object findUserbyId() {
    }
}
