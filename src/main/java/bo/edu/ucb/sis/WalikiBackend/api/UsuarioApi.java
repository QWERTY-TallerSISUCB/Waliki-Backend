package bo.edu.ucb.sis.WalikiBackend.api;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
            return new ResponseDto( false, null, "El nombre del proyecto debe ser obligatorio");
        }
        if (usuario.getUsername() == null || usuario.getUsername().trim().equals("") ) {  // password: "     "
            return new ResponseDto( false, null, "El monto a recaudar debe ser obligatorio y mayor a 0");
        }
        if (usuario.getEmail() == null || usuario.getEmail().trim().equals("") ) {  // email: "     "
            return new ResponseDto( false, null, "La descripcion debe ser obligatoria");
        }
        return new ResponseDto(true, usuarioBl.addUsuario(usuario), "Proyecto agregado con exito");
    }
}
