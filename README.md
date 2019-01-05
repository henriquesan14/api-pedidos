# API RESTFUL de pedidos
### Tecnologias:
* MySQL
* Java
* Spring Boot
* Spring Data Jpa
* Spring Security

### Para executar a API:

1. Baixe todas depedência do arquivo pom.xml
2. Configure o arquivo **application.properties** com as configurações do seu banco de dados.
3. Execute o sistema .

### Endpoints REST:

**Listar paginado e ordenado:**
>GET:  /mesas , /produtos , /pedidos

**parâmetro page, default = 0;
parâmetro size, default = 5;
parâmetro nome, default = ""**

**Exemplo = /mesas?size=0&size=5&nome=teste**

**Listar todos:**
>GET:  /mesas/all , /produtos/all , /pedidos/all



**Cadastro:**
>POST: /mesas

    {  
            "nome": "mesa teste",
            "descricao": "descrição teste"
        }
 
>POST: /produtos

    {
            "nome": "produto teste",
            "valorUnitario": 6
        }
     
>POST: /pedidos

    {
            "mesa": {
                "id": 2
            },
            "itensPedidos": [
                {
                    "quantidade": 2,
                    "produto": {
                        "id": 1
                    }
                },
                {
                    "quantidade": 1,
                    "produto": {
                        "id": 2
                    }
                }
            ]
        }
**Data/hora e valor total do pedido gerados automaticamentes.**

**Edição:**
>PUT: /mesas/id , /produtos/id , /mesas/id

**Exemplo do body no endpoint de POST**

**Remoção:**
>DELETE: /mesas/id , /produtos/id , /mesas/id






        
