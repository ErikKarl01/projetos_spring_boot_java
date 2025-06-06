create schema if not exists users;

create table users.user {
    id bigserial primary KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(100) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    dataCadastro TIMESTAMP NOT NULL
};