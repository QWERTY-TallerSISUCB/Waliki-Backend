package bo.edu.ucb.sis.WalikiBackend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import bo.edu.ucb.sis.WalikiBackend.dto.UsuarioDto;

public class UsuarioDao {
    @Autowired
    private DataSource dataSource2;
    @Autowired
    private SequenceDao sequenceDao;
    //Crear un nuevo proyecto
    public UsuarioDto crearProyecto (UsuarioDto usuarioDto) {
        //usuarioDto.set(sequenceDao.getPrimaryKeyForTable("proyecto"));

        /*
        usuarioDto.setEmail();
        usuarioDto.setUsername(23); // id_emprendedor
        usuarioDto.setRol();
        usuarioDto.setPassword();
        */
        try (Connection conn = dataSource2.getConnection())  //cerrado de conexion
        {
            PreparedStatement stmts = conn.prepareStatement("" +
                    "INSERT INTO proyecto (nombreusuario, contrasenia, tipo_usuario, persona_id_persona, direccion, cuenta_bancaria_id_c_bancaria) " +
                    "VALUES (?,?,?,?,?,?,?); ");
                    stmts.setString(1, usuarioDto.getUsername()); //nombre proyecto
                    stmts.setString(2, usuarioDto.getPassword());// contrasenia
                    stmts.setString(3, usuarioDto.getRol()); // tipo_usuario
                    stmts.setString(4, usuarioDto.getEmail());//id_proyecto
                    stmts.setString(5, usuarioDto.getEmail()); // monto_recaudar
                    stmts.setInt(6, 1);
                    stmts.setInt(7, 1);
                    /*
            stmts.setString(5, usuarioDto.get()); // id_emprendedor
            stmts.setString(6, usuarioDto.getHoraInicio()); //hora_inicio
            stmts.setString(7, usuarioDto.getHoraFin()); //hora-fin
            stmts.setInt(8, usuarioDto.getEstadoId()); //id_estado
            stmts.setString(9, usuarioDto.getFechaInicio()); //fecha_inicio
            stmts.setString(10, usuarioDto.getFechaFin()); //fecha_final
            */
            stmts.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // No hacer nada intencionalemte;

        return usuarioDto;
    }
}
