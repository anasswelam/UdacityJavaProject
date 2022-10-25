/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.InvoiceHeader;
import model.InvoiceLine;
import model.InvoiceLineTable;
import view.InvoiceFrame;

/**
 *
 * @author Anas
 */
public class TableSelection implements ListSelectionListener{
    
  private InvoiceFrame frame;

    public TableSelection(InvoiceFrame frame) {
        this.frame = frame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInvIndex = frame.getInvHTbl().getSelectedRow();
        System.out.println("Invoice selected: " + selectedInvIndex);
        if (selectedInvIndex != -1) {
            InvoiceHeader selectedInv = frame.getInvoicesArray().get(selectedInvIndex);
            ArrayList<InvoiceLine> lines = selectedInv.getLines();
            InvoiceLineTable lineTableModel = new InvoiceLineTable(lines);
            frame.setLinesArray(lines);
            frame.getInvLTbl().setModel(lineTableModel);
            frame.getCustNameLbl().setText(selectedInv.getCustomer());
            frame.getInvNumLbl().setText("" + selectedInv.getNum());
            frame.getInvTotalIbl().setText("" + selectedInv.getInvoiceTotal());
            frame.getInvDateLbl().setText(InvoiceFrame.dateFormat.format(selectedInv.getInvDate()));
        }
    }

}
