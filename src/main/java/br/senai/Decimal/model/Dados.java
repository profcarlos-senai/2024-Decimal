package br.senai.Decimal.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
public class Dados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Column(precision = 10, scale = 2)
    private BigDecimal valor;
}
