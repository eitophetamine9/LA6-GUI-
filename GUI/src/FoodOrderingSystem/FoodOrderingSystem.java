package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame{

    private JButton btnOrder;

    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;

    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;

    private JPanel JPanel;

    public FoodOrderingSystem() {
        setTitle("Food Ordering System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        cPizza.setName("cPizza");
        cBurger.setName("cBurger");
        cFries.setName("cFries");
        cSoftDrinks.setName("cSoftDrinks");
        cTea.setName("cTea");
        cSundae.setName("cSundae");

        rbNone.setName("rbNone");
        rb5.setName("rb5");
        rb10.setName("rb10");
        rb15.setName("rb15");

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean pizzaChecked = cPizza.isSelected();
                boolean burgerChecked = cBurger.isSelected();
                boolean friesChecked = cFries.isSelected();
                boolean softDrinksChecked = cSoftDrinks.isSelected();
                boolean teaSelected = cTea.isSelected();
                boolean sundaeSelected = cSundae.isSelected();

                boolean rb5Selected = rb5.isSelected();
                boolean rb10Selected = rb10.isSelected();
                boolean rb15Selected = rb15.isSelected();

                double totalPrice = 0;

                if (pizzaChecked) { totalPrice += 100; }
                if (burgerChecked) { totalPrice += 80; }
                if (friesChecked) { totalPrice += 65; }
                if (softDrinksChecked) { totalPrice += 55; }
                if (teaSelected) { totalPrice += 50; }
                if (sundaeSelected) { totalPrice += 40; }

                if (rb5Selected) { totalPrice *= 0.95; }
                if (rb10Selected) { totalPrice *= 0.90; }
                if (rb15Selected) { totalPrice *= 0.85; }

                String msg = "The total price is Php " + String.format("%.2f", totalPrice);

                JOptionPane.showMessageDialog(null, msg);
            }
        });
    }
}
