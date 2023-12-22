package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

public class ListaDeTarefas {
	private JFrame jF;
	private JButton btCriar, btRemover, btEditar;
	private JLabel msgListaTarefas;
	private JTextField jTxtTarefa;
	private DefaultListModel<String> tarefas;
	private JList<String> jLTarefas; 
	private String[] dadosPreSetados = {"Dado 1", "Dado 2", "Dado 3", "Dado 4", "Dado 5", "Dado 6", "Dado 7", "Dado 8"};
	
	public ListaDeTarefas() {
		jF = new JFrame("Lista de Tarefas");
		jF.setSize(550, 350);
		jF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jF.setLayout(null);
		
		tarefas = new DefaultListModel<>();
		
		jLTarefas = new JList<>(tarefas);
		jLTarefas.setBounds(10, 10, 200, 200);
		
		msgListaTarefas = new JLabel("Tarefa: ");
		msgListaTarefas.setBounds(220, 10, 200, 40);
		
		jTxtTarefa = new JTextField(15);
		jTxtTarefa.setBounds(275, 10, 150, 40);
		
		btCriar = new JButton("Criar");
		btCriar.setBounds(300, 60, 100, 40);
		
		btRemover = new JButton("Remover");
		btRemover.setBounds(300, 110 , 100, 40);
		
		btEditar = new JButton("Editar");
		btEditar.setBounds(300, 160, 100, 40);
		
		
		
		jF.add(msgListaTarefas);
		jF.add(jTxtTarefa);
		jF.add(btCriar);
		jF.add(btRemover);
		jF.add(btEditar);
		jF.add(jLTarefas);
				
		btCriar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				adicionarTarefa();
			}
		});
		
		btEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				editarTarefa();
			}
		});
		
		btRemover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				removerTarefa();
			}
		});
		
		for(String dado : dadosPreSetados) {
			tarefas.addElement(dado);
		}
		
		jF.setVisible(true);
	}
	
	public void adicionarTarefa() {
		String novaTarefa = jTxtTarefa.getText();
		tarefas.addElement(novaTarefa);	
		jTxtTarefa.setText("");
	}
	
	public void editarTarefa() {
		int index = jLTarefas.getSelectedIndex();
        String tarefaSelecionada = tarefas.getElementAt(index);
        String novaDescricao = JOptionPane.showInputDialog(jF, "Editar Tarefa:", tarefaSelecionada);
        if (novaDescricao != null) {
        tarefas.setElementAt(novaDescricao, index);
        }
    }
	
	public void removerTarefa() {
		int index = jLTarefas.getSelectedIndex();
			tarefas.remove(index);
	}
	
	
	public static void main(String[] args) {
		new ListaDeTarefas();
	}
}
