INSERT INTO codecraft.alunos (nome_aluno, matricula_aluno ) VALUES ('Herick Moreira', 0001);
INSERT INTO codecraft.alunos (nome_aluno, matricula_aluno ) VALUES ('Karina Maciel', 0002);

INSERT INTO codecraft.cursos (nome_curso, professor_id) VALUES ('Curso de Java', 1);
INSERT INTO cursos (nome_curso, professor_id) VALUES ('Curso de Kotlin', 2);

INSERT INTO cursos_alunos (curso_id, aluno_id) VALUES (1, 1);
INSERT INTO cursos_alunos (curso_id, aluno_id) VALUES (2, 2);

INSERT INTO professores (nome_professor, matricula_professor) VALUES ('Vinicius do Java', 12345);
INSERT INTO professores (nome_professor, matricula_professor) VALUES ('Monique do Kotlin', 54321);
