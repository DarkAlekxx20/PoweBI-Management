
package org.powerbi.model;

/**
 *
 * @author mazu1
 */
public class Maestro {

    private int idMaestro;
    private String nombre;
    private String ape1;
    private String ape2;
    private String matricula;
    private String area;
    private User user;

    public Maestro() {
    }

    public Maestro(int idMaestro, String nombre, String ape1, String ape2, String matricula, String area, User user) {
        this.idMaestro = idMaestro;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.matricula = matricula;
        this.area = area;
        this.user = user;
    }
    
    

    public int getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(int idMaestro) {
        this.idMaestro = idMaestro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public User getUsuario() {
        return user;
    }

    public void setUsuario(User user) {
        this.user = user;
    }
    
    

    
}
