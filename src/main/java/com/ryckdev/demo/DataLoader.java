package com.ryckdev.demo;

import com.ryckdev.demo.Entity.ECliente;
import com.ryckdev.demo.Entity.EIncidente;
import com.ryckdev.demo.Entity.EServicio;
import com.ryckdev.demo.Entity.ETecnico;
import com.ryckdev.demo.Repository.RCliente;
import com.ryckdev.demo.Repository.RIncidente;
import com.ryckdev.demo.Repository.RServicio;
import com.ryckdev.demo.Repository.RTecnico;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@SpringBootApplication
@Transactional
@Component
public class DataLoader implements CommandLineRunner {

    private final RCliente clienteRepository;
    private final RTecnico tecnicoRepository;
    private final RServicio servicioRepository;
    private final RIncidente incidenteRepository;

    public DataLoader(RCliente clienteRepository, RTecnico tecnicoRepository,
                      RServicio servicioRepository, RIncidente incidenteRepository) {
        this.clienteRepository = clienteRepository;
        this.tecnicoRepository = tecnicoRepository;
        this.servicioRepository = servicioRepository;
        this.incidenteRepository = incidenteRepository;
    }

    @Override
    public void run(String... args) {
        // Crear clientes de prueba
        ECliente cliente1 = new ECliente();
        cliente1.setRazonSocial("Cliente1");
        cliente1.setCuit("123456789");
        ECliente cliente2 = new ECliente();
        cliente2.setRazonSocial("Cliente2");
        cliente2.setCuit("987654321");
        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));

        // Crear  técnicos de prueba
        ETecnico tecnico1 = new ETecnico();
        tecnico1.setNombre("Tecnico1");
        tecnico1.setEspecialidades("Especialidad1");
        tecnico1.setTiempoEstimadoPorDefecto(30);

        ETecnico tecnico2 = new ETecnico();
        tecnico2.setNombre("Tecnico2");
        tecnico2.setEspecialidades("Especialidad2");
        tecnico2.setTiempoEstimadoPorDefecto(45);

        tecnicoRepository.saveAll(Arrays.asList(tecnico1, tecnico2));

// Crear servicios
        EServicio servicio1 = new EServicio();
        servicio1.setNombre("Servicio1");
        servicio1.setTipoProblema("Problema1");
        servicio1.setTiempoMaximoResolucion(60);

        EServicio servicio2 = new EServicio();
        servicio2.setNombre("Servicio2");
        servicio2.setTipoProblema("Problema2");
        servicio2.setTiempoMaximoResolucion(90);

        servicioRepository.saveAll(Arrays.asList(servicio1, servicio2));


