package dev.breje.fdasimpleclient.model.openfda.response;

public class OpenFdaPagination {

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
