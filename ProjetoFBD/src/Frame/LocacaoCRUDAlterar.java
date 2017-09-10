/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import br.com.fachada.Fachada;
import br.com.model.LocacaoModel;
import br.com.util.ConnectionFactory;
import br.com.util.SqlUtil;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexp0tter
 */
public class LocacaoCRUDAlterar extends javax.swing.JFrame {

    PreparedStatement statementCL,statCarro,statFun, statloc;
    ResultSet resultCL,resultCarro,resultFun, resultloc;
    Connection conCliente,conCarro,conFun, conloc;
    LocacaoModel loc = new LocacaoModel();
    
    int idCl;
    int idCarro;
    int idFun;
    String nomeFun;

    public LocacaoCRUDAlterar(int idLoc){
        
        initComponents();
        setLocationRelativeTo(null);
        
        try {
            conloc = ConnectionFactory.getInstance(ConnectionFactory.NOME_DATABASE_MYSQL);
        } catch (Exception ex) {
            Logger.getLogger(LocacaoCRUDAlterar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            statloc = conloc.prepareStatement("SELECT loc.id, loc.idCliente, loc.idFuncionario, loc.idCarro, loc.dataSaida, loc.dataVolta, loc.valorPagamento, loc.statusLocacao FROM locacao AS loc inner join cliente AS cli ON cli.id = loc.idCliente inner join funcionario AS fun ON fun.id = loc.idFuncionario inner join carro AS car ON car.id = loc.idCarro WHERE loc.id ='"+idLoc+"'");
            statloc.execute();
            resultloc = statloc.executeQuery();
            
            while(resultloc.next()){
                
                this.idCl = Integer.parseInt((resultloc.getString("loc.idCliente")));
                this.idFun = Integer.parseInt((resultloc.getString("loc.idFuncionario")));
                this.idCarro = Integer.parseInt((resultloc.getString("loc.idCarro")));
                
                dataRetirLoca.setText(resultloc.getString("loc.dataSaida"));
                dataDevoLoca.setText(resultloc.getString("loc.dataVolta"));
                valorLoca.setText(resultloc.getString("loc.valorPagamento"));
                statusLocacao.setText(resultloc.getString("loc.statusLocacao"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoCRUDAlterar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    public LocacaoCRUDAlterar(String cpf,String nomeFun) {
        initComponents();
        setLocationRelativeTo(null);
        
        valorLoca.setText("0");
        statusLocacao.setText("true");
        dataDevoLoca.setText(null);
        this.nomeFun = nomeFun;
        
        //status locação (finalizada em )
        

        try {
            conCliente = ConnectionFactory.getInstance(ConnectionFactory.NOME_DATABASE_MYSQL);
            conCarro = ConnectionFactory.getInstance(ConnectionFactory.NOME_DATABASE_MYSQL);
            conFun = ConnectionFactory.getInstance(ConnectionFactory.NOME_DATABASE_MYSQL);

        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                conCliente.rollback();
                conCarro.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace();
            }
        }

        try {

            statementCL = conCliente.prepareStatement("select cl.id, cl.nome, cl.cpf, cl.contato, cl.idEndereco, end.rua, end.bairro, end.cidade, end.cep, end.uf from cliente as cl inner join endereco AS end ON end.id = cl.idEndereco where cl.cpf ='"+cpf+"'");
            statementCL.execute();
            resultCL = statementCL.executeQuery();   
           

            while (resultCL.next()) {

                clienteNome.setText(resultCL.getString("cl.nome"));
                cpfCliente.setText(resultCL.getString("cl.cpf"));
                clienteContato.setText(resultCL.getString("cl.contato"));
                endCliente.setText(resultCL.getString("end.rua"));
                bairroCliente.setText(resultCL.getString("end.bairro"));
                cidadeCliente.setText(resultCL.getString("end.cidade"));
                ufCliente.setText(resultCL.getString("end.uf"));
                cepCliente.setText(resultCL.getString("end.cep"));
                
                this.idCl = Integer.parseInt((resultCL.getString("cl.id"))); 
                System.out.println(idCl);
            }
            

        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
        
        try{
            
            statFun = conFun.prepareStatement("SELECT fun.id,fun.nome, fun.cpf, fun.cargo, fun.contato, fun.loginUser, fun.loginSenha, fun.idEndereco, end.rua, end.bairro, end.cidade, end.cep, end.uf FROM funcionario AS fun inner join endereco AS end ON end.id = fun.idEndereco where fun.cpf = '"+nomeFun+"'");
            statFun.execute();
            resultFun = statFun.executeQuery();
            
            while(resultFun.next()){
                
                               
                this.idFun = Integer.parseInt((resultFun.getString("fun.id")));
                funLoca1.setText(resultFun.getString("fun.nome"));
            }
            
        }
        
        catch(SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
        
        PopularJTable(SqlUtil.SELECT_CARROS);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        valorLoca = new javax.swing.JTextField();
        funLoca1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        dataDevoLoca = new javax.swing.JFormattedTextField();
        dataRetirLoca = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        statusLocacao = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        marcaCarro = new javax.swing.JTextField();
        diariaCarro = new javax.swing.JTextField();
        placaCarro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        statusLocCarro = new javax.swing.JTextField();
        corCarro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        modeloCarro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fieldBusca = new javax.swing.JTextField();
        btBusca = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        bairroCliente = new javax.swing.JTextField();
        ufCliente = new javax.swing.JTextField();
        clienteContato = new javax.swing.JFormattedTextField();
        clienteNome = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        endCliente = new javax.swing.JTextField();
        cidadeCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        cepCliente = new javax.swing.JFormattedTextField();
        jLabel40 = new javax.swing.JLabel();
        cpfCliente = new javax.swing.JFormattedTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Locação"));

        jLabel32.setText("Data Devolução");

        jLabel33.setText("Data Retirada");

        jLabel34.setText("Valor");

        valorLoca.setEditable(false);

        funLoca1.setEditable(false);
        funLoca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funLoca1ActionPerformed(evt);
            }
        });

        jLabel36.setText("Funcionário");

        dataDevoLoca.setEditable(false);
        try {
            dataDevoLoca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataDevoLoca.setText("  00/00 /00  ");

        try {
            dataRetirLoca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Status da Locação");

        statusLocacao.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(114, 114, 114)
                        .addComponent(jLabel33))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(funLoca1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dataRetirLoca, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(dataDevoLoca, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorLoca, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(statusLocacao))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(funLoca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataDevoLoca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataRetirLoca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorLoca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Carro"));

        marcaCarro.setEditable(false);
        marcaCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaCarroActionPerformed(evt);
            }
        });

        diariaCarro.setEditable(false);

        placaCarro.setEditable(false);
        placaCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placaCarroActionPerformed(evt);
            }
        });

        jLabel6.setText("Status de Locação");

        jLabel2.setText("Cor");

        statusLocCarro.setEditable(false);

        corCarro.setEditable(false);

        jLabel3.setText("Modelo");

        modeloCarro.setEditable(false);
        modeloCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloCarroActionPerformed(evt);
            }
        });

        jLabel4.setText("Placa");

        jLabel31.setText("Marca");

        jLabel35.setText("Valor Diária");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Modelo", "Marca", "Placa", "Cor", "Valor Diária", "Status de Locação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        fieldBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBuscaActionPerformed(evt);
            }
        });

        btBusca.setText("Buscar");
        btBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 161, Short.MAX_VALUE))
                            .addComponent(modeloCarro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(marcaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(corCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(placaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(93, 93, 93)
                                .addComponent(jLabel4)))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(diariaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(statusLocCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fieldBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBusca)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBusca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel31)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel35)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modeloCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marcaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diariaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLocCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));

        bairroCliente.setEditable(false);

        ufCliente.setEditable(false);
        ufCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ufClienteActionPerformed(evt);
            }
        });

        clienteContato.setEditable(false);
        try {
            clienteContato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # #### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        clienteContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteContatoActionPerformed(evt);
            }
        });

        clienteNome.setEditable(false);
        clienteNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteNomeActionPerformed(evt);
            }
        });

        jLabel38.setText("Cidade");

        endCliente.setEditable(false);

        cidadeCliente.setEditable(false);

        jLabel5.setText("CPF");

        jLabel39.setText("CEP");

        cepCliente.setEditable(false);
        try {
            cepCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel40.setText("Contato");

        cpfCliente.setEditable(false);
        try {
            cpfCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel41.setText("Nome");

        jLabel42.setText("Bairro");

        jLabel43.setText("UF");

        jLabel44.setText("Endereço");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(clienteNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(96, 96, 96))
                            .addComponent(clienteContato)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(endCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(0, 184, Short.MAX_VALUE))
                            .addComponent(bairroCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(116, 116, 116))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(cidadeCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ufCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cepCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel5)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clienteContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel42)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bairroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cepCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ufCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalvar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar)
                    .addComponent(btSalvar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void funLoca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funLoca1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_funLoca1ActionPerformed

    private void marcaCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaCarroActionPerformed

    private void placaCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placaCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placaCarroActionPerformed

    private void modeloCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modeloCarroActionPerformed

    private void ufClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ufClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ufClienteActionPerformed

    private void clienteNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteNomeActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        loc.getCliente().setId(idCl);
        loc.getCarro().setId(idCarro);
        loc.getFun().setId(idFun);
        
        loc.setStatusLocacao(Boolean.parseBoolean(statusLocacao.getText()));
        loc.setValor(Double.parseDouble(valorLoca.getText()));
        loc.setDataDevolucao(dataDevoLoca.getText());
        loc.setDataRetirada(dataRetirLoca.getText());
     
        
        /*
        String saida = dataRetirLoca.getText();
        String devolucao = dataDevoLoca.getText();        

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/YYYY");

        try {
            Date dateDevo = sdf.parse(devolucao);
            Date dateRetir = sdf.parse(saida);

           java.sql.Date sqlDateDevo = new java.sql.Date(dateDevo.getTime());
            java.sql.Date sqlDateReti = new java.sql.Date(dateRetir.getTime());
            
           loc.setDataDevolucao(sqlDateDevo);
            loc.setDataRetirada(sqlDateReti);
            
            

        } catch (ParseException e) {
            e.printStackTrace();
        }
        */

        Fachada coreFachada = new Fachada();
        coreFachada.salvarLoca(loc);

    }//GEN-LAST:event_btSalvarActionPerformed

    public double calcularValor() throws ParseException  {
        String taxaCarro = diariaCarro.getText();
        
        String saida = dataRetirLoca.getText();
        String devolucao = dataDevoLoca.getText();
        
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        
        Date carroSaida = formatador.parse(saida);
        Date carroDevolucao = formatador.parse(devolucao);
        
        long dias = (carroDevolucao.getTime()-carroSaida.getTime())/(1000*60*60*24);
        double taxa = Double.parseDouble(taxaCarro);
        
        double valorTotal = taxa*dias;
        return valorTotal;

    }
    
   
    private void clienteContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteContatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteContatoActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        setVisible(false);
        new tabelaLocacao(nomeFun);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
            
        int linha = jTable1.getSelectedRow(); // retorna a linha selecionada pelo usuario
        modeloCarro.setText(jTable1.getValueAt(linha, 1).toString()); // retorna o valor da celula linha X 0
        marcaCarro.setText(jTable1.getValueAt(linha, 2).toString()); // retorna o valor da celula linha X 1
        placaCarro.setText(jTable1.getValueAt(linha, 3).toString()); // retorna o valor da celula linha X 2
        corCarro.setText(jTable1.getValueAt(linha, 4).toString()); // retorna o valor da celula linha X 2
        diariaCarro.setText(jTable1.getValueAt(linha, 5).toString());
        statusLocCarro.setText(jTable1.getValueAt(linha, 6).toString());
        
        this.idCarro = Integer.parseInt(jTable1.getValueAt(linha,0).toString());
        
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void fieldBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBuscaActionPerformed

    private void btBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaActionPerformed

        String sql = "SELECT * FROM carro WHERE modelo LIKE '%"
        + fieldBusca.getText() + "%' OR marca LIKE '%"
        + fieldBusca.getText() + "%'"
        + " ORDER BY id";

        this.PopularJTable(sql);// TODO add your handling code here:

    }//GEN-LAST:event_btBuscaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LocacaoCRUDAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocacaoCRUDAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocacaoCRUDAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocacaoCRUDAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocacaoCRUDAlterar("","").setVisible(true);
            }
        });
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public JFormattedTextField getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(JFormattedTextField cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    

    public JTextField getFunLoca1() {
        return funLoca1;
    }

    public void setFunLoca1(JTextField funLoca1) {
        this.funLoca1 = funLoca1;
    }

    public JTextField getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(JTextField modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public JFormattedTextField getDataRetirLoca() {
        return dataRetirLoca;
    }

    public void setDataRetirLoca(JFormattedTextField dataRetirLoca) {
        this.dataRetirLoca = dataRetirLoca;
    }

    public JFormattedTextField getDataDevoLoca() {
        return dataDevoLoca;
    }

    public void setDataDevoLoca(JFormattedTextField dataDevoLoca) {
        this.dataDevoLoca = dataDevoLoca;
    }

    public JTextField getValorLoca() {
        return valorLoca;
    }

    public void setValorLoca(JTextField valorLoca) {
        this.valorLoca = valorLoca;
    }

    public JTextField getStatusLocacao() {
        return statusLocacao;
    }

    public void setStatusLocacao(JTextField statusLocacao) {
        this.statusLocacao = statusLocacao;
    }
    
    
    
    public void PopularJTable(String sql) {
        
        try {

            statCarro = conCarro.prepareStatement(sql);
            statCarro.execute();
            resultCarro = statCarro.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);

            while (resultCarro.next()) {
                model.addRow(new Object[]{
                    //retorna os dados da tabela do BD, cada campo e um coluna.
                    resultCarro.getString("id"),
                    resultCarro.getString("modelo"),
                    resultCarro.getString("marca"),
                    resultCarro.getString("placa"),
                    resultCarro.getString("cor"),
                    resultCarro.getString("valorDiaria"),
                    resultCarro.getString("statusLocacao"),});
            }

        } catch (SQLException ex) {
            System.out.println("o erro foi " + ex);
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairroCliente;
    private javax.swing.JButton btBusca;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JFormattedTextField cepCliente;
    private javax.swing.JTextField cidadeCliente;
    private javax.swing.JFormattedTextField clienteContato;
    private javax.swing.JTextField clienteNome;
    private javax.swing.JTextField corCarro;
    private javax.swing.JFormattedTextField cpfCliente;
    private javax.swing.JFormattedTextField dataDevoLoca;
    private javax.swing.JFormattedTextField dataRetirLoca;
    private javax.swing.JTextField diariaCarro;
    private javax.swing.JTextField endCliente;
    private javax.swing.JTextField fieldBusca;
    private javax.swing.JTextField funLoca1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField marcaCarro;
    private javax.swing.JTextField modeloCarro;
    private javax.swing.JTextField placaCarro;
    private javax.swing.JTextField statusLocCarro;
    private javax.swing.JTextField statusLocacao;
    private javax.swing.JTextField ufCliente;
    private javax.swing.JTextField valorLoca;
    // End of variables declaration//GEN-END:variables
}
