package Objetos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Clase que representa un cliente del hotel
 * @author USUARIO
 */
public class Cliente {
    private String id;
    private String nombre;
    private String celular;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private static final double PRECIO_POR_NOCHE = 100000; // Precio fijo por noche
    
    /**
     * Constructor completo
     */
    public Cliente(String id, String nombre, String celular, LocalDate fechaIngreso, LocalDate fechaSalida) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }
    
    /**
     * Constructor con fechas actuales (check-in inmediato)
     */
    public Cliente(String id, String nombre, String celular, int diasEstadia) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.fechaIngreso = LocalDate.now();
        this.fechaSalida = LocalDate.now().plusDays(diasEstadia);
    }
    
    /**
     * Calcula el costo total de la estadía
     */
    public double getCostoEstadia() {
        if (fechaIngreso != null && fechaSalida != null) {
            long dias = ChronoUnit.DAYS.between(fechaIngreso, fechaSalida);
            return dias * PRECIO_POR_NOCHE;
        }
        return 0.0;
    }
    
    /**
     * Calcula los días de estadía
     */
    public long getDiasEstadia() {
        if (fechaIngreso != null && fechaSalida != null) {
            return ChronoUnit.DAYS.between(fechaIngreso, fechaSalida);
        }
        return 0;
    }
    
    // Getters y Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCelular() {
        return celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public LocalDate getFechaSalida() {
        return fechaSalida;
    }
    
    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    public static double getPrecioPorNoche() {
        return PRECIO_POR_NOCHE;
    }
    
    @Override
    public String toString() {
        return String.format("Cliente[ID: %s, Nombre: %s, Telefono: %s, Ingreso: %s, Salida: %s, Dias: %d, Costo: $%.2f]",
                id, nombre, celular, fechaIngreso, fechaSalida, getDiasEstadia(), getCostoEstadia());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return id != null ? id.equals(cliente.id) : cliente.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}