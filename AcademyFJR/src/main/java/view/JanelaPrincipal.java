package view;

import dao.*;
import model.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JanelaPrincipal implements ActionListener {

    JMenuItem cadFormaPagamento, consFormaPagamento, altFormaPagamento, delFormaPagamento, cadExercicio, consExercicios, altExercicios, delExercicios, cadPlano, consPlano, altPlano, delPlano, cadInstrutor, consInstrutor, altInstrutor, delInstrutor, cadMedidas, consMedidas, altMedidas, delMedidas, cadAluno, consAluno, altAluno, delAluno, cadMatricula, consMatricula, altMatricula, delMatricula,
            cadPagamentoMensalidade, consPagamentoMensalidade, altPagamentoMensalidade, delPagamentoMensalidade,
            sair;
    static String resultado;
    //construtor;
    public JanelaPrincipal() {
        JFrame janela = new JFrame("AcademyFJR");
        janela.setSize(420, 420); //define tamanho da tela
        janela.setLocationRelativeTo(null);
        // criar uma barra para colocar o menu
        JMenuBar jmBarra = new JMenuBar();
        janela.setJMenuBar(jmBarra);
        //Define e adiciona os menus
        JMenu cadastroMenu = new JMenu("Cadastro");
        JMenu consultaMenu = new JMenu("Consulta");
        JMenu alterarMenu = new JMenu("Alterar");
        JMenu deletarMenu = new JMenu("Deletar");
        JMenu matriculaMenu = new JMenu("Matrícula");
        JMenu sairMenu = new JMenu("Sair");
        //declarar opções ao menu
        cadFormaPagamento = new JMenuItem("Forma de Pagamento");
        consFormaPagamento = new JMenuItem("Forma de Pagamento");
        altFormaPagamento = new JMenuItem("Forma de Pagamento");
        delFormaPagamento = new JMenuItem("Forma de Pagamento");
        sair = new JMenuItem("Encerrar");
        // opções da tabela Exercícios
        cadExercicio = new JMenuItem("Exercícios");
        consExercicios = new JMenuItem("Exercícios");
        altExercicios = new JMenuItem("Exercícios");
        delExercicios = new JMenuItem("Exercícios");
        // opções da tabela Planos
        cadPlano = new JMenuItem("Planos");
        consPlano = new JMenuItem("Planos");
        altPlano = new JMenuItem("Planos");
        delPlano = new JMenuItem("Planos");
        sair = new JMenuItem("Encerrar");
        // opções da tabela Instrutor
        cadInstrutor = new JMenuItem("Instrutor");
        consInstrutor = new JMenuItem("Instrutor");
        altInstrutor = new JMenuItem("Instrutor");
        delInstrutor = new JMenuItem("Instrutor");
        // opções da tabela Medidas
        cadMedidas = new JMenuItem("Medidas");
        consMedidas = new JMenuItem("Medidas");
        altMedidas = new JMenuItem("Medidas");
        delMedidas = new JMenuItem("Medidas");
        // opções da tabela Aluno
        cadAluno = new JMenuItem("Aluno");
        consAluno = new JMenuItem("Aluno");
        altAluno = new JMenuItem("Aluno");
        delAluno = new JMenuItem("Aluno");
        // opções da tabela Matricula
        cadMatricula = new JMenuItem("Realizar");
        consMatricula = new JMenuItem("Consultar");
        altMatricula = new JMenuItem("Alterar");
        delMatricula = new JMenuItem("Remover");
        // opções da tabela Pagameneto Mensalidade
        cadPagamentoMensalidade = new JMenuItem("Pagamento Mensalidade");
        consPagamentoMensalidade = new JMenuItem("Pagamento Mensalidade");
        altPagamentoMensalidade = new JMenuItem("Pagamento Mensalidade");
        delPagamentoMensalidade = new JMenuItem("Pagamento Mensalidade");
        //adicionar menu a barraMenu
        jmBarra.add(cadastroMenu);
        jmBarra.add(consultaMenu);
        jmBarra.add(deletarMenu);
        jmBarra.add(alterarMenu);
        jmBarra.add(matriculaMenu);
        jmBarra.add(sairMenu);
        // adicionar opções Cadastrar ao menu
        cadastroMenu.add(cadFormaPagamento);
        consultaMenu.add(consFormaPagamento);
        alterarMenu.add(altFormaPagamento);
        deletarMenu.add(delFormaPagamento);
        sairMenu.add(sair);
        // adicionar opções Exercícios ao menu
        cadastroMenu.add(cadExercicio);
        consultaMenu.add(consExercicios);
        alterarMenu.add(altExercicios);
        deletarMenu.add(delExercicios);
        sairMenu.add(sair);
        // adicionar opções Planos ao menu
        cadastroMenu.add(cadPlano);
        consultaMenu.add(consPlano);
        alterarMenu.add(altPlano);
        deletarMenu.add(delPlano);
        // adicionar opções Instrutor ao menu
        cadastroMenu.add(cadInstrutor);
        consultaMenu.add(consInstrutor);
        alterarMenu.add(altInstrutor);
        deletarMenu.add(delInstrutor);
        // adicionar opções Medidas ao menu
        cadastroMenu.add(cadMedidas);
        consultaMenu.add(consMedidas);
        alterarMenu.add(altMedidas);
        deletarMenu.add(delMedidas);
        // adicionar opções Alunos ao menu
        cadastroMenu.add(cadAluno);
        consultaMenu.add(consAluno);
        alterarMenu.add(altAluno);
        deletarMenu.add(delAluno);
        // adicionar opções Matricula ao menu
        matriculaMenu.add(cadMatricula);
        matriculaMenu.add(consMatricula);
        matriculaMenu.add(altMatricula);
        matriculaMenu.add(delMatricula);
        // adicionar opções Pagamento Mensalidade ao menu
        cadastroMenu.add(cadPagamentoMensalidade);
        consultaMenu.add(consPagamentoMensalidade);
        alterarMenu.add(altPagamentoMensalidade);
        deletarMenu.add(delPagamentoMensalidade);
        // ações do botão forma de pagamento
        sair.addActionListener(this);
        cadFormaPagamento.addActionListener(this);
        consFormaPagamento.addActionListener(this);
        delFormaPagamento.addActionListener(this);
        altFormaPagamento.addActionListener(this);
        // ações do botão Exercícios
        cadExercicio.addActionListener(this);
        consExercicios.addActionListener(this);
        delExercicios.addActionListener(this);
        altExercicios.addActionListener(this);
        // ações do botão Planos
        cadPlano.addActionListener(this);
        consPlano.addActionListener(this);
        delPlano.addActionListener(this);
        altPlano.addActionListener(this);
        // ações do botão Instrutor
        cadInstrutor.addActionListener(this);
        consInstrutor.addActionListener(this);
        delInstrutor.addActionListener(this);
        altInstrutor.addActionListener(this);
        // ações do botão Medidas
        cadMedidas.addActionListener(this);
        consMedidas.addActionListener(this);
        delMedidas.addActionListener(this);
        altMedidas.addActionListener(this);
        // ações do botão Alunos
        cadAluno.addActionListener(this);
        consAluno.addActionListener(this);
        delAluno.addActionListener(this);
        altAluno.addActionListener(this);
        // ações do botão Matricula
        cadMatricula.addActionListener(this);
        consMatricula.addActionListener(this);
        delMatricula.addActionListener(this);
        altMatricula.addActionListener(this);
        // ações do botão Pagamento Mensalidade
        cadPagamentoMensalidade.addActionListener(this);
        consPagamentoMensalidade.addActionListener(this);
        delPagamentoMensalidade.addActionListener(this);
        altPagamentoMensalidade.addActionListener(this);

        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JanelaPrincipal();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String descricao, nomeExercicio, nomeInstrutor, emailInstrutor;
        long telefoneInstrutor;
        int idExercicioInst;
        float alturaMed, pesoMed, bracoDirMed, bracoEsqMed, peitoralMed, quadrilMed, coxaDirMed, coxaEsqMed, panturrilhaDirMed, panturrilhaEsqMed, valorPlano;
        Date dataCadastroMed;
        int idExercicioPlano;
        long cpfAluno, telefoneAluno;
        String nomeCompletoAluno, enderecoAluno, emailAluno;
        Date dataNascimentoAluno;
        Date dataMatriculaAluno;
        int senha;
        //matricula
        float valorMatricula;
        Date dataMatriculaCadastro;
        int idClienteMatricula;
        int idPlanoMatricula;
        //pagamento mensalidade
        int idAlunoPagamentoMensalidade;
        Date dataPagamentoMensalidade;
        Date dataVencimentoPagamentoMensalidade;
        String statusPagamentoMensalidade, data;
        float valorTotalPagamentoMensalidade;
        int idFormaPagamentoPagamentoMensalidade;
        // delete
        int id;
        // alterar
        //cadastro exercicio
        int idAlunoExercicio;

        if (e.getSource() == sair) {
            System.exit(0);
        } else if (e.getSource() == cadFormaPagamento) {
            descricao = JOptionPane.showInputDialog("Digite a sua Forma de Pagamento:");
            cadastrarFormaPagamento(descricao);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!!");
        } else if (e.getSource() == cadExercicio) {
            nomeExercicio = JOptionPane.showInputDialog("Digite o nome do Exercício:");
            cadastrarExercicios(nomeExercicio);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!!");
        } else if (e.getSource() == cadPlano) {
            descricao = JOptionPane.showInputDialog("Digite o Seu Plano:");
            valorPlano = Float.parseFloat(JOptionPane.showInputDialog("Digite o Valor do Plano:"));
            idExercicioPlano = Integer.parseInt(JOptionPane.showInputDialog("Digite o id exercicio plano:"));

            cadastrarPlanos(descricao, valorPlano, idExercicioPlano);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!!");
        } else if (e.getSource() == cadInstrutor) {
            nomeInstrutor = JOptionPane.showInputDialog("Digite o seu nome:");
            telefoneInstrutor = Long.parseLong(JOptionPane.showInputDialog("Digite o seu Telefone:"));
            idExercicioInst = Integer.parseInt(JOptionPane.showInputDialog("Digite o identificador do Exercício:"));
            emailInstrutor = JOptionPane.showInputDialog("Digite o seu Email:");

            cadastrarInstrutor(nomeInstrutor, telefoneInstrutor, idExercicioInst, emailInstrutor);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!!");
        } else if (e.getSource() == cadMedidas) {
            resultado = consultaAlunoNome();
            JOptionPane.showMessageDialog(null, resultado);
            idAlunoExercicio = Integer.parseInt(JOptionPane.showInputDialog("Informe o Aluno: (ID)"));
            alturaMed = Float.parseFloat(JOptionPane.showInputDialog("Informe sua Altura:"));
            pesoMed = Float.parseFloat(JOptionPane.showInputDialog("Informe seu Peso:"));
            bracoDirMed = Float.parseFloat(JOptionPane.showInputDialog("Informe a Medida do seu Braço Direito:"));
            bracoEsqMed = Float.parseFloat(JOptionPane.showInputDialog("Informe a Medida do seu Braço Esquerdo:"));
            peitoralMed = Float.parseFloat(JOptionPane.showInputDialog("Informe a Medida do seu Peitoral:"));
            quadrilMed = Float.parseFloat(JOptionPane.showInputDialog("Informe a Medida do seu Quadril:"));
            coxaDirMed = Float.parseFloat(JOptionPane.showInputDialog("Informe a Medida da sua Coxa Direita:"));
            coxaEsqMed = Float.parseFloat(JOptionPane.showInputDialog("Informe a Medida da sua Coxa Esquerdo:"));
            panturrilhaDirMed = Float.parseFloat(JOptionPane.showInputDialog("Informe a Medida da sua Panturrilha Direita:"));
            panturrilhaEsqMed = Float.parseFloat(JOptionPane.showInputDialog("Informe a Medida da sua Panturrilha Esquerda:"));
            data = JOptionPane.showInputDialog("Informe a Data de Cadastro:");
            resultado = consultaMedidas();
            JOptionPane.showMessageDialog(null, resultado);
            try {
                 dataCadastroMed = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            cadastrarMedidas(idAlunoExercicio, alturaMed, pesoMed, bracoDirMed, bracoEsqMed, peitoralMed, quadrilMed, coxaDirMed, coxaEsqMed, panturrilhaDirMed, panturrilhaEsqMed, dataCadastroMed);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!!");
        } else if (e.getSource() == cadAluno) {
            cpfAluno = Long.parseLong(JOptionPane.showInputDialog("Digite o seu CPF:"));
            nomeCompletoAluno = JOptionPane.showInputDialog("Digite o seu Nome Completo:");
            enderecoAluno = JOptionPane.showInputDialog("Digite o seu Endereço:");
            telefoneAluno = Long.parseLong(JOptionPane.showInputDialog("Digite o seu Telefone:"));
            emailAluno = JOptionPane.showInputDialog("Digite o seu Email:");
            data = JOptionPane.showInputDialog("Digite sua Data de Nascimento:");
            try {
                dataNascimentoAluno = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            data = JOptionPane.showInputDialog("Digite sua Data de Matricula:");
            try {
                dataMatriculaAluno = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            senha = Integer.parseInt(JOptionPane.showInputDialog("Digite sua Senha:"));

            cadastrarAluno(cpfAluno, nomeCompletoAluno, enderecoAluno, telefoneAluno, emailAluno, dataNascimentoAluno, dataMatriculaAluno, senha);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!!");
        } else if (e.getSource() == cadMatricula) {
            valorMatricula = Float.parseFloat(JOptionPane.showInputDialog("Digite o Valor da Matricula:"));
            idClienteMatricula = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Cliente:"));

            data = JOptionPane.showInputDialog("Digite a Data da Matricula:");
            try {
                dataMatriculaCadastro = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            idPlanoMatricula = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Plano:"));

            cadastrarMatricula(valorMatricula, idClienteMatricula, dataMatriculaCadastro, idPlanoMatricula);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!!");

        } else if (e.getSource() == cadPagamentoMensalidade) {
            resultado = consultaAlunoNome();
            idAlunoPagamentoMensalidade = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nDigite o ID do Aluno:"));
            data = JOptionPane.showInputDialog("Digite a Data de Pagamento da Mensalidade:");
            try {
                dataPagamentoMensalidade = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            data = JOptionPane.showInputDialog("Digite a Data de Vencimento da Mensalidade:");
            try {
                dataVencimentoPagamentoMensalidade = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            valorTotalPagamentoMensalidade = Float.parseFloat(JOptionPane.showInputDialog("Digite o Valor Total do Pagamento da Mensalidade:"));
            statusPagamentoMensalidade = JOptionPane.showInputDialog("Digite o Status de Pagamento: (Pago - Não Pago)");
            resultado = consultaFormaPagamento();
            idFormaPagamentoPagamentoMensalidade = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nDigite o ID da Forma de Pagamento:"));

            cadastrarPagamentoMensalidade(idAlunoPagamentoMensalidade, dataPagamentoMensalidade, dataVencimentoPagamentoMensalidade, valorTotalPagamentoMensalidade, statusPagamentoMensalidade, idFormaPagamentoPagamentoMensalidade);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!!");
        } else if (e.getSource() == consFormaPagamento) {
            resultado = consultaFormaPagamento();
            JOptionPane.showMessageDialog(null, resultado);
        } else if (e.getSource() == consExercicios) {
            resultado = consultaExercicios();
            JOptionPane.showMessageDialog(null, resultado);
        } else if (e.getSource() == consPlano) {
            resultado = consultaPlano();
            JOptionPane.showMessageDialog(null, resultado);
        } else if (e.getSource() == consAluno) {
            resultado = consultaAluno();
            JOptionPane.showMessageDialog(null, resultado);
        } else if (e.getSource() == consInstrutor) {
            resultado = consultaInstrutor();
            JOptionPane.showMessageDialog(null, resultado);
        } else if (e.getSource() == consMedidas) {
            resultado = consultaMedidas();
            JOptionPane.showMessageDialog(null, resultado);
        } else if (e.getSource() == consMatricula) {
            resultado = consultaMatricula();
            JOptionPane.showMessageDialog(null, resultado);
        } else if (e.getSource() == consPagamentoMensalidade) {
            resultado = consultaPagamentoMensalidade();
            JOptionPane.showMessageDialog(null, resultado);
        } else if (e.getSource() == delAluno) {
            resultado = consultaAluno();
            id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nQual Aluno deseja Remover?"));
            removerAluno(id);
            System.out.println("Aluno Removido com Sucesso!");
        } else if (e.getSource() == delExercicios) {
            resultado = consultaExercicios();
            id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nQual Exercicio deseja Remover?"));
            removerExercicio(id);
            System.out.println("Exercicio Removido com Sucesso!");
        } else if (e.getSource() == delInstrutor) {
            resultado = consultaInstrutor();
            id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nQual Instrutor deseja Remover?"));
            removerInstrutor(id);
            System.out.println("Instrutor Removido com Sucesso!");
        } else if (e.getSource() == delFormaPagamento) {
            resultado = consultaFormaPagamento();
            id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nQual Forma de Pagamento deseja Remover?"));
            removerFormaPagamento(id);
            System.out.println("Forma de Pagamento Removido com Sucesso!");
        } else if (e.getSource() == delMatricula) {
            resultado = consultaMatricula();
            id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nQual Matricula deseja Remover?"));
            removerMatricula(id);
            System.out.println("Matricula Removido com Sucesso!");
        } else if (e.getSource() == delMedidas) {
            resultado = consultaMedidas();
            id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nQual Medida deseja Remover?"));
            removerMedidas(id);
            System.out.println("Medida Removido com Sucesso!");
        } else if (e.getSource() == delPagamentoMensalidade) {
            resultado = consultaPagamentoMensalidade();
            id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nQual Pagamento Mensalidade deseja Remover?"));
            removerPagamentoMensalidade(id);
            System.out.println("Pagamento Mensalidade Removido com Sucesso!");
        } else if (e.getSource() == delPlano) {
            resultado = consultaPlano();
            id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nQual Plano deseja Remover?"));
            removerPlanos(id);
            System.out.println("Plano Removido com Sucesso!");
        } else if (e.getSource() == altAluno) {
            resultado = consultaAluno();
            id = Integer.parseInt(JOptionPane.showInputDialog(null,  resultado + "\nQual aluno deseja alterar? (Id)"));

            cpfAluno = Long.parseLong(JOptionPane.showInputDialog("Digite o seu CPF:"));
            nomeCompletoAluno = JOptionPane.showInputDialog("Digite o seu Nome Completo:");
            enderecoAluno = JOptionPane.showInputDialog("Digite o seu Endereço:");
            telefoneAluno = Long.parseLong(JOptionPane.showInputDialog("Digite o seu Telefone:"));
            emailAluno = JOptionPane.showInputDialog("Digite o seu Email:");
            data = JOptionPane.showInputDialog("Digite sua Data de Nascimento:");
            try {
                dataNascimentoAluno = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            data = JOptionPane.showInputDialog("Digite sua Data de Matricula:");
            try {
                dataMatriculaAluno = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            senha = Integer.parseInt(JOptionPane.showInputDialog("Digite sua Senha:"));

            alterarAluno(id, cpfAluno, nomeCompletoAluno, enderecoAluno, telefoneAluno, emailAluno, dataNascimentoAluno, dataMatriculaAluno, senha);
            JOptionPane.showMessageDialog(null, "Aluno Alterado com Sucesso.");
        } else if (e.getSource() == altExercicios) {
            resultado = consultaExercicios();
            JOptionPane.showMessageDialog(null, resultado);
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual Exercício Deseja Alterar? (Id)"));

            nomeExercicio = JOptionPane.showInputDialog(null, "Informe o Nome do Exercicio:");

            alterarExercicio(id, nomeExercicio);
            JOptionPane.showMessageDialog(null, "Exercício Alterado com Sucesso.");
        } else if (e.getSource() == altFormaPagamento) {
            resultado = consultaFormaPagamento();
            JOptionPane.showMessageDialog(null, resultado);

            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual Forma de Pagamento Deseja Alterar? (Id)"));
            descricao = JOptionPane.showInputDialog(null, "Informe o Nome da Forma de Pagamento:");

            alterarFormaPagamento(id, descricao);
            JOptionPane.showMessageDialog(null, "Forma de Pagamento Alterado com Sucesso.");
        } else if (e.getSource() == altInstrutor) {
            resultado = consultaInstrutor();
            JOptionPane.showMessageDialog(null, resultado);

            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual Instrutor Deseja Alterar? (Id)"));

            nomeInstrutor = JOptionPane.showInputDialog(null, "Informe o Nome do Instrutor:");
            telefoneInstrutor = Long.parseLong(JOptionPane.showInputDialog(null, "Informe o Telefone do Instrutor:"));
            resultado = consultaExercicios();
            JOptionPane.showMessageDialog(null, resultado);
            idExercicioInst = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o Identificador do Exercício do Instrutor:"));
            emailInstrutor = JOptionPane.showInputDialog(null, "Informe o Email do Instrutor:");

            alterarInstrutor(id, nomeInstrutor, telefoneInstrutor, idExercicioInst, emailInstrutor);
            JOptionPane.showMessageDialog(null, "Instrutor Alterado com Sucesso.");
        } else if (e.getSource() == altMatricula) {
            resultado = consultaMatricula();

            id = Integer.parseInt(JOptionPane.showInputDialog(null, resultado + "\nQual Matricula Deseja Alterar? (Id)"));
            valorMatricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o Valor da Matricula:"));
            idClienteMatricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ID do Cliente:"));
            data = JOptionPane.showInputDialog(null, "Informe a Data de Matricula do Cliente:");
            try {
                dataMatriculaCadastro = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            resultado = consultaPlano();
            JOptionPane.showMessageDialog(null, resultado);
            idPlanoMatricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o Identificador do Plano:"));

            alterarMatricula(id, valorMatricula, idClienteMatricula, dataMatriculaCadastro, idPlanoMatricula);
            JOptionPane.showMessageDialog(null, "Matricula Alterada com Sucesso.");
        } else if (e.getSource() == altMedidas) {
            resultado = consultaMedidas();
            JOptionPane.showMessageDialog(null, resultado);

            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Quais Medidas Deseja Alterar? (Id)"));

            alturaMed = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe sua Altura:"));
            pesoMed = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe seu Peso:"));
            bracoDirMed = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe a Medida do seu Braço Direito:"));
            bracoEsqMed = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe a Medida do seu Braço Esquerdo:"));
            peitoralMed = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe a Medida do seu Peitoral:"));
            quadrilMed = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe Medida do seu Quadril:"));
            coxaDirMed = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe Medida da sua Coxa Direita:"));
            coxaEsqMed = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe Medida da sua Coxa Esquerda:"));
            panturrilhaDirMed = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe a Medida da sua Panturrilha Direita:"));
            panturrilhaEsqMed = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe a Medida da sua Panturrilha Esquerda:"));

            data = JOptionPane.showInputDialog(null, "Informe o Telefone do Instrutor:");
            try {
                dataCadastroMed = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            alterarMedidas(id, alturaMed, pesoMed, bracoDirMed, bracoEsqMed, peitoralMed, quadrilMed, coxaDirMed, coxaEsqMed, panturrilhaDirMed, panturrilhaEsqMed, dataCadastroMed);
            JOptionPane.showMessageDialog(null, "Instrutor Alterado com Sucesso.");

        } else if (e.getSource() == altPagamentoMensalidade) {
            resultado = consultaPagamentoMensalidade();
            JOptionPane.showMessageDialog(null, resultado);

            idAlunoPagamentoMensalidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual Aluno Deseja Alterar? (Id)"));

            data = JOptionPane.showInputDialog(null, "Informe o Telefone do Instrutor:");
            try {
                dataPagamentoMensalidade = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }

            /*resultado = JOptionPane.showInputDialog("Informe a Data da Consulta:");
            try {
                dataConsulta = new SimpleDateFormat("yyyy/MM/dd").parse(resultado);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }*/

            data = JOptionPane.showInputDialog(null, "Informe o Nome do Instrutor:");
            try {
                dataVencimentoPagamentoMensalidade = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            valorTotalPagamentoMensalidade = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o Nome do Instrutor:"));
            statusPagamentoMensalidade = JOptionPane.showInputDialog(null, "Informe o Nome do Instrutor:");
            idFormaPagamentoPagamentoMensalidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o Nome do Instrutor:"));

            JOptionPane.showMessageDialog(null, resultado);
            idExercicioInst = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o Identificador do Exercício do Instrutor:"));
            emailInstrutor = JOptionPane.showInputDialog(null, "Informe o Email do Instrutor:");

            alterarPagamentoMensalidade(idAlunoPagamentoMensalidade,  dataPagamentoMensalidade,  dataVencimentoPagamentoMensalidade, valorTotalPagamentoMensalidade,  statusPagamentoMensalidade,  idFormaPagamentoPagamentoMensalidade);
            JOptionPane.showMessageDialog(null, "Instrutor Alterado com Sucesso.");

        } else if (e.getSource() == altPlano) {
            resultado = consultaPlano();
            JOptionPane.showMessageDialog(null, resultado);

            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual Plano Deseja Alterar? (Id)"));

            descricao = JOptionPane.showInputDialog(null, "Informe a Descrição do Plano:");
            valorPlano = Long.parseLong(JOptionPane.showInputDialog(null, "Informe o Valor do Plano:"));
            resultado = consultaPlano();
            idExercicioPlano = Integer.parseInt(JOptionPane.showInputDialog(null, resultado + "\nInforme o Identificador do Exercício do Plano:"));

            alterarPlanos(id, descricao, valorPlano, idExercicioPlano);
            JOptionPane.showMessageDialog(null, "Plano Alterado com Sucesso.");
        }
    }

    public static void alterarAluno(int id, long cpfAluno, String nomeCompletoAluno, String enderecoAluno,
                                    long telefoneAluno, String emailAluno, Date dataNascimentoAluno, Date dataMatriculaAluno, int senha) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        AlunoDao alunoDao = new AlunoDao(em);

        //buscar produto e carregar na variável p
        Aluno p = alunoDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();

        //chamar o método de cadastro
        alunoDao.alterar(p);
        p.setCpf(cpfAluno);
        p.setNomeCompleto(nomeCompletoAluno);
        p.setEndereco(enderecoAluno);
        p.setTelefone(telefoneAluno);
        p.setEmail(emailAluno);
        p.setDataNascimento(dataNascimentoAluno);
        p.setDataMatricula(dataMatriculaAluno);
        p.setSenha(senha);

        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void alterarExercicio(int id, String nomeExercicio) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ExerciciosDao exerciciosDao = new ExerciciosDao(em);

        //buscar produto e carregar na variável p
        Exercicios p = exerciciosDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();

        //chamar o método de cadastro
        exerciciosDao.alterar(p);
        p.setNomeExercicio(nomeExercicio);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void alterarFormaPagamento(int id, String descricao) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(em);

        //buscar produto e carregar na variável p
        FormaPagamento p = formaPagamentoDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();

        //chamar o método de cadastro
        formaPagamentoDao.alterarFormaPagamento(p);
        p.setDescricao(descricao);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void alterarInstrutor(int id, String nome, long telefone, int idExercicio, String email) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        InstrutorDao instrutorDao = new InstrutorDao(em);

        //buscar produto e carregar na variável p
        Instrutor p = instrutorDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();

        //chamar o método de cadastro
        instrutorDao.alterarInstrutor(p);
        p.setNome(nome);
        p.setTelefone(telefone);
        p.setIdExercicio(idExercicio);
        p.setEmail(email);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void alterarMatricula(int id, float valor, int idCliente, Date dataMatricula, int idPlano) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        MatriculaDao matriculaDao = new MatriculaDao(em);

        //buscar produto e carregar na variável p
        Matricula p = matriculaDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();

        //chamar o método de cadastro
        MatriculaDao.alterarMatricula(p);
        p.setValorMatricula(valor);
        p.setIdCliente(idCliente);
        p.setDataMatricula(dataMatricula);
        p.setIdPlano(idPlano);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void alterarMedidas(int id, float altura, float peso, float bracoDir, float bracoEsq, float peitoral,
                                      float quadril, float coxaDir, float coxaEsq, float panturrilhaDir, float panturrilhaEsq, Date dataCadastro) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        MedidasDao medidasDao = new MedidasDao(em);

        //buscar produto e carregar na variável p
        Medidas p = medidasDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();

        //chamar o método de cadastro
        MedidasDao.alterarMedidas(p);
        p.setAltura(altura);
        p.setPeso(peso);
        p.setBracoDir(bracoDir);
        p.setBracoEsq(bracoEsq);
        p.setPeitoral(peitoral);
        p.setQuadril(quadril);
        p.setCoxaDir(coxaDir);
        p.setCoxaEsq(coxaEsq);
        p.setPanturrilhaDir(panturrilhaDir);
        p.setPanturrilhaEsq(panturrilhaEsq);
        p.setDataCadastro(dataCadastro);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void alterarPagamentoMensalidade(int id, Date dataPagamento, Date dataVencimento,
                                                   float valorTotalPagamentoMensalidade, String statusPagamentoMensalidade, int idFormaPagamentoPagamentoMensalidade) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PagamentoMensalidadeDao pagamentoMensalidadeDao = new PagamentoMensalidadeDao(em);

        //buscar produto e carregar na variável p
        PagamentoMensalidade p = pagamentoMensalidadeDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();

        //chamar o método de cadastro
        //PagamentoMensalidadeDao.alterar(p);
        p.setIdAluno(id);
        p.setDataPagamento(dataPagamento);
        p.setDataVencimento(dataVencimento);
        p.setValorTotal(valorTotalPagamentoMensalidade);
        p.setStatus(statusPagamentoMensalidade);
        p.setIdFormaPagamento(idFormaPagamentoPagamentoMensalidade);

        //valida a transação
        em.getTransaction().commit();
        em.close();
    }
    public static void alterarPlanos(int id, String descricao, float valor, int idExercico) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PlanosDao planosDao = new PlanosDao(em);

        //buscar produto e carregar na variável p
        Planos p = planosDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();

        //chamar o método de cadastro
       // PlanosDao.alterar(p);
        p.setIdPlanos(id);
        p.setDescricao(descricao);
        p.setValor(valor);
        p.setIdExercicio(idExercico);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

   /* public static void alterarFuncionario(int id, String nomeFunc, long cpf, long fone, int crm, int idProfissao) {
        EntityManager em = JPAUtil.getEntityManager();
        FuncionarioDao funcionarioDao = new FuncionarioDao(em);

        Funcionario p = funcionarioDao.buscarPorId(id);

        em.getTransaction().begin();
        funcionarioDao.alterarFuncionario(p);

        p.setIdFuncionario(id);
        p.setNomeFunc(nomeFunc);
        p.setCpf(cpf);
        p.setFone(fone);
        p.setCrm(crm);
        p.setIdProfissao(idProfissao);

        em.getTransaction().commit();
        em.close();
    }*/

    public static void removerAluno(int id) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        AlunoDao alunoDao = new AlunoDao(em);

        //buscar produto e carregar na variável p
        Aluno p = alunoDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        alunoDao.removerAluno(p);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void removerExercicio(int id) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ExerciciosDao exerciciosDao = new ExerciciosDao(em);

        //buscar produto e carregar na variável p
        Exercicios p = exerciciosDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        exerciciosDao.removerExercicio(p);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void removerInstrutor(int id) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        InstrutorDao instrutorDao = new InstrutorDao(em);

        //buscar produto e carregar na variável p
        Instrutor p = instrutorDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        instrutorDao.removerInstrutor(p);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void removerFormaPagamento(int id) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(em);

        //buscar produto e carregar na variável p
        FormaPagamento p = formaPagamentoDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        formaPagamentoDao.removerFormaPagamento(p);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void removerMatricula(int id) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        MatriculaDao matriculaDao = new MatriculaDao(em);

        //buscar produto e carregar na variável p
        Matricula p = matriculaDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        matriculaDao.removerMatricula(p);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void removerMedidas(int id) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        MedidasDao medidasDao = new MedidasDao(em);

        //buscar produto e carregar na variável p
        Medidas p = medidasDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        medidasDao.removerMedidas(p);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void removerPagamentoMensalidade(int id) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PagamentoMensalidadeDao pagamentoMensalidadeDao = new PagamentoMensalidadeDao(em);

        //buscar produto e carregar na variável p
        PagamentoMensalidade p = pagamentoMensalidadeDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        pagamentoMensalidadeDao.removerPagamentoMensalidade(p);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void removerPlanos(int id) {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PlanosDao planosDao = new PlanosDao(em);

        //buscar produto e carregar na variável p
        Planos p = planosDao.buscarPorId(id);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        planosDao.remover(p);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static String consultaFormaPagamento() {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(em);
        List<FormaPagamento> todos = formaPagamentoDao.buscarTodos();

        int tam = todos.size();
        resultado = "ID - DESCRIÇÃO\n";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getIdFormaPagamento() + " - " + todos.get(i).getDescricao() + "\n";
        }
        return resultado;
    }

    public static String consultaExercicios() {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ExerciciosDao exerciciosDao = new ExerciciosDao(em);
        List<Exercicios> todos = exerciciosDao.buscarTodos();

        int tam = todos.size();
        resultado = "ID - DESCRIÇÃO\n";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getIdExercicio() + " - " + todos.get(i).getNomeExercicio() + "\n";
        }
        return resultado;
    }

    public static String consultaPlano() {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PlanosDao planosDao = new PlanosDao(em);
        List<Planos> todos = planosDao.buscarTodos();

        int tam = todos.size();
        resultado = "ID - DESCRIÇÃO - EXERCICIO - VALOR\n";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getIdPlanos() + " - " + todos.get(i).getDescricao() + " - " + todos.get(i).getIdExercicio() + " - " + todos.get(i).getValor() + "\n";

        }
        return resultado;
    }

    public static String consultaPlanoNome() {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PlanosDao planosDao = new PlanosDao(em);
        List<Planos> todos = planosDao.buscarTodos();

        int tam = todos.size();
        resultado = "ID - DESCRIÇÃO - EXERCICIO - VALOR\n";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getIdPlanos() + " - " + todos.get(i).getDescricao() + "\n";
        }
        return resultado;

    }

    public static String consultaAluno() {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        AlunoDao alunoDao = new AlunoDao(em);
        List<Aluno> todos = alunoDao.buscarTodos();

        int tam = todos.size();
        resultado = "ID - NOME - CPF - DATA NASCIMENTO - ENDEREÇO - TELEFONE - DATA MATRICULA\n";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getIdAluno() + " - " + todos.get(i).getNomeCompleto() + " - " + todos.get(i).getCpf() + " - " + todos.get(i).getDataNascimento() + " - " + todos.get(i).getEndereco() + " - " + todos.get(i).getTelefone() + " - " + todos.get(i).getDataMatricula() + "\n";

        }
        return resultado;
    }

    public static String consultaAlunoNome() {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        AlunoDao alunoDao = new AlunoDao(em);
        List<Aluno> todos = alunoDao.buscarTodos();

        int tam = todos.size();
        resultado = "ID - NOME\n";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getIdAluno() + " - " + todos.get(i).getNomeCompleto() + " - " + "\n";

        }
        return resultado;
    }

    public static String consultaInstrutor() {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        InstrutorDao instrutorDao = new InstrutorDao(em);
        List<Instrutor> todos = instrutorDao.buscarTodos();

        int tam = todos.size();
        resultado = "ID - NOME - EMAIL - TELEFONE\n";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getIdInstrutor() + " - " + todos.get(i).getNome() + " - " + todos.get(i).getEmail() + " - " + todos.get(i).getTelefone() + "\n";
        }
        return resultado;
    }

    public static String consultaMedidas() {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        MedidasDao medidasDao = new MedidasDao(em);
        List<Medidas> todos = medidasDao.buscarTodos();

        int tam = todos.size();
        resultado = "ID MEDIDAS -ID ALUNO - PESO - ALTURA - PEITORAL - QUADRIL - PANTURRILHA DIR/ESQRAÇO DIR/ESQ - COXA DIR/ESQ - DATA CADASTRO\n";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getIdMedidas() + " - " + todos.get(i).getIdAluno() + " - " + todos.get(i).getPeso() + " - " + todos.get(i).getAltura() + " - " + todos.get(i).getPeitoral() + " - " + todos.get(i).getQuadril() + " - " + todos.get(i).getBracoDir() + " - " + todos.get(i).getBracoEsq() + " - " + todos.get(i).getCoxaDir() + " - " + todos.get(i).getCoxaEsq() + " - " + todos.get(i).getPanturrilhaDir() + " - " + todos.get(i).getPanturrilhaEsq() + " - " + todos.get(i).getDataCadastro() + "\n";
        }
        return resultado;
    }

    public static String consultaMatricula() {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        MatriculaDao matriculaDao = new MatriculaDao(em);
        List<Matricula> todos = matriculaDao.buscarTodos();

        int tam = todos.size();
        resultado = "ID MATRICULA - VALOR - DATA MATRICULA - ID CLIENTE - ID PLANO\n";
         for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getIdMatricula() + " - " +todos.get(i).getValorMatricula() + " - " + todos.get(i).getDataMatricula() + " - " + todos.get(i).getIdCliente() + " - " + todos.get(i).getIdPlano() + "\n";
        }
        return resultado;
    }

    public static String consultaPagamentoMensalidade() {
        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PagamentoMensalidadeDao pagamentoMensalidadeDao = new PagamentoMensalidadeDao(em);
        List<PagamentoMensalidade> todos = pagamentoMensalidadeDao.buscarTodos();

        int tam = todos.size();
        resultado = "ID ALUNO - DATA PAGAMENTO - DATA VENCIMENTO - VALOR TOTAL - STATUS - ID FORMA PAGAMENTO\n";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getIdAluno() + " - " + todos.get(i).getDataPagamento() + " - " + todos.get(i).getDataVencimento() + " - " + todos.get(i).getValorTotal() + todos.get(i).getValorTotal() + " - " + todos.get(i).getStatus() + " - " + todos.get(i).getIdFormaPagamento() + "\n";
        }
        return resultado;
    }

    public static void cadastrarFormaPagamento(String descricao) {
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setDescricao(descricao);

        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(em);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        formaPagamentoDao.cadastrar(formaPagamento);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void cadastrarExercicios(String nomeExercicio) {
        Exercicios exercicios = new Exercicios();
        exercicios.setNomeExercicio(nomeExercicio);

        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ExerciciosDao exerciciosDao = new ExerciciosDao(em);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        exerciciosDao.cadastrar(exercicios);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void cadastrarPlanos(String descricao, float valor, int idExercico) {
        Planos planos = new Planos();
        planos.setDescricao(descricao);
        planos.setValor(valor);
        planos.setIdExercicio(idExercico);

        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PlanosDao planosDao = new PlanosDao(em);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        planosDao.cadastrar(planos);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void cadastrarAluno(long cpf, String nomeCompleto, String endereco, long telefone, String
            email, Date dataNascimento, Date dataMatricula, int senha) {
        Aluno aluno = new Aluno();
        aluno.setCpf(cpf);
        aluno.setNomeCompleto(nomeCompleto);
        aluno.setEndereco(endereco);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
        aluno.setDataNascimento(dataNascimento);
        aluno.setDataMatricula(dataMatricula);
        aluno.setSenha(senha);

        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        AlunoDao alunoDao = new AlunoDao(em);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        alunoDao.cadastrar(aluno);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void cadastrarInstrutor(String nome, long telefone, int idExercicio, String email) {
        Instrutor instrutor = new Instrutor();
        instrutor.setNome(nome);
        instrutor.setTelefone(telefone);
        instrutor.setIdExercicio(idExercicio);
        instrutor.setEmail(email);

        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        InstrutorDao instrutorDao = new InstrutorDao(em);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        instrutorDao.cadastrar(instrutor);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void cadastrarMedidas(int idAluno, float altura, float peso, float bracoDir, float bracoEsq, float peitoral,
                                        float quadril, float coxaDir, float coxaEsq, float panturrilhaDir, float panturrilhaEsq, Date dataCadastro) {
        Medidas medidas = new Medidas();
        medidas.setIdAluno(idAluno);
        medidas.setAltura(altura);
        medidas.setPeso(peso);
        medidas.setBracoDir(bracoDir);
        medidas.setBracoEsq(bracoEsq);
        medidas.setPeitoral(peitoral);
        medidas.setQuadril(quadril);
        medidas.setCoxaDir(coxaDir);
        medidas.setCoxaEsq(coxaEsq);
        medidas.setPanturrilhaDir(panturrilhaDir);
        medidas.setPanturrilhaEsq(panturrilhaEsq);
        medidas.setDataCadastro(dataCadastro);

        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        MedidasDao medidasDao = new MedidasDao(em);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        medidasDao.cadastrar(medidas);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    //valorMatricula, idClienteMatricula, dataMatriculaCadastro, idPlanoMatricula
    public static void cadastrarMatricula(float valor, int idCliente, Date dataMatricula, int idPlano) {
        Matricula matricula = new Matricula();
        matricula.setValorMatricula(valor);
        matricula.setIdCliente(idCliente);
        matricula.setDataMatricula(dataMatricula);
        matricula.setIdPlano(idPlano);

        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        MatriculaDao matriculaDao = new MatriculaDao(em);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        matriculaDao.cadastrar(matricula);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }

    public static void cadastrarPagamentoMensalidade(int idAluno, Date dataPagamento, Date dataVencimento,
                                                     float valorTotalPagamentoMensalidade, String statusPagamentoMensalidade, int idFormaPagamentoPagamentoMensalidade) {
        PagamentoMensalidade pagamentoMensalidade = new PagamentoMensalidade();
        pagamentoMensalidade.setIdAluno(idAluno);
        pagamentoMensalidade.setDataPagamento(dataPagamento);
        pagamentoMensalidade.setDataVencimento(dataVencimento);
        pagamentoMensalidade.setValorTotal(valorTotalPagamentoMensalidade);
        pagamentoMensalidade.setStatus(statusPagamentoMensalidade);
        pagamentoMensalidade.setIdFormaPagamento(idFormaPagamentoPagamentoMensalidade);

        //classe para conectar o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        PagamentoMensalidadeDao pagamentoMensalidadeDao = new PagamentoMensalidadeDao(em);
        //inicializa a transação
        em.getTransaction().begin();
        //chamar o método de cadastro
        pagamentoMensalidadeDao.cadastrar(pagamentoMensalidade);
        //valida a transação
        em.getTransaction().commit();
        em.close();
    }
}
