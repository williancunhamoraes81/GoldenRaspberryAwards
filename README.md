# Golden Raspberry Awards

Serviço responsável pela listagem de indicados e vendedores de pior filme. 
<br/>
Nessa aplicação retorno os produtores com maior intervalo entre dois prêmios consecutivos e o que obteve dois prêmios mais rápido.

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
<br/>
localhost:9800/api/list-all { GET }
<br/>
localhost:9800/api/{id} { GET }
<br/>
localhost:9800/api/{id} { DELETE }
<br/>
localhost:9800/api/{id} { PUT }
<br/>
localhost:9800/api/{Movie} { POST }
<br/>

#### ⚙️Compilar a aplicação

```
mvn compile
```

