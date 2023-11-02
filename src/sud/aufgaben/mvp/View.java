import javax.swing.*;
import java.awt.*;

public class View extends JFrame implements IView {
    private Presenter presenter;

    public View() {
        this.presenter = new Presenter(this);
    }

    @Override
    public JButton getAddWorkerButton() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAddWorkerButton'");
    }

    @Override
    public JButton getRemoveWorkerButton() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRemoveWorkerButton'");
    }

    private void buildStructure() {
        JButton addButton = new JButton("Add worker");
        JButton removeButton = new JButton("Remove worker");
        JButton importButton = new JButton("Import worker");
        JButton exportButton = new JButton("Export worker");
        JButton closeButton = new JButton("Close");

        JButton[] buttons = {addButton, removeButton, importButton, exportButton, closeButton};

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        int padding = 10;
        Dimension dim = new Dimension(200, 50);
        for (JButton button : buttons) {
            buttonPanel.add(button);
            button.setPreferredSize(dim);
            buttonPanel.add(Box.createRigidArea(new Dimension(0, padding)));
        }

        JTable table = new JTable();

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        mainPanel.add(table, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.EAST);
        this.add(mainPanel);
        
        setTitle("Mitarbeiter Verwaltung");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        View view = new View();
        view.buildStructure();
    }
}
