package com.example;

import java.util.List;

public class QueriesExecution {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();

        List<Aluno> alunos = alunoDAO.list();
        alunos.stream().forEach(System.out::println);

        // Aluno aluno = alunoDAO.getById(4);
        // System.out.println(aluno.toString());

        // Aluno alunoAux = new Aluno("Douglas", 20, "ES");
        // alunoDAO.create(alunoAux);
        // alunos = alunoDAO.list();
        // alunos.stream().forEach(System.out::println);

        // alunoDAO.delete(aluno);
        // alunos = alunoDAO.list();
        // alunos.stream().forEach(System.out::println);

        // Aluno alunoAux2 = alunoDAO.getById(3);
        // alunoAux2.setNome("João Lucas");
        // alunoAux2.setIdade(18);
        // alunoDAO.update(alunoAux2);
        // alunos = alunoDAO.list();
        // alunos.stream().forEach(System.out::println);
    }
}
