import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Eine GUI-Anwendung zur Verwaltung von Mitarbeitern.
 */
public class MitarbeiterGUI extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private int currentMaxID = 0;
    private JComboBox<String> rolleComboBox;
    private String[] rolleOptions = {"Bueroarbeiter", "Fahrer", "Manager", "Mitarbeiter", "Schichtarbeiter"};

    /**
     * Konstruktor der Klasse MitarbeiterGUI.
     * Initialisiert die GUI und lädt Daten aus der CSV-Datei.
     */
    public MitarbeiterGUI() {
        setTitle("Mitarbeiter Verwaltung");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Erstellen der Spalten und des Modells der Tabelle
        String[] columnNames = {"MitarbeiterID", "Nachname", "Vorname", "Rolle", "Gehalt"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Erstellen der Schaltflächen
        JButton addButton = new JButton("Mitarbeiter hinzufügen");
        JButton removeButton = new JButton("Mitarbeiter entfernen");
        JButton importButton = new JButton("Mitarbeiter importieren");
        JButton exportButton = new JButton("Mitarbeiter exportieren");
        JButton closeButton = new JButton("Schliessen");

        // Hinzufügen von Aktionsempfängern zu den Schaltflächen
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Erstellen eines Arrays von Eingabefeldern
                JTextField nachnameField = new JTextField();
                JTextField vornameField = new JTextField();
                rolleComboBox = new JComboBox<>(rolleOptions);
                JTextField gehaltField = new JTextField();
                JLabel errorMsg = new JLabel("");
                errorMsg.setBackground(Color.RED);

                Dimension fieldSize = new Dimension(150, 30);
                nachnameField.setPreferredSize(fieldSize);
                vornameField.setPreferredSize(fieldSize);
                gehaltField.setPreferredSize(fieldSize);
                rolleComboBox.setPreferredSize(fieldSize);

                // Erstellen eines Arrays von Beschriftungen
                Object[] message = {
                        "Nachname:", nachnameField,
                        "Vorname:", vornameField,
                        "Rolle:", rolleComboBox,
                        "Gehalt:", gehaltField,
                        errorMsg
                };

                while (true) {
                    // Anzeigen des Eingabedialogs
                    int option = JOptionPane.showConfirmDialog(null, message, "Mitarbeiter hinzufügen", JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        // Abrufen der Eingabewerte
                        String nachname = nachnameField.getText();
                        String vorname = vornameField.getText();
                        String rolle = (String) rolleComboBox.getSelectedItem();
                        String gehalt = gehaltField.getText();

                        if (
                            nachname.isEmpty() ||
                            vorname.isEmpty() ||
                            rolle.isEmpty() ||
                            gehalt.isEmpty()
                        ) {
                            errorMsg.setText("<html><font color='red'>Alle Felder müssen ausgefüllt sein!</font></html>");
                        } else {
                            currentMaxID++;

                            Object[] newRow = {currentMaxID, nachname, vorname, rolle, gehalt};
                            tableModel.addRow(newRow);

                            saveDataToCSV();
                            break; // Aus der Schleife ausbrechen, wenn alle Felder ausgefüllt sind
                        }
                    } else {
                        break; // Aus der Schleife ausbrechen, wenn "Abbrechen" gedrückt wird
                    }
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                    saveDataToCSV(); // CSV nach Entfernen der Zeile aktualisieren
                }
            }
        });

        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(".");
                fileChooser.setDialogTitle("CSV importieren");
                int userSelection = fileChooser.showOpenDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(";");
                            if (parts.length == 5) {
                                int id = Integer.parseInt(parts[0]);
                                if (id > currentMaxID) {
                                    currentMaxID = id;
                                }
                                Object[] rowData = { id, parts[1], parts[2], parts[3], parts[4] };
                                tableModel.addRow(rowData);
                            } else {
                                System.out.println("Ungültige Daten in der CSV-Datei.");
                            }
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        exportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(".");
                fileChooser.setDialogTitle("Als CSV speichern");
                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try (PrintWriter writer = new PrintWriter(fileToSave)) {
                        for (int i = 0; i < tableModel.getRowCount(); i++) {
                            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                                writer.print(tableModel.getValueAt(i, j));
                                if (j < tableModel.getColumnCount() - 1) {
                                    writer.print(";");
                                }
                            }
                            writer.println();
                        }
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        closeButton.setBackground(Color.RED);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                    null, "Möchten Sie das Programm wirklich beenden?", "Programm beenden",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Erstellen eines Panels für die Schaltflächen
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton[] buttons = {addButton, removeButton, importButton, exportButton};

        Dimension buttonSize = new Dimension(200, 50);
        int padding = 10;
        for (JButton button : buttons) {
            button.setMaximumSize(buttonSize);
            button.setPreferredSize(buttonSize);
            buttonPanel.add(button);
            buttonPanel.add(Box.createRigidArea(new Dimension(0, padding)));
        }
        closeButton.setPreferredSize(buttonSize);

        JPanel allButtonPanel = new JPanel(new BorderLayout());
        allButtonPanel.add(buttonPanel, BorderLayout.NORTH);
        allButtonPanel.add(closeButton, BorderLayout.SOUTH);

        // Erstellen des Haupt-Panels und Hinzufügen der Tabelle und der Schaltflächen
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(allButtonPanel, BorderLayout.EAST);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(mainPanel);

        loadDataFromCSV();
    }

    /**
     * Lädt Mitarbeiterdaten aus der CSV-Datei.
     * Wenn die Datei nicht existiert, wird keine Aktion durchgeführt.
     */
    private void loadDataFromCSV() {
        File file = new File("mitarbeiter.csv");

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length == 5) {
                        int id = Integer.parseInt(parts[0]);
                        if (id > currentMaxID) {
                            currentMaxID = id;
                        }
                        Object[] rowData = { id, parts[1], parts[2], parts[3], parts[4] };
                        tableModel.addRow(rowData);
                    } else {
                        System.out.println("Ungültige Daten in der CSV-Datei.");
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Speichert Mitarbeiterdaten in die CSV-Datei.
     * Wenn die Datei nicht existiert, wird sie neu erstellt.
     */
    private void saveDataToCSV() {
        File file = new File("mitarbeiter.csv");

        try (PrintWriter writer = new PrintWriter(file)) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    writer.print(tableModel.getValueAt(i, j));
                    if (j < tableModel.getColumnCount() - 1) {
                        writer.print(";");
                    }
                }
                writer.println();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Hauptmethode, die die Anwendung startet.
     * Erzeugt eine Instanz der Klasse MitarbeiterGUI und macht sie sichtbar.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MitarbeiterGUI gui = new MitarbeiterGUI();
                gui.setVisible(true);
            }
        });
    }
}
