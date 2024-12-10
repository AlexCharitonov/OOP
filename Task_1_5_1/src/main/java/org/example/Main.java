package org.example;

import org.example.markdown.Table;
import org.example.markdown.Text;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Table.TableBuilder tableBuilder = new Table.TableBuilder()

                .withAlignments(Table.Align.ALIGN_RIGHT, Table.Align.ALIGN_LEFT)
                .withRowLimit(6)
                .addRow("Index", "Random");
        for (int i = 1; i <= 5; i ++) {
            final var value = (int) (Math.random() * 10);
            if (value > 5) {
                tableBuilder.addRow(new Text.TextBuilder().setText(Integer.toString(i)).build(),
                        new Text.TextBuilder().setBold(String.valueOf(value)).build());
            } else {
                tableBuilder.addRow(Integer.toString(i), Integer.toString((int) (Math.random() * 10)));
            }
        }
        System.out.println(tableBuilder.build());
    }
}