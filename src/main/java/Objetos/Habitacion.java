package Objetos;

/**
 * Clase que representa una habitacion del hotel
 * @author USUARIO
 */
public class Habitacion {
    private int numero;
    private boolean disponible;
    private Cliente clienteActual;
    private String tipo;
    
    /**
     * Constructor que inicializa una habitacion disponible
     */
    public Habitacion(int numero) {
        this.numero = numero;
        this.disponible = true;
        this.clienteActual = null;
        this.tipo = "Estandar";
    }
    
    /**
     * Constructor completo
     */
    public Habitacion(int numero, String tipo) {
        this.numero = numero;
        this.disponible = true;
        this.clienteActual = null;
        this.tipo = tipo;
    }
    
    /**
     * Realiza check-in de un cliente
     */
    public boolean realizarCheckIn(Cliente cliente) {
        if (disponible && cliente != null) {
            this.clienteActual = cliente;
            this.disponible = false;
            return true;
        }
        return false;
    }
    
    /**
     * Realiza check-out liberando la habitacion
     */
    public Cliente realizarCheckOut() {
        if (!disponible && clienteActual != null) {
            Cliente clienteSaliente = this.clienteActual;
            this.clienteActual = null;
            this.disponible = true;
            return clienteSaliente;
        }
        return null;
    }
    
    /**
     * Verifica si la habitacion esta disponible
     */
    public boolean estaDisponible() {
        return disponible;
    }
    
    /**
     * Obtiene informacion resumida de la habitacion
     */
    public String getEstadoResumido() {
        if (disponible) {
            return "Disponible";
        } else {
            return "Ocupada por: " + clienteActual.getNombre();
        }
    }
    
    /**
     * Verifica si un cliente especifico esta en esta habitacion
     */
    public boolean tieneCliente(String idCliente) {
        return !disponible && clienteActual != null && clienteActual.getId().equals(idCliente);
    }
    
    /**
     * Busca cliente por nombre (busqueda parcial)
     */
    public boolean clienteCoincideNombre(String nombre) {
        return !disponible && clienteActual != null && 
               clienteActual.getNombre().toLowerCase().contains(nombre.toLowerCase());
    }
    
    /**
      Busca cliente por telefono
     */
    public boolean clienteCoincideTelefono(String telefono) {
        return !disponible && clienteActual != null && 
               clienteActual.getCelular().equals(telefono);
    }
    
    // Getters y Setters
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public Cliente getClienteActual() {
        return clienteActual;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Fuerza el estado de disponibilidad (para mantenimiento)
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
        if (disponible) {
            this.clienteActual = null;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("Habitacion %d [%s] - ", numero, tipo));
        
        if (disponible) {
            info.append("DISPONIBLE");
        } else {
            info.append("OCUPADA");
            if (clienteActual != null) {
                info.append(String.format("\n  Cliente: %s (ID: %s)", 
                    clienteActual.getNombre(), clienteActual.getId()));
                info.append(String.format("\n  Telefono: %s", clienteActual.getCelular()));
                info.append(String.format("\n  Estadia: %s a %s (%d dias)", 
                    clienteActual.getFechaIngreso(), clienteActual.getFechaSalida(), 
                    clienteActual.getDiasEstadia()));
                info.append(String.format("\n  Costo: $%.2f", clienteActual.getCostoEstadia()));
            }
        }
        
        return info.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Habitacion that = (Habitacion) obj;
        return numero == that.numero;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(numero);
    }
}
