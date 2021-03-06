package paint2.pkg0;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author João Neto
 * @author José Ilmar
 * @param <Forma>
 */
public class JListCustom<Forma> extends JList {
    DefaultListModel listModel;
    ArrayList<Forma> formas;
    
    public JListCustom() {
        //Há eventos de mouse, mas eles estão na classe Tela
        //A razão é a necessidade do painel
        formas = (ArrayList<Forma>) Editor.getEditor().getFormas();
        listModel = Editor.getEditor().getFormasJL();
        setModel(listModel);
    }
    
    /**
     * 
     * @return Retorna se a forma foi movida para cima
     */
    public boolean moverCima() {
        try {
            int i = formas.size() - 1 - getSelectedIndex();
        
            if (getSelectedIndex() > 0) {
                Forma itemSelecionado = formas.get(i);
                formas.remove(i);
                formas.add(i + 1, itemSelecionado);
                int selectedIndex = getSelectedIndex();
                listModel.clear();
                for (Forma forma : formas) {
                    listModel.add(0, forma);
                }
                setSelectedIndex(selectedIndex - 1);
                return true;
            }
        } catch (IndexOutOfBoundsException ex) {}
        return false;
    }
    
    /**
     * 
     * @return Retorna se a forma foi movida para baixo
     */
    public boolean moverBaixo() {   
        try {
            int i = formas.size() - 1 - getSelectedIndex();
        
            if (getSelectedIndex() < listModel.getSize() - 1) {
                Forma itemSelecionado = formas.get(i);
                formas.remove(i);
                formas.add(i - 1, itemSelecionado);
                int selectedIndex = getSelectedIndex();
                listModel.clear();
                for (Forma forma : formas) {
                    listModel.add(0, forma);
                }
                setSelectedIndex(selectedIndex + 1);
                return true;
            }
        } catch (IndexOutOfBoundsException ex) {}
        return false;
    }
}