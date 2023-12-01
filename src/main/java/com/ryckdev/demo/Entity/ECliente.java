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
@Table(name = "cliente")
public class ECliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "cuit")
    private String cuit;

    @OneToMany(mappedBy = "cliente")
    private List<EIncidente> incidentes;



}
