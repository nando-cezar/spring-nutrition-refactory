package br.edu.ifba.nutrition.entity;

import br.edu.ifba.nutrition.domain.dto.request.RequestComentarioDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    private String text;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Dica dica;

    public Comentario(LocalDateTime dataHora, String text, Usuario usuario, Dica dica) {
        this.dataHora = dataHora;
        this.text = text;
        this.usuario = usuario;
        this.dica = dica;
    }
}
