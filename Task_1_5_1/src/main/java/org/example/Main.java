package org.example;

import org.example.markdown.Table;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Table.TableBuilder builder = new Table.TableBuilder();
        builder.withAlignments(Table.Align.RIGHT_ALIGN,
                        Table.Align.CENTER_ALIGN, Table.Align.LEFT_ALIGN)
                .setMaxRows(5)
                .withRowLimit(13)
                .addRow("Index", "Index x2", "Index * Index");
        for (int i = 0; i < 4; i++) {
            builder.addRow(
                    Integer.toString(i),
                    Integer.toString(i * 2),
                    Integer.toString(i * i)
            );
        }
        System.out.print(builder.build());
    }
}