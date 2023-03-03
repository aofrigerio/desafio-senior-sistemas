# Desafio Senior Sistemas


<h2>Descrição da implementação</h2>

<p> Para o projeto, a estratégia utilizado para não poder excluir os produtos que já foram vinculados em pedidos foi de constraints no banco de dados.</p>
<p> Para diferenciação de pedidos e produtos, foi utilizado o enum. Assim, poderá fazer a separação
de produtos/serviços e de pedidos abertos/fechados.</p>

<h2>O que foi utilizado:</h2>

<ul>Java 17</ul>
<ul>Spring Boot 3</ul>
<ul>Lombok</ul>
<ul>Junit + Mockito</ul>
<ul>Flyway</ul>
<ul>Maven</ul>
<ul>JPA + Hibernate</ul>
<ul>QueryDSL</ul>
<ul>Postegres</ul>
<ul>Swagger OpenAPI v2</ul>

<h2>A Base da API está na porta 8080</h2>

http://localhost:8090/

<h2>Swagger - Documentação</h2>

<p>Documentação do swagger http://localhost:8080/swagger-ui/index.html</p>


<h2>Rodando o Projeto</h2>

<p>O projeto está configurando com o tomcat embarcado. Não precisa necessidade de ter tomcat instalado. Somente o Java.</p>
<p>Na raiz do projeto, execute o comando ./mnvw clean package install. Isso irá gerar um build do projeto na pasta target</p>
<p>Depois, para iniciar o projeto, dentro da pasta target, utilize o comando: "java -jar senior-0.0.1-SNAPSHOT.jar"

<h4> Docker Compose </h4>
<p>Com o docker instalado na máquina, execute o comando dentro da pasta do projeto:<p>
<p>utilize o docker-compose.yaml após gerar o pacote java. O apontamento do JAR está no ./target</p>

