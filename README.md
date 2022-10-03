## APLICAÇÃO DISPONÍVEL APENAS PARA UTILIZAÇÃO LOCALHOST

## Movie API

 - `/api/list-all ( GET )`: Lista todos movies
 - `/api/filter (GET )`: Encontra Produtores o produtor com maior intervalo entre dois prêmios consecutivos, e o que
   obteve dois prêmios mais rápido
 - `/api/{id} (GET)`: Retonra registro por id
 - `/api/{id} (DELETE)`: Remove registro por id
 - `/api/ (POST)`: Cria registro por id ( passando Entity Movie)
 - `/api/{id} (PUT)`: Atualiza registro por id ( passando Entity Movie)

## Requisitos
 - `java`: 1.8
 - `maven`: V3
 - `lombok plugin`: Lombok plugin

## Build
 ```
 $ mvn clean install
 ```
