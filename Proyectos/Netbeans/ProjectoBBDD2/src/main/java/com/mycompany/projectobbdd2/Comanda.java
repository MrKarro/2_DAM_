/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectobbdd2;

/**
 *
 * @author 6002755
 */



public class Comanda {
    
    private int refresco;
    private int cafe;
    private int cerveza;
    private int infusion;
    private int bocadillo;
    private int racion;

    public Comanda(int refresco, int cafe, int cerveza, int infusion, int bocadillo, int racion) {
        this.refresco = refresco;
        this.cafe = cafe;
        this.cerveza = cerveza;
        this.infusion = infusion;
        this.bocadillo = bocadillo;
        this.racion = racion;
    }

    @Override
    public String toString() {
        return "refresco=" + refresco + ", cafe=" + cafe + ", cerveza=" + cerveza + ", infusion=" + infusion + ", bocadillo=" + bocadillo + ", racion=" + racion;
    }
    
    

    public int getRefresco() {
        return refresco;
    }

    public void setRefresco(int refresco) {
        this.refresco = refresco;
    }

    public int getCafe() {
        return cafe;
    }

    public void setCafe(int cafe) {
        this.cafe = cafe;
    }

    public int getCerveza() {
        return cerveza;
    }

    public void setCerveza(int cerveza) {
        this.cerveza = cerveza;
    }

    public int getInfusion() {
        return infusion;
    }

    public void setInfusion(int infusion) {
        this.infusion = infusion;
    }

    public int getBocadillo() {
        return bocadillo;
    }

    public void setBocadillo(int bocadillo) {
        this.bocadillo = bocadillo;
    }

    public int getRacion() {
        return racion;
    }

    public void setRacion(int racion) {
        this.racion = racion;
    }
    
    
    
}
