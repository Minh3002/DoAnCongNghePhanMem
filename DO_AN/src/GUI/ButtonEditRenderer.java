package GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

class ButtonEditRenderer extends JButton implements TableCellRenderer {

    public ButtonEditRenderer() {
      setOpaque(true);
    }
  
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
      if (isSelected) {
        setForeground(table.getSelectionForeground());
        setBackground(table.getSelectionBackground());
      } else {
        setForeground(table.getForeground());
        setBackground(UIManager.getColor("Button.background"));
      }
      setBackground(new Color(234,230,235));
      setBorderPainted(false);
      Icon icon = new ImageIcon("img/icon_edit.png");
      setIcon(icon);
      //setText((value == null) ? "" : value.toString());
      return this;
    }
  }
