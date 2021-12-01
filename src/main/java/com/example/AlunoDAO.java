package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    public List<Aluno> list() {
        List<Aluno> alunos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {
            String SQLquery = "SELECT * FROM aluno";
            PreparedStatement pstmt = conn.prepareStatement(SQLquery);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String estado = rs.getString("estado");

                alunos.add(new Aluno(id, nome, idade, estado));
            }
            System.out.println("SUCESSO na listagem dos alunos.");
        } catch (SQLException e) {
            System.out.println("FALHA na listagem dos alunos.");
            e.printStackTrace();
        }

        return alunos;
    }

    public Aluno getById(int id) {
        Aluno aluno = new Aluno();

        try (Connection conn = ConnectionFactory.getConnection()) {
            String SQLquery = "SELECT * FROM aluno WHERE id = ?";

            PreparedStatement pstmt = conn.prepareStatement(SQLquery);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));
            }
            System.out.println("SUCESSO na recuperacao do aluno.");
        } catch (SQLException e) {
            System.out.println("FALHA ao recuperar o aluno.");
            e.printStackTrace();
        }

        return aluno;
    }

    public void create(Aluno aluno) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String SQLquery = "INSERT INTO aluno (nome, idade, estado) VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(SQLquery);
            pstmt.setString(1, aluno.getNome());
            pstmt.setInt(2, aluno.getIdade());
            pstmt.setString(3, aluno.getEstado());

            int updatedRows = pstmt.executeUpdate();
            System.out.println("SUCESSO na insercao do aluno. " + updatedRows + " linhas afetadas.");
        } catch (SQLException e) {
            System.out.println("FALHA ao inserir o aluno.");
            e.printStackTrace();
        }
    }

    public void delete(Aluno aluno) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String SQLquery = "DELETE FROM aluno WHERE id = ?";

            PreparedStatement pstmt = conn.prepareStatement(SQLquery);
            pstmt.setInt(1, aluno.getId());

            int updatedRows = pstmt.executeUpdate();

            System.out.println("SUCESSO na delecao do aluno. " + updatedRows + " linhas afetadas.");
        } catch (SQLException e) {
            System.out.println("FALHA ao deletar o aluno.");
            e.printStackTrace();
        }
    }

    public void update(Aluno aluno) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String SQLquery = "UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ?";

            PreparedStatement pstmt = conn.prepareStatement(SQLquery);
            pstmt.setString(1, aluno.getNome());
            pstmt.setInt(2, aluno.getIdade());
            pstmt.setString(3, aluno.getEstado());
            pstmt.setInt(4, aluno.getId());

            int updatedRows = pstmt.executeUpdate();

            System.out.println("SUCESSO na atualização dos dados do aluno. " + updatedRows + " linhas afetadas.");
        } catch (SQLException e) {
            System.out.println("FALHA ao atualizar dados do aluno.");
            e.printStackTrace();
        }
    }
}
