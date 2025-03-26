package view;

import model.CatalogoVacinas;
import model.Vacina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Interface gráfica
public class GerenciadorVacinasGUI {
    private CatalogoVacinas catalogo;
    private JFrame frame;
    private JTextArea textArea;

    public GerenciadorVacinasGUI() {
        catalogo = CatalogoVacinas.getInstance();
        frame = new JFrame("Gerenciador de Vacinas");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JTextField nomeField = new JTextField();
        JTextField fabricacaoField = new JTextField();
        JTextField validadeField = new JTextField();

        JButton addButton = new JButton("Adicionar ao catálogo");
        JButton removeButton = new JButton("Remover do catálogo");
        JButton listButton = new JButton("Listar");

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Fabricação:"));
        panel.add(fabricacaoField);
        panel.add(new JLabel("Validade:"));
        panel.add(validadeField);
        panel.add(addButton);
        panel.add(removeButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(listButton, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String fabricacao = fabricacaoField.getText();
                String validade = validadeField.getText();
                catalogo.adicionarVacina(new Vacina(nome, fabricacao, validade));
                nomeField.setText("");
                fabricacaoField.setText("");
                validadeField.setText("");
                atualizarLista();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira o nome da vacina a ser removida do catálogo.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int tamanhoAntes = catalogo.listarVacinas().size();
                catalogo.removerVacina(nome);
                int tamanhoDepois = catalogo.listarVacinas().size();

                if (tamanhoAntes == tamanhoDepois) {
                    JOptionPane.showMessageDialog(frame, "Vacina não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    atualizarLista();
                }

                nomeField.setText("");
            }
        });


        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarLista();
            }
        });

        frame.setVisible(true);
    }

    private void atualizarLista() {
        textArea.setText("");
        for (Vacina v : catalogo.listarVacinas()) {
            textArea.append(v.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        new GerenciadorVacinasGUI();
    }
}