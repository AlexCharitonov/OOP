package org.example;

import org.example.markdown.CodeBlocks;
import org.example.markdown.Table;
import org.example.markdown.Text;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CodeBlocks.CodeBlocksBuilder builder = new CodeBlocks.CodeBlocksBuilder();
        builder = builder.addString(new Text.TextBuilder()
                .setText("print(\"Test_1_5_1\");").build());
        System.out.println(builder.build());
    }
}