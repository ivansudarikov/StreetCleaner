package io.angelhack.rest.pojo;

import java.util.List;

public class ScenariosVox {
    private List<ScenarioVox> result;
    private Long total_count;
    private Long count;

    public List<ScenarioVox> getResult() {
        return result;
    }

    public void setResult(List<ScenarioVox> result) {
        this.result = result;
    }

    public Long getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Long total_count) {
        this.total_count = total_count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScenariosVox that = (ScenariosVox) o;

        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (total_count != null ? !total_count.equals(that.total_count) : that.total_count != null) return false;
        return !(count != null ? !count.equals(that.count) : that.count != null);

    }

    @Override
    public int hashCode() {
        int result1 = result != null ? result.hashCode() : 0;
        result1 = 31 * result1 + (total_count != null ? total_count.hashCode() : 0);
        result1 = 31 * result1 + (count != null ? count.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "ScenariosVox{" +
                "result=" + result +
                ", total_count=" + total_count +
                ", count=" + count +
                '}';
    }
}
