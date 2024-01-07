package entidades;
// Generated 14 dic. 2023 18:03:52 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Auxemp generated by hbm2java
 */
public class Auxemp  implements java.io.Serializable {


     private int empNo;
     private Auxdept auxdept;
     private String apellido;
     private String oficio;
     private Integer dir;
     private Date fechaAlta;
     private Integer salario;
     private Integer comision;

    public Auxemp() {
    }

	
    public Auxemp(int empNo) {
        this.empNo = empNo;
    }
    public Auxemp(int empNo, Auxdept auxdept, String apellido, String oficio, Integer dir, Date fechaAlta, Integer salario, Integer comision) {
       this.empNo = empNo;
       this.auxdept = auxdept;
       this.apellido = apellido;
       this.oficio = oficio;
       this.dir = dir;
       this.fechaAlta = fechaAlta;
       this.salario = salario;
       this.comision = comision;
    }
   
    public int getEmpNo() {
        return this.empNo;
    }
    
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
    public Auxdept getAuxdept() {
        return this.auxdept;
    }
    
    public void setAuxdept(Auxdept auxdept) {
        this.auxdept = auxdept;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getOficio() {
        return this.oficio;
    }
    
    public void setOficio(String oficio) {
        this.oficio = oficio;
    }
    public Integer getDir() {
        return this.dir;
    }
    
    public void setDir(Integer dir) {
        this.dir = dir;
    }
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public Integer getSalario() {
        return this.salario;
    }
    
    public void setSalario(Integer salario) {
        this.salario = salario;
    }
    public Integer getComision() {
        return this.comision;
    }
    
    public void setComision(Integer comision) {
        this.comision = comision;
    }




}


