package sud.aufgaben.designPatterns.remote.userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import sud.aufgaben.designPatterns.remote.Command;
import sud.aufgaben.designPatterns.remote.Remote;
import sud.aufgaben.designPatterns.remote.receiver.Receiver;

public class RemoteUserInterface {
    private JPanel panel;
    private Remote remote;

    public RemoteUserInterface() {
        super();
        this.panel = new JPanel();
        this.remote = new Remote();
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void visualizePanel(List<Command<? extends Receiver>> commands) {
        for (Command<? extends Receiver> command : commands) {
            JButton button = this.initializeCommandButton(command);
            this.panel.add(button);
        }

        this.panel.add(this.initializeCommandUndoButton());
    }

    private JButton initializeCommandButton(Command<? extends Receiver> command) {
        JButton button = new JButton(command.getName());
        button.addActionListener(new CommandButtonActionListener(command));

        return button;
    }

    private JButton initializeCommandUndoButton() {
        JButton button = new JButton("Undo");
        button.addActionListener(new CommandUndoButtonActionListener());

        return button;
    }

    private class CommandButtonActionListener implements ActionListener {
        private Command<? extends Receiver> command;

        public CommandButtonActionListener(Command<? extends Receiver> command) {
            this.command = command;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            RemoteUserInterface.this.remote.setCommand(this.command);
            RemoteUserInterface.this.remote.invoke();
        }
    }

    private class CommandUndoButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RemoteUserInterface.this.remote.undo();
        }

    }
}
