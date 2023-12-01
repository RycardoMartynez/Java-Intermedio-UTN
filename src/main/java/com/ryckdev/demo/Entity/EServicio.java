package com.ryckdev.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;




@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
@Data
@EqualsAndHashCode
@Entity
@Table (name = "servicio")
public class EServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo_problema")
    private String tipoProblema;
    @Column(name = "tiempo_maximo_resolucion")
    private int tiempoMaximoResolucion;

    @OneToMany(mappedBy = "servicio")
    private List<EIncidente> incidentes;



}
