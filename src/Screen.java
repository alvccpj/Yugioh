import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Screen() {
        setTitle("Jogo de Cartas");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        JLabel usernameLabel = new JLabel("Nome de Usuário:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Senha:");
        passwordField = new JPasswordField();

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                if (validarCredenciais(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido. Bem-vindo, " + username + "!");
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciais inválidas. Tente novamente.");
                }

                usernameField.setText("");
                passwordField.setText("");
            }
        });

        add(panel);
        setVisible(true);
    }

    private boolean validarCredenciais(String username, String password) {
        // Adicione sua lógica de validação de credenciais aqui
        // Por enquanto, estamos apenas simulando uma validação simples
        return username.equals("seu_nome_de_usuario") && password.equals("sua_senha");
    }

}
