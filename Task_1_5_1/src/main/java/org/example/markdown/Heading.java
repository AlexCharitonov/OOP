package org.example.markdown;

/**
 * Headings class.
 */
public class Heading extends Element {

    /**
     * Simple constructor.
     */
    public Heading() {
        this.str = "";
    }

    /**
     * Constructor by builder.
     *
     * @param builder builder.
     */
    public Heading(HeadingBuilder builder) {
        str = builder.str;
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

        Heading head = (Heading) obj;

        return head.str.equals(this.str);
    }

    /**
     * Builder class.
     */
    public static class HeadingBuilder {
        String str;

        /**
         * Builder constructor.
         */
        public HeadingBuilder() {
            str = "";
        }


        /**
         * Add heading by Element.
         *
         * @param elInHead head value
         * @param typeOfHead type of heading
         * @return builder
         */
        public  HeadingBuilder setHeader(Element elInHead, int typeOfHead) {
            this.str = "";

            for (int i = 0; i < typeOfHead; i++) {
                str = str + "#";
            }

            str += " ";

            str += elInHead.str;

            return this;
        }

        /**
         * Add heading by String.
         *
         * @param str head value
         * @param typeOfHead type of heading
         * @return builder
         */
        public  HeadingBuilder setHeader(String str, int typeOfHead) {
            this.str = "";

            for (int i = 0; i < typeOfHead; i++) {
                this.str = this.str + "#";
            }

            this.str += " ";

            this.str += str;

            return this;
        }


        /**
         * Build builder.
         *
         * @return built Heading
         */
        public Heading build() {
            return new Heading(this);
        }


    }
}