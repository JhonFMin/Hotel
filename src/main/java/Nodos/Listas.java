package Nodos;

import Objetos.Habitacion;
import Objetos.Cliente;
import Nodos.Nodo;

/**
 * Implementación de Lista Doblemente Enlazada Circular para gestionar habitaciones
 * @author USUARIO
 */
public class Listas {
    private Nodo cabeza;
    private int tamaño;
    private int numeroHabitaciones;
    
    /**
     * Constructor que inicializa la lista con un número específico de habitaciones
     */
    public Listas(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
        this.tamaño = 0;
        this.cabeza = null;
        inicializarHabitaciones();
    }
    
    /**
     * Inicializa todas las habitaciones del hotel
     */
    private void inicializarHabitaciones() {
        for (int i = 1; i <= numeroHabitaciones; i++) {
            Habitacion habitacion = new Habitacion(i);
            insertarHabitacion(habitacion);
        }
    }
    
    /**
     * Inserta una habitación en la lista circular
     */
    private void insertarHabitacion(Habitacion habitacion) {
        Nodo nuevoNodo = new Nodo(habitacion);
        
        if (cabeza == null) {
            // Primera habitación - crear lista circular
            cabeza = nuevoNodo;
            nuevoNodo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(nuevoNodo);
        } else {
            // Insertar al final de la lista circular
            Nodo ultimo = cabeza.getAnterior();
            
            nuevoNodo.setSiguiente(cabeza);
            nuevoNodo.setAnterior(ultimo);
            
            ultimo.setSiguiente(nuevoNodo);
            cabeza.setAnterior(nuevoNodo);
        }
        
        tamaño++;
    }
    
