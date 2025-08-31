package Interfaz;

import Nodos.Logica;
import Objetos.Cliente;
import Objetos.Habitacion;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Clase de prueba para verificar todas las funcionalidades del sistema del hotel
 * COLOCA ESTE ARCHIVO EN: src/Interfaz/TestHotel.java
 * 
 * Para ejecutar: Clic derecho en el archivo > Run File
 * @author USUARIO
 */
public class TestHotel {
    private static Logica hotel;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("    SISTEMA DE GESTION DE HOTEL - PRUEBAS");
        System.out.println("==============================================");
        
        hotel = new Logica();
        scanner = new Scanner(System.in);
        
        // Ejecutar todas las pruebas automaticamente
        ejecutarPruebasAutomaticas();
        
        // Menu interactivo para pruebas manuales
        mostrarMenuInteractivo();
    }
    
    /**
     * Ejecuta todas las pruebas del CRUD automaticamente
     */
    private static void ejecutarPruebasAutomaticas() {
        System.out.println("\n>>> INICIANDO PRUEBAS AUTOMATICAS DEL CRUD <<<\n");
        
        // 1. Prueba de estructura inicial
        pruebaEstructuraInicial();
        
        // 2. Pruebas de CREATE (Check-in)
        pruebasCreate();
        
        // 3. Pruebas de READ (Busquedas)
        pruebasRead();
        
        // 4. Pruebas de UPDATE (Actualizacion)
        pruebasUpdate();
        
        // 5. Pruebas de DELETE (Check-out)
        pruebasDelete();
        
        // 6. Pruebas avanzadas
        pruebasAvanzadas();
        
        System.out.println("\n>>> PRUEBAS AUTOMATICAS COMPLETADAS <<<\n");
    }
    
    private static void pruebaEstructuraInicial() {
        System.out.println("--- PRUEBA 1: ESTRUCTURA INICIAL ---");
        
        System.out.println("Verificando estructura circular: " + hotel.verificarEstructuraCircular());
        System.out.println("Habitaciones disponibles: " + hotel.getHabitacionesDisponibles());
        System.out.println("Habitaciones ocupadas: " + hotel.getHabitacionesOcupadas());
        System.out.println("Porcentaje de ocupacion: " + String.format("%.1f%%", hotel.calcularPorcentajeOcupacion()));
        
        System.out.println("- Estructura inicial verificada\n");
    }
    
    private static void pruebasCreate() {
        System.out.println("--- PRUEBA 2: CREATE (CHECK-IN) ---");
        
        // Check-in automatico
        Cliente cliente1 = new Cliente("001", "Juan Perez", "3001234567", 3);
        int habitacion1 = hotel.realizarCheckInAutomatico(cliente1);
        System.out.println("Check-in automatico - Cliente: " + cliente1.getNombre() + 
                          " asignado a habitacion: " + habitacion1);
        
        // Check-in por posicion especifica
        Cliente cliente2 = new Cliente("002", "Maria Garcia", "3007654321", 
                                     LocalDate.now().plusDays(1), LocalDate.now().plusDays(5));
        boolean exito2 = hotel.realizarCheckInPorPosicion(5, cliente2);
        System.out.println("Check-in habitacion 5 - Cliente: " + cliente2.getNombre() + 
                          " - Exito: " + exito2);
        
        // Mas clientes para pruebas
        Cliente cliente3 = new Cliente("003", "Carlos Lopez", "3009876543", 2);
        Cliente cliente4 = new Cliente("004", "Ana Martinez", "3005551234", 4);
        Cliente cliente5 = new Cliente("005", "Luis Rodriguez", "3008887777", 1);
        
        hotel.realizarCheckInAutomatico(cliente3);
        hotel.realizarCheckInAutomatico(cliente4);
        hotel.realizarCheckInAutomatico(cliente5);
        
        System.out.println("Total check-ins realizados: " + hotel.getTotalCheckIns());
        System.out.println("Habitaciones ocupadas ahora: " + hotel.getHabitacionesOcupadas());
        
        // Intentar check-in en habitacion ocupada
        Cliente clienteError = new Cliente("006", "Pedro Silva", "3001111111", 2);
        boolean errorCheckIn = hotel.realizarCheckInPorPosicion(1, clienteError);
        System.out.println("Intento check-in en habitacion ocupada (debe fallar): " + errorCheckIn);
        
        System.out.println("- Pruebas CREATE completadas\n");
    }
    
    private static void pruebasRead() {
        System.out.println("--- PRUEBA 3: READ (BUSQUEDAS) ---");
        
        // Buscar por ID
        Cliente clienteEncontrado = hotel.buscarClientePorId("002");
        System.out.println("Busqueda por ID '002': " + 
                          (clienteEncontrado != null ? clienteEncontrado.getNombre() : "No encontrado"));
        
        // Buscar habitacion de cliente
        int habitacionCliente = hotel.buscarHabitacionDeCliente("003");
        System.out.println("Habitacion del cliente '003': " + habitacionCliente);
        
        // Verificar disponibilidad
        System.out.println("Habitacion 1 disponible: " + hotel.verificarDisponibilidadHabitacion(1));
        System.out.println("Habitacion 8 disponible: " + hotel.verificarDisponibilidadHabitacion(8));
        
        // Informacion de habitacion especifica
        Habitacion habitacion5 = hotel.obtenerInformacionHabitacion(5);
        System.out.println("Info habitacion 5: " + 
                          (habitacion5 != null ? habitacion5.getEstadoResumido() : "No encontrada"));
        
        // Mostrar habitaciones disponibles
        int[] disponibles = hotel.obtenerHabitacionesDisponibles();
        System.out.print("Habitaciones disponibles: ");
        for (int hab : disponibles) {
            System.out.print(hab + " ");
        }
        System.out.println();
        
        System.out.println("- Pruebas READ completadas\n");
    }
    
    private static void pruebasUpdate() {
        System.out.println("--- PRUEBA 4: UPDATE (ACTUALIZACION) ---");
        
        // Actualizar datos de cliente
        Cliente clienteActualizado = new Cliente("001", "Juan Perez Actualizado", "3001234999", 
                                               LocalDate.now(), LocalDate.now().plusDays(5));
        boolean actualizacionExitosa = hotel.actualizarCliente(clienteActualizado);
        System.out.println("Actualizacion cliente '001': " + actualizacionExitosa);
        
        // Verificar actualizacion
        Cliente clienteVerificacion = hotel.buscarClientePorId("001");
        System.out.println("Datos actualizados: " + 
                          (clienteVerificacion != null ? clienteVerificacion.toString() : "Error"));
        
        // Intentar actualizar cliente inexistente
        Cliente clienteInexistente = new Cliente("999", "Inexistente", "0000000000", 1);
        boolean errorUpdate = hotel.actualizarCliente(clienteInexistente);
        System.out.println("Actualizacion cliente inexistente (debe fallar): " + errorUpdate);
        
        System.out.println("- Pruebas UPDATE completadas\n");
    }
    
    private static void pruebasDelete() {
        System.out.println("--- PRUEBA 5: DELETE (CHECK-OUT) ---");
        
        double facturacionAntes = hotel.getFacturacionAcumulada();
        System.out.println("Facturacion antes del check-out: $" + String.format("%.2f", facturacionAntes));
        
        // Check-out normal
        Cliente clienteCheckOut = hotel.realizarCheckOut(1);
        System.out.println("Check-out habitacion 1: " + 
                          (clienteCheckOut != null ? clienteCheckOut.getNombre() : "Habitacion vacia"));
        
        double facturacionDespues = hotel.getFacturacionAcumulada();
        System.out.println("Facturacion despues del check-out: $" + String.format("%.2f", facturacionDespues));
        System.out.println("Ingresos generados: $" + String.format("%.2f", facturacionDespues - facturacionAntes));
        
        // Eliminar cliente por ID
        Cliente clienteEliminado = hotel.eliminarClientePorId("003");
        System.out.println("Eliminacion por ID '003': " + 
                          (clienteEliminado != null ? clienteEliminado.getNombre() : "No encontrado"));
        
        System.out.println("Total check-outs realizados: " + hotel.getTotalCheckOuts());
        System.out.println("Habitaciones ocupadas ahora: " + hotel.getHabitacionesOcupadas());
        
        // Intentar check-out en habitacion vacia
        Cliente checkOutVacio = hotel.realizarCheckOut(1);
        System.out.println("Intento check-out habitacion vacia (debe fallar): " + (checkOutVacio == null));
        
        System.out.println("- Pruebas DELETE completadas\n");
    }
    
    private static void pruebasAvanzadas() {
        System.out.println("--- PRUEBA 6: FUNCIONES AVANZADAS ---");
        
        // Porcentaje de ocupacion
        System.out.println("Porcentaje de ocupacion: " + String.format("%.1f%%", hotel.calcularPorcentajeOcupacion()));
        
        // Ingresos proyectados
        System.out.println("Ingresos proyectados: $" + String.format("%.2f", hotel.calcularIngresosProyectados()));
        
        // Validacion de fechas
        LocalDate fechaValidaIn = LocalDate.now();
        LocalDate fechaValidaOut = LocalDate.now().plusDays(3);
        System.out.println("Fechas validas (hoy a +3 dias): " + hotel.validarFechas(fechaValidaIn, fechaValidaOut));
        
        LocalDate fechaInvalidaIn = LocalDate.now().minusDays(1);
        LocalDate fechaInvalidaOut = LocalDate.now();
        System.out.println("Fechas invalidas (ayer a hoy): " + hotel.validarFechas(fechaInvalidaIn, fechaInvalidaOut));
        
        // Resumen completo
        System.out.println("\nResumen del hotel:");
        System.out.println(hotel.generarResumenHotel());
        
        // Check-out masivo
        int clientesMasivo = hotel.checkOutMasivo();
        System.out.println("Check-out masivo: " + clientesMasivo + " clientes liberados");
        System.out.println("Habitaciones disponibles despues: " + hotel.getHabitacionesDisponibles());
        
        // Reiniciar estadisticas
        hotel.reiniciarEstadisticas();
        System.out.println("Estadisticas reiniciadas - Check-ins: " + hotel.getTotalCheckIns() + 
                           ", Check-outs: " + hotel.getTotalCheckOuts() + 
                           ", Facturacion: $" + String.format("%.2f", hotel.getFacturacionAcumulada()));
        
        System.out.println("- Pruebas avanzadas completadas\n");
    }
    
    private static void mostrarMenuInteractivo() {
        boolean salir = false;
        
        while (!salir) {
            mostrarMenu();
            int opcion = Integer.parseInt(scanner.nextLine());
            
            switch (opcion) {
                case 1 -> realizarCheckInManual();
                case 2 -> realizarCheckOutManual();
                case 3 -> buscarClienteManual();
                case 4 -> mostrarEstadoHotel();
                case 5 -> mostrarTodasLasHabitaciones();
                case 6 -> actualizarClienteManual();
                case 7 -> pruebaCheckOutMasivo();
                case 8 -> reiniciarEstadisticas();
                case 9 -> pruebaValidacionFechas();
                case 0 -> salir = true;
                default -> System.out.println("Opcion invalida. Intente nuevamente.");
            }
        }
        
        System.out.println("\nGracias por usar el sistema de pruebas del hotel!");
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=== MENU INTERACTIVO DE PRUEBAS ===");
        System.out.println("1. Realizar Check-in Manual");
        System.out.println("2. Realizar Check-out Manual");
        System.out.println("3. Buscar Cliente");
        System.out.println("4. Mostrar Estado del Hotel");
        System.out.println("5. Mostrar Todas las Habitaciones");
        System.out.println("6. Actualizar Cliente");
        System.out.println("7. Check-out Masivo");
        System.out.println("8. Reiniciar Estadisticas");
        System.out.println("9. Probar Validacion de Fechas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    
    private static void realizarCheckInManual() {
        System.out.println("\n--- CHECK-IN MANUAL ---");
        
        System.out.print("ID del cliente: ");
        String id = scanner.nextLine();
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        
        System.out.print("Dias de estadia: ");
        int dias = Integer.parseInt(scanner.nextLine());
        
        Cliente cliente = new Cliente(id, nombre, telefono, dias);
        
        System.out.print("Check-in automatico? (s/n): ");
        String respuesta = scanner.nextLine();
        
        if (respuesta.toLowerCase().startsWith("s")) {
            int habitacion = hotel.realizarCheckInAutomatico(cliente);
            if (habitacion != -1) {
                System.out.println("Check-in exitoso en habitacion: " + habitacion);
                System.out.println("Costo total: $" + String.format("%.2f", cliente.getCostoEstadia()));
            } else {
                System.out.println("No hay habitaciones disponibles.");
            }
        } else {
            System.out.print("Numero de habitacion deseada (1-10): ");
            int habitacion = Integer.parseInt(scanner.nextLine());
            
            if (hotel.realizarCheckInPorPosicion(habitacion, cliente)) {
                System.out.println("Check-in exitoso en habitacion: " + habitacion);
                System.out.println("Costo total: $" + String.format("%.2f", cliente.getCostoEstadia()));
            } else {
                System.out.println("Error: Habitacion no disponible o numero invalido.");
            }
        }
    }
    
    private static void realizarCheckOutManual() {
        System.out.println("\n--- CHECK-OUT MANUAL ---");
        
        System.out.print("Numero de habitacion (1-10): ");
        int habitacion = Integer.parseInt(scanner.nextLine());
        
        Cliente cliente = hotel.realizarCheckOut(habitacion);
        
        if (cliente != null) {
            System.out.println("Check-out exitoso!");
            System.out.println("Cliente: " + cliente.toString());
            System.out.println("Facturacion actualizada: $" + String.format("%.2f", hotel.getFacturacionAcumulada()));
        } else {
            System.out.println("Error: Habitacion vacia o numero invalido.");
        }
    }
    
    private static void buscarClienteManual() {
        System.out.println("\n--- BUSQUEDA DE CLIENTE ---");
        
        System.out.print("ID del cliente a buscar: ");
        String id = scanner.nextLine();
        
        Cliente cliente = hotel.buscarClientePorId(id);
        
        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            System.out.println(cliente.toString());
            
            int habitacion = hotel.buscarHabitacionDeCliente(id);
            System.out.println("Habitacion actual: " + habitacion);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    
    private static void mostrarEstadoHotel() {
        System.out.println("\n--- ESTADO COMPLETO DEL HOTEL ---");
        System.out.println(hotel.generarResumenHotel());
    }
    
    private static void mostrarTodasLasHabitaciones() {
        System.out.println("\n--- TODAS LAS HABITACIONES ---");
        
        Habitacion[] habitaciones = hotel.obtenerTodasLasHabitaciones();
        
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion.toString());
            System.out.println("-".repeat(50));
        }
    }
    
    private static void actualizarClienteManual() {
        System.out.println("\n--- ACTUALIZAR CLIENTE ---");
        
        System.out.print("ID del cliente a actualizar: ");
        String id = scanner.nextLine();
        
        Cliente clienteActual = hotel.buscarClientePorId(id);
        
        if (clienteActual != null) {
            System.out.println("Cliente actual: " + clienteActual.toString());
            
            System.out.print("Nuevo nombre (Enter para mantener actual): ");
            String nombre = scanner.nextLine();
            if (nombre.isEmpty()) nombre = clienteActual.getNombre();
            
            System.out.print("Nuevo telefono (Enter para mantener actual): ");
            String telefono = scanner.nextLine();
            if (telefono.isEmpty()) telefono = clienteActual.getCelular();
            
            Cliente clienteActualizado = new Cliente(id, nombre, telefono, 
                                                   clienteActual.getFechaIngreso(), 
                                                   clienteActual.getFechaSalida());
            
            if (hotel.actualizarCliente(clienteActualizado)) {
                System.out.println("Cliente actualizado exitosamente!");
            } else {
                System.out.println("Error al actualizar cliente.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    
    private static void pruebaCheckOutMasivo() {
        System.out.println("\n--- CHECK-OUT MASIVO ---");
        
        double facturacionAntes = hotel.getFacturacionAcumulada();
        int clientesAntes = hotel.getHabitacionesOcupadas();
        
        System.out.println("Clientes hospedados antes: " + clientesAntes);
        System.out.println("Facturacion antes: $" + String.format("%.2f", facturacionAntes));
        
        System.out.print("Esta seguro de realizar check-out masivo? (s/n): ");
        String confirmacion = scanner.nextLine();
        
        if (confirmacion.toLowerCase().startsWith("s")) {
            int clientesCheckOut = hotel.checkOutMasivo();
            
            System.out.println("Check-out masivo completado!");
            System.out.println("Clientes que hicieron check-out: " + clientesCheckOut);
            System.out.println("Nueva facturacion: $" + String.format("%.2f", hotel.getFacturacionAcumulada()));
            System.out.println("Ingresos generados: $" + String.format("%.2f", 
                              hotel.getFacturacionAcumulada() - facturacionAntes));
        } else {
            System.out.println("Check-out masivo cancelado.");
        }
    }
    
    private static void reiniciarEstadisticas() {
        System.out.println("\n--- REINICIAR ESTADISTICAS ---");
        
        System.out.println("Estadisticas actuales:");
        System.out.println("Check-ins: " + hotel.getTotalCheckIns());
        System.out.println("Check-outs: " + hotel.getTotalCheckOuts());
        System.out.println("Facturacion: $" + String.format("%.2f", hotel.getFacturacionAcumulada()));
        
        System.out.print("Reiniciar estadisticas? (s/n): ");
        String confirmacion = scanner.nextLine();
        
        if (confirmacion.toLowerCase().startsWith("s")) {
            hotel.reiniciarEstadisticas();
            System.out.println("Estadisticas reiniciadas. Los huespedes actuales se mantienen.");
        } else {
            System.out.println("Reinicio cancelado.");
        }
    }
    
    private static void pruebaValidacionFechas() {
        System.out.println("\n--- VALIDACION DE FECHAS ---");
        
        System.out.print("Ingrese fecha de ingreso (YYYY-MM-DD): ");
        LocalDate ingreso = LocalDate.parse(scanner.nextLine());
        
        System.out.print("Ingrese fecha de salida (YYYY-MM-DD): ");
        LocalDate salida = LocalDate.parse(scanner.nextLine());
        
        boolean valido = hotel.validarFechas(ingreso, salida);
        System.out.println("Fechas validas: " + valido);
        
        if (valido) {
            long dias = ChronoUnit.DAYS.between(ingreso, salida);
            double costo = dias * Cliente.getPrecioPorNoche();
            System.out.println("Dias de estadia: " + dias);
            System.out.println("Costo estimado: $" + String.format("%.2f", costo));
        } else {
            System.out.println("Razones posibles: Fecha ingreso anterior a hoy o salida no posterior a ingreso.");
        }
    }
}
