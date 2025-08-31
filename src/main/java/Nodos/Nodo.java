package Nodos;

import Objetos.Habitacion;
//ssa

public class Nodo {
    private Habitacion habitacion;
    private Nodo siguiente;
    private Nodo anterior;
    

    public Nodo(Habitacion habitacion) {
        this.habitacion = habitacion;
        this.siguiente = null;
        this.anterior = null;
    }
    
    /**
     * Constructor que crea un nodo circular (apunta a sí mismo)
     */
    public Nodo(Habitacion habitacion, boolean circular) {
        this.habitacion = habitacion;
        if (circular) {
            this.siguiente = this;
            this.anterior = this;
        } else {
            this.siguiente = null;
            this.anterior = null;
        }
    }
    
    // Getters y Setters
    public Habitacion getHabitacion() {
        return habitacion;
    }
    
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
    public Nodo getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    public Nodo getAnterior() {
        return anterior;
    }
    
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
    /**
     * Verifica si este nodo es el único en la lista (circular)
     */
    public boolean esSoloEnLista() {
        return siguiente == this && anterior == this;
    }
    
    /**
     * Inserta un nuevo nodo después de este nodo
     */
    public void insertarDespues(Nodo nuevoNodo) {
        if (nuevoNodo != null) {
            nuevoNodo.setAnterior(this);
            nuevoNodo.setSiguiente(this.siguiente);
            
            if (this.siguiente != null) {
                this.siguiente.setAnterior(nuevoNodo);
            }
            
            this.siguiente = nuevoNodo;
        }
    }
    
    /**
     * Inserta un nuevo nodo antes de este nodo
     */
    public void insertarAntes(Nodo nuevoNodo) {
        if (nuevoNodo != null) {
            nuevoNodo.setSiguiente(this);
            nuevoNodo.setAnterior(this.anterior);
            
            if (this.anterior != null) {
                this.anterior.setSiguiente(nuevoNodo);
            }
            
            this.anterior = nuevoNodo;
        }
    }
    
    /**
     * Desconecta este nodo de la lista
     */
    public void desconectar() {
        if (siguiente != null && siguiente != this) {
            siguiente.setAnterior(anterior);
        }
        
        if (anterior != null && anterior != this) {
            anterior.setSiguiente(siguiente);
        }
        
        // Si es el único nodo en la lista circular
        if (siguiente == this && anterior == this) {
            siguiente = null;
            anterior = null;
        }
    }
    
    @Override
    public String toString() {
        return String.format("Nodo[Habitación: %d, Disponible: %s]", 
            habitacion.getNumero(), 
            habitacion.estaDisponible() ? "Sí" : "No");
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Nodo nodo = (Nodo) obj;
        return habitacion != null ? habitacion.equals(nodo.habitacion) : nodo.habitacion == null;
    }
    
    @Override
    public int hashCode() {
        return habitacion != null ? habitacion.hashCode() : 0;
    }
}