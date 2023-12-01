package com.ryckdev.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
@Data
@EqualsAndHashCode
@Entity
@Table(name = "incidente")
public class EIncidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIncidente;
    @Column(name = "descripcion_problema")
    private String descripcionProblema;
    @Column(name = "fecha_ingreso")
    private Timestamp fechaIngreso;
    @Column(name = "fecha_posible_resolucion")
    private Timestamp fechaPosibleResolucion;
    @Column(name = "complejo")
    private boolean complejo;
    @Column(name = "horas_estimadas_colchon")
    private int horasEstimadasColchon;
    @Column(name = "tiempo_resolucion")
    private int tiempoResolucion;
    @Column(name = "resuelto")
    private boolean resuelto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    @JsonIgnore
    private ECliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTecnico")
    @JsonIgnore
    private ETecnico tecnico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idServicio")
    @JsonIgnore
    private EServicio servicio;


}
