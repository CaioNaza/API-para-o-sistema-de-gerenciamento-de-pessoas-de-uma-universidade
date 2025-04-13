package api.trabalho.DTO;

import java.util.Date;

public record PessoaDto(String nome, Date dataNascimento, String sexo, String cpf ) {
}