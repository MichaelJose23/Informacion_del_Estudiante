/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Alumno;

/**
 *
 * @author Michael Castro
 */
public class AlumnoDao {
    Conexion conn;
    
    public AlumnoDao(Conexion conn){
        this.conn=conn;
    }
    
    public boolean insertar(Alumno alu){
        String sql="insert into Alumno values(?,?,?,?,?)";
        try {
            PreparedStatement ps =conn.conectar().prepareStatement(sql);
            ps.setInt(1, alu.getId());
            ps.setString(2, alu.getNombre());
            ps.setString(3, alu.getApellido());
            ps.setInt(4, alu.getEdad());
            ps.setString(5, alu.getFecha_de_ingreso());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public List<Alumno> consultarAll(){
       String sql="select * from Alumno";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Alumno alu;
            List<Alumno> lista =new LinkedList<>();
            while (rs.next()){
                alu = new Alumno(rs.getInt("id"));
                alu.setNombre(rs.getString("nombre"));
                alu.setApellido(rs.getString("apellido"));
                alu.setEdad(rs.getInt("edad"));
                alu.setFecha_de_ingreso(rs.getString("fecha_de_ingreso"));
                lista.add(alu);
                
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
