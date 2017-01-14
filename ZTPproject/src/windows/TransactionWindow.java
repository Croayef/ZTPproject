package windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TransactionWindow extends JPanel implements CustomWindowInterface {

    private static TransactionWindow instance;
    private JScrollPane transactionScrollPane;
    private JTable transactions;
    private JLabel outcomeLabel;
    private JButton approveTransactionButton;
    private JButton rejectTransactionButton;

    private TransactionWindow() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder("Transakcje"));

        approveTransactionButton = new JButton("Zatwierdź Transakcję");
        rejectTransactionButton = new JButton("Odrzuć Transakcję");
        outcomeLabel = new JLabel("OUTCOME");
        transactions = new JTable();
        transactionScrollPane = new JScrollPane(transactions);

        setComponentsPositions();

    }

    private void setComponentsPositions() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        this.add(transactionScrollPane, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LAST_LINE_START;
        this.add(approveTransactionButton, constraints);
        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.LAST_LINE_END;
        this.add(rejectTransactionButton, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(outcomeLabel, constraints);
        
    }

    public static TransactionWindow getInstance() {
        if (instance == null) {
            instance = new TransactionWindow();
        }
        return instance;
    }

    public JButton getApproveTransactionButton() {
        return this.approveTransactionButton;
    }

    public JButton getRejectTransactionButton() {
        return this.rejectTransactionButton;
    }

    public JTable getTransactionsTable() {
        return this.transactions;
    }



}
