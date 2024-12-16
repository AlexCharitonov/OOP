package markdown;


/**
 * Quote class.
 */
public class BlockQuotes extends Element {

    /**
     * Constructor by builder.
     *
     * @param builder builder
     */
    public BlockQuotes(BlockQuotesBuilder builder) {
        this.str = builder.str;
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
        BlockQuotes quote = (BlockQuotes) obj;
        return quote.str.equals(this.str);
    }


    /**
     * Builder class.
     */
    public static class BlockQuotesBuilder {
        String str;

        /**
         * Builder constructor.
         */
        public BlockQuotesBuilder() {
            str = "";
        }

        /**
         * Set Quote by Element.
         *
         * @param el new quote
         * @return builder
         */
        public BlockQuotesBuilder setQuote(Element el) {
            this.str = ">" + el.str;
            this.str = this.str.replaceAll("\n", "\n>");
            return this;
        }

        /**
         * Set Quote by String.
         *
         * @param str new quote
         * @return builder
         */
        public BlockQuotesBuilder setQuote(String str) {
            this.str = ">" + str;
            this.str = this.str.replaceAll("\n", "\n>");
            return this;
        }

        /**
         * Build builder.
         *
         * @return built Quote
         */
        public BlockQuotes build() {
            return new BlockQuotes(this);
        }
    }
}