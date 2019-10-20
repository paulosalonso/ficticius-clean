insert into Montadora(nome) values
    ('Chevrolet'),
    ('Fiat'),
    ('Ford'),
    ('Volkswagen');

insert into Modelo(nome, montadoraId) values
    ('Cruze', 1),
    ('Strada', 2),
    ('Mustang', 3),
    ('Gol', 4);

insert into Veiculo(nome, modeloId, dataFabricacao, consumoCidadeKml, consumoRodoviaKml) values
    ('AAA-1111 - Carro do Gerente', 1, '2018-01-01', 10, 7),
    ('BBB-2222 - Carro do Entregador', 2, '2016-01-01', 14, 10),
    ('CCC-3333 - Carro do Patrão', 3, '2019-10-20', 8, 3),
    ('DDD-4444 - Carro do Administrativo', 4, '2017-01-01', 12, 10);
