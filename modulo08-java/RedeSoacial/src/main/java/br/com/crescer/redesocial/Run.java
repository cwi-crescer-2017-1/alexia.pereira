package br.com.crescer.redesocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Carlos H. Nonnemacher
 */
@SpringBootApplication
public class Run {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Run.class, args);
        System.out.println("CREATE TABLE \"Usuario\" (\n" +
"	\"Id_Usuario\" long,\n" +
"	\"Nome\" varchar2,\n" +
"	\"Sexo\" char,\n" +
"	\"Data_Nascimento\" DATE,\n" +
"	\"Email\" varchar2,\n" +
"	\"Senha\" varchar2,\n" +
"	\"Role\" varchar2,\n" +
"	constraint USUARIO_PK PRIMARY KEY (\"Id_Usuario\")\n" +
");\n" +
"\n" +
"CREATE trigger \"BI_USUARIO\"\n" +
"  before insert on \"USUARIO\"\n" +
"  for each row\n" +
"begin\n" +
"  select \"USUARIO_SEQ\".nextval into :NEW.\"Id_Usuario\" from dual;\n" +
"end;\n" +
"\n" +
"CREATE sequence \"USUARIO_SEQ\";\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"CREATE TABLE \"Solicitacao\" (\n" +
"	\"Id_Solicitacao\" long,\n" +
"	\"Id_Usuario_Owner\" long,\n" +
"	\"Id_Usuario_Target\" long,\n" +
"	constraint SOLICITACAO_PK PRIMARY KEY (\"Id_Solicitacao\")\n" +
"  );\n" +
"CREATE sequence \"SOLICITACAO_SEQ\";\n" +
"CREATE trigger \"BI_SOLICITACAO\"\n" +
"  before insert on \"SOLICITACAO\"\n" +
"  for each row\n" +
"begin\n" +
"  select \"SOLICITACAO_SEQ\".nextval into :NEW.\"Id_Solicitacao\" from dual;\n" +
"end;\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"CREATE TABLE \"Amizade\" (\n" +
"	\"Id_Amizade\" long,\n" +
"	\"Id_Usuario_1\" long,\n" +
"	\"Id_Usuario_2\" long,\n" +
"	constraint AMIZADE_PK PRIMARY KEY (\"Id_Amizade\")\n" +
"  );\n" +
"CREATE sequence \"AMIZADE_SEQ\";\n" +
"CREATE trigger \"BI_AMIZADE\"\n" +
"  before insert on \"AMIZADE\"\n" +
"  for each row\n" +
"begin\n" +
"  select \"AMIZADE_SEQ\".nextval into :NEW.\"Id_Amizade\" from dual;\n" +
"end;\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"CREATE TABLE \"Post\" (\n" +
"	\"Id_Post\" long,\n" +
"	\"Id_Usuario\" long,\n" +
"	\"Descricao\" varchar2,\n" +
"	\"Url_Imagem\" varchar2,\n" +
"	constraint POST_PK PRIMARY KEY (\"Id_Post\");\n" +
"CREATE sequence \"POST_SEQ\";\n" +
"CREATE trigger \"BI_POST\"\n" +
"  before insert on \"POST\"\n" +
"  for each row\n" +
"begin\n" +
"  select \"POST_SEQ\".nextval into :NEW.\"Id_Post\" from dual;\n" +
"end;\n" +
"\n" +
"\n" +
"\n" +
"CREATE TABLE \"Curtidas\" (\n" +
"	\"Id_Curtida\" long,\n" +
"	\"Id_Post\" long,\n" +
"	\"Id_Usuario\" long,\n" +
"	constraint CURTIDAS_PK PRIMARY KEY (\"Id_Curtida\")\n" +
"  );\n" +
"CREATE sequence \"CURTIDAS_SEQ\";\n" +
"CREATE trigger \"BI_CURTIDAS\"\n" +
"  before insert on \"CURTIDAS\"\n" +
"  for each row\n" +
"begin\n" +
"  select \"CURTIDAS_SEQ\".nextval into :NEW.\"Id_Curtida\" from dual;\n" +
"end;\n" +
"\n" +
"\n" +
"ALTER TABLE \"Solicitacao\" ADD CONSTRAINT \"Solicitacao_fk0\" FOREIGN KEY (\"Id_Usuario_Owner\") REFERENCES Usuario(\"Id_Usuario\");\n" +
"ALTER TABLE \"Solicitacao\" ADD CONSTRAINT \"Solicitacao_fk1\" FOREIGN KEY (\"Id_Usuario_Target\") REFERENCES Usuario(\"Id_Usuario\");\n" +
"\n" +
"ALTER TABLE \"Amizade\" ADD CONSTRAINT \"Amizade_fk0\" FOREIGN KEY (\"Id_Usuario_1\") REFERENCES Usuario(\"Id_Usuario\");\n" +
"ALTER TABLE \"Amizade\" ADD CONSTRAINT \"Amizade_fk1\" FOREIGN KEY (\"Id_Usuario_2\") REFERENCES Usuario(\"Id_Usuario\");\n" +
"\n" +
"ALTER TABLE \"Post\" ADD CONSTRAINT \"Post_fk0\" FOREIGN KEY (\"Id_Usuario\") REFERENCES Usuario(\"Id_Usuario\");\n" +
"\n" +
"ALTER TABLE \"Curtidas\" ADD CONSTRAINT \"Curtidas_fk0\" FOREIGN KEY (\"Id_Post\") REFERENCES Post(\"Id_Post\");\n" +
"ALTER TABLE \"Curtidas\" ADD CONSTRAINT \"Curtidas_fk1\" FOREIGN KEY (\"Id_Usuario\") REFERENCES Usuario(\"Id_Usuario\");\n" +
"".replace("\"\"", ""));
    }

}
