/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabpc2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author tinei
 */
public class TrabPC2 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
       
          Sistema sist = Sistema.getInstance();
          

        int opc=0;
        int opc1=0;
        String motivo="";
        String nome="";
        String nomeLogin="";
        String senha="";
        int num=1;
        long id=1;
        long numParaExcluir=0;
        long idParaExcluir=0;
        long numCNS=0;
        String relato="";
        String datadenascimento="";
        String nomeMae="";
        Sexo sex = null;
        String sexo="";
        String nomeParaBuscar="";
        int numeroEndereco=1;
        String logradouro="";
        String cidade="";
        String uf="";
        String diagnostico="";
        int opcTipo=1;
        String tipo;
        int opcCadastro;
        Tipo g = Tipo.Atendente;
        
        Paciente[] pacientes = sist.listarPacientes();
        Usuario[] usuarios = sist.listarUsuarios();
        Anamnese[] anamneses = sist.listarAnamnese();
        sist.init();
         do{   System.out.print("Digite 1 se já tem cadastro ou 2 se quer fazer: ");
         opcCadastro = sc.nextInt();
        
        if (opcCadastro==2) {
        System.out.print("Digite M para Medico ou A para atendente: ");
            tipo = sc.next();
                    switch(tipo){
                        case "M":
                        
                            g = Tipo.Medico;
                            break;
                        case "A":
                        
                            g = Tipo.Atendente;
                            break;
                    }
                    System.out.print("Digite seu nome: ");
                    nome = scString.next();
                    System.out.print("Digite seu login: ");
                    nomeLogin = sc.next();
                    
                    System.out.print("Digite sua senha: ");
                    senha = sc.next();
                    Usuario usu = new Usuario(nome, nomeLogin, senha, id, g);
                    usu.setSenha(senha);
                    sist.adicionarUsuario(usu);
        }
                    
        }while(opcCadastro==2);


        do {
            
            System.out.println("\n\t    MENU\n"
                    + "Digite 0 para sair\n"
                    + "Digite 1 para Inserir um paciente\n"
                    + "Digite 2 buscar um paciente\n"
                    + "Digite 3 para excluir um paciente\n"
                    + "Digite 4 para imprimir os pacientes\n"
                    + "Digite 5 para ir para o modulo Anamnese\n"
                    + "Digite 6 para alterar um paciente");
            System.out.print("\nDigite: ");
            opc = sc.nextInt();
            
            switch (opc) {
                
                case 0:
                    System.exit(0);
                    
                    
                    
                    
                    break;
                case 1:
                    Paciente novoPaciente = new Paciente(nome,nomeMae,sex,datadenascimento);
                    //Endereco end = new Endereco(logradouro,numeroEndereco,cidade,uf);
                    // Coletar dados do paciente
                    System.out.println("--------------------");
                    System.out.print("Digite o nome: ");
                    nome = scString.next();
                    System.out.println("--------------------");
                    System.out.print("Digite a data de nascimento: ");
                    datadenascimento = sc.next();
                    SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
                    Date data2 = null;
                    try {
                        data2 = formataData.parse(datadenascimento);

                    } catch (ParseException e) {

                        System.out.println("Erro na data");
                    }
                    String datareal = formataData.format(data2);

                    
                    System.out.println("--------------------");
                    System.out.print("Digite o sexo(F/M): ");
                    sexo = sc.next().toUpperCase();
                    System.out.println("--------------------");
                    System.out.print("Digite o nome da mãe: ");
                    nomeMae = scString.next();
                    System.out.println("--------------------");

                    novoPaciente.setNome(nome);
                    novoPaciente.setNomeMae(nomeMae);
                   
                    novoPaciente.setDataNascimento(datadenascimento);
                    switch (sexo) {
                        case "F":
                        case "f":
                            novoPaciente.setSexo(Sexo.F);
                            break;
                        case "M":
                        case "m":
                            novoPaciente.setSexo(Sexo.M);
                            break;
                        default:
                            novoPaciente.setSexo(Sexo.I);
                    }

                    // Coletar endereço
                    System.out.print("Digite o endereço: ");
                    logradouro = scString.next();
                    System.out.println("--------------------");
                    System.out.print("Digite o numero da casa ou apartamento: ");
                    numeroEndereco = sc.nextInt();
                    System.out.println("--------------------");
                    System.out.print("Digite a cidade: ");
                    cidade = scString.next();
                    System.out.println("--------------------");
                    System.out.print("Digite o uf: ");
                    uf = scString.next();
                    System.out.println("--------------------");
                    Endereco end = new Endereco(logradouro,numeroEndereco,cidade,uf);
                    novoPaciente.setEnd(end);
                    //novoPaciente.setEnd(end).set
                    //novoPaciente.end.cidade = cidade;
                    //novoPaciente.end.numero = numeroEndereco;
                    //novoPaciente.end.uf = uf;
                    
                    novoPaciente.adicionarEndereco(novoPaciente,end);
                    
                    sist.adicionarPaciente(novoPaciente);
                    
                    break;
                case 2:
                    String leftAlignFOrmat = "|%-17s|%-17s|%-4s|%-10s|%-16s|%-15s|%-2s|%-6s|%n";
                    System.out.println("--------------------");
                    System.out.print("Digite o numero de CNS do paciente que voce quer buscar: ");
                    long numParaBuscar = sc.nextLong();
                    sist.buscarPaciente(numParaBuscar);
                    
                    Paciente pacienteBuscado = sist.buscarPaciente(numParaBuscar);

                    System.out.format("+-----------------+-----------------+----+----------+----------------+---------------+--+------+%n");
                    System.out.format("|NOME             |MÃE              |SEXO|CNS       |Endereço        |Cidade         |UF|Numero|%n");
                    System.out.format("+-----------------+-----------------+----+----------+----------------+---------------+--+------+%n");

                    System.out.format(leftAlignFOrmat,pacienteBuscado.getNome(),pacienteBuscado.getNomeMae(),pacienteBuscado.getSexo(),
                            pacienteBuscado.getNumCNS(),pacienteBuscado.getEnd().getLogradouro(), pacienteBuscado.getEnd().getCidade(),
                            pacienteBuscado.getEnd().getUf(), pacienteBuscado.getEnd().getNumero(),pacienteBuscado.getDataNascimento());
                    System.out.format("+-----------------+-----------------+----+----------+----------------+---------------+--+------+%n");

                    break;
                case 3:
                    System.out.println("--------------------");
                    System.out.print("\nDigite o numero CNS do paciente que voce quer excluir: ");
                    numParaExcluir = sc.nextLong();
                    if (sist.excluirPaciente(numParaExcluir) == false) {
                        System.out.println("Erro, o paciente que voce tentou excluir nao existe ou ja possui anamnese");

                    }
                    sist.excluirPaciente(numParaExcluir);
                    break;
                case 4:
                    listarPacientes(pacientes);

                    break;
                case 6:
                    System.out.println("Digite o numero de CNS do paciente que voce quer alterar: ");
                    long numCNSparaalterar = sc.nextLong();
                    System.out.println("Observação: O numero de CNS nao podera ser alterado");
                    Paciente pAlterado = new Paciente(nome,nomeMae,sex,datadenascimento);
                   // Endereco end1 = new Endereco(logradouro,numeroEndereco,cidade,uf);
                    System.out.println("Digite o nome: ");
                    nome = scString.nextLine();

                    System.out.println("Digite o sexo(F/M): ");
                    sexo = sc.next().toUpperCase();
                    System.out.println("Digite a data de nascimento: ");
                    datadenascimento = sc.next();
                    System.out.println("Digite o nome da mãe: ");
                    nomeMae = scString.nextLine();

                    pAlterado.setNome(nome);
                    pAlterado.setNomeMae(nomeMae);
                    pAlterado.setNumCNS(numCNSparaalterar);
                    pAlterado.setDataNascimento(datadenascimento);
                    switch (sexo) {
                        case "F":
                        case "f":
                            pAlterado.setSexo(Sexo.F);
                            break;
                        case "M":
                        case "m":
                            pAlterado.setSexo(Sexo.M);
                            break;
                        default:
                            pAlterado.setSexo(Sexo.I);
                    }
                    // Coletar endereço
                    System.out.println("Digite seu endereço: ");
                    logradouro = scString.nextLine();
                    System.out.println("Digite o numero da casa ou apartamento: ");
                    numeroEndereco = sc.nextInt();
                    System.out.println("Digite a cidade: ");
                    cidade = scString.nextLine();
                    System.out.println("Digite o uf: ");
                    uf = scString.nextLine();
                    
                    
                    

                    Endereco end1 = new Endereco(logradouro,numeroEndereco,cidade,uf);
                    pAlterado.setEnd(end1);
                    
                    sist.alterarPaciente(pAlterado);

                    break;
                case 5:
                    System.out.println("Digite seu login: ");
                    String login2 = sc.next();
                    System.out.println("Digite sua senha: ");
                    String senha2 = sc.next();
                    if (sist.conferirlogin(senha2, login2 )!=null){
                        System.out.println("Acesso permitido");
                    }else {
                        System.out.println("Acesso negado");
                        System.exit(0);
                    }
                        
                   
                    do {
                        System.out.println("\n\t    MENU\n"
                                + "Digite 0 para voltar ao modulo paciente\n"
                                + "Digite 1 para Inserir uma Anamnese\n"
                                + "Digite 2 alterar uma anamnese\n"
                                + "Digite 3 para excluir uma anamnese\n"
                                + "Digite 4 para imprimir as anamneses\n"
                                + "Digite 5 para buscar uma anamnese"
                        );
                        System.out.print("\nDigite: ");
                        opc1 = sc.nextInt();

                        switch (opc1) {
                            case 1:
                                System.out.println("--------------------");
                                System.out.print("Digite o numero CNS do paciente que queira fazer a anamnese: ");
                                num = sc.nextInt();
                                System.out.println("--------------------");
                                System.out.print("Digite o motivo que o paciente veio para a consulta: ");
                                motivo = scString.nextLine();
                                System.out.println("--------------------");
                                System.out.print("Digite o relato do paciente: ");
                                relato = scString.nextLine();
                                System.out.println("--------------------");
                                System.out.print("Faça um diagnostico: ");
                                diagnostico = scString.nextLine();
                                Anamnese anamnese = new Anamnese(motivo,relato,diagnostico,num);
                                sist.adicionarAnamneseAopaciente(pacientes, anamnese, num, sist);

                                break;
                            case 4:
                                listarAnamneses(anamneses);
                                break;
                            case 3:
                                System.out.println("--------------------");
                                System.out.print("Digite o numero CNS do paciente que voce quer excluir a anamnese: ");
                                idParaExcluir = sc.nextLong();
                                sist.excluirAnamnese(idParaExcluir);
                                break;
                            case 5:
                                String leftalignFOrmat = "|%-17s|%-17s|%n";
                                System.out.println("--------------------");
                                System.out.print("Digite o nome do paciente que voce quer buscar a anamnese: ");
                                String nomeParaBuscarigual = scString.nextLine();
                                int contador = 0;

                                System.out.format("+-----------------+-----------------+%n");
                                System.out.format("|NOME             |MÃE              |%n");
                                System.out.format("+-----------------+-----------------+%n");
                                for (int i = 0; i < pacientes.length; i++) {

                                    if (pacientes[i] != null) {
                                        if (nomeParaBuscarigual.equals(pacientes[i].getNome())) {
                                            contador++;
                                            System.out.format(leftalignFOrmat, pacientes[i].getNome(), pacientes[i].getNomeMae());
                                            System.out.format("+-----------------+-----------------+%n");
                                            if (contador > 1) {

                                                System.out.print("\nDigite o seu numero de CNS: ");
                                                long numCNSparabuscar = sc.nextLong();
                                                Anamnese aBuscada = sist.buscarAnamnesePorNum(numCNSparabuscar);
                                                System.out.println("\nNumero do cns: " + aBuscada.getId() + "\n" + "Motivo: " + aBuscada.getMotivo()
                                                        + "\n" + "Relato: " + aBuscada.getRelato() + "\n" + "Diagnostico: " + aBuscada.getDiagnostico() + "\n--------------------------------------");

                                            }

                                        }
                                    }

                                }

                                if (contador == 1) {

                                    sist.buscarAnamnese(nomeParaBuscarigual);
                                    Anamnese a = sist.buscarAnamnese(nomeParaBuscarigual);
                                    System.out.println("\nNumero do cns: " + a.getId() + "\n" + "Motivo: " + a.getMotivo()
                                            + "\n" + "Relato: " + a.getRelato() + "\n" + "Diagnostico: " + a.getDiagnostico() + "\n--------------------------------------");

                                }

                                break;

                            case 2:
                                System.out.println("Digite o numero de CNS do paciente que voce quer alterar a anamnese: ");
                                long numCNSparaAlterarAnamnese = sc.nextLong();
                                System.out.println("Observação: O numero de CNS nao podera ser alterado");
                                Anamnese aAlterada = new Anamnese(motivo,relato,diagnostico,numCNSparaAlterarAnamnese);
                                System.out.print("Digite o motivo que o paciente veio para a consulta: ");
                                motivo = scString.nextLine();
                                System.out.println("--------------------");
                                System.out.print("Digite o relato do paciente: ");
                                relato = scString.nextLine();
                                System.out.println("--------------------");
                                System.out.print("Faça um diagnostico: ");
                                diagnostico = scString.nextLine();

                                aAlterada.setId(numCNSparaAlterarAnamnese);
                                aAlterada.setMotivo(motivo);
                                aAlterada.setDiagnostico(diagnostico);
                                aAlterada.setRelato(relato);
                                sist.alterarAnamnese(aAlterada);

                                break;

                        }
                    } while (opc1 != 0);

                    break;
                default:
                    break;
            }

        } while (opc != 0);
        }
    

          static void listarPacientes(Paciente[] pacientes) {

               String leftAlignFOrmat = "|%-17s|%-17s|%-4s|%-10s|%-16s|%-15s|%-2s|%-6s|%-13s|%n";
        System.out.format("+-----------------+-----------------+----+----------+----------------+---------------+--+------+------------------+%n");
        System.out.format("|NOME             |MÃE              |SEXO|CNS       |Endereço        |Cidade         |UF|Numero|Data de Nascimento|%n");
        System.out.format("+-----------------+-----------------+----+----------+----------------+---------------+--+------+------------------+%n");

        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                System.out.format( leftAlignFOrmat,pacientes[i].getNome(),pacientes[i].getNomeMae()
                        ,pacientes[i].getSexo()
                ,pacientes[i].getNumCNS(),pacientes[i].getEnd().getLogradouro()
                        ,pacientes[i].getEnd().getCidade(),
                        pacientes[i].getEnd().getUf(),pacientes[i].getEnd().getNumero()
                ,pacientes[i].getDataNascimento());

            }

        }
        System.out.format("+-----------------+-----------------+----+----------+----------------+---------------+--+------+------------------+%n");

    }

    static void listarAnamneses(Anamnese[] anamneses) {
        for (int i = 0; i < anamneses.length; i++) {
            if (anamneses[i] != null) {
                System.out.println("Numero do cns: " + anamneses[i].getId() + "\n" + "Motivo: " + anamneses[i].getMotivo()
                        + "\n" + "Relato: " + anamneses[i].getRelato() + "\n" + "Diagnostico: " + anamneses[i].getDiagnostico() + "\n--------------------------------------");

            }

        }

    }
   }
