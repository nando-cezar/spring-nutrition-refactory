package br.edu.ifba.nutrition.entity;

import br.edu.ifba.nutrition.domain.dto.request.RequestDicaDTO;
import br.edu.ifba.nutrition.domain.enums.Categoria;
import jakarta.persistence.*;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "dicas")
public class Dica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String foto;
    private String texto;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @OneToMany(
            cascade = CascadeType.REMOVE,
            mappedBy = "dica"
    )
    private List<Comentario> comentarios;
    private boolean ativo;

    public Dica(RequestDicaDTO dto) {
        this.titulo = dto.titulo();
        this.foto = dto.foto();
        this.texto = dto.texto();
        this.categoria = dto.categoria();
        this.ativo = true;
    }
}
