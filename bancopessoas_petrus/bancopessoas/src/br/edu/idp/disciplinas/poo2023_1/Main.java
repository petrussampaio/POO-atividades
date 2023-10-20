package br.edu.idp.disciplinas.poo2023_1;


import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {

        int id = 1;

        // 1. Habilitar o driver JDBC a partir da aplicação cliente;
        //      ok

        // 2. Estabelecer uma conexão entre a aplicação cliente e servidor do banco de dados;
        String paramsConexao = "jdbc:h2:mem:testdb";
        String usuario = "";
        String senha = "";
        Connection conexao = DriverManager.getConnection(paramsConexao, usuario, senha);

        // 3. Montar e executar a consulta SQL desejada;
        String criacaoSql = "create table pessoa (id int primary key, nome varchar(150), qtdAcesso int, naturalidade varchar(75) )";
        Statement stmtC = conexao.createStatement();
        stmtC.executeUpdate(criacaoSql);
        stmtC.close();

        String consulta = "select * from pessoa";
        //consulta = "select nome as nome_completo, naturalidade from pessoa";
        Statement stmt = conexao.createStatement();
        ResultSet resultado = stmt.executeQuery(consulta);

        // 4. Processar no cliente o resultado da consulta.
        while (resultado.next()) {
            String nome = resultado.getString("nome");
            Integer quantidade = resultado.getInt("qtdAcesso");
            String naturalidade = resultado.getString("naturalidade");

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            pessoa.setQuantidadeAcesso(quantidade);
            pessoa.setNaturalidade(naturalidade);


            // print
            // add list
        }

        // Criação de uma nova pessoa
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome("João Silva");
        novaPessoa.setQuantidadeAcesso(3);
        novaPessoa.setNaturalidade("Brasileiro");

        // Instrução SQL para inserir uma nova pessoa
        String insercaoSql = "INSERT INTO pessoa (ID, nome, qtdAcesso, naturalidade) VALUES (?, ?, ?, ?)";

        // Utilização de PreparedStatement para evitar SQL Injection
        try (PreparedStatement stmtInsercao = conexao.prepareStatement(insercaoSql)) {
            stmtInsercao.setInt(1, id++); // Substitua 1 pelo valor desejado
            stmtInsercao.setString(2, novaPessoa.getNome());
            stmtInsercao.setInt(3, novaPessoa.getQuantidadeAcesso());
            stmtInsercao.setString(4, novaPessoa.getNaturalidade());

            // Execução da instrução de inserção
            int linhasAfetadas = stmtInsercao.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Inserção bem-sucedida!");
            } else {
                System.out.println("Falha na inserção.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Tratamento adequado de exceções é recomendado na prática
        }
        // ...


        try (PreparedStatement stmtInsercao = conexao.prepareStatement(insercaoSql, Statement.RETURN_GENERATED_KEYS)) {
            stmtInsercao.setInt(1, id++); // Substitua 1 pelo valor desejado
            stmtInsercao.setString(2, novaPessoa.getNome());
            stmtInsercao.setInt(3, novaPessoa.getQuantidadeAcesso());
            stmtInsercao.setString(4, novaPessoa.getNaturalidade());

            // Execução da instrução de inserção
            int linhasAfetadas = stmtInsercao.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Inserção bem-sucedida!");

                // Recuperar o ID gerado, se aplicável
                ResultSet generatedKeys = stmtInsercao.getGeneratedKeys();
                int idGerado = -1;
                if (generatedKeys.next()) {
                    idGerado = generatedKeys.getInt(1);
                    System.out.println("ID gerado: " + idGerado);

                    // Consulta para obter os dados inseridos
                    String consulta1 = "SELECT * FROM pessoa WHERE id = ?";
                    try (PreparedStatement stmtConsulta = conexao.prepareStatement(consulta1)) {
                        stmtConsulta.setInt(1, idGerado);

                        ResultSet resultadoConsulta = stmtConsulta.executeQuery();

                        // Exibir os resultados da consulta
                        while (resultadoConsulta.next()) {
                            System.out.println("Dados inseridos:");
                            System.out.println("ID: " + resultadoConsulta.getInt("id"));
                            System.out.println("Nome: " + resultadoConsulta.getString("nome"));
                            System.out.println("Quantidade de Acesso: " + resultadoConsulta.getInt("qtdAcesso"));
                            System.out.println("Naturalidade: " + resultadoConsulta.getString("naturalidade"));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Falha na inserção.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("\nTchau, até a próxima\n\n\t\t:-)");

    }

}
