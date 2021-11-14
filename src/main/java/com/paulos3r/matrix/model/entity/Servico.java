package com.paulos3r.matrix.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String descricao;
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private  Cliente cliente;
    @Column
    private BigDecimal valor;
}
