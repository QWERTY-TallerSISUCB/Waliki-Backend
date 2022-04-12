package bo.edu.ucb.sis.WalikiBackend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import bo.edu.ucb.sis.WalikiBackend.dto.UserInformationDto;
import org.springframework.beans.factory.annotation.Autowired;

import bo.edu.ucb.sis.WalikiBackend.dto.UserSignUpDto;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
    @Autowired
    private DataSource dataSource2;
    @Autowired
    private SequenceDao sequenceDao;
    //Crear un nuevo usuario
    public UserSignUpDto signUp (UserSignUpDto userSignUpDto) {
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
                    "INSERT INTO usuario (nombreusuario, contrasenia, tipo_usuario, persona_id_persona, direccion, cuenta_bancaria_id_c_bancaria) " +
                    "VALUES (?,?,?,?,?,?); ");
                    stmts.setString(1, userSignUpDto.getUsername()); //nombre proyecto
                    stmts.setString(2, userSignUpDto.getPassword());// contrasenia
                    stmts.setString(3, userSignUpDto.getRol()); // tipo_usuario
                    stmts.setString(4, userSignUpDto.getEmail());//id_proyecto
                    stmts.setString(5, userSignUpDto.getEmail()); // monto_recaudar
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

        return userSignUpDto;
    }

    //Buscar un donador por su id
    public UserInformationDto findDonadorById(Integer userId) {
        UserInformationDto result = new UserInformationDto();
        try(
                Connection conn = dataSource2.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT d.id_user, nombre_persona, nombre_proyecto, monto " +
                                "FROM proyecto pr " +
                                "JOIN donador d ON d.id_donador= pr.id_proyecto " +
                                "JOIN donacion dn ON d.id_donador = dn.id_donacion " +
                                "JOIN usuario us ON us.id_usuario = d.id_usuario " +
                                "JOIN persona pe ON pe.id_persona = us.id_persona_fk " +
                                "WHERE d.id_donador = ? " + //
                                "GROUP BY d.id_donador, pe.nombre_persona, pr.nombre_proyecto, dn.monto;")
        )
        {   pstmt.setInt(1, idDonador );
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setDonadorId(rs.getInt("id_donador"));
                result.setNombrePersona(rs.getString("nombre_persona"));
                result.setNombreProyecto(rs.getString("nombre_proyecto"));
                result.setMonto_donacion(rs.getDouble("monto"));
            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