// Crear algunos incidentes
        EIncidente incidente3 = new EIncidente();
        incidente3.setDescripcionProblema("Descripción3");
        incidente3.setFechaIngreso(new Timestamp(LocalDate.now().minusDays(5).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli())); // Convertir LocalDate a Timestamp
        incidente3.setFechaPosibleResolucion(new Timestamp(LocalDate.now().minusDays(3).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli())); // Convertir LocalDate a Timestamp
        incidente3.setComplejo(true);
        incidente3.setHorasEstimadasColchon(8);
        incidente3.setCliente(cliente1);
        incidente3.setTecnico(tecnico1);
        incidente3.setServicio(servicio1);
        incidente3.setResuelto(true); // Marcar como resuelto
        incidente3.setTiempoResolucion(7); // Tiempo de resolución en horas

        EIncidente incidente4 = new EIncidente();
        incidente4.setDescripcionProblema("Descripción4");
        incidente4.setFechaIngreso(new Timestamp(LocalDate.now().minusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli())); // Convertir LocalDate a Timestamp
        incidente4.setFechaPosibleResolucion(new Timestamp(LocalDate.now().minusDays(5).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli())); // Convertir LocalDate a Timestamp
        incidente4.setComplejo(true);
        incidente4.setHorasEstimadasColchon(12);
        incidente4.setCliente(cliente2);
        incidente4.setTecnico(tecnico2);
        incidente4.setServicio(servicio2);
        incidente4.setResuelto(true);
        incidente4.setTiempoResolucion(10);
        incidenteRepository.saveAll(Arrays.asList(incidente3, incidente4));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una opción:");
        System.out.println("1. Recursos Humanos");
        System.out.println("2. Área Comercial");
        System.out.println("3. Mesa de Ayuda");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ha elegido Recursos Humanos.");
                System.out.println("Seleccione una opción:");
                System.out.println("1. Ingresar un nuevo técnico");
                System.out.println("2. Consulta para obtener incidentes de hoy");
                System.out.println("3. Consulta para obtener el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días");
                System.out.println("4. Consulta para obtener el técnico que más rápido resolvió los incidentes");
                System.out.println("5. Ingresar un nuevo servicio");

                int opcionRH = scanner.nextInt();

                switch (opcionRH) {
                    case 1:
                        System.out.println("Ingresar un nuevo técnico.");
                        System.out.println("Ingrese el nombre del técnico:");
                        String nombreTecnico = scanner.next();
                        System.out.println("Ingrese las especialidades del técnico:");
                        String especialidadesTecnico = scanner.next();
                        System.out.println("Ingrese el tiempo estimado por defecto del técnico:");
                        int tiempoEstimadoPorDefectoTecnico = scanner.nextInt();
                        tecnicoRepository.save(new ETecnico(null, nombreTecnico, especialidadesTecnico, tiempoEstimadoPorDefectoTecnico, null));
                        System.out.println("Técnico ingresado correctamente.");

                        break;
                    case 2:
                        System.out.println("Reporte de incidentes de hoy.");
                        Timestamp fechaHoy = new Timestamp(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
                        List<EIncidente> incidentesHoy = incidenteRepository.findIncidentesResueltosUltimosNDias(fechaHoy);
                        System.out.println("Incidentes resueltos hoy: " + incidentesHoy.size());

                        break;
                    case 3:
                        System.out.println("Consulta para obtener el técnico con más incidentes resueltos de una determinada especialidad en los últimos N días");
                        System.out.println("Ingrese la especialidad:");
                        String especialidad = scanner.next();
                        System.out.println("Ingrese la cantidad de días:");
                        int cantidadDias = scanner.nextInt();
                        Timestamp fechaLimite = new Timestamp(LocalDate.now().minusDays(cantidadDias).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
                        ETecnico tecnicoConMasIncidentesResueltosPorEspecialidadUltimosNDias = incidenteRepository.findTecnicoConMasIncidentesResueltosPorEspecialidadUltimosNDias(especialidad, fechaLimite);
                        System.out.println("El técnico con más incidentes resueltos de la especialidad " + especialidad + " en los últimos " + cantidadDias + " días es: " + tecnicoConMasIncidentesResueltosPorEspecialidadUltimosNDias.getNombre());
                    case 4:
                        System.out.println("Consulta para obtener el técnico que más rápido resolvió los incidentes");
                        ETecnico tecnicoMasRapidoResolviendo = incidenteRepository.findTecnicoMasRapidoResolviendo();
                        System.out.println("El técnico que más rápido resolvió los incidentes es: " + tecnicoMasRapidoResolviendo.getNombre());
                    case 5:
                        System.out.println("Ingresar un nuevo servicio.");
                        System.out.println("Ingrese el nombre del servicio:");
                        String nombreServicio = scanner.next();
                        System.out.println("Ingrese el tipo de problema del servicio:");
                        String tipoProblemaServicio = scanner.next();
                        System.out.println("Ingrese el tiempo máximo de resolución del servicio:");
                        int tiempoMaximoResolucionServicio = scanner.nextInt();
                        servicioRepository.save(new EServicio(null, nombreServicio, tipoProblemaServicio, tiempoMaximoResolucionServicio, null));
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
                break;
            case 2:
                System.out.println("Ha elegido Área Comercial.");
                System.out.println("Puede cargar un cliente con todos sus datos ingresándolos por consola.");
                System.out.println("Ingrese la razón social del cliente:");
                String razonSocial = scanner.next();
                System.out.println("Ingrese el CUIT del cliente:");
                String cuit = scanner.next();
                clienteRepository.save(new ECliente(null, razonSocial, cuit, null));

                break;
            case 3:
                System.out.println("Ha elegido Mesa de Ayuda.");
                System.out.println("Siga los pasos para crear un Incidente con todos sus atributos.");

                System.out.println("Ingrese la descripción del problema:");
                String descripcionProblema = scanner.nextLine();

                System.out.println("Ingrese la fecha de ingreso (en formato yyyy-MM-dd):");
                LocalDate fechaIngreso = LocalDate.parse(scanner.nextLine());

                System.out.println("Ingrese la fecha posible de resolución (en formato yyyy-MM-dd):");
                LocalDate fechaPosibleResolucion = LocalDate.parse(scanner.nextLine());

                System.out.println("¿Es un problema complejo? (true/false):");
                boolean complejo = Boolean.parseBoolean(scanner.nextLine());

                System.out.println("Ingrese las horas estimadas de colchón:");
                int horasEstimadasColchon = Integer.parseInt(scanner.nextLine());

                EIncidente incidente = new EIncidente();
                incidente.setDescripcionProblema(descripcionProblema);
                incidente.setFechaIngreso(new Timestamp(fechaIngreso.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()));
                incidente.setFechaPosibleResolucion(new Timestamp(fechaPosibleResolucion.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()));
                incidente.setComplejo(complejo);
                incidente.setHorasEstimadasColchon(horasEstimadasColchon);
                //asignar servicio
                System.out.println("Ingrese el id del servicio:");
                Long idServicio = scanner.nextLong();
                EServicio servicio = servicioRepository.findById(idServicio).orElse(null);
                incidente.setServicio(servicio);
                //asignar cliente
                System.out.println("Ingrese el id del cliente:");
                Long idCliente = scanner.nextLong();
                ECliente cliente = clienteRepository.findById(idCliente).orElse(null);
                incidente.setCliente(cliente);
                //mostrar lista de tecnicos que tengan ese servicio
                assert servicio != null;
                List<ETecnico> tecnicos = tecnicoRepository.findByEspecialidades(servicio.getTipoProblema());
                System.out.println("Tecnicos disponibles:");
                for (ETecnico tecnico : tecnicos) {
                    System.out.println(tecnico.getIdTecnico() + " - " + tecnico.getNombre());
                }
                //asignar tecnico
                System.out.println("Ingrese el id del técnico:");
                Long idTecnico = scanner.nextLong();
                ETecnico tecnico = tecnicoRepository.findById(idTecnico).orElse(null);
                incidente.setTecnico(tecnico);



                // Guarda el incidente en la base de datos
                incidenteRepository.save(incidente);

                System.out.println("Incidente creado exitosamente.");

                scanner.close();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        scanner.close();


        }




    }

