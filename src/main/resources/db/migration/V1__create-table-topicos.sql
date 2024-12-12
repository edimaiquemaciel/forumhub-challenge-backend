CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensagem LONGTEXT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('NAO_RESPONDIDO', 'RESPONDIDO', 'EM_ANDAMENTO', 'RESOLVIDO') DEFAULT 'NAO_RESPONDIDO',
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL,
    mensagem_hash VARCHAR(255) NOT NULL,

    PRIMARY KEY (id),
    UNIQUE KEY unique_titulo_mensagem (titulo, mensagem_hash) -- Chave única combinada
);