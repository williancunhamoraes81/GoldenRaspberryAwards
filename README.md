# Golden Raspberry Awards

Serviço responsável pela listagem de indicados e vendedores de pior filme. 

## Tabela de Conteúdos
 
* Movie 
* Movie_Producers
* Movie_Studios
* Producer
* Studio

### 📚 Pré-requisitos

- 🌴 Git
- ☕ Java 1.8
- 📦 Maven
- 🐘 H2


#### 📋 Clonar repositório

```
git clone https://github.com/williancunhamoraes81/GoldenRaspberryAwards.git
```

#### 🚢 Executar serviços necessários

Essa API utiliza o H2 como banco de dados. Disponível apenas para utilização localhost:9800


#### 🚢 Utilizando API

localhost:9800/api/filter { GET }
localhost:9800/api/list-all { GET }
localhost:9800/api/{id} { GET }
localhost:9800/api/{id} { DELETE }
localhost:9800/api/{id} { PUT }
localhost:9800/api/{Movie} { POST }


#### ⚙️Compilar a aplicação

```
mvn compile
```

