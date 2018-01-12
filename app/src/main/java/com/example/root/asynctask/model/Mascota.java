package com.example.root.asynctask.model;

/**
 * Created by root on 11-01-18.
 */

public class Mascota {
    private int id;
    private String nombre;
    private String raza;
    private String genero;
    private float peso;

    public Mascota() {
    }

    public Mascota(String nombre, String raza, String genero, float peso) {
        this.nombre = nombre;
        this.raza = raza;
        this.genero = genero;
        this.peso = peso;
    }

    public Mascota(int id, String nombre, String raza, String genero, float peso) {

        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.genero= genero;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
