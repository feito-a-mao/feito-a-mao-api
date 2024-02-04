DROP TABLE IF EXISTS imagem_produto;

CREATE TABLE imagem_produto (
    id_imagem_produto bigserial PRIMARY KEY,
    id_produto int8 NOT NULL,
    id_imagem int8 NOT NULL,
    CONSTRAINT imagem_produto_id_produto_fkey FOREIGN KEY (id_produto) REFERENCES produto(id_produto),
    CONSTRAINT imagem_produto_id_imagem_fkey FOREIGN KEY (id_imagem) REFERENCES imagem(id_imagem)
);