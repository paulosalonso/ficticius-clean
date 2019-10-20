# Ficticius Clean

API para cálculo de consumo de combustível de veículos.

## Obter a aplicação

```
git clone https://github.com/paulosalonso/ficticius-clear.git
```

## Executar a aplicação

Gerar o executável (jar):
```
mvn package
```

Executar a aplicação via linha de comando:
```
java -jar <caminho-da-aplicaço>/ficticius-clean-1.0.0.jar
```

## Testar a aplicação

Acessar, no navegador, a seguinte URL:

* http://localhost:8080/swagger-ui.html

### Filtros

Os endpoints de busca (http://localhost:8080/<path>/list) podem receber filtros, através do parâmetro "filter" na url.

Os filtros podem ser implementados seguindo as orientações do projeto [QueryDecoder](https://github.com/paulosalonso/query-decoder/blob/master/README.md).

__Exemplo__: http://localhost:8080//veiculos/list?filter=nome[CT]:Entregador
