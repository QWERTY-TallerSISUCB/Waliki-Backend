package bo.edu.ucb.sis.WalikiBackend.api;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import bo.edu.ucb.sis.WalikiBackend.bl.*;
import bo.edu.ucb.sis.WalikiBackend.dto.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserApi {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private UserBl userBl;

     //Crear un nuevo usuario
    @PostMapping(path = "/signup")
    public ResponseDto addProyecto(@RequestBody UserSignUpDto usuario) {
        // Validar que los datos enviados son correctos.
        if (usuario.getUsername() == null || usuario.getUsername().trim().equals("") ) {  // usuario: "     "
            return new ResponseDto( false, null, "El nombre de usuario es obligatorio");
        }
        if (usuario.getPassword() == null || usuario.getPassword().trim().equals("") ) {  // password: "     "
            return new ResponseDto( false, null, "La constrasenia es obligatoria");
        }
        return new ResponseDto(true, userBl.addUsuario(usuario), "Proyecto agregado con exito");
    }
    //Search user by id
    @GetMapping(path = "/user/{userid}")
    public ResponseDto  findUserbyId(@PathVariable Integer userId) {
        UserInformationDto user = userBl.findUserbyId(userId);
        if (user != null ) {
            if (userId<0){
                return new ResponseDto( false, null, "No puede ser un valor negativo:");
            }else {
                return new ResponseDto( true, user, null);
            }
        } else {
            return new ResponseDto( false, null, "No existe el usuario con codigo:");
        }

    }
    }
}
