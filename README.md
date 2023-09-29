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
Os próximos métodos são utilizados para baixar arquivos com base no id.:    
    
    {
	    "url": https://hisign-production.up.railway.app/tce/{id}/downloadtce
    }

<br>

    {
	    "url": https://hisign-production.up.railway.app/trilha/{id}/downloadtrilha
    }

### POST /
O método POST **/incluir** faz o cadastro das informações no banco de dados e o **/{id}/upload** faz o cadastro dos arquivos:
    
    {
	    "url": https://hisign-production.up.railway.app/horario/incluir

	    Exemplo:
     	    "nomecompleto": "Nivaldo",
	    "entrada_Segunda": "",
            "intervalo_Segunda": "",
            "saida_Segunda": "",
	    "entrada_Terca": "08:30",
            "intervalo_Terca": "11:00",
            "saida_Terca": "15:30",
	    "entrada_Quarta": "08:30",
            "intervalo_Quarta": "11:00",
            "saida_Quarta": "15:30",
	    "entrada_Quinta": "08:30",
            "intervalo_Quinta": "11:00",
            "saida_Quinta": "15:30",
	    "entrada_Sexta": "08:30",
            "intervalo_Sexta": "11:00",
            "saida_Sexta": "15:30",
	    "entrada_Sabado": "08:30",
            "intervalo_Sabado": "11:00",
            "saida_Sabado": "15:30",
            "observacao": "",
            "turno": "noturno",
	    "empresa": "TT & T",
	    "setor": "Teste <3"
    }
OBS: O sistema tem uma exceção que apenas permite o cadastro de horários entre 25 e 30 horas semanais.

    {
	      "url": https://hisign-production.up.railway.app/teste/incluir
              
	      Exemplo:
              "nometeste": "teste",
              "resumo": "acesse o link",
              "linkgit": "link github.com",
              "equipe": "manhã"
    }
<br>
    
    {
	      "url": https://hisign-production.up.railway.app/trilha/incluir

	      Exemplo:
              "nome_aula": "aula",
              "descricao": "descricao",
              "link_aula": "link",
              "modulo": "modulo"
    }
<br>
Depois de incluir algumas informações no banco a API upload pode ser utilizada para cadastrar arquivos e associar esses arquivos a um id:

OBS: Lembre de trocar a URL {id} por um id existente!
    
    {
	      "url": https://hisign-production.up.railway.app/teste/{id}/uploadpdf

	      "arquivo"
    }
<br>

    {
	      "url": https://hisign-production.up.railway.app/trilha/{id}/uploadtrilha

	      "Resumo_Envio"
    }

### PUT /
O método PUT **/{id}/alterar** faz a alteração das informações no banco de dados:

    {
	    "url": https://hisign-production.up.railway.app/horario/{id}/alterar

	      Exemplo:
              "nomecompleto": "Nome Trocado",
	      "entrada_Segunda": "08:30",
              "intervalo_Segunda": "11:00",
              "saida_Segunda": "15:30",
	      "entrada_Terca": "08:30",
              "intervalo_Terca": "11:00",
              "saida_Terca": "15:30",
	      "entrada_Quarta": "08:30",
              "intervalo_Quarta": "11:00",
              "saida_Quarta": "15:30",
	      "entrada_Quinta": "08:30",
              "intervalo_Quinta": "11:00",
              "saida_Quinta": "15:30",
	      "entrada_Sexta": "08:30",
              "intervalo_Sexta": "11:00",
              "saida_Sexta": "15:30",
	      "entrada_Sabado": "08:30",
              "intervalo_Sabado": "11:00",
              "saida_Sabado": "12:30",
              "observacao": "teste",
              "turno": "manhã",
	      "empresa": "TT & T",
	      "setor": "Troca"
    }
 <br>

    {
	    "url": https://hisign-production.up.railway.app/teste/{id}/alterar
              
	      Exemplo:
              "nometeste": "teste1",
  	      "resumo": "link para git",
              "arquivo": null,
              "linkgit": "gitlav.com",
              "equipe": "noturna"
    }
 <br>

    {
	    "url": https://hisign-production.up.railway.app/trilha/{id}/alterar

     	    Exemplo:
            "nome_aula": "aula back",
  	    "descricao": "teste",
            "link_aula": "link",
            "modulo": "teste"
    }

### DELETE /
O método DELETE **/{id}/excluir** exclui as informações do banco de dados:
        
    {
	    "url": https://hisign-production.up.railway.app/horario/{id}/excluir
    }
 <br>

    {
	    "url": https://hisign-production.up.railway.app/teste/{id}/excluir
    }
 <br>

    {
	    "url": https://hisign-production.up.railway.app/trilha/{id}/excluir
    }

---

<h2>Tecnologias:</h2>

- Java
- Spring Boot
- MySQL
- JPA
- Hibernate

---
