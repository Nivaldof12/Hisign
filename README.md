# Projeto Hisig

Este projeto inclui **Horario**, **Teste** e **Trilha**. Neste módulo do Hisig não foi acrecentado a Classe **Usuario**.

## Resumo
Este projeto é uma aplicação Java que abrange várias APIs REST com os métodos GET, POST, PUT e DELETE.

OBS: O deploy da aplicação está desativado mas se quiser testar entre em contato comigo!

## Métodos Disponíveis na API
Todos os métodos abaixo foram testados com os aplicativos [Postman](https://www.postman.com/) e [Insomnia](https://insomnia.rest/download).

### GET /
O método de GET **/lista** retornam todos os registros existentes e o **/{id}/download** permite baixar os arquivos salvos no banco de dados:

    {
	    "url": https://hisign-production.up.railway.app/horario/lista
    }
<br>

    {
	    "url": https://hisign-production.up.railway.app/teste/lista
    }
<br>

    {
	    "url": https://hisign-production.up.railway.app/tce/lista
    }
<br>

    {
	    "url": https://hisign-production.up.railway.app/trilha/lista
    }
Os próximos métodos são utilizados para baixar arquivos:    
    
    {
	    "url": https://hisign-production.up.railway.app/tce/{id}/downloadtce
    }

<br>

    {
	    "url": https://hisign-production.up.railway.app/trilha/{id}/downloadtrilha
    }

---

<h2>Tecnologias:</h2>

- Java
- Spring Boot
- MySQL
- JPA
- Hibernate

---
