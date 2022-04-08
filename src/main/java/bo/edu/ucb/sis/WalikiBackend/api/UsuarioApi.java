package bo.edu.ucb.sis.WalikiBackend.api;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.sis.WalikiBackend.bl.UsuarioBl;
import bo.edu.ucb.sis.WalikiBackend.dto.ResponseDto;
import bo.edu.ucb.sis.WalikiBackend.dto.UsuarioDto;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioApi {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private UsuarioBl usuarioBl;
     //Crear un nuevo usuario
    @PostMapping(path = "/signup")
    public ResponseDto addProyecto(@RequestBody UsuarioDto usuario) {
        // Validar que los datos enviados son correctos.
        if (usuario.getUsername() == null || usuario.getUsername().trim().equals("") ) {  // usuario: "     "
            return new ResponseDto( false, null, "El nombre de usuario es obligatorio");
        }
        if (usuario.getPassword() == null || usuario.getPassword().trim().equals("") ) {  // password: "     "
            return new ResponseDto( false, null, "La constrasenia es obligatoria");
        }
        return new ResponseDto(true, usuarioBl.addUsuario(usuario), "Proyecto agregado con exito");
    }
}
