package Interfaz;

import Objetos.Cliente;
import Objetos.Habitacion;
import Nodos.Listas;
import java.time.LocalDate;

/**
 * Lógica de negocio del hotel. Gestiona operaciones CRUD,
 * check-in/check-out, facturación y control de habitaciones.
 */
public class Logica {
    private Listas habitacionesHotel;
    private double facturacionAcumulada;
    private int totalCheckIns;
    private int totalCheckOuts;
    private final int NUMERO_HABITACIONES = 10; // Hotel con 10 habitaciones
    
    /**
     * Constructor que inicializa el hotel con habitaciones vacías.
     */
    public Logica() {
        this.habitacionesHotel = new Listas(NUMERO_HABITACIONES);
        this.facturacionAcumulada = 0.0;
        this.totalCheckIns = 0;
        this.totalCheckOuts = 0;
    }
    
    /**
     * Realiza check-in automático en la primera habitación disponible.
     * @param cliente Cliente que realizará check-in
     * @return Número de habitación asignada, o -1 si no hay disponibles
     */
    public int realizarCheckInAutomatico(Cliente cliente) {
        int habitacionDisponible = habitacionesHotel.buscarPrimeraHabitacionDisponible();
        
        if (habitacionDisponible != -1) {
            boolean exito = habitacionesHotel.checkInPorPosicion(habitacionDisponible, cliente);
            if (exito) {
                totalCheckIns++;
                return habitacionDisponible;
            }
        }
        return -1;
    }
    
