package bo.edu.ucb.sis.WalikiBackend.bl;

import org.springframework.beans.factory.annotation.Autowired;

import bo.edu.ucb.sis.WalikiBackend.dao.UsuarioDao;
import bo.edu.ucb.sis.WalikiBackend.dto.UsuarioDto;

public class UsuarioBl {
    @Autowired
    UsuarioDao usuarioDao;
    //Listado productos todos
    public UsuarioDto addUsuario(UsuarioDto usuarioDto) {
        return usuarioDao.crearProyecto(usuarioDto);
    }
}
