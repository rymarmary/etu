package org.example;

/* Подключение графических библиотек */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PriceList {
    /* Объявления графических компонентов */
    private JFrame priceList;
    private DefaultTableModel priceListModel;
    private JButton save;
    private JButton open;
    private JButton add;
    private JButton remove;
    private JButton edit;
    private JLabel searchByLabel;
    private JComboBox searchBy;
    private JTextField searchInformation;
    private JButton searchButton;
    private JToolBar toolBar;
    private JTable GPUTable;
    private JScrollPane tableScrollBar;
    private JTextArea additionalInformation;

    /**
     * Creates a JFrame window and sets its size
     * Creates save, open, add, remove, edit buttons and adds them to a toolbar
     * Creates search menu and puts adds it to a toolbar
     * Places a toolbar to the top of a window
     * Creates a table with the information about GPUs and puts it to the center of a window
     * Creates an additional information text field and puts it to the right of a window
     */
    public void show() {
        /* Создание окна */
        priceList = new JFrame("Price list");
        priceList.setSize(1200, 600);
        priceList.setLocation(300,300);
        priceList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Скейлинг изображений для правильного отображения в кнопках */
        ImageIcon imageIconSave = new ImageIcon(new ImageIcon("save.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        ImageIcon imageIconOpen = new ImageIcon(new ImageIcon("open.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        ImageIcon imageIconAdd = new ImageIcon(new ImageIcon("add.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        ImageIcon imageIconRemove = new ImageIcon(new ImageIcon("delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        ImageIcon imageIconEdit = new ImageIcon(new ImageIcon("edit.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        /* Создание кнопок и прикрепление иконок */
        save = new JButton(imageIconSave);
        open = new JButton(imageIconOpen);
        add = new JButton(imageIconAdd);
        remove = new JButton(imageIconRemove);
        edit = new JButton(imageIconEdit);

        /* Настройка подсказок для кнопок */
        save.setToolTipText("Save");
        open.setToolTipText("Open");
        add.setToolTipText("Add");
        remove.setToolTipText("Remove");
        edit.setToolTipText("Edit");

        /* Настройка размера кнопок */
        save.setPreferredSize(new Dimension(25,25));
        open.setPreferredSize(new Dimension(25,25));
        add.setPreferredSize(new Dimension(25,25));
        remove.setPreferredSize(new Dimension(25,25));
        edit.setPreferredSize(new Dimension(25,25));

        /* Создание поиска */
        searchByLabel = new JLabel("Search by");
        searchBy = new JComboBox(new String[]{"manufacturer", "model"});
        searchInformation = new JTextField("Enter information");
        searchButton = new JButton("Search");

        /* Добавление кнопок и поиска на панель инструментов */
        toolBar = new JToolBar("Toolbar");
        toolBar.add(save);
        toolBar.add(open);
        toolBar.add(add);
        toolBar.add(remove);
        toolBar.add(edit);
        toolBar.add(Box.createHorizontalStrut(12));
        toolBar.add(new JSeparator(SwingConstants.VERTICAL));
        toolBar.add(Box.createHorizontalStrut(12));
        toolBar.add(searchByLabel);
        toolBar.add(Box.createHorizontalStrut(3));
        toolBar.add(searchBy);
        toolBar.add(Box.createHorizontalStrut(3));
        toolBar.add(searchInformation);
        toolBar.add(Box.createHorizontalStrut(3));
        toolBar.add(searchButton);

        /* Размещение панели инструментов */
        priceList.setLayout(new BorderLayout());
        priceList.add(toolBar, BorderLayout.NORTH);


        /* Создание таблицы с данными */
        String[] Columns = {"Manufacturer", "Model", "Price, rub", "Availability"};
        String[][] Data = {{"NVIDIA", "GeForce GTX 1080Ti", "30000", "Yes"}, {"NVIDIA", "GeForce RTX 2060Ti", "40000", "Yes"},
                {"NVIDIA", "GeForce RTX 2070", "50000", "Yes"}, {"NVIDIA","GeForce RTX 2070Ti", "55000", "No"},
                {"NVIDIA","GeForce RTX 2080Ti", "60000", "No"}};
        priceListModel = new DefaultTableModel(Data, Columns);
        GPUTable = new JTable(priceListModel);
        tableScrollBar = new JScrollPane(GPUTable);

        /* Размещение таблицы с данными */
        priceList.add(tableScrollBar, BorderLayout.CENTER);

        /* Создание окна с доп. информацией */
        additionalInformation = new JTextArea("Space for additional information");

        /* Размещение окна с доп. информацией */
        priceList.add(additionalInformation, BorderLayout.EAST);
        priceList.add(new JScrollPane(additionalInformation), BorderLayout.EAST);

        priceList.setVisible(true);
    }
}