    /**
     * Realiza check-in en una habitación específica.
     * @param numeroHabitacion Número de habitación deseada
     * @param cliente Cliente que realizará check-in
     * @return true si el check-in fue exitoso
     */
    public boolean realizarCheckInPorPosicion(int numeroHabitacion, Cliente cliente) {
        if (habitacionesHotel.estaDisponiblePosicion(numeroHabitacion)) {
            boolean exito = habitacionesHotel.checkInPorPosicion(numeroHabitacion, cliente);
            if (exito) {
                totalCheckIns++;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Realiza check-out de una habitación específica y actualiza la facturación.
     * @param numeroHabitacion Número de habitación para check-out
     * @return Cliente que hizo check-out, o null si la habitación estaba vacía
     */
    public Cliente realizarCheckOut(int numeroHabitacion) {
        Cliente clienteSaliente = habitacionesHotel.checkOutPorPosicion(numeroHabitacion);
        
        if (clienteSaliente != null) {
            facturacionAcumulada += clienteSaliente.getCostoEstadia();
            totalCheckOuts++;
        }
        
        return clienteSaliente;
    }
    
    /**
     * Busca un cliente por ID en todas las habitaciones.
     * @param idCliente ID del cliente a buscar
     * @return Cliente encontrado o null si no existe
     */
    public Cliente buscarClientePorId(String idCliente) {
        return habitacionesHotel.buscarClientePorId(idCliente);
    }
    
    /**
     * Busca en qué habitación está hospedado un cliente.
     * @param idCliente ID del cliente a buscar
     * @return Número de habitación o -1 si no se encuentra
     */
    public int buscarHabitacionDeCliente(String idCliente) {
        return habitacionesHotel.buscarHabitacionPorClienteId(idCliente);
    }
    
    /**
     * Actualiza los datos de un cliente que ya está hospedado.
     * @param clienteActualizado Cliente con datos actualizados
     * @return true si la actualización fue exitosa
     */
    public boolean actualizarCliente(Cliente clienteActualizado) {
        int numeroHabitacion = buscarHabitacionDeCliente(clienteActualizado.getId());
        
        if (numeroHabitacion != -1) {
            Habitacion habitacion = habitacionesHotel.obtenerHabitacionPorPosicion(numeroHabitacion);
            if (habitacion != null && !habitacion.estaDisponible()) {
                // Actualizar los datos del cliente actual en la habitación
                Cliente clienteActual = habitacion.getClienteActual();
                clienteActual.setNombre(clienteActualizado.getNombre());
                clienteActual.setCelular(clienteActualizado.getCelular());
                clienteActual.setFechaIngreso(clienteActualizado.getFechaIngreso());
                clienteActual.setFechaSalida(clienteActualizado.getFechaSalida());
                return true;
            }
        }
        return false;
    }
    
    /**
     * Elimina un cliente realizando check-out forzado.
     * @param idCliente ID del cliente a eliminar
     * @return Cliente eliminado o null si no se encontró
     */
    public Cliente eliminarClientePorId(String idCliente) {
        int numeroHabitacion = buscarHabitacionDeCliente(idCliente);
        if (numeroHabitacion != -1) {
            return realizarCheckOut(numeroHabitacion);
        }
        return null;
    }
    
    /**
     * Verifica si una habitación específica está disponible.
     * @param numeroHabitacion Número de habitación a verificar
     * @return true si está disponible
     */
    public boolean verificarDisponibilidadHabitacion(int numeroHabitacion) {
        return habitacionesHotel.estaDisponiblePosicion(numeroHabitacion);
    }
    
    /**
     * Obtiene información de una habitación específica.
     * @param numeroHabitacion Número de habitación
     * @return Habitación o null si no existe
     */
    public Habitacion obtenerInformacionHabitacion(int numeroHabitacion) {
        return habitacionesHotel.obtenerHabitacionPorPosicion(numeroHabitacion);
    }
    
    /**
     * Obtiene todas las habitaciones para mostrar en la interfaz.
     * @return Array de todas las habitaciones
     */
    public Habitacion[] obtenerTodasLasHabitaciones() {
        return habitacionesHotel.obtenerHabitacionesArray();
    }
    
    /**
     * Calcula el porcentaje de ocupación del hotel.
     * @return Porcentaje de ocupación (0-100)
     */
    public double calcularPorcentajeOcupacion() {
        int ocupadas = habitacionesHotel.contarHabitacionesOcupadas();
        return (double) ocupadas / NUMERO_HABITACIONES * 100.0;
    }
    
    /**
     * Genera un reporte de ingresos proyectados basado en las reservas actuales.
     * @return Ingresos proyectados de huéspedes actuales
     */
    public double calcularIngresosProyectados() {
        double ingresosProyectados = 0.0;
        Habitacion[] habitaciones = obtenerTodasLasHabitaciones();
        
        for (Habitacion habitacion : habitaciones) {
            if (!habitacion.estaDisponible()) {
                ingresosProyectados += habitacion.getClienteActual().getCostoEstadia();
            }
        }
        
        return ingresosProyectados;
    }
    
    /**
     * Verifica si hay habitaciones disponibles para nuevos huéspedes.
     * @return true si hay al menos una habitación disponible
     */
    public boolean hayHabitacionesDisponibles() {
        return habitacionesHotel.contarHabitacionesDisponibles() > 0;
    }
    
    /**
     * Obtiene la lista de números de habitaciones disponibles.
     * @return Array con números de habitaciones disponibles
     */
    public int[] obtenerHabitacionesDisponibles() {
        Habitacion[] todasHabitaciones = obtenerTodasLasHabitaciones();
        int disponibles = habitacionesHotel.contarHabitacionesDisponibles();
        int[] habitacionesDisponibles = new int[disponibles];
        
        int index = 0;
        for (Habitacion habitacion : todasHabitaciones) {
            if (habitacion.estaDisponible()) {
                habitacionesDisponibles[index++] = habitacion.getNumero();
            }
        }
        
        return habitacionesDisponibles;
    }
    
    /**
     * Valida que las fechas de estadía sean correctas.
     * @param fechaIngreso Fecha de check-in
     * @param fechaSalida Fecha de check-out
     * @return true si las fechas son válidas
     */
    public boolean validarFechas(LocalDate fechaIngreso, LocalDate fechaSalida) {
        if (fechaIngreso == null || fechaSalida == null) {
            return false;
        }
        
        LocalDate hoy = LocalDate.now();
        
        // La fecha de ingreso no puede ser anterior a hoy
        if (fechaIngreso.isBefore(hoy)) {
            return false;
        }
        
        // La fecha de salida debe ser posterior a la de ingreso
        return fechaSalida.isAfter(fechaIngreso);
    }
    
    /**
     * Genera un resumen completo del estado del hotel.
     * @return String con estadísticas del hotel
     */
    public String generarResumenHotel() {
        StringBuilder resumen = new StringBuilder();
        resumen.append("=== RESUMEN DEL HOTEL ===\n");
        resumen.append("Habitaciones totales: ").append(NUMERO_HABITACIONES).append("\n");
        resumen.append("Habitaciones ocupadas: ").append(habitacionesHotel.contarHabitacionesOcupadas()).append("\n");
        resumen.append("Habitaciones disponibles: ").append(habitacionesHotel.contarHabitacionesDisponibles()).append("\n");
        resumen.append("Porcentaje de ocupacion: ").append(String.format("%.1f%%", calcularPorcentajeOcupacion())).append("\n");
        resumen.append("Total check-ins realizados: ").append(totalCheckIns).append("\n");
        resumen.append("Total check-outs realizados: ").append(totalCheckOuts).append("\n");
        resumen.append("Facturacion acumulada: $").append(String.format("%.2f", facturacionAcumulada)).append("\n");
        resumen.append("Ingresos proyectados actuales: $").append(String.format("%.2f", calcularIngresosProyectados())).append("\n");
        
        return resumen.toString();
    }
    
    /**
     * Reinicia las estadísticas del hotel (mantiene huéspedes actuales).
     */
    public void reiniciarEstadisticas() {
        this.facturacionAcumulada = 0.0;
        this.totalCheckIns = 0;
        this.totalCheckOuts = 0;
    }
    
    /**
     * Realiza check-out masivo de todas las habitaciones (para limpieza del hotel).
     * @return Cantidad de clientes que hicieron check-out
     */
    public int checkOutMasivo() {
        int clientesCheckOut = 0;
        double ingresosMasivos = 0.0;
        
        for (int i = 1; i <= NUMERO_HABITACIONES; i++) {
            Cliente cliente = habitacionesHotel.checkOutPorPosicion(i);
            if (cliente != null) {
                ingresosMasivos += cliente.getCostoEstadia();
                clientesCheckOut++;
            }
        }
        
        facturacionAcumulada += ingresosMasivos;
        totalCheckOuts += clientesCheckOut;
        
        return clientesCheckOut;
    }
    
    // Getters para estadísticas
    public double getFacturacionAcumulada() {
        return facturacionAcumulada;
    }
    
    public int getTotalCheckIns() {
        return totalCheckIns;
    }
    
    public int getTotalCheckOuts() {
        return totalCheckOuts;
    }
    
    public int getNumeroHabitaciones() {
        return NUMERO_HABITACIONES;
    }
    
    public int getHabitacionesOcupadas() {
        return habitacionesHotel.contarHabitacionesOcupadas();
    }
    
    public int getHabitacionesDisponibles() {
        return habitacionesHotel.contarHabitacionesDisponibles();
    }
    
    /**
     * Verifica si la estructura de habitaciones es circular.
     * @return true si la lista es circular
     */
    public boolean verificarEstructuraCircular() {
        return habitacionesHotel.esCircular();
    }
}