package br.com.alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        String titulo,
        String mensagem,
        String autor,
        String curso) {
}
