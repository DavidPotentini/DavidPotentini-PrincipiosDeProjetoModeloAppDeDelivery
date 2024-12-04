## 🚀 Como clonar
git clone  https://github.com/DavidPotentini/DavidPotentini-PrincipiosDeProjetoModeloAppDeDelivery.git

## ✅ Como conectar ao banco de dados
 <p>Na classe ConexaoSQLite na váriavel url, coloque o caminho para o seu banco de dados. Exemplo: "jdbc:sqlite:C:\Users\Usuario\Desktop\banco.db"</p>
 <p>Para funcionar corretamente você deve criar uma tabela no banco de dados SQLite com o seguinte comando:</p>
 
```
 CREATE TABLE "logs" (
	"id"	INTEGER,
	"usuario"	TEXT NOT NULL, 
	"datahora"	TEXT NOT NULL, 
	"codigo_pedido"	INTEGER NOT NULL, 
	"operacao"	TEXT NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT) 
);
```

## 👨‍💻 Autores
- David Sebastião Zardo Potentini 
- Layon José Pedrosa Dos Reis
- Romerson Medina
