class IntMeaning implements Meaning<Integer> {
    private Integer I;
    public IntMeaning(Integer I){
        this.I = I;
    }
    @Override
    public Integer meaning() {
        return this.I;
    }
}