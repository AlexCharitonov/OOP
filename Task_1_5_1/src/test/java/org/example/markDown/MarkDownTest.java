package org.example.markDown;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MarkDownTest {

    @Test
    void TaskListTest() {
        TaskList.TaskListBuilder builder = new TaskList.TaskListBuilder();
        builder = builder.addNode(true, "Wake up");
        builder.addNode(true, "Visit U");
        builder = builder.addNode(false, "do cleaning");

        TaskList.TaskListBuilder builder2 = new TaskList.TaskListBuilder();
        builder2 = builder2.addNode(true, new Text.TextBuilder().setText("Wake up").build());
        builder2.addNode(true, new Text.TextBuilder().setText("Visit U").build());
        builder2 = builder2.addNode(false, new Text.TextBuilder().setText("do cleaning").build());

        assertTrue(builder2.build().equals(builder.build()));
    }

    @Test
    void CodeBlocksTest() {
        CodeBlocks.CodeBlocksBuilder builder = new CodeBlocks.CodeBlocksBuilder();
        builder = builder.addString(new Text.TextBuilder()
                .setText("print(\"Hello World\");").build());
        CodeBlocks.CodeBlocksBuilder builder1
                = new CodeBlocks.CodeBlocksBuilder().addString("print(\"Hello World\");");
        assertTrue(builder1.build().equals(builder.build()));
    }

    @Test
    void HeadingTest() {
        Heading.HeadingBuilder builder = new Heading.HeadingBuilder();
        builder.setHeader("header", 2);

        Heading.HeadingBuilder builder1 = new Heading.HeadingBuilder();
        builder1.setHeader(new Text.TextBuilder()
                .setText("header").build(), 2);

        assertTrue(builder.build().equals(builder1.build()));
    }

    @Test
    void ImageTest() {
        Image.ImageBuilder builder = new Image.ImageBuilder();
        builder.setText("image");
        builder.setLink("https://images.unsplash.com/photo-1571992049393-827d13da8fe3?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        Image.ImageBuilder builder1 = new Image.ImageBuilder();
        builder1.setText(new Text.TextBuilder().setText("image").build());
        builder1.setLink("https://images.unsplash.com/photo-1571992049393-827d13da8fe3?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        assertTrue(builder.build().equals(builder1.build()));
    }

    @Test
    void LinkTest() {
        Image.ImageBuilder builder = new Image.ImageBuilder();
        builder.setText("image");
        builder.setLink("https://images.unsplash.com/photo-1571992049393-827d13da8fe3?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        Image.ImageBuilder builder1 = new Image.ImageBuilder();
        builder1.setText(new Text.TextBuilder().setText("image").build());
        builder1.setLink("https://images.unsplash.com/photo-1571992049393-827d13da8fe3?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        assertTrue(builder.build().equals(builder1.build()));
    }

    @Test
    void BlockQuotesTest() {
        BlockQuotes.BlockQuotesBuilder builder = new BlockQuotes.BlockQuotesBuilder();
        builder.setQuote("People who thinks they know everything are a great \n"
                + "annoyance to those of us who do\n"
                + "\t\t\tIsaak Asimov");
        BlockQuotes.BlockQuotesBuilder builder1 = new BlockQuotes.BlockQuotesBuilder();
        builder1.setQuote(new Text.TextBuilder()
                .setText("People who thinks they know everything are a great \n"
                        + "annoyance to those of us who do\n"
                        + "\t\t\tIsaak Asimov").build());
        assertTrue(builder.build().equals(builder1.build()));
    }

    @Test
    void TextTest() {
        Text.TextBuilder builder = new Text.TextBuilder();
        builder.setText("Just").setLineBreak()
                .setBold("simple").setLineBreak()
                .setCode("example").setParagraph()
                .setCursive("of").setLineBreak()
                .setStrike("text");
        Text.TextBuilder builder1 = new Text.TextBuilder();
        builder1.setText(new Text.TextBuilder().setText("Just").build())
                .setLineBreak()
                .setBold(new Text.TextBuilder().setText("simple").build())
                .setLineBreak()
                .setCode(new Text.TextBuilder().setText("example").build())
                .setParagraph()
                .setCursive(new Text.TextBuilder().setText("of").build())
                .setLineBreak()
                .setStrike(new Text.TextBuilder().setText("text").build());
        assertTrue(builder.build().equals(builder1.build()));
    }

    @Test
    void TableTest() {
        Table.TableBuilder builder = new Table.TableBuilder();
        builder.withAlignments(Table.Align.RIGHT_ALIGN,
                        Table.Align.CENTER_ALIGN, Table.Align.LEFT_ALIGN)
                .setMaxRows(5)
                .addRow("Index", "Index x2", "Index * Index");
        for (int i = 0; i < 3; i++) {
            builder.addRow(
                    Integer.toString(i),
                    Integer.toString(i * 2),
                    Integer.toString(i * i)
            );
        }
        Table.TableBuilder builder1 = new Table.TableBuilder();
        builder1.withAlignments(Table.Align.RIGHT_ALIGN,
                        Table.Align.CENTER_ALIGN, Table.Align.LEFT_ALIGN)
                .setMaxRows(5)
                .addRow("Index", "Index x2", "Index * Index");
        for (int i = 0; i < 3; i++) {
            builder1.addRow(
                    new Text.TextBuilder().setText(Integer.toString(i)).build(),
                    new Text.TextBuilder().setText(Integer.toString(i * 2)).build(),
                    new Text.TextBuilder().setText(Integer.toString(i * i)).build()
            );
        }
        assertTrue(builder1.build().equals(builder.build()));
    }

}
