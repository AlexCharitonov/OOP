package org.example.markdown;

/**
 * Checkboxes class.
 */
public class TaskList extends Element {
    List.ListBuilder list;

    /**
     * Constructor by builder.
     *
     * @param builder builder.
     */
    TaskList(TaskListBuilder builder) {
        list = builder.list;
        str = builder.list.build().str;
    }

    /**
     * Compare objects.
     *
     * @param obj object to compare
     * @return is equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        TaskList box = (TaskList) obj;

        return list.build().equals(box.list.build());
    }

    /**
     * Builder class.
     */
    public static class TaskListBuilder {
        List.ListBuilder list;

        /**
         * Builder constructor.
         */
        TaskListBuilder() {
            list = new List.ListBuilder('-');
        }

        /**
         * addNode to the checkbox by Element.
         *
         * @param set is node set
         * @param el node
         * @return builder
         */
        public TaskListBuilder addNode(boolean set, Element el) {
            Text.TextBuilder text = new Text.TextBuilder();

            if (set) {
                text = text.setText("[x] " + el.str);
            } else {
                text = text.setText("[ ] " + el.str);
            }

            list.addNode(text.build());
            return this;
        }

        /**
         * addNode to the checkbox by String value.
         *
         * @param set is node set
         * @param el node
         * @return builder
         */
        public TaskListBuilder addNode(boolean set, String el) {
            Text.TextBuilder text = new Text.TextBuilder();

            if (set) {
                text = text.setText("[x] " + el);
            } else {
                text = text.setText("[ ] " + el);
            }

            list.addNode(text.build());
            return this;
        }


        /**
         * Build builder.
         *
         * @return built checkbox
         */
        public TaskList build() {
            return new TaskList(this);
        }
    }
}