    /**
     * Busca la primera habitación disponible
     */
    public int buscarPrimeraHabitacionDisponible() {
        if (cabeza == null) return -1;
        
        Nodo actual = cabeza;
        do {
            if (actual.getHabitacion().estaDisponible()) {
                return actual.getHabitacion().getNumero();
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        return -1; // No hay habitaciones disponibles
    }
    
    /**
     * Realiza check-in por posición específica
     */
    public boolean checkInPorPosicion(int numeroHabitacion, Cliente cliente) {
        Nodo nodo = buscarNodoPorNumero(numeroHabitacion);
        
        if (nodo != null && nodo.getHabitacion().estaDisponible()) {
            return nodo.getHabitacion().realizarCheckIn(cliente);
        }
        
        return false;
    }
    
    /**
     * Realiza check-out por posición específica
     */
    public Cliente checkOutPorPosicion(int numeroHabitacion) {
        Nodo nodo = buscarNodoPorNumero(numeroHabitacion);
        
        if (nodo != null && !nodo.getHabitacion().estaDisponible()) {
            return nodo.getHabitacion().realizarCheckOut();
        }
        
        return null;
    }
    
    /**
     * Busca un nodo por número de habitación
     */
    private Nodo buscarNodoPorNumero(int numeroHabitacion) {
        if (cabeza == null) return null;
        
        Nodo actual = cabeza;
        do {
            if (actual.getHabitacion().getNumero() == numeroHabitacion) {
                return actual;
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        return null;
    }
    
    /**
     * Busca un cliente por ID en todas las habitaciones
     */
    public Cliente buscarClientePorId(String idCliente) {
        if (cabeza == null || idCliente == null) return null;
        
        Nodo actual = cabeza;
        do {
            Habitacion habitacion = actual.getHabitacion();
            if (!habitacion.estaDisponible() && habitacion.tieneCliente(idCliente)) {
                return habitacion.getClienteActual();
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        return null;
    }
    
    /**
     * Busca clientes por nombre (búsqueda parcial)
     */
    public Cliente[] buscarClientesPorNombre(String nombre) {
        if (cabeza == null || nombre == null) return new Cliente[0];
        
        Cliente[] resultadosTemp = new Cliente[numeroHabitaciones];
        int contador = 0;
        
        Nodo actual = cabeza;
        do {
            Habitacion habitacion = actual.getHabitacion();
            if (!habitacion.estaDisponible() && habitacion.clienteCoincideNombre(nombre)) {
                resultadosTemp[contador++] = habitacion.getClienteActual();
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        // Crear array del tamaño exacto
        Cliente[] resultados = new Cliente[contador];
        System.arraycopy(resultadosTemp, 0, resultados, 0, contador);
        return resultados;
    }
    
    /**
     * Busca cliente por teléfono
     */
    public Cliente buscarClientePorTelefono(String telefono) {
        if (cabeza == null || telefono == null) return null;
        
        Nodo actual = cabeza;
        do {
            Habitacion habitacion = actual.getHabitacion();
            if (!habitacion.estaDisponible() && habitacion.clienteCoincideTelefono(telefono)) {
                return habitacion.getClienteActual();
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        return null;
    }
    
    /**
     * Busca en qué habitación está un cliente por ID
     */
    public int buscarHabitacionPorClienteId(String idCliente) {
        if (cabeza == null || idCliente == null) return -1;
        
        Nodo actual = cabeza;
        do {
            Habitacion habitacion = actual.getHabitacion();
            if (!habitacion.estaDisponible() && habitacion.tieneCliente(idCliente)) {
                return habitacion.getNumero();
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        return -1;
    }
    
    /**
     * Verifica si una habitación específica está disponible
     */
    public boolean estaDisponiblePosicion(int numeroHabitacion) {
        Nodo nodo = buscarNodoPorNumero(numeroHabitacion);
        return nodo != null && nodo.getHabitacion().estaDisponible();
    }
    
    /**
     * Obtiene una habitación por posición
     */
    public Habitacion obtenerHabitacionPorPosicion(int numeroHabitacion) {
        Nodo nodo = buscarNodoPorNumero(numeroHabitacion);
        return nodo != null ? nodo.getHabitacion() : null;
    }
    
    /**
     * Obtiene todas las habitaciones como array
     */
    public Habitacion[] obtenerHabitacionesArray() {
        if (cabeza == null) return new Habitacion[0];
        
        Habitacion[] habitaciones = new Habitacion[numeroHabitaciones];
        Nodo actual = cabeza;
        int indice = 0;
        
        do {
            habitaciones[indice++] = actual.getHabitacion();
            actual = actual.getSiguiente();
        } while (actual != cabeza && indice < numeroHabitaciones);
        
        return habitaciones;
    }
    
    /**
     * Cuenta habitaciones ocupadas
     */
    public int contarHabitacionesOcupadas() {
        if (cabeza == null) return 0;
        
        int ocupadas = 0;
        Nodo actual = cabeza;
        do {
            if (!actual.getHabitacion().estaDisponible()) {
                ocupadas++;
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        return ocupadas;
    }
    
    /**
     * Cuenta habitaciones disponibles
     */
    public int contarHabitacionesDisponibles() {
        return numeroHabitaciones - contarHabitacionesOcupadas();
    }
    
    /**
     * Verifica si la estructura es circular
     */
    public boolean esCircular() {
        if (cabeza == null) return true;
        
        try {
            Nodo actual = cabeza;
            int contador = 0;
            
            do {
                actual = actual.getSiguiente();
                contador++;
                
                // Evitar bucle infinito en caso de error
                if (contador > numeroHabitaciones + 1) {
                    return false;
                }
                
            } while (actual != null && actual != cabeza);
            
            return actual == cabeza;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Obtiene información completa del estado de la lista
     */
    public String obtenerEstadoCompleto() {
        StringBuilder estado = new StringBuilder();
        estado.append("=== ESTADO DE HABITACIONES ===\n");
        
        if (cabeza == null) {
            estado.append("No hay habitaciones inicializadas.\n");
            return estado.toString();
        }
        
        Nodo actual = cabeza;
        do {
            estado.append(actual.getHabitacion().toString()).append("\n\n");
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        estado.append("Total habitaciones: ").append(numeroHabitaciones).append("\n");
        estado.append("Ocupadas: ").append(contarHabitacionesOcupadas()).append("\n");
        estado.append("Disponibles: ").append(contarHabitacionesDisponibles()).append("\n");
        estado.append("Estructura circular: ").append(esCircular() ? "SÍ" : "NO").append("\n");
        
        return estado.toString();
    }
    
    // Getters
    public int getTamaño() {
        return tamaño;
    }
    
    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }
    
    public boolean estaVacia() {
        return cabeza == null;
    }
}