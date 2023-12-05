-- Tabela imagem
CREATE TABLE imagem (
    id_imagem BIGSERIAL PRIMARY KEY,
    dados_imagem BYTEA NOT NULL,
    legenda TEXT, -- Pode ser NULL
    data_upload TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
COMMENT ON TABLE imagem IS 'Tabela que armazena informações sobre imagens.';
COMMENT ON COLUMN imagem.id_imagem IS 'Identificador único da imagem.';
COMMENT ON COLUMN imagem.dados_imagem IS 'Dados binários da imagem.';
COMMENT ON COLUMN imagem.legenda IS 'Legenda associada à imagem (pode ser NULL).';
COMMENT ON COLUMN imagem.data_upload IS 'Data e hora do upload da imagem.';

-- Tabela usuario
CREATE TABLE usuario (
    id_usuario BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    id_foto_perfil BIGINT, -- Pode ser NULL
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (id_foto_perfil) REFERENCES imagem(id_imagem)
);
COMMENT ON TABLE usuario IS 'Tabela que armazena informações sobre usuários.';
COMMENT ON COLUMN usuario.id_usuario IS 'Identificador único do usuário.';
COMMENT ON COLUMN usuario.nome IS 'Nome do usuário.';
COMMENT ON COLUMN usuario.email IS 'Endereço de e-mail do usuário.';
COMMENT ON COLUMN usuario.id_foto_perfil IS 'Identificador da foto de perfil (pode ser NULL).';
COMMENT ON COLUMN usuario.data_criacao IS 'Data e hora de criação do usuário.';

-- Tabela vendedor
CREATE TABLE vendedor (
    id_vendedor BIGSERIAL PRIMARY KEY,
    id_usuario BIGINT UNIQUE NOT NULL, -- FK referenciando a tabela de usuarios
    descricao_perfil TEXT,
    localizacao VARCHAR(255),
    avaliacao_media DECIMAL(2,1), -- Pode variar dependendo dos requisitos
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);
COMMENT ON TABLE vendedor IS 'Tabela que armazena informações sobre vendedores.';
COMMENT ON COLUMN vendedor.id_vendedor IS 'Identificador único do vendedor.';
COMMENT ON COLUMN vendedor.id_usuario IS 'Identificador do usuário associado ao vendedor.';
COMMENT ON COLUMN vendedor.descricao_perfil IS 'Descrição do perfil do vendedor.';
COMMENT ON COLUMN vendedor.localizacao IS 'Localização do vendedor.';
COMMENT ON COLUMN vendedor.avaliacao_media IS 'Avaliação média do vendedor (pode variar dependendo dos requisitos).';


-- Tabela produto
CREATE TABLE produto (
    id_produto BIGSERIAL PRIMARY KEY,
    id_vendedor BIGINT NOT NULL, -- FK referenciando a tabela de vendedor
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    estoque_disponivel INT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (id_vendedor) REFERENCES vendedor(id_vendedor)
);
COMMENT ON TABLE produto IS 'Tabela que armazena informações sobre produtos.';
COMMENT ON COLUMN produto.id_produto IS 'Identificador único do produto.';
COMMENT ON COLUMN produto.id_vendedor IS 'Identificador do vendedor associado ao produto.';
COMMENT ON COLUMN produto.nome IS 'Nome do produto.';
COMMENT ON COLUMN produto.descricao IS 'Descrição do produto.';
COMMENT ON COLUMN produto.preco IS 'Preço do produto.';
COMMENT ON COLUMN produto.estoque_disponivel IS 'Quantidade disponível em estoque.';
COMMENT ON COLUMN produto.data_criacao IS 'Data e hora de criação do produto.';


CREATE TABLE imagem_produto (
    id_produto BIGINT,
    id_imagem BIGINT,
    PRIMARY KEY (id_produto, id_imagem),
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto),
    FOREIGN KEY (id_imagem) REFERENCES imagem(id_imagem)
);
COMMENT ON TABLE imagem_produto IS 'Tabela de associação entre produtos e imagens.';
COMMENT ON COLUMN imagem_produto.id_produto IS 'Identificador do produto associado à imagem.';
COMMENT ON COLUMN imagem_produto.id_imagem IS 'Identificador da imagem associada ao produto.';
