package dev.breje.fdasimpleclient.model.response.openfda;

public class MetaInfo {

    private Pagination results;

    public Pagination getResults() {
        return results;
    }

    class Pagination {

        private int skip;

        private int limit;

        private int total;

        public int getSkip() {
            return skip;
        }

        public int getLimit() {
            return limit;
        }

        public int getTotal() {
            return total;
        }
    }

}


