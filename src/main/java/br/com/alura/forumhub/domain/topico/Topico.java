package br.com.alura.forumhub.domain.topico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Entity(name = "topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @Lob
    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
    private String autor;
    private String curso;
    @Column(name = "mensagem_hash")
    private String mensagemHash;

    public Topico(DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.status = StatusTopico.NAO_RESPONDIDO;
        this.dataCriacao = LocalDateTime.now();
        this.mensagemHash = gerarHashMensagem(this.mensagem);
    }


    private String gerarHashMensagem(String mensagem) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(mensagem.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash da mensagem", e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public void atualizarInformacoes( DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if (dados.autor() != null){
            this.autor = dados.autor();
        }
        if (dados.curso() != null){
            this.curso = dados.curso();
        }
    }
}
