package windows;

import javax.swing.JTable;

public interface CustomWindowInterface {

    default public JTable getTable() {
        return null;
    }
    
    public void clear();
    
}
