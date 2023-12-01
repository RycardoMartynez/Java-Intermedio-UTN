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
@Table(name = "tecnico")
public class ETecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTecnico;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "especialidades")
    private String especialidades;
    @Column(name = "tiempo_estimado_por_defecto")
    private int tiempoEstimadoPorDefecto;

    @OneToMany(mappedBy = "tecnico")
    private List<EIncidente> incidentes;


}
