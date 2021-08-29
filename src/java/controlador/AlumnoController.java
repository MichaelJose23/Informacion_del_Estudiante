/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.AlumnoDao;
import java.util.List;
import java.util.Scanner;
import modelo.Alumno;

/**
 *
 * @author Michael Castro
 */
public class AlumnoController {
    public static void main(String[] args) {
        Scanner cc = new Scanner(System.in);
        Alumno alu = new Alumno(0);
        Conexion conn = new Conexion();
        AlumnoDao aludo = new AlumnoDao(conn);
        
        
        System.out.println("Ingrese el nombre del Alumno:");
        alu.setNombre(cc.next());
        System.out.println("Ingrese el apellido del Alumno:");
        alu.setApellido(cc.next());
        System.out.println("Ingrese la edad del Alumno:");
        alu.setEdad(cc.nextInt());
        System.out.println("Ingrese la fecha de ingreso del Alumno:");
        alu.setFecha_de_ingreso(cc.next());
        
       
        
        boolean respuesta= aludo.insertar(alu);
        
        if (respuesta) {
            System.out.println("su registro se guardo");
            
        }
        else{
            System.out.println("no se guardo su registro");
        }
        
        List<Alumno> list=aludo.consultarAll();
        for (Alumno alu1 :list) {
            System.out.println("el ID del estudiante es: " +alu1.getId() );
            System.out.println("el nombre de estudiante es; " + alu1.getNombre());
            System.out.println("el apellido del estudiante es; " + alu1.getApellido());
            System.out.println("la fecha de ingreso del estudiante es; " + alu1.getFecha_de_ingreso());
        }
    }
    
}
