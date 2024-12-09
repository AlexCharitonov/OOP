package org.example.markdown;
/**
 * Link class.
 */
public class Link extends Element {

    /**
     * Constructor by builder.
     *
     * @param builder builder
     */
    Link(LinkBuilder builder) {
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

        Link link = (Link) obj;

        return link.str.equals(this.str);
    }

    /**
     * Builder class.
     */
    public static class LinkBuilder {
        String str;

        /**
         * Builder constructor.
         */
        LinkBuilder() {
            str = "";
        }


        /**
         * Set link by String.
         *
         * @param link link
         * @return builder
         */
        public LinkBuilder setLink(String link) {
            str = "";
            str = "<" + link + ">";
            return this;
        }

        /**
         * Set link by Element.
         *
         * @param link link
         * @return builder
         */
        public LinkBuilder setLink(Element link) {
            str = "";
            str = "<" + link.str + ">";
            return this;
        }


        /**
         * Build builder.
         *
         * @return built Link
         */
        public Link build() {
            return new Link(this);
        }
    }
}