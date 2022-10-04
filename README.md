<h1 style="background-color: #319eaa; padding: 24px">
  <img src="https://ik.imagekit.io/u91mpqdslhn/totvs-techfin_fB1XRByKP.png" alt="Banner Totvs Techfin">
</h1>

[![Build Status](https://dev.azure.com/totvstfs/Techfin/_apis/build/status/MaisPrazo/Techfin-CI-DEV-MaisPrazo-Core-API?repoName=techfin-maisprazo-core-api&branchName=develop)](https://dev.azure.com/totvstfs/Techfin/_build/latest?definitionId=1676&repoName=techfin-maisprazo-core-api&branchName=develop)

# Techfin Mais Prazo Core API

Serviço responsável pela comunicação com o front-end do Mais Prazo e com a API da *Supplier*.

## Tabela de Conteúdos
 
* Descrição do serviço 
* Status
* Pré-requisitos
* Rodando a aplicação
    * Clonar repositório
    * Instalar dependências
    * Executar serviços necessários
    * Compilar a aplicação
    * Executando testes
    * Gerando o *.jar*
* Usando a aplicação
* Licença

### Descrição do serviço

A API recebe requisições dos seguintes serviços:

- Front-end do Mais Prazo (techfin-maisprazo-frontend)

E a API se comunica com os seguintes serviços:

- API *Supplier*
- DB Mais Prazo (PostgreSQL)

Para mais detalhes sobre o fluxo e arquitetura,
consulte [esse link](https://tdn.totvs.com/display/TC/Arquitetura+Macro).

### 💈 Status

🚧 Em desenvolvimento 🚧

### 📚 Pré-requisitos

- 🌴 Git
- ☕ Java 11
- 📦 Maven
- 🐘 PostgreSQL

### 🎲 Rodando a aplicação

#### 📋 Clonar repositório

```
git clone https://totvstfs@dev.azure.com/totvstfs/Techfin/_git/techfin-maisprazo-core-api
cd techfin-maisprazo-core-api
```

#### 📖 Instalar dependências

🚨 **Atenção**: Por padrão, existem dependências desse projeto que estão
no [Artifactory](http://maven.engpro.totvs.com.br/artifactory/webapp/#/home) da Totvs. Antes de
instalar as dependências, verifique se você está conectadx na VPN e se tem acesso à ele.

```
mvn dependency:resolve
```

#### 🚢 Executar serviços necessários

Essa API utiliza o PostgreSQL como banco de dados. Para o ambiente de Dev, é necessário ter acesso a
uma instância do PostreSQL com a base criada para testes. Você pode rodar esse serviço através do
Docker da seguinte forma:

```
docker run -d --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=mais_prazo -p 5432:5432 --rm postgres
```

☝ **Dica!** Criar um arquivo *docker-compose.yml* e utilizar da seguinte maneira:

```
docker-compose up -d 
```

docker-compose.yml:

```
version: "3.9"
services:
  postgres:
    image: "postgres"
    ports:
      - "5432:5432"
    environment:
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=postgres
      - POSTGRES_DB=mais_prazo
```

#### ⚙️Compilar a aplicação

```
mvn compile
```

#### 🧪 Executando testes

⚠️Os testes precisam do serviço de PostgreSQL para não falharem.

```
mvn test
```

#### 🚀 Gerando o *.jar*

```
mvn package 
```

Caso queira pular a etapa de testes:

```
mvn package -DskipTests
```

### 🔨 Usando a aplicação

Para executar o serviço localmente, usando Spring Boot:

```
mvn spring-boot:run
```

Para executar o serviço localmente, pelo *.jar*:

```
java -jar target/techfin-maisprazo-core-api-1.0.0-RELEASE.jar
```

Por padrão, a API fica disponível na porta **8080**.

### Licença

Copyright © 2021 by [TOTVS](https://www.totvs.com)
