# Ficticius Clean

API para cálculo de consumo de combustível de veículos.

## Obter

```
git clone https://github.com/paulosalonso/ficticius-clean.git
```

## Executar

Gerar o executável (JAR):
```
mvn package
```

Executar a aplicação via linha de comando:
```
java -jar <caminho-da-aplicaço>/ficticius-clean-1.0.0.jar
```

## Testar

Acessar, no navegador, a URL http://localhost:8080/swagger-ui.html

### Filtros

Os endpoints de busca (http://localhost:8080/<resource-path\>/list) podem receber filtros, através do parâmetro "filter" na url.

Os filtros podem ser implementados seguindo as orientações do projeto [QueryDecoder](https://github.com/paulosalonso/query-decoder/blob/master/README.md).

__Exemplo__: http://localhost:8080/veiculos/list?filter=nome[CT]:Entregador

## Considerações

Esta API utiliza o banco de dados H2, configurado para execução em memória. Isto quer dizer que seus dados são transientes, ou seja, deixarão de existir assim que a aplicação for finalizada.

Ao ser inicializada, a aplicação abastece o banco com dados mínimos para viabilizar testes do endpoint /veiculo/rankingConsumo.